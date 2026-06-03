import java.util.*;
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int n1 = sc.nextInt();
        System.out.println("Enter the second number");
        int n2 = sc.nextInt();
        System.out.println("Enter the operation : (+,-,*,/)");
        char op = sc.next().charAt(0);
        switch(op){
            case '+':
                System.out.println("The sum is : "+(n1+n2));
                break;
            case '-':
                System.out.println("The difference is : "+(n1-n2));
                break;
            case '*':
                System.out.println("The product is : "+(n1*n2));
                break;
            case '/':
                if(n2!=0){
                    System.out.println("The quotient is : "+(n1/n2));
                }
                else{
                    System.out.println("Cannot divide by zero");
                }
                break;
            default:
                System.out.println("Invalid operation");
        } 
    }
}