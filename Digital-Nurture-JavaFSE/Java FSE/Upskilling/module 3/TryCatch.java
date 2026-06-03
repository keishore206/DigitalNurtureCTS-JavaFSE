import java.util.*;
public class TryCatch {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("ENter the first number ");
            int a = sc.nextInt();
            System.out.println("Enter the second number ");
            int b = sc.nextInt();
            int res = a / b; 
            System.out.println("Result: " + res);
        } catch (ArithmeticException e) {
            System.out.println("Second is 0");
        }
    }
}