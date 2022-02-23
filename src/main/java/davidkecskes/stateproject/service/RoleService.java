package davidkecskes.stateproject.service;

import davidkecskes.stateproject.dto.RoleDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.model.VAuthorizationsId;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getAllRoles();

    RoleDTO getRole(Integer id) throws DataNotFoundException;

    List<VAuthorizationsId> getAllAuthorizations();

    void saveRole(RoleDTO roleDTO);

    void updateUser(Integer id, RoleDTO roleDTO);
}
