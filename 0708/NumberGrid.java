public class NumberGrid {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {      // 控制列數
            for (int j = 1; j <= 5; j++) {  // 控制欄數
                System.out.print(j + " ");
            }
            System.out.println(); // 換行
        }
    }
}