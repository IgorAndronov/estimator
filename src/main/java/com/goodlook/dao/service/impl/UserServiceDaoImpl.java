package com.goodlook.dao.service.impl;

import com.goodlook.dao.bo.SelectionCriteria;
import com.goodlook.dao.bo.entity.ExternalUser;
import com.goodlook.dao.bo.entity.UserFotoRefs;
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
        List<ExternalUser> externalUsers =new ArrayList<ExternalUser>();

        Query query=entityManager.createNamedQuery("usersSearchPriority");
        long minVal=1;
        long maxVal=selectionCriteria.getRecordsCount();

        if(selectionCriteria.getSecondLevelPriorities()==null ||selectionCriteria.getSecondLevelPriorities().isEmpty()) {
            minVal = selectionCriteria.getMinNum();
            maxVal = selectionCriteria.getMaxNum();

            query.setParameter("priority", selectionCriteria.getPriority())
                    .setParameter("MIN_VAL", minVal)
                    .setParameter("MAX_VAL", maxVal);
            externalUsers = query.getResultList();
        }else{
            for(int i=0; i< selectionCriteria.getSecondLevelPriorities().size();i++ ){
                if(i==selectionCriteria.getSecondLevelPriorities().size()-1){
                    minVal = selectionCriteria.getMinNum();
                    maxVal = selectionCriteria.getMaxNum();
                }
                query.setParameter("priority",selectionCriteria.getSecondLevelPriorities().get(i) )
                        .setParameter("MIN_VAL",minVal)
                        .setParameter("MAX_VAL", maxVal);
                List<ExternalUser> extraList =  query.getResultList();
                externalUsers.addAll(extraList);
            }
        }




        return externalUsers;
    }

    @Override
    public long getUsersCountPerSelectionCriteria(SelectionCriteria selectionCriteria){
        Query query = entityManager.createNamedQuery("usersCountByPerSelectionCriteria");
        query.setParameter("priority", selectionCriteria.getPriority());

        long count = ((BigInteger) query.getSingleResult()).longValue();

        if(selectionCriteria.getSecondLevelPriorities()!=null){
            for(int priority:selectionCriteria.getSecondLevelPriorities() ){
                query.setParameter("priority", priority);
                count+= ((BigInteger) query.getSingleResult()).longValue();
            }
        }


        return count;
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
    public ExternalUser getExternalUserById(Long id) {
        return entityManager.find(ExternalUser.class, id);
    }

    @Override
    public void delete(Long id) {
        ExternalUser externalUser = getExternalUserById(id);
        if (externalUser != null) {
            entityManager.remove(externalUser);
        }
    }

    @Override
    public String setTestExternalUsersData(){
        List<ExternalUser> externalUsers = new ArrayList<ExternalUser>();
        List<UserFotoRefs> fotoRefs = new ArrayList<UserFotoRefs>();

        ExternalUser externalUser = new ExternalUser();
        externalUser.setName("Olga");
        externalUser.setUrlIcon("../../assets/ng1.jpg");
        externalUser.setPriority(0);
        externalUsers.add(externalUser);

        UserFotoRefs userFotoRefs = new UserFotoRefs();
        userFotoRefs.setUrl("../../assets/ng1.jpg");
        userFotoRefs.setExternalUser(externalUser);
        fotoRefs.add(userFotoRefs);

        externalUser = new ExternalUser();
        externalUser.setName("Marina");
        externalUser.setUrlIcon("../../assets/ng2.jpg");
        externalUser.setPriority(1);
        externalUsers.add(externalUser);

        userFotoRefs = new UserFotoRefs();
        userFotoRefs.setUrl("../../assets/ng2.jpg");
        userFotoRefs.setExternalUser(externalUser);
        fotoRefs.add(userFotoRefs);

        externalUser = new ExternalUser();
        externalUser.setName("Svetlana");
        externalUser.setUrlIcon("../../assets/ng3.jpg");
        externalUser.setPriority(2);
        externalUsers.add(externalUser);

        userFotoRefs = new UserFotoRefs();
        userFotoRefs.setUrl("../../assets/ng3.jpg");
        userFotoRefs.setExternalUser(externalUser);
        fotoRefs.add(userFotoRefs);

        externalUser = new ExternalUser();
        externalUser.setName("Larisa");
        externalUser.setUrlIcon("../../assets/ng4.jpg");
        externalUser.setPriority(3);
        externalUsers.add(externalUser);

        userFotoRefs = new UserFotoRefs();
        userFotoRefs.setUrl("../../assets/ng4.jpg");
        userFotoRefs.setExternalUser(externalUser);
        fotoRefs.add(userFotoRefs);

        externalUser = new ExternalUser();
        externalUser.setName("Kseniya");
        externalUser.setUrlIcon("../../assets/ng5.jpg");
        externalUser.setPriority(4);
        externalUsers.add(externalUser);

        userFotoRefs = new UserFotoRefs();
        userFotoRefs.setUrl("../../assets/ng5.jpg");
        userFotoRefs.setExternalUser(externalUser);
        fotoRefs.add(userFotoRefs);

        for(ExternalUser user:externalUsers){
            entityManager.persist(user);
        }

        for(UserFotoRefs userFoto:fotoRefs){
            entityManager.persist(userFoto);
        }


        return ""+externalUsers.size();

    }
}


