import entity.RichType;
import entity.User;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/7
 */
public class Test01 {

    public static void main(String[] args) {
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        Reflector reflector = reflectorFactory.findForClass(User.class);
        System.out.println("可读" + Arrays.toString(reflector.getGetablePropertyNames()));
        System.out.println("可写" + Arrays.toString(reflector.getSetablePropertyNames()));
        System.out.println("是否有默认构造器" + reflector.hasDefaultConstructor());
        System.out.println("Reflector对应的class" + reflector.getType());
    }

    @Test
    public void test01() throws Exception {
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        Reflector reflector = reflectorFactory.findForClass(User.class);
        Object o = reflector.getDefaultConstructor().newInstance();
        Invoker invoker = reflector.getSetInvoker("userId");
        invoker.invoke(o, new Object[] {1});
        System.out.println(o);
    }

    @Test
    public void test02() {
        ReflectorFactory factory = new DefaultReflectorFactory();
        MetaClass metaClass = MetaClass.forClass(RichType.class, factory);

        System.out.println(metaClass.hasGetter("richField"));
        System.out.println(metaClass.hasGetter("richProperty"));
        System.out.println(metaClass.hasGetter("richList"));
        System.out.println(metaClass.hasGetter("richMap"));
        System.out.println(metaClass.hasGetter("richList[0]"));

        System.out.println(metaClass.hasGetter("richType"));
        System.out.println(metaClass.hasGetter("richType.richField"));
        System.out.println(metaClass.hasGetter("richType.richProperty"));
        System.out.println(metaClass.hasGetter("richType.richList"));
        System.out.println(metaClass.hasGetter("richType.richMap"));
        System.out.println(metaClass.hasGetter("richType.richList[0]"));
        // findProperty 只能处理.的表达式
        System.out.println(metaClass.findProperty("richType.richProperty"));
        System.out.println(metaClass.findProperty("richType.richProperty1"));
        System.out.println(metaClass.findProperty("richList[0]"));
        System.out.println(Arrays.toString(metaClass.getGetterNames()));
    }

    @Test
    public void test03() {
        RichType richType = new RichType();
        MetaObject metaObject = SystemMetaObject.forObject(richType);
        metaObject.setValue("richField", "李四");
        System.out.println(metaObject.getValue("richField"));
    }

    @Test
    public void test04() {
        RichType richType = new RichType();
        MetaObject metaObject = SystemMetaObject.forObject(richType);
        metaObject.setValue("richType.richField", "李四1");
        System.out.println(metaObject.getValue("richType.richField"));
    }

    @Test
    public void test05() {
        RichType richType = new RichType();
        MetaObject metaObject = SystemMetaObject.forObject(richType);
        metaObject.setValue("richMap[0]", "李四2");
        System.out.println(metaObject.getValue("richMap[0]"));
    }
}
