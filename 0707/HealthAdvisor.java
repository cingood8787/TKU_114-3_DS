import java.util.Scanner;

public class HealthAdvisor {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String continueInput = "y";

        while (continueInput.equals("y")) {

            System.out.print("請輸入姓名：");
            String name = input.next();

            System.out.print("請輸入身高（公尺）：");
            double height = input.nextDouble();

            System.out.print("請輸入體重（公斤）：");
            double weight = input.nextDouble();

            double bmi = weight / (height * height);

            String level;

            if (bmi < 18.5) {
                level = "Underweight";
            } else if (bmi < 24) {
                level = "Normal";
            } else if (bmi < 27) {
                level = "Overweight";
            } else {
                level = "Obese";
            }

            System.out.println();
            System.out.println("=== BMI Report ===");
            System.out.println("Name: " + name);
            System.out.println("BMI: " + bmi);
            System.out.println("Level: " + level);
            System.out.println();

            System.out.print("是否繼續輸入下一筆？(y/n)：");
            continueInput = input.next();
            System.out.println();
        }

        input.close();
    }
}