package com.goodlook.dao.service.impl;

import com.goodlook.dao.bo.SelectionCriteria;
import com.goodlook.dao.bo.entity.ExternalUser;
import com.goodlook.dao.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10.09.2017.
 */

@Component
public class UserServiceImpl implements UserService {

    @Override
    public List<ExternalUser> getUsersData(SelectionCriteria selectionCriteria){
        List<ExternalUser> externalUsers = new ArrayList<ExternalUser>();
        ExternalUser externalUser = new ExternalUser();
        externalUser.setName("Olga");
        externalUser.setUrlIcon("../../assets/ng1.jpg");
        externalUsers.add(externalUser);

        externalUser = new ExternalUser();
        externalUser.setName("Marina");
        externalUser.setUrlIcon("../../assets/ng2.jpg");
        externalUsers.add(externalUser);

        externalUser = new ExternalUser();
        externalUser.setName("Svetlana");
        externalUser.setUrlIcon("../../assets/ng3.jpg");
        externalUsers.add(externalUser);

        externalUser = new ExternalUser();
        externalUser.setName("Larisa");
        externalUser.setUrlIcon("../../assets/ng4.jpg");
        externalUsers.add(externalUser);

        externalUser = new ExternalUser();
        externalUser.setName("Kseniya");
        externalUser.setUrlIcon("../../assets/ng5.jpg");
        externalUsers.add(externalUser);

        return externalUsers;
    }
}


