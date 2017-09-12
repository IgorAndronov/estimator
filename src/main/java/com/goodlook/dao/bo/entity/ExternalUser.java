package com.goodlook.dao.bo.entity;
import javax.persistence.*;

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
}
