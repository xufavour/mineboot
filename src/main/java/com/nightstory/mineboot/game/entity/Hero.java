package com.nightstory.mineboot.game.entity;

/**
 * @Author: putao
 * @Date: 2019/1/30
 */
public class Hero {

    private String name;
    private double hp;
    private double harm;

    public void attack(Hero target){
       target.setHp(target.getHp() - harm);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getHarm() {
        return harm;
    }

    public void setHarm(double harm) {
        this.harm = harm;
    }
}
