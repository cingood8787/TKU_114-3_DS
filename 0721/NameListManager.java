import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();

        while (true) {
            System.out.println("\n===== 名單管理系統 =====");
            System.out.println("1. 新增姓名");
            System.out.println("2. 搜尋姓名");
            System.out.println("3. 修改姓名");
            System.out.println("4. 刪除姓名");
            System.out.println("5. 列出全部");
            System.out.println("0. 離開");
            System.out.print("請選擇：");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    // 新增
                    System.out.print("請輸入姓名：");
                    String newName = sc.nextLine().trim();

                    if (newName.isEmpty()) {
                        System.out.println("姓名不可空白！");
                    } else {
                        nameList.add(newName);
                        System.out.println("新增成功！");
                    }
                    break;

                case "2":
                    // 搜尋
                    System.out.print("請輸入要搜尋的姓名：");
                    String searchName = sc.nextLine().trim();

                    int index = findName(nameList, searchName);

                    if (index != -1) {
                        System.out.println("找到：" + nameList.get(index));
                    } else {
                        System.out.println("找不到此姓名！");
                    }
                    break;

                case "3":
                    // 修改
                    System.out.print("請輸入要修改的姓名：");
                    String oldName = sc.nextLine().trim();

                    int modifyIndex = findName(nameList, oldName);

                    if (modifyIndex != -1) {
                        System.out.print("請輸入新姓名：");
                        String newModifyName = sc.nextLine().trim();

                        if (newModifyName.isEmpty()) {
                            System.out.println("姓名不可空白！");
                        } else {
                            nameList.set(modifyIndex, newModifyName);
                            System.out.println("修改成功！");
                        }
                    } else {
                        System.out.println("找不到此姓名！");
                    }
                    break;

                case "4":
                    // 刪除
                    System.out.print("請輸入要刪除的姓名：");
                    String deleteName = sc.nextLine().trim();

                    int deleteIndex = findName(nameList, deleteName);

                    if (deleteIndex != -1) {
                        nameList.remove(deleteIndex);
                        System.out.println("刪除成功！");
                    } else {
                        System.out.println("找不到此姓名！");
                    }
                    break;

                case "5":
                    // 列出全部
                    if (nameList.isEmpty()) {
                        System.out.println("名單目前是空的。");
                    } else {
                        System.out.println("===== 全部名單 =====");
                        for (int i = 0; i < nameList.size(); i++) {
                            System.out.println((i + 1) + ". " + nameList.get(i));
                        }
                    }
                    break;

                case "0":
                    System.out.println("程式結束！");
                    sc.close();
                    return;

                default:
                    System.out.println("輸入錯誤，請重新選擇！");
            }
        }
    }

    // 忽略英文大小寫搜尋
    public static int findName(ArrayList<String> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}