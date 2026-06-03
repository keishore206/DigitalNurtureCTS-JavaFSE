import java.util.*;
public class RecursiveFibonacci {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        if(n<0){
            System.out.println("Negative number");
        }else{
            int res = fibonacci(n);
            System.out.println("Fibonacci of " + n + ": "+ res);
        }
    }
}