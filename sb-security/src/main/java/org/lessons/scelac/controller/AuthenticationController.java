package org.lessons.scelac.controller;

import org.lessons.scelac.dto.ApiResponseDTO;
import org.lessons.scelac.dto.JwtAuthenticationResponseDTO;
import org.lessons.scelac.dto.LoginRequestDTO;
import org.lessons.scelac.dto.RegisterUserDTO;
import org.lessons.scelac.model.User;
import org.lessons.scelac.service.AuthenticationService;
import org.lessons.scelac.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author scelac
 */
@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponseDTO> login( @RequestBody LoginRequestDTO authenticationRequest) {
        String jwt = authenticationService.authenticationAndGenerateJWT(authenticationRequest);

        return ResponseEntity.ok(new JwtAuthenticationResponseDTO(jwt));
    }

    @PostMapping("/signup")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserDTO registerUser) {
        if (userService.existsByEmail(registerUser.getEmail())) {
            return new ResponseEntity<>(new ApiResponseDTO(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        User result = userService.save(registerUser);
        //todo response logic on create user
        return new ResponseEntity<>(new ApiResponseDTO(true, "UserAccount registered successfully"), HttpStatus.OK);
    }
}
