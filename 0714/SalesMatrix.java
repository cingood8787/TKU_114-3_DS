import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 3列4欄：3項商品、4天
        int[][] sales = new int[3][4];

        inputSales(sc, sales);

        System.out.println("\n===== 銷售資料 =====");
        displaySales(sales);

        System.out.println("\n===== 每項商品總銷售量 =====");
        calculateProductTotal(sales);

        System.out.println("\n===== 每天總銷售量 =====");
        calculateDayTotal(sales);

        int bestProduct = findBestProduct(sales);
        System.out.println("\n總銷售量最高的商品：商品 " + (bestProduct + 1));

        sc.close();
    }

    // 輸入銷售量(不可小於0)
    public static void inputSales(Scanner sc, int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                while (true) {
                    System.out.print("請輸入商品" + (i + 1) + " 第" + (j + 1) + "天銷售量：");
                    int value = sc.nextInt();

                    if (value >= 0) {
                        sales[i][j] = value;
                        break;
                    } else {
                        System.out.println("輸入錯誤！銷售量不可小於0，請重新輸入。");
                    }
                }
            }
        }
    }

    // 顯示表格
    public static void displaySales(int[][] sales) {
        System.out.print("\t第1天\t第2天\t第3天\t第4天\n");

        for (int i = 0; i < sales.length; i++) {
            System.out.print("商品" + (i + 1) + "\t");
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 每項商品總銷售量
    public static void calculateProductTotal(int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            int total = 0;
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
            System.out.println("商品" + (i + 1) + " 總銷售量：" + total);
        }
    }

    // 每天總銷售量
    public static void calculateDayTotal(int[][] sales) {
        for (int j = 0; j < sales[0].length; j++) {
            int total = 0;
            for (int i = 0; i < sales.length; i++) {
                total += sales[i][j];
            }
            System.out.println("第" + (j + 1) + "天 總銷售量：" + total);
        }
    }

    // 找出總銷售量最高的商品
    public static int findBestProduct(int[][] sales) {
        int maxIndex = 0;
        int maxTotal = 0;

        for (int j = 0; j < sales[0].length; j++) {
            maxTotal += sales[0][j];
        }

        for (int i = 1; i < sales.length; i++) {
            int total = 0;
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }

            if (total > maxTotal) {
                maxTotal = total;
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}