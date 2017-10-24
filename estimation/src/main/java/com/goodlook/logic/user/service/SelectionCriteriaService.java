package com.goodlook.logic.user.service;

import com.goodlook.dao.bo.SelectionCriteria;

/**
 * Created by iandronov on 13.09.2017.
 */
public interface SelectionCriteriaService {
    SelectionCriteria getSelectionCriteria(String region);

    int calculatePriority();

    int calculateNextPriority(int currentPriority);

    int getAmountOfPriorityLevels();
}
