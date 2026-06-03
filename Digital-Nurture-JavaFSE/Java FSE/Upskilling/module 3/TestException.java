import java.util.*;
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
public class TestException {
    static void validate(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age invalid");
        } else {
            System.out.println("Valid age: " + age);
        }
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter age: ");
            int age = sc.nextInt();
            validate(age);
        } catch (CustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}