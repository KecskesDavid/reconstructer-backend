package davidkecskes.stateproject.mapper;

import davidkecskes.stateproject.dto.RoleDTO;
import davidkecskes.stateproject.model.Roles;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleDTOMapper implements Mapper<Roles, RoleDTO> {

    @Override
    public RoleDTO convertOne(Roles role) {
        return new RoleDTO(role.getId(), role.getName());
    }

    @Override
    public List<RoleDTO> convertList(List<Roles> roles) {
        return roles.stream().map(this::convertOne).collect(Collectors.toList());
    }

}
