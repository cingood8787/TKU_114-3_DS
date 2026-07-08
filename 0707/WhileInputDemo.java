import java.util.Scanner;

public class WhileInputDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        while (number != 0) {
            System.out.println(number);
            number = input.nextInt();
        }

        System.out.println("End");
    }
}