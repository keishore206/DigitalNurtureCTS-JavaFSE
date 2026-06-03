class Car {
    String make;
    String model;
    int year;

    void displayDetails() {
        System.out.println("Make  : " + make);
        System.out.println("Model : " + model);
        System.out.println("Year  : " + year);
        System.out.println();
    }
}
public class ClassCar {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.make = "Karthi";
        car1.model = "23UCS080";
        car1.year = 2005;

        Car car2 = new Car();
        car2.make = "Mohan";
        car2.model = "23UCS001";
        car2.year = 1978;

        System.out.println("Car 1 Details:");
        car1.displayDetails();

        System.out.println("Car 2 Details:");
        car2.displayDetails();
    }
}