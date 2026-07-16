publimport java.util.Scanner;

public class ArrayStatistics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取資料筆數
        int count = readCount(sc);

        // 建立陣列
        int[] scores = new int[count];

        // 輸入成績
        inputScores(sc, scores);

        // 顯示全部成績
        System.out.println("\n全部成績：");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("第 " + (i + 1) + " 筆：" + scores[i]);
        }

        // 統計資料
        int total = calculateTotal(scores);
        double average = (double) total / scores.length;
        int max = findMax(scores);
        int min = findMin(scores);
        int pass = countPass(scores);
        int fail = scores.length - pass;

        // 顯示統計結果
        System.out.println("\n統計結果：");
        System.out.println("總分：" + total);
        System.out.printf("平均：%.2f\n", average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("及格人數：" + pass);
        System.out.println("不及格人數：" + fail);

        // 搜尋成績
        System.out.print("\n請輸入要搜尋的成績：");
        int target = sc.nextInt();

        int index = findIndex(scores, target);

        if (index != -1) {
            System.out.println("第一次出現的索引為：" + index);
        } else {
            System.out.println("找不到該成績。");
        }

        sc.close();
    }

    // 讀取資料筆數(1~50)
    public static int readCount(Scanner sc) {
        int count;

        while (true) {
            System.out.print("請輸入資料筆數(1~50)：");
            count = sc.nextInt();

            if (count >= 1 && count <= 50) {
                return count;
            } else {
                System.out.println("輸入錯誤，請重新輸入！");
            }
        }
    }

    // 輸入成績(0~100)
    public static void inputScores(Scanner sc, int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            while (true) {
                System.out.print("請輸入第 " + (i + 1) + " 筆成績(0~100)：");
                int score = sc.nextInt();

                if (score >= 0 && score <= 100) {
                    scores[i] = score;
                    break;
                } else {
                    System.out.println("成績錯誤，請重新輸入！");
                }
            }
        }
    }

    // 計算總分
    public static int calculateTotal(int[] scores) {
        int total = 0;

        for (int score : scores) {
            total += score;
        }

        return total;
    }

    // 找最高分
    public static int findMax(int[] scores) {
        int max = scores[0];

        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        return max;
    }

    // 找最低分
    public static int findMin(int[] scores) {
        int min = scores[0];

        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }

        return min;
    }

    // 計算及格人數
    public static int countPass(int[] scores) {
        int count = 0;

        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }

        return count;
    }

    // 找第一次出現的索引
    public static int findIndex(int[] scores, int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                return i;
            }
        }

        return -1;
    }
}