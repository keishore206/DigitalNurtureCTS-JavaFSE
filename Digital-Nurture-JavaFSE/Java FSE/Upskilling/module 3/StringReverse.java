import java.util.*;
public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String w = sc.nextLine();
        String rev = "";
        for(int i=w.length()-1;i>=0;i--){
            rev+=w.charAt(i);
        }
        System.out.println("Reversed of "+w+ " is "+rev);
    }
}