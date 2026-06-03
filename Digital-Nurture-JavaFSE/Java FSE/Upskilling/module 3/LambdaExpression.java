import java.util.*;
public class LambdaExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        List<String> name = new ArrayList<>();
        System.out.println("Enter the names: ");
        for(int i=0;i<n;i++){
            name.add(sc.next());
        }
        Collections.sort(name, (a, b) -> a.compareTo(b));
        System.out.println("Sorted names: ");
        for(String n1 : name){
            System.out.println(n1);
        }
    }
}