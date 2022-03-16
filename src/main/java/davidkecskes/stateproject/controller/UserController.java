package davidkecskes.stateproject.controller;

import davidkecskes.stateproject.dto.UserDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.service.UserService;
import davidkecskes.stateproject.service.impl.UserServiceImpl;
import davidkecskes.stateproject.utils.ExceptionHandlerUtils;
import davidkecskes.stateproject.utils.ResponseBodyUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "{userId}")
    public ResponseEntity<?> getUserDetails(@PathVariable("userId") String id) {
        try {
            return new ResponseEntity<>(userService.getUserDetails(id), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDTO) {
        try {
            userService.registerUser(userDTO);

            ResponseBodyUtil responseBodyUtil = new ResponseBodyUtil();
            responseBodyUtil.addToResponseBody("message", "User registered successfully!");

            return new ResponseEntity<>(responseBodyUtil.createResponseBody(), HttpStatus.OK);
        } catch (Exception e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @PutMapping(path = "{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") String id, @Valid @RequestBody UserDTO userDTO) {
        try {
            userService.updateUser(id, userDTO);
            return new ResponseEntity<>("Update successful!", HttpStatus.OK);
        } catch (Exception e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }
}
