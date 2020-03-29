package com.soen387.a2.controller;

import com.soen387.a2.CommonReturnType;
import com.soen387.a2.Model.UserModel;
import com.soen387.a2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/10/20
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public CommonReturnType login(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        UserModel userModel = userService.login(username, password);
        return CommonReturnType.create(userModel);
    }
}
