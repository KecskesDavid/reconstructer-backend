package davidkecskes.stateproject.mapper;

import davidkecskes.stateproject.dto.UserDTO;
import davidkecskes.stateproject.model.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDTOMapper implements Mapper<Users, UserDTO> {
    @Override
    public UserDTO convertOne(Users user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhoneNumber(), user.getProfilePicture());
    }

    @Override
    public List<UserDTO> convertList(List<Users> users) {
        return users.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
