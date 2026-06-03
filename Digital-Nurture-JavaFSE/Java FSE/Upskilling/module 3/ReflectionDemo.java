import java.lang.reflect.*;
public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("Student");
            System.out.println("Class Name: " + cls.getName());
            Method[] methods = cls.getDeclaredMethods();
            System.out.println("\nMethods in Class:");
            for (Method m : methods) {
                System.out.print("Method: " + m.getName());
                Parameter[] params = m.getParameters();
                System.out.print(" (");
                for (int i = 0; i < params.length; i++) {
                    System.out.print(params[i].getType().getSimpleName());
                    if (i < params.length - 1)
                        System.out.print(", ");
                }
                System.out.println(")");
            }
            Object obj = cls.getDeclaredConstructor().newInstance();
            Method greetMethod = cls.getMethod("greet", String.class);
            System.out.println("\nInvoking Method:");
            greetMethod.invoke(obj, "Karthik");            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}