package com.hermes.designpattern.prototype.deepcopy;

import lombok.Data;

import java.io.*;

/**
 * @author liu.zongbin
 * @since 2022/8/14 21:49
 */
@Data
public class DeepPrototype implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String name;

    /**
     * 引用类型
     */
    private DeepCloneableTarget deepCloneableTarget;

    public DeepPrototype() {
        super();
    }

    @Override
    public DeepPrototype clone() throws CloneNotSupportedException {

        // 这里完成对基本数据类型和String的拷贝
        DeepPrototype deepPrototype = (DeepPrototype) super.clone();

        // 对引用类型的属性，进行单独处理
        deepPrototype.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

        return deepPrototype;
    }

    public DeepPrototype deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 当前这个对象以流的方式输出
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            return (DeepPrototype) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                // 关闭流
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
