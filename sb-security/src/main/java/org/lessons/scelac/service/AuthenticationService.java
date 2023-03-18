package org.lessons.scelac.service;

import org.lessons.scelac.dto.LoginRequestDTO;

/**
 * @author scelac
 */
public interface AuthenticationService {
    String authenticationAndGenerateJWT(LoginRequestDTO authenticationRequest);
}
