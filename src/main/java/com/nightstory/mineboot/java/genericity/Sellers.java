package com.nightstory.mineboot.java.genericity;

import java.util.ArrayList;
import java.util.List;

public class Sellers<T extends Fruit>
{
    // 使用属性记录售卖某种水果的最佳日期
    public ArrayList<String> list = new ArrayList<>();
    public List<Strawberry> BerryDateList = new ArrayList<Strawberry>();
    public List<Apple> AppleDateList = new ArrayList<Apple>();
    public List<Orange> OrangeDateList = new ArrayList<Orange>();

    // 获取具体的水果品种售卖时间列表
    public List<Apple> getAppleList(List<Apple> eList)
    {
        ArrayList<Apple> appleList  =  new  ArrayList<Apple> ();
        return null;
    }

    // 使用泛型extends解决调用实体方法名称带来的异常
    public void getInfo(T t)
    {
        t.showInfo();
    }

    // 获取某种类水果日期销售列表
    public List<T> getList(List<T> eProduuctList)
    {
        return null;
    }

    public static <T> T getListByStatic(List<T> eList)
    {
        return null;
    }

}
class SelfEmployed extends Sellers<Orange>
{

}