package com.goodlook.logic.user.service;

import com.goodlook.dao.bo.SelectionCriteria;

import java.util.*;

/**
 * Created by admin on 10.09.2017.
 */
public class SelectionCriteriaServiceImp {
    static final int PRIORITY_LEVELS=9;

    public SelectionCriteria getSelectionCriteria(String region){
        SelectionCriteria selectionCriteria = new SelectionCriteria();
        selectionCriteria.setRegion(region);
        selectionCriteria.setMaxNum(2);
        selectionCriteria.setPriority(calculatePriority());

        return selectionCriteria;
    }

    private int calculatePriority() {

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
}
