public class MethodOverloading {
    public static int sum(int n1,int n2){
        return n1+n2;
    }
    public static double sum(double n1,double n2){
        return n1+n2;
    }
    public static int sum(int n1,int n2,int n3){
        return n1+n2+n3;
    }
    public static void main(String[] args) {
        System.out.println("Sum of 2 and 3: " + sum(2, 3));
        System.out.println("Sum of 2.5 and 3.5: " + sum(2.5, 3.5));
        System.out.println("Sum of 1, 2 and 3: " + sum(1, 2, 3));
    }
}