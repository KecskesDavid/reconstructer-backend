package davidkecskes.stateproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private int id;
    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }
}
