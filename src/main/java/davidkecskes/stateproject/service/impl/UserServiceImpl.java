package davidkecskes.stateproject.service.impl;

import davidkecskes.stateproject.dto.UserDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.mapper.UserDTOMapper;
import davidkecskes.stateproject.mapper.UserEntityMapper;
import davidkecskes.stateproject.model.Users;
import davidkecskes.stateproject.repository.AuthorizationRepository;
import davidkecskes.stateproject.repository.RoleRepository;
import davidkecskes.stateproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements davidkecskes.stateproject.service.UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final UserEntityMapper userEntityMapper;
    private final AuthorizationRepository authorizationRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userDTOMapper.convertList(userRepository.findAll());
    }

    @Override
    public UserDTO getUserDetails(String id) throws DataNotFoundException {
        return userDTOMapper.convertOne(
                userRepository.findById(id).
                        orElseThrow(
                                () -> new DataNotFoundException("There is no user with this id.")
                        )
        );
    }

    @Override
    public String registerUser(UserDTO userDTO) {
        // No further checking is needed because the firebase and frontend should check the data
        Users user = userEntityMapper.convertOne(userDTO);
        return userRepository.save(user).getId();
    }

    @Override
    public void updateUser(String id, UserDTO userDTO){
        // No further checking is needed because the firebase and frontend should check the data
        Users user = userRepository.findById(id).
                orElseThrow(() -> new DataNotFoundException("There is no user with this id."));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setProfilePicture(userDTO.getProfilePicture());

        userRepository.save(user);
    }
}