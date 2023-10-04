package ir.oopjdbcgeneric.menu;


import ir.oopjdbcgeneric.domain.User;
import ir.oopjdbcgeneric.service.ShoppingCartService;
import ir.oopjdbcgeneric.service.UserService;
import ir.oopjdbcgeneric.util.ApplicationContex;
import ir.oopjdbcgeneric.util.Validation;

import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class BaseMenu {
    protected final Scanner scanner = new Scanner(System.in);
    protected final UserService userService = ApplicationContex.getUserServiceImpl();
    protected final ShoppingCartService shoppingCartService = ApplicationContex.getShoppingCatServiceImpl();
    ShoppingMenu shoppingMenu =new ShoppingMenu();

    public void fistMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n***********************************************");
        System.out.println("|          WELCOMT TO ONLINE SHOP             |");
        System.out.println("***********************************************\n");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("3- Exit\n");
        System.out.println("Enter your select:");
        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> shoppingMenu.login();
                case 2 -> signup();
                case 3 -> System.out.println("exit");
                default -> System.out.println("---Eror404---");
            }
        }catch (Exception e){
//            System.out.println("!!!WRONG!!!");
            e.printStackTrace();
        }

    }

    public void signup() throws SQLException {
        System.out.println("Enter firstName :  ");
        String firstName = scanner.next();
        System.out.println("Enter lastName : ");
        String lastName = scanner.next();
        System.out.println("Enter username : ");
        String username = scanner.next();
        System.out.println("Enter password : ");
        String password;
        password =validationPassword();
        System.out.println("Enter email : ");
        String email;
        email =validationEmail();
        System.out.println("Enter MobileNumber : ");
        String mobileNumber;
        mobileNumber =validationMoblieNumber();
        User<Integer> user = new User<>(null, firstName, lastName, username, password, email, mobileNumber);
        userService.Save(user);
        System.out.println("ADD to DataBase SUCESSFULLY");

    }

    public String validationPassword() {
        String password=null;
        boolean isTrue = true;
        while (isTrue) {
            password = scanner.next();
            if (Validation.validatonPassword(password)) {
                isTrue = false;
            } else {
                System.out.println("Enter valid password!!!!");
            }
        }
        return password;
    }

    public String validationEmail() {
        String email=null;
        boolean isTrue = true;
        while (isTrue) {
            email = scanner.next();
            if (Validation.validaitonEmail(email)) {
                isTrue = false;
            } else {
                System.out.println("Enter validation Email!!!!");
            }
        }
        return email;
    }

    public String validationMoblieNumber() {
        String mobileNumber=null;
        boolean isTrue = true;
        while (isTrue) {
            mobileNumber = scanner.next();
            if (Validation.validationMobileNumber(mobileNumber)) {
                isTrue = false;
            } else {
                System.out.println("Enter validation MobileNumber!!!!");
            }
        }
        return mobileNumber;
    }
}


