package com.goodlook.logic.user.service.imp;

import com.goodlook.dao.bo.SelectionCriteria;
import com.goodlook.logic.user.PriorityLevel;
import com.goodlook.logic.user.service.SelectionCriteriaService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by admin on 10.09.2017.
 */
@Service
public class SelectionCriteriaServiceImp implements SelectionCriteriaService {
    static final int PRIORITY_LEVELS= 9;

    @Override
    public SelectionCriteria getSelectionCriteria(String region){
        SelectionCriteria selectionCriteria = new SelectionCriteria();
        selectionCriteria.setRegion(region);
        //selectionCriteria.setMaxNum(2);
        selectionCriteria.setPriority(calculatePriority());

        return selectionCriteria;
    }

    @Override
    public int calculatePriority() {

        List<Integer> values = new ArrayList<Integer>();
        for(int i=PRIORITY_LEVELS; i>=0; i--){
            for(int j=0; j<=i; j++){
                values.add(PRIORITY_LEVELS-i);
            }
        }
        System.out.println("before "+values);
        Collections.shuffle(values);
        System.out.println("after "+values);

        Long indexLong = new Long(Math.round(Math.random()*(values.size()-1)) ) ;
        int randomIndex = indexLong.intValue();
        System.out.println("random "+randomIndex);


        return values.get(randomIndex);
    }

    @Override
    public int calculateNextPriority(int currentPriority){
        return currentPriority+1>PRIORITY_LEVELS? 0:currentPriority+1;
    }

    @Override
    public int getAmountOfPriorityLevels(){
        return PRIORITY_LEVELS;
    }
}
