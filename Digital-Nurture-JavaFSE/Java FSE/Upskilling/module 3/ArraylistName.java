import java.util.*;
public class ArraylistName {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of names: ");
        int n = sc.nextInt();
        System.out.println("Enter the names: ");
        for(int i=0;i<n;i++){
            String name = sc.next();
            a.add(name);
        }
        System.out.println("Names :");
        for(String name : a){
            System.out.println(name);
        }
    }
}