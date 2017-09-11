package com.goodlook.web.controller;

import com.goodlook.dao.bo.SelectionCriteria;
import com.goodlook.dao.bo.entity.ExternalUser;
import com.goodlook.dao.service.UserService;
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
        SelectionCriteria selectionCriteria = new SelectionCriteria();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        return  new ResponseEntity<List<ExternalUser>>(userService.getUsersData(selectionCriteria), responseHeaders, HttpStatus.OK);

    }


}