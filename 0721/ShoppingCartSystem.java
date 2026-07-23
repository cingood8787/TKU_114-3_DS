import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {

    static ArrayList<CartItem> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== 購物車系統 =====");
            System.out.println("1. 新增商品");
            System.out.println("2. 修改數量");
            System.out.println("3. 移除商品");
            System.out.println("4. 顯示購物車");
            System.out.println("5. 計算總額");
            System.out.println("0. 離開");
            System.out.print("請選擇：");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addItem();
                    break;
                case "2":
                    updateQuantity();
                    break;
                case "3":
                    removeItem();
                    break;
                case "4":
                    showCart();
                    break;
                case "5":
                    calculateTotal();
                    break;
                case "0":
                    System.out.println("程式結束！");
                    return;
                default:
                    System.out.println("輸入錯誤！");
            }
        }
    }

    // 新增商品
    public static void addItem() {

        System.out.print("商品代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("代碼不可空白！");
            return;
        }

        CartItem item = findItem(code);

        if (item != null) {
            System.out.print("增加數量：");
            int qty = Integer.parseInt(sc.nextLine());

            if (qty <= 0) {
                System.out.println("數量必須大於0！");
                return;
            }

            item.addQuantity(qty);
            System.out.println("已增加商品數量！");
        } else {

            System.out.print("商品名稱：");
            String name = sc.nextLine().trim();

            System.out.print("單價：");
            double price = Double.parseDouble(sc.nextLine());

            System.out.print("數量：");
            int qty = Integer.parseInt(sc.nextLine());

            if (qty <= 0) {
                System.out.println("數量必須大於0！");
                return;
            }

            cart.add(new CartItem(code, name, price, qty));
            System.out.println("商品加入成功！");
        }
    }

    // 修改數量
    public static void updateQuantity() {

        System.out.print("商品代碼：");
        String code = sc.nextLine();

        CartItem item = findItem(code);

        if (item == null) {
            System.out.println("找不到商品！");
            return;
        }

        System.out.print("新數量：");
        int qty = Integer.parseInt(sc.nextLine());

        if (qty <= 0) {
            System.out.println("數量必須大於0！");
            return;
        }

        item.setQuantity(qty);
        System.out.println("修改成功！");
    }

    // 移除商品
    public static void removeItem() {

        System.out.print("商品代碼：");
        String code = sc.nextLine();

        CartItem item = findItem(code);

        if (item == null) {
            System.out.println("找不到商品！");
        } else {
            cart.remove(item);
            System.out.println("移除成功！");
        }
    }

    // 顯示購物車
    public static void showCart() {

        if (cart.isEmpty()) {
            System.out.println("購物車是空的！");
            return;
        }

        System.out.println("\n===== 購物車 =====");

        for (CartItem item : cart) {
            System.out.println(item);
        }
    }

    // 計算總額
    public static void calculateTotal() {

        double total = 0;

        for (CartItem item : cart) {
            total += item.getSubtotal();
        }

        System.out.println("購物車總額：" + total);
    }

    // 搜尋商品
    public static CartItem findItem(String code) {

        for (CartItem item : cart) {
            if (item.getCode().equalsIgnoreCase(code)) {
                return item;
            }
        }

        return null;
    }
}