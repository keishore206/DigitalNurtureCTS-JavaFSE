import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        List<Integer> org = a.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers: " + org);
    }
}