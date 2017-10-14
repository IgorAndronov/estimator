package com.goodlook.logic.user.service.imp;

import com.goodlook.dao.bo.SelectionCriteria;
import com.goodlook.dao.bo.entity.ExternalUser;
import com.goodlook.dao.service.UserServiceDao;
import com.goodlook.logic.user.PriorityLevel;
import com.goodlook.logic.user.service.SelectionCriteriaService;
import com.goodlook.logic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by iandronov on 13.09.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final int MAX_TRIES_WHEN_NOT_FOUND =20 ;
    @Autowired
    UserServiceDao userServiceDao;

    @Autowired
    SelectionCriteriaService selectionCriteriaService;

    @Override
    public List<ExternalUser> getExternalUserData(){

        SelectionCriteria selectionCriteria = new SelectionCriteria();
        int priorityLevel = selectionCriteriaService.calculatePriority();
        System.out.println("priorityLevel="+priorityLevel);
        selectionCriteria.setPriority(priorityLevel);
        selectionCriteria.setRecordsCount(3); //TODO make a parametr
        calculateMinMaxNum(selectionCriteria);

        List<ExternalUser> externalUsers=  userServiceDao.getUsersData(selectionCriteria);

        int iterationAmmount = selectionCriteriaService.getAmountOfPriorityLevels();
        while((externalUsers==null || externalUsers.isEmpty()) && iterationAmmount>=0 ){
            iterationAmmount--;
            selectionCriteria.setPriority(selectionCriteriaService.calculateNextPriority(selectionCriteria.getPriority()));
            externalUsers=  userServiceDao.getUsersData(selectionCriteria);
        }

        return externalUsers;

    }

    private void calculateMinMaxNum(SelectionCriteria selectionCriteria) {
        long dbCount =0;
        long dbCountPrevLevel=0;
        int nextPriorityLevel=selectionCriteria.getPriority();
        int displayRecordsCount = selectionCriteria.getRecordsCount();
        for(int i=0;i<=selectionCriteriaService.getAmountOfPriorityLevels();i++){ //restrict ammount of iterations to avoid infinit loop
            dbCount = userServiceDao.getUsersCountPerSelectionCriteria(selectionCriteria);
            if(dbCount<displayRecordsCount){
                nextPriorityLevel=selectionCriteriaService.calculateNextPriority(nextPriorityLevel);
                selectionCriteria.getSecondLevelPriorities().add(nextPriorityLevel);
                dbCountPrevLevel=dbCount;
            }else{
                break;
            }
        }

        displayRecordsCount=((Long)(new Long(displayRecordsCount)-dbCountPrevLevel)).intValue();
        long ammountOfSlots = (long) Math.floor((dbCount-dbCountPrevLevel)/displayRecordsCount);
        int remainCount = (int)(dbCount-dbCountPrevLevel)%displayRecordsCount;
        if(remainCount>0){
            ammountOfSlots++;
        }
        long randomSlotIndex = Math.round(Math.random()*(ammountOfSlots-1));
        long minNum,maxNum=0L;
        if(randomSlotIndex==ammountOfSlots-1){
            maxNum=dbCount-dbCountPrevLevel;
            minNum=maxNum-displayRecordsCount;

        }else{
            minNum = randomSlotIndex*displayRecordsCount+1;
            maxNum = minNum+displayRecordsCount;
        }
        selectionCriteria.setMinNum(minNum);
        selectionCriteria.setMaxNum(maxNum);

    }

    @Override
    public String create(ExternalUser externalUser) {
        return userServiceDao.create(externalUser);
    }

    @Override
    public String setTestExternalUsersData() {
        return userServiceDao.setTestExternalUsersData();
    }

    @Override
    public ExternalUser getExternalUserById(long id) {
        return userServiceDao.getExternalUserById(id);
    }


}
