package com.goodlook.dao.service;

import com.goodlook.dao.bo.SelectionCriteria;
import com.goodlook.dao.bo.entity.ExternalUser;

import java.util.List;

/**
 * Created by admin on 10.09.2017.
 */

public interface UserServiceDao {
    public List<ExternalUser> getUsersData(SelectionCriteria selectionCriteria);

    long getUsersCountPerSelectionCriteria(SelectionCriteria selectionCriteria);

    String create(ExternalUser externalUser);

    void update(ExternalUser externalUser);

    ExternalUser getExternalUserById(Long id);

    void delete(Long id);

    String setTestExternalUsersData();
}
