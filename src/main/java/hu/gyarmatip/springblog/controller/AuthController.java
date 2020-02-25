package hu.gyarmatip.springblog.controller;

import hu.gyarmatip.springblog.dto.RegisterRequest;
import hu.gyarmatip.springblog.entity.User;
import hu.gyarmatip.springblog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody RegisterRequest registerRequest) {
        User signedUpUser = authService.signUp(registerRequest);
        return ResponseEntity.ok(signedUpUser);
    }
}
