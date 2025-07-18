package com.ecomweb.demo.service.interf;

import com.ecomweb.demo.dto.LoginRequest;
import com.ecomweb.demo.dto.Response;
import com.ecomweb.demo.dto.UserDto;
import com.ecomweb.demo.entity.User;

public interface UserService {
    Response registerUser(UserDto registrationRequest);
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    User getLoginUser();
    Response getUserInfoAndOrderHistory();
}
