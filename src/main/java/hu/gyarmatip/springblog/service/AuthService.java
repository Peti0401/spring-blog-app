package hu.gyarmatip.springblog.service;

import hu.gyarmatip.springblog.dto.RegisterRequest;
import hu.gyarmatip.springblog.entity.User;

public interface AuthService {

    User signUp(RegisterRequest registerRequest);

}
