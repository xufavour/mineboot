package com.nightstory.mineboot.java.genericity;

/**
 * @Author: putao
 * @Date: 2019/3/6
 */
public class Fruit {
    private String name;
    private String color;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public void showInfo()
    {
        System.out.println(this.name + ":" + this.color);
    }

}
class Strawberry extends Fruit {

}

class Apple extends Fruit
{

}

class Orange extends Fruit
{

}
