package davidkecskes.stateproject.controller;

import davidkecskes.stateproject.dto.RoleDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.model.VAuthorizationsId;
import davidkecskes.stateproject.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping(path = "/role")
    public List<RoleDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping(path = "/role/{roleId}")
    public RoleDTO getRole(@PathVariable("roleId") Integer id) throws DataNotFoundException {
        return roleService.getRole(id);
    }

    @PutMapping(path = "/role/{roleId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> updateRole(@PathVariable("roleId") Integer id, @RequestBody RoleDTO roleDTO) {
        try {
            roleService.updateUser(id, roleDTO);
            return new ResponseEntity("Update successful!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/role")
    public ResponseEntity<?> saveRole(@RequestBody RoleDTO roleDTO) {
        try {
            roleService.saveRole(roleDTO);
            return new ResponseEntity("Role saved successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/authorization")
    public List<VAuthorizationsId> getAllAuthorizations() {
        return roleService.getAllAuthorizations();
    }
}
