package com.exampleagain.springbootajaxandjquery.controller.rest;

import com.exampleagain.springbootajaxandjquery.model.User;
import com.exampleagain.springbootajaxandjquery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class RestWebController {

    private UserService userService;

    @Autowired
    public RestWebController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<User> postSave(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<User> postUpdate(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }
}
