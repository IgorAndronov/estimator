package com.goodlook.web.type;

import javax.persistence.Column;

/**
 * Created by iandronov on 14.10.2017.
 */
public class FotoData {

    String url;
    String info;

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
