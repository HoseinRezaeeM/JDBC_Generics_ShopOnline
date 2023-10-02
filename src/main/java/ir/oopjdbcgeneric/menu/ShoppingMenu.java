package ir.oopjdbcgeneric.menu;

import ir.oopjdbcgeneric.domain.ShoppingCart;
import ir.oopjdbcgeneric.domain.User;
import ir.oopjdbcgeneric.domain.enumeration.ElectricApplianceType;
import ir.oopjdbcgeneric.domain.enumeration.ShoesType;
import ir.oopjdbcgeneric.service.ShoppingCartService;
import ir.oopjdbcgeneric.service.UserService;
import ir.oopjdbcgeneric.util.ApplicationContex;

import java.sql.SQLException;
import java.util.Scanner;


public class ShoppingMenu {
    protected final Scanner scanner = new Scanner(System.in);
    protected final UserService userService = ApplicationContex.getUserServiceImpl();
    protected final ShoppingCartService shoppingCartService = ApplicationContex.getShoppingCatServiceImpl();

    public void login() throws SQLException {
        System.out.println("Enter username :");
        String userName = scanner.next();
        System.out.println("Enter Password : ");
        String password = scanner.next();
        User user = userService.login(userName);
        if (user != null && !user.getPassword().equals(password)) {
            System.out.println("you enter a username and password incorrect!!!");
        } else {
            boolean isBolean = true;
            while (isBolean) {
                System.out.println("---------** ShoppingCart **-------\n");
                System.out.println("1. SHOW All product ");
                System.out.println("2. ADD product in ShoppingCart ");
                System.out.println("3. Print list of ShoppingCart ");
                System.out.println("4. Print the total prices of shopping cart items  ");
                System.out.println("5. REMOVE product from ShoppingCart");
                System.out.println("6. Exit \n");
                System.out.println("Enter your select :");
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select) {
                    case 1:
                        showAllProduct();
                    case 2:
                        saveShoppingCart();
                    case 3:
                        printList();
                        break;
                    case 4:
                        sum();
                        break;
                    case 5:
                        deleteShoppingCart();
                    case 6:
                        System.out.println("----Good Bye---");
                        break;
                    default:
                        System.out.println("-----Error404----");
                        isBolean = false;

                }
            }
        }
    }

    public void showAllProduct() {
        ElectricApplianceType[] array = ElectricApplianceType.values();
        System.out.println("-ElectricApplianceType Product-");
        System.out.println("Product     |        Price");
        System.out.println("--------------------------");
        for (ElectricApplianceType type : array) {
            System.out.println(type.getName() + "              " + type.getPrice());
        }
        System.out.println();
        ShoesType[] arrays = ShoesType.values();
        System.out.println("---- ShoesType Product---");
        System.out.println("Product      |      Price");
        System.out.println("-------------------------");
        for (ShoesType type : arrays) {
            System.out.println(type.getName() + "              " + type.getPrice());
        }
        System.out.println();

    }

    public void saveShoppingCart() throws SQLException {
        System.out.println("1. ElectricAppliance");
        System.out.println("2. Shoes");
        System.out.println("Enter your Select :");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1:
                System.out.println("--ElectricAppliance--");
                System.out.println("Enter Product Name :");
                String productName = scanner.next();
                if (productName.equals("null")){
                    break;
                }else {
                ElectricApplianceType type = ElectricApplianceType.valueOf(productName);
                double price = type.getPrice();
                ShoppingCart<Integer> shoppingCart = new ShoppingCart<>(null, productName, price);
                shoppingCartService.Save(shoppingCart);}
            case 2:
                System.out.println("----Shoes---");
                System.out.println("Enter Product Name :");
                String productName1 = scanner.next();
                if (productName1.equals("null")){
                    break;
                }else {
                    ShoesType type1 = ShoesType.valueOf(productName1);
                    double price1 = type1.getPrice();
                    ShoppingCart<Integer> shoppingCartt = new ShoppingCart<>(null, productName1, price1);
                    shoppingCartService.Save(shoppingCartt);
                    break;
                }
            default:
                System.out.println("Error");
        }
        System.out.println("ADD To ShoppingCart");
    }

    public void printList() throws SQLException {
        System.out.println(shoppingCartService.countAllList());
    }

    public void sum() throws SQLException {
        shoppingCartService.sumPriceList();
    }

    public void deleteShoppingCart() throws SQLException {
        System.out.println("REMOVE product from ShoppingCart");
        System.out.println("Enter ID product:");
        int id = scanner.nextInt();
        shoppingCartService.delete(id);
    }

}
