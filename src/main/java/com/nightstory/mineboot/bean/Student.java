package com.nightstory.mineboot.bean;

/**
 * @Author: putao
 * @Date: 2018/12/12
 */
public class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getString(){
        return id + name;
    }
    protected String getTestId(){
        return id;
    }
}
