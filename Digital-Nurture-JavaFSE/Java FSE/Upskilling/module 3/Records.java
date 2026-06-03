import java.util.*;
public class Records {
    record Person(String name, int age) {}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of people: ");
        int n = sc.nextInt();
        Person[] peopleArray = new Person[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter name: ");
            String name = sc.next();
            System.out.println("Enter age: ");
            int age = sc.nextInt();
            peopleArray[i] = new Person(name, age);
        }
        System.out.println("Person Records:");
        for (Person person : peopleArray) {
            System.out.println(person);
        }
        List<Person> people = Arrays.asList(peopleArray);
        System.out.println("\nPeople with age > 20:");
        people.stream()
              .filter(person -> person.age() > 20)
              .forEach(System.out::println);
    }
}