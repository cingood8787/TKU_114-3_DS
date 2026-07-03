import java.util.Scanner;

public class GreetingInput {
    public class InputProfile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = sc.nextLine();

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
         System.out.println("Hello, 姓名. You are 年齡 years old. " + age);

        sc.close();
    }
 }
}