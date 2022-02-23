package davidkecskes.stateproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "Not valid id")
    private String id;

    @NotBlank(message = "Not valid name")
    private String name;

    @Email(message = "Not valid email address")
    private String email;

    @NotBlank(message = "Not valid phone number")
    private String phoneNumber;
}
