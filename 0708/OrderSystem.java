import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option;
        int totalAmount = 0;
        int totalQuantity = 0;

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Black tea ($30)");
            System.out.println("2. Green tea ($35)");
            System.out.println("3. Coffee ($50)");
            System.out.println("0. Checkout");
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            if (option == 0) {
                break;
            }

            int price = 0;

            switch (option) {
                case 1:
                    price = 30;
                    break;
                case 2:
                    price = 35;
                    break;
                case 3:
                    price = 50;
                    break;
                default:
                    System.out.println("選項錯誤！");
                    continue;
            }

            System.out.print("請輸入數量：");
            int quantity = sc.nextInt();

            while (quantity <= 0) {
                System.out.print("數量不合法，請重新輸入：");
                quantity = sc.nextInt();
            }

            int subtotal = price * quantity;
            totalAmount += subtotal;
            totalQuantity += quantity;

            System.out.println("本次小計：" + subtotal);
            System.out.println();
        }

        System.out.println("=== Checkout ===");
        System.out.println("總數量：" + totalQuantity);
        System.out.println("總金額：" + totalAmount);

        sc.close();
    }
}