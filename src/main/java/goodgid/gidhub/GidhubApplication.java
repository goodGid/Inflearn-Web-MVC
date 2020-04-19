package goodgid.gidhub;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GidhubApplication {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
                   InvocationTargetException, InstantiationException, NoSuchFieldException {
//        SpringApplication.run(GidhubApplication.class, args);



        zlass();

        a();

        b();

        c();

        sum();



    }

    public static void zlass() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
                                   InvocationTargetException, InstantiationException {
        Class<?> bookClass = Class.forName("goodgid.gidhub.Book");
        Constructor<?> constructors = bookClass.getConstructor(null);
        Book book = (Book) constructors.newInstance();
        System.out.println(book);

        constructors = bookClass.getConstructor(String.class);
        book = (Book) constructors.newInstance("B");
        System.out.println(book);

    }

    public static void a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
                           InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("goodgid.gidhub.Book");
        Constructor<?> constructors = bookClass.getConstructor(null);
        Book book = (Book) constructors.newInstance();

        Field staticField = Book.class.getDeclaredField("A");
        Object o = staticField.get(null);// instance 마다 다르지 않고 모든 클래스가 같으니까 null
        System.out.println(o);

        staticField.set(null, "A by Reflection");
        o = staticField.get(null);
        System.out.println(o);

    }

    public static void b() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
                           InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("goodgid.gidhub.Book");
        Constructor<?> constructors = bookClass.getConstructor(null);
        Book book = (Book) constructors.newInstance();

        Field instanceField = Book.class.getDeclaredField("b");
        instanceField.setAccessible(true);

        Object o1 = instanceField.get(book); // 특정 인스턴스를 거쳐서 갖고 와야 한다.
        System.out.println(o1);

        instanceField.set(book, "B by Reflection");
        o1 = instanceField.get(book);
        System.out.println(o1);

    }

    public static void c() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
                           InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("goodgid.gidhub.Book");
        Constructor<?> constructors = bookClass.getConstructor(null);
        Book book = (Book) constructors.newInstance();

        Method m = Book.class.getDeclaredMethod("c");
        m.setAccessible(true);

        // 특정한 인스턴스에 해당하는 메소드면 인스턴스를 넘겨줘야한다.
        m.invoke(book);
        // m.invoke(book,1,2);// 파라미터는 c라는 메소드에 넘겨줘야할 파라미터들이다.

    }

    public static void sum() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException,
                             InvocationTargetException, InstantiationException {
        Class<?> bookClass = Class.forName("goodgid.gidhub.Book");
        Constructor<?> constructors = bookClass.getConstructor(null);
        Book book = (Book) constructors.newInstance();

        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int sum = (int) d.invoke(book, 1, 2);
        System.out.println(sum);

    }

}
