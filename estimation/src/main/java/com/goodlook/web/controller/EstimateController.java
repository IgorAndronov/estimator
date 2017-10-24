package com.goodlook.web.controller;

import com.goodlook.dao.bo.SelectionCriteria;
import com.goodlook.dao.bo.entity.ExternalUser;
import com.goodlook.dao.bo.entity.UserFotoRefs;
import com.goodlook.dao.service.UserServiceDao;
import com.goodlook.logic.user.service.SelectionCriteriaService;
import com.goodlook.logic.user.service.UserService;
import com.goodlook.web.type.FotoData;
import com.goodlook.web.type.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 26.08.2017.
 */

@RestController
@RequestMapping(value="/api")
public class EstimateController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/users/", method= RequestMethod.GET)
    public ResponseEntity<List<UserData>> getUser() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        List<ExternalUser> externalUserList = userService.getExternalUserData();
        return  new ResponseEntity<List<UserData>>(mapExternalUserResponseList(externalUserList), responseHeaders, HttpStatus.OK);

    }

    @RequestMapping(value="/users/createTestData", method= RequestMethod.GET)
    public ResponseEntity<String> saveTestUsersData() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        return  new ResponseEntity<String>(userService.setTestExternalUsersData(), responseHeaders, HttpStatus.OK);

    }

    @RequestMapping(value="/users/get/{userId}", method= RequestMethod.GET)
    public ResponseEntity<UserData> getTestUsersData(@PathVariable Long userId) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        ExternalUser externalUser =userService.getExternalUserById(userId);


        return  new ResponseEntity<UserData>(mapExternalUserResponse(externalUser), responseHeaders, HttpStatus.OK);

    }

     List<UserData> mapExternalUserResponseList(List<ExternalUser> externalUserList){
        List<UserData> userDataList = new ArrayList<UserData>();
        for(ExternalUser externalUser:externalUserList){
            userDataList.add(mapExternalUserResponse(externalUser));
        }
        return userDataList;
     }

     UserData mapExternalUserResponse(ExternalUser externalUser){
         UserData userData = new UserData();
         userData.setUserId(externalUser.getUserId());
         userData.setName(externalUser.getName());
         userData.setClientMsg(externalUser.getClientMsg());
         userData.setUrlIcon(externalUser.getUrlIcon());
         userData.setPriority(externalUser.getPriority());

         List<FotoData> fotoDataList = new ArrayList<FotoData>();
         for(UserFotoRefs userFotoRefs:externalUser.getUserFotoRefs() ){
             FotoData fotoData = new FotoData();
             fotoData.setUrl(userFotoRefs.getUrl());
             fotoData.setInfo(userFotoRefs.getInfo());
             fotoDataList.add(fotoData);
         }
         userData.setUserFotos(fotoDataList);

         return userData;
    }

}
