package com.goodlook.dao.bo.entity;

import javax.persistence.*;

/**
 * Created by iandronov on 14.10.2017.
 */

@Entity
@Table(name = "Users_Fotos")
public class UserFotoRefs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    ExternalUser externalUser;

    @Column(name="url")
    String url;
    @Column(name="info")
    String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExternalUser getExternalUser() {
        return externalUser;
    }

    public void setExternalUser(ExternalUser externalUser) {
        this.externalUser = externalUser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
