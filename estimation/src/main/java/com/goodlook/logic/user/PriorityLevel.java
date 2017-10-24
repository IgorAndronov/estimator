package com.goodlook.logic.user;

import com.goodlook.dao.bo.SelectionCriteria;

/**
 * Created by iandronov on 14.10.2017.
 */
public enum PriorityLevel {
    Level0,Level1,Level2,Level3,Level4,Level5,Level6,Level7,Level8,Level9;

    public PriorityLevel nextLevel(){
        return this.ordinal()==9 ? Level0: PriorityLevel.values()[this.ordinal()+1] ;
    }
}
