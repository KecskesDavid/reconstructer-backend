package davidkecskes.stateproject.service;

import davidkecskes.stateproject.dto.UserDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserDetails(String id) throws DataNotFoundException;

    String registerUser(UserDTO userDTO);

    void updateUser(String id, UserDTO userDTO);
}
