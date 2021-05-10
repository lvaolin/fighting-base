package com.dhy.leetcode.loadbanlance;

import java.io.Serializable;

public class DbKeyWeightDto implements Serializable {

    private static final long serialVersionUID = -5196176232082947951L;

    public DbKeyWeightDto() {
    }

    public DbKeyWeightDto(String dbkey, Integer weight) {
        this.dbkey = dbkey;
        this.weight = weight;
    }

    private String dbkey;

    private Integer weight;

    public String getDbkey() {
        return dbkey;
    }

    public void setDbkey(String dbkey) {
        this.dbkey = dbkey;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}