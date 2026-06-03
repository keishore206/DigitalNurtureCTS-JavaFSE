import java.util.*;
public class HashMapNames {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of names: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter ID and Name: ");
            int id = sc.nextInt();
            String name = sc.next();
            map.put(id, name);
        }
        System.out.println("Key to search");
        int key = sc.nextInt();
        System.out.println("Value: " + map.get(key));
    }
}