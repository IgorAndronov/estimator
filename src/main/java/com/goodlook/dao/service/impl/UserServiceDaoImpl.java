package com.goodlook.dao.service.impl;

import com.goodlook.dao.bo.SelectionCriteria;
import com.goodlook.dao.bo.entity.ExternalUser;
import com.goodlook.dao.service.UserServiceDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10.09.2017.
 */

@Repository
@Transactional
public class UserServiceDaoImpl implements UserServiceDao {

   @PersistenceContext
   private EntityManager entityManager;


    @Override
    public List<ExternalUser> getUsersData(SelectionCriteria selectionCriteria){
        Query query=entityManager.createNamedQuery("usersSearchPriority")
                .setParameter("priority", selectionCriteria.getPriority())
                .setParameter("MIN_VAL",selectionCriteria.getMinNum())
                .setParameter("MAX_VAL", selectionCriteria.getMaxNum());

        List<ExternalUser> externalUsers = query.getResultList();


        return externalUsers;
    }

    @Override
    public long getUsersCountPerSelectionCriteria(SelectionCriteria selectionCriteria){
        Query query=entityManager.createNamedQuery("usersCountByPerSelectionCriteria")
                .setParameter("priority", selectionCriteria.getPriority());


        BigInteger count = (BigInteger) query.getSingleResult();


        return count.longValue();
    }

    @Override
    public String create(ExternalUser externalUser) {
        entityManager.persist(externalUser);
        return "ok";
    }

    @Override
    public void update(ExternalUser externalUser) {
        entityManager.merge(externalUser);
    }

    @Override
    public ExternalUser getExternalUserById(long id) {
        return entityManager.find(ExternalUser.class, id);
    }

    @Override
    public void delete(long id) {
        ExternalUser externalUser = getExternalUserById(id);
        if (externalUser != null) {
            entityManager.remove(externalUser);
        }
    }

    @Override
    public String setTestExternalUsersData(){
        List<ExternalUser> externalUsers = new ArrayList<ExternalUser>();
        ExternalUser externalUser = new ExternalUser();
        externalUser.setName("Olga");
        externalUser.setUrlIcon("../../assets/ng1.jpg");
        externalUser.setPriority(0);
        externalUsers.add(externalUser);

        externalUser = new ExternalUser();
        externalUser.setName("Marina");
        externalUser.setUrlIcon("../../assets/ng2.jpg");
        externalUser.setPriority(1);
        externalUsers.add(externalUser);

        externalUser = new ExternalUser();
        externalUser.setName("Svetlana");
        externalUser.setUrlIcon("../../assets/ng3.jpg");
        externalUser.setPriority(2);
        externalUsers.add(externalUser);

        externalUser = new ExternalUser();
        externalUser.setName("Larisa");
        externalUser.setUrlIcon("../../assets/ng4.jpg");
        externalUser.setPriority(3);
        externalUsers.add(externalUser);

        externalUser = new ExternalUser();
        externalUser.setName("Kseniya");
        externalUser.setUrlIcon("../../assets/ng5.jpg");
        externalUser.setPriority(4);
        externalUsers.add(externalUser);

        for(ExternalUser user:externalUsers){
            entityManager.persist(user);
        }


        return ""+externalUsers.size();

    }
}


