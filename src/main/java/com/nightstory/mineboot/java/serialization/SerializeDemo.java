package com.nightstory.mineboot.java.serialization;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @Author: putao
 * @Date: 2019/1/11
 */
public class SerializeDemo {

    public static void main(String[] args) {
      User user = new User();
      user.setAge(18);
      user.setName("hhh");
        byte[] bytes = serialize(user);
        System.out.println(new String(bytes));
        User user1 = deserialize(bytes);
    }


    public static <T> byte[] serializer(T o) {
        Schema schema = RuntimeSchema.getSchema(o.getClass());
        return ProtobufIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(256));
    }
    private static RuntimeSchema<User> schema = RuntimeSchema.createFrom(User.class);

    /**
     * 序列化方法，将User对象序列化为字节数组
     * @param user
     * @return
     */
    public static byte[] serialize(User user) {
        // Serializes the {@code message} into a byte array using the given schema
        return ProtostuffIOUtil.toByteArray(user, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }

    /**
     * 反序列化方法，将字节数组反序列化为User对象
     * @param array
     * @return
     */
    public static User deserialize(byte[] array) {
        User user = schema.newMessage();
        // Merges the {@code message} with the byte array using the given {@code schema}
        ProtostuffIOUtil.mergeFrom(array, user, schema);
        return user;
    }
}
