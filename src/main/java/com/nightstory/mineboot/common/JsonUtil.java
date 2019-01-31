package com.nightstory.mineboot.common;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private static final Gson gson = new Gson();

    /**
     * json数据转List<T> 对象.
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String data, Class<T> clazz){
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        return gson.fromJson(data, listType);
    }

    public static String objToStr(Object o){
        return gson.toJson(o);
    }





     static class ParameterizedTypeImpl implements ParameterizedType {
        private final Class raw;
        private final Type[] args;
        public ParameterizedTypeImpl(Class raw, Type[] args) {
            this.raw = raw;
            this.args = args != null ? args : new Type[0];
        }
        @Override
        public Type[] getActualTypeArguments() {
            return args;
        }
        @Override
        public Type getRawType() {
            return raw;
        }
        @Override
        public Type getOwnerType() {return null;}
    }

}
