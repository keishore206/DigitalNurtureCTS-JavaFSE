import java.util.*;
public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n =sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements: ");
        int sum =0;
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            sum+= a[i];
        }
        System.out.println("Sum : "+sum);
        double average = (double)(sum)/n;
        System.out.println("Average : "+average);
    }
}