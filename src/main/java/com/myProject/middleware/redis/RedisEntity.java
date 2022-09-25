package com.myProject.middleware.redis;

import java.io.Serializable;

public class RedisEntity implements Serializable {

    private static final long serialVersionUID = -8647523043631048788L;

    public RedisEntity() {
    }

    private String guoId;
    private String guoName;
    private Integer guoAge;

    public RedisEntity(String guoId, String guoName, Integer guoAge) {
        this.guoId = guoId;
        this.guoName = guoName;
        this.guoAge = guoAge;
    }

    public String getGuoId() {
        return guoId;
    }

    public void setGuoId(String guoId) {
        this.guoId = guoId;
    }

    public String getGuoName() {
        return guoName;
    }

    public void setGuoName(String guoName) {
        this.guoName = guoName;
    }

    public Integer getGuoAge() {
        return guoAge;
    }

    public void setGuoAge(Integer guoAge) {
        this.guoAge = guoAge;
    }

    @Override
    public String toString() {
        return "RedisEntity{" +
                "guoId='" + guoId + '\'' +
                ", guoName='" + guoName + '\'' +
                ", guoAge=" + guoAge +
                '}';
    }
}
