import java.util.Scanner;

public class JavaTesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== JAVA TESTING ===");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("\n--- RESULT ---");
        System.out.println("Hello, " + name + "!");
        System.out.println("Your age is " + age);

        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }

        sc.close();
    }
}