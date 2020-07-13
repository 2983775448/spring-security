package com.zj.domain;

public class Permission {
    private int id;
    private String permName;
    private String permTag;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermTag() {
        return permTag;
    }

    public void setPermTag(String permTag) {
        this.permTag = permTag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
