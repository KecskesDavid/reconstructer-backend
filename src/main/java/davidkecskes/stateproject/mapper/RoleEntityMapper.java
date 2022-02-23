package davidkecskes.stateproject.mapper;

import davidkecskes.stateproject.dto.RoleDTO;
import davidkecskes.stateproject.model.Roles;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleEntityMapper implements Mapper<RoleDTO, Roles> {
    @Override
    public Roles convertOne(RoleDTO roleDTO) {
        return new Roles(0, roleDTO.getName());
    }

    @Override
    public List<Roles> convertList(List<RoleDTO> roleDTOs) {
        return roleDTOs.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
