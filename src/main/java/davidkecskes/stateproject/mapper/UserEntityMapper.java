package davidkecskes.stateproject.mapper;

import davidkecskes.stateproject.dto.UserDTO;
import davidkecskes.stateproject.model.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserEntityMapper implements Mapper<UserDTO, Users> {

    @Override
    public Users convertOne(UserDTO userDTO) {
        return new Users(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPhoneNumber());
    }

    @Override
    public List<Users> convertList(List<UserDTO> userDTOs) {
        return userDTOs.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
