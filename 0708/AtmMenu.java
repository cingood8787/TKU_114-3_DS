import java.util.Scanner;

public class AtmMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int balance = 1000; // 初始餘額
        int option;

        while (true) {
            System.out.println("=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("0. Exit");
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("目前餘額：" + balance);
                    break;

                case 2:
                    System.out.print("請輸入存款金額：");
                    int deposit = sc.nextInt();

                    // 輸入驗證：存款必須大於 0
                    while (deposit <= 0) {
                        System.out.print("金額必須大於 0，請重新輸入：");
                        deposit = sc.nextInt();
                    }

                    balance += deposit;
                    System.out.println("存款成功！");
                    System.out.println("目前餘額：" + balance);
                    break;

                case 3:
                    System.out.print("請輸入提款金額：");
                    int withdraw = sc.nextInt();

                    // 輸入驗證：提款必須大於 0
                    while (withdraw <= 0) {
                        System.out.print("金額必須大於 0，請重新輸入：");
                        withdraw = sc.nextInt();
                    }

                    // 輸入驗證：提款不可超過餘額
                    while (withdraw > balance) {
                        System.out.print("餘額不足，請重新輸入提款金額：");
                        withdraw = sc.nextInt();
                    }

                    balance -= withdraw;
                    System.out.println("提款成功！");
                    System.out.println("目前餘額：" + balance);
                    break;

                case 0:
                    System.out.println("謝謝使用，再見！");
                    sc.close();
                    return;

                default:
                    System.out.println("選項錯誤！");
            }

            System.out.println();
        }
    }
}