package com.goodlook.web.type;

import com.goodlook.dao.bo.entity.UserFotoRefs;

import javax.persistence.*;
import java.util.List;

/**
 * Created by iandronov on 14.10.2017.
 */
public class UserData {

    private Long userId;
    private String name;
    private String urlIcon;
    private Integer priority;
    private List<FotoData> userFotos;
    private String clientMsg;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<FotoData> getUserFotos() {
        return userFotos;
    }

    public void setUserFotos(List<FotoData> userFotos) {
        this.userFotos = userFotos;
    }

    public String getClientMsg() {
        return clientMsg;
    }

    public void setClientMsg(String clientMsg) {
        this.clientMsg = clientMsg;
    }
}
