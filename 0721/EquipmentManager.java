import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {

    static ArrayList<Equipment> equipments = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== 設備管理系統 =====");
            System.out.println("1. 新增設備");
            System.out.println("2. 依代碼搜尋");
            System.out.println("3. 借出設備");
            System.out.println("4. 歸還設備");
            System.out.println("5. 列出可借設備");
            System.out.println("0. 離開");
            System.out.print("請選擇：");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addEquipment();
                    break;
                case "2":
                    searchEquipment();
                    break;
                case "3":
                    borrowEquipment();
                    break;
                case "4":
                    returnEquipment();
                    break;
                case "5":
                    listAvailableEquipment();
                    break;
                case "0":
                    System.out.println("程式結束！");
                    return;
                default:
                    System.out.println("輸入錯誤，請重新輸入！");
            }
        }
    }

    // 新增設備
    public static void addEquipment() {
        System.out.print("請輸入設備代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("代碼不可空白！");
            return;
        }

        if (findEquipment(code) != null) {
            System.out.println("代碼不可重複！");
            return;
        }

        System.out.print("請輸入設備名稱：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("名稱不可空白！");
            return;
        }

        equipments.add(new Equipment(code, name));
        System.out.println("新增成功！");
    }

    // 搜尋設備
    public static void searchEquipment() {
        System.out.print("請輸入設備代碼：");
        String code = sc.nextLine();

        Equipment e = findEquipment(code);

        if (e != null) {
            System.out.println(e);
        } else {
            System.out.println("找不到設備！");
        }
    }

    // 借出設備
    public static void borrowEquipment() {
        System.out.print("請輸入設備代碼：");
        String code = sc.nextLine();

        Equipment e = findEquipment(code);

        if (e == null) {
            System.out.println("找不到設備！");
        } else if (!e.isAvailable()) {
            System.out.println("設備已借出！");
        } else {
            e.borrow();
            System.out.println("借出成功！");
        }
    }

    // 歸還設備
    public static void returnEquipment() {
        System.out.print("請輸入設備代碼：");
        String code = sc.nextLine();

        Equipment e = findEquipment(code);

        if (e == null) {
            System.out.println("找不到設備！");
        } else if (e.isAvailable()) {
            System.out.println("設備本來就是可借用狀態！");
        } else {
            e.giveBack();
            System.out.println("歸還成功！");
        }
    }

    // 列出可借設備
    public static void listAvailableEquipment() {

        boolean found = false;

        System.out.println("\n===== 可借設備 =====");

        for (Equipment e : equipments) {
            if (e.isAvailable()) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("目前沒有可借設備。");
        }
    }

    // 依代碼尋找設備
    public static Equipment findEquipment(String code) {
        for (Equipment e : equipments) {
            if (e.getCode().equalsIgnoreCase(code)) {
                return e;
            }
        }
        return null;
    }
}