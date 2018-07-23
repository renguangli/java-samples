package com.renguangli.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SerializableExamples
 *
 * @author renguangli 2018/7/10 17:41
 * @since JDK 1.8
 */
public class SerializableExamples{


    /**
     * 反序列化
     */
    public Product UnSerializer() {
        try (
            FileInputStream fis = new FileInputStream("d:/data/object.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
             return (Product) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 序列化
     */
    public void serializer() {
        try (FileOutputStream fis = new FileOutputStream("d:/data/object.data");ObjectOutputStream oos = new ObjectOutputStream(fis)) {
            Product product = new Product(1, "电脑", 4999);
            oos.writeObject(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SerializableExamples examples = new SerializableExamples();
        examples.serializer();
        Product product = examples.UnSerializer();
        System.out.println(product);
    }
}
