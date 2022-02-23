package davidkecskes.stateproject.service.impl;

import davidkecskes.stateproject.dto.RoleDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.model.Roles;
import davidkecskes.stateproject.model.VAuthorizationsId;
import davidkecskes.stateproject.mapper.RoleDTOMapper;
import davidkecskes.stateproject.mapper.RoleEntityMapper;
import davidkecskes.stateproject.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements davidkecskes.stateproject.service.RoleService {

    private final RoleRepository roleRepository;
    private final RoleDTOMapper roleDTOMapper;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleDTOMapper.convertList(StreamSupport.stream(roleRepository.findAll().spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public RoleDTO getRole(Integer id) throws DataNotFoundException {
        return roleDTOMapper.convertOne(roleRepository.findById(id).orElseThrow(DataNotFoundException::new));
    }

    @Override
    public List<VAuthorizationsId> getAllAuthorizations() {
        List<VAuthorizationsId> authorizations = roleRepository.getAllAuthorizations().stream().map(auth -> {
            return new VAuthorizationsId(
                    auth.getRoleId(),
                    auth.getRoleName(),
                    auth.getUserId(),
                    auth.getUserName()
            );
        }).collect(Collectors.toList());

        return authorizations;
    }

    @Override
    public void saveRole(RoleDTO roleDTO) {
        Roles role = roleEntityMapper.convertOne(roleDTO);
        role.setId(roleRepository.getNextValue());

        roleRepository.save(role);
    }

    @Override
    public void updateUser(Integer id, RoleDTO roleDTO) {
        Roles role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role not found"));

        role.setName(roleDTO.getName());
        roleRepository.save(role);
    }
}
