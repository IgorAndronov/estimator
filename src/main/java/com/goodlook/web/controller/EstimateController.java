package com.goodlook.web.controller;

import com.goodlook.dao.bo.SelectionCriteria;
import com.goodlook.dao.bo.entity.ExternalUser;
import com.goodlook.dao.service.UserServiceDao;
import com.goodlook.logic.user.service.SelectionCriteriaService;
import com.goodlook.logic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 26.08.2017.
 */

@RestController
@RequestMapping(value="/api")
public class EstimateController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/users/{user}", method= RequestMethod.GET)
    public ResponseEntity<List<ExternalUser>> getUser(@PathVariable Long user) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        return  new ResponseEntity<List<ExternalUser>>(userService.getUsersData(), responseHeaders, HttpStatus.OK);

    }

    @RequestMapping(value="/users/createTestData", method= RequestMethod.GET)
    public ResponseEntity<String> saveTestUsersData() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        return  new ResponseEntity<String>(userService.setTestExternalUsersData(), responseHeaders, HttpStatus.OK);

    }

    @RequestMapping(value="/users/get/{userId}", method= RequestMethod.GET)
    public ResponseEntity<String> getTestUsersData(@PathVariable Long userId) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");



        return  new ResponseEntity<String>(userService.getExternalUserById(userId).getName(), responseHeaders, HttpStatus.OK);

    }

}
