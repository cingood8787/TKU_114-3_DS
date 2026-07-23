import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {

    static ArrayList<Course> courses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== 課程選課系統 =====");
            System.out.println("1. 新增課程");
            System.out.println("2. 選課");
            System.out.println("3. 退選");
            System.out.println("4. 刪除課程");
            System.out.println("5. 搜尋課程");
            System.out.println("6. 顯示所有課程");
            System.out.println("7. 統計資訊");
            System.out.println("0. 離開");
            System.out.print("請選擇：");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addCourse();
                    break;
                case "2":
                    enrollCourse();
                    break;
                case "3":
                    dropCourse();
                    break;
                case "4":
                    deleteCourse();
                    break;
                case "5":
                    searchCourse();
                    break;
                case "6":
                    showCourses();
                    break;
                case "7":
                    showStatistics();
                    break;
                case "0":
                    System.out.println("程式結束！");
                    return;
                default:
                    System.out.println("輸入錯誤，請重新輸入！");
            }
        }
    }

    // 新增課程
    public static void addCourse() {
        System.out.print("課程代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("代碼不可空白！");
            return;
        }

        if (findCourse(code) != null) {
            System.out.println("課程代碼不可重複！");
            return;
        }

        System.out.print("課程名稱：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("名稱不可空白！");
            return;
        }

        System.out.print("課程容量：");
        int capacity;

        try {
            capacity = Integer.parseInt(sc.nextLine());

            if (capacity <= 0) {
                System.out.println("容量必須大於0！");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("容量格式錯誤！");
            return;
        }

        courses.add(new Course(code, name, capacity));
        System.out.println("新增成功！");
    }

    // 選課
    public static void enrollCourse() {
        System.out.print("輸入課程代碼：");
        String code = sc.nextLine();

        Course course = findCourse(code);

        if (course == null) {
            System.out.println("找不到課程！");
        } else if (course.enroll()) {
            System.out.println("選課成功！");
        } else {
            System.out.println("課程已額滿！");
        }
    }

    // 退選
    public static void dropCourse() {
        System.out.print("輸入課程代碼：");
        String code = sc.nextLine();

        Course course = findCourse(code);

        if (course == null) {
            System.out.println("找不到課程！");
        } else if (course.drop()) {
            System.out.println("退選成功！");
        } else {
            System.out.println("目前沒有人選課！");
        }
    }

    // 刪除課程
    public static void deleteCourse() {
        System.out.print("輸入課程代碼：");
        String code = sc.nextLine();

        Course course = findCourse(code);

        if (course == null) {
            System.out.println("找不到課程！");
        } else {
            courses.remove(course);
            System.out.println("刪除成功！");
        }
    }

    // 搜尋課程
    public static void searchCourse() {
        System.out.print("輸入課程代碼：");
        String code = sc.nextLine();

        Course course = findCourse(code);

        if (course == null) {
            System.out.println("找不到課程！");
        } else {
            System.out.println(course);
        }
    }

    // 顯示全部課程
    public static void showCourses() {

        if (courses.isEmpty()) {
            System.out.println("目前沒有課程。");
            return;
        }

        System.out.println("\n===== 課程清單 =====");

        for (Course c : courses) {
            System.out.println(c);
        }
    }

    // 統計資訊
    public static void showStatistics() {

        int totalStudents = 0;
        int fullCourses = 0;

        for (Course c : courses) {
            totalStudents += c.getEnrolled();

            if (c.isFull()) {
                fullCourses++;
            }
        }

        System.out.println("\n===== 統計資訊 =====");
        System.out.println("總課程數：" + courses.size());
        System.out.println("總選課人次：" + totalStudents);
        System.out.println("額滿課程數：" + fullCourses);
    }

    // 搜尋課程
    public static Course findCourse(String code) {

        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }

        return null;
    }
}