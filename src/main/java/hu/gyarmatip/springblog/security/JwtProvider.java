package hu.gyarmatip.springblog.security;

import org.springframework.security.core.Authentication;

public interface JwtProvider {

    String generateToken(Authentication authentication);

}
