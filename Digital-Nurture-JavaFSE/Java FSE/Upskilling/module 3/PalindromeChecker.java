import java.util.*;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter :");
        String str = sc.nextLine();
        str = str.toLowerCase();
        String org = "";
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if((ch >= 'a' && ch <= 'z') ||(ch >= '0' && ch <= '9')) {
                org += ch;
            }
        }
        boolean f = true;
        int i = 0, j =org.length()-1;
        while(i<j){
            if(org.charAt(i)!=org.charAt(j)){
                f = false;
                break;
            }
            i++;
            j--;
        }
        if(f){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not a palindrome");
        }
    }
}