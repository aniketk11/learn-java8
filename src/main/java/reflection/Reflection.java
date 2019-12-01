package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection extends Student{

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {

        Student student = new Student();
        Field field = Student.class.getDeclaredField("id");
        field.setAccessible(true);
        System.out.println(field.get(student));
        field.set(student,"2000");
        System.out.println(field.get(student));

        Field[] fields = Student.class.getDeclaredFields();

        for (Field f : fields) {
            f.setAccessible(true);
            System.out.println(f.getName());
        }

        Method[] methods = Student.class.getDeclaredMethods();

        for (Method m : methods) {
            m.setAccessible(true);
            System.out.println(m.getName());
            System.out.println(m.invoke(student,null));
        }
    }
}
