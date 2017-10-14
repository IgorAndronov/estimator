package com.goodlook.dao.bo.entity;
import javax.persistence.*;
import java.util.List;

/**
 * Created by admin on 10.09.2017.
 */
@Entity
@Table(name = "External_User")
public class ExternalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name="name")
    private String name;
    @Column(name="urlIcon")
    private String urlIcon;
    @Column(name = "priority")
    private Integer priority;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "externalUser")
    private List<UserFotoRefs> userFotoRefs;

    @Column(name = "clientMsg")
    private String clientMsg;


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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<UserFotoRefs> getUserFotoRefs() {
        return userFotoRefs;
    }

    public void setUserFotoRefs(List<UserFotoRefs> userFotoRefs) {
        this.userFotoRefs = userFotoRefs;
    }

    public String getClientMsg() {
        return clientMsg;
    }

    public void setClientMsg(String clientMsg) {
        this.clientMsg = clientMsg;
    }
}
