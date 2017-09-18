package com.goodlook.logic.user.service;

import com.goodlook.dao.bo.entity.ExternalUser;

import java.util.List;

/**
 * Created by iandronov on 13.09.2017.
 */
public interface UserService {
    List<ExternalUser> getUsersData();
    String create(ExternalUser externalUser);
    String setTestExternalUsersData();
    ExternalUser getExternalUserById(long id);
}
