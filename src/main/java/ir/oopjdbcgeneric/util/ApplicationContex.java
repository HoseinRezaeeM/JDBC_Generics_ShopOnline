package ir.oopjdbcgeneric.util;

import ir.oopjdbcgeneric.repository.ShoppingCartRepository;
import ir.oopjdbcgeneric.repository.UserRepository;
import ir.oopjdbcgeneric.repository.impl.ShoppingCartRepositoryImpl;
import ir.oopjdbcgeneric.repository.impl.UserRepositoryImpl;
import ir.oopjdbcgeneric.service.ShoppingCartService;
import ir.oopjdbcgeneric.service.UserService;
import ir.oopjdbcgeneric.service.impl.ShoppingCartServiceImpl;
import ir.oopjdbcgeneric.service.impl.UserServiceImpl;

import java.sql.Connection;
//Hosein Rezaei 
@SuppressWarnings("unused")
public class ApplicationContex {
    private static final Connection connection;
    private static final UserRepository userRepository;
    private static final UserService userService;
    private static final ShoppingCartRepository shoppingCatRepository;
    private static final ShoppingCartService shoppingCatService;

    static {
        connection = DataSource.getConnection();
        userRepository = new UserRepositoryImpl(connection);
        userService = new UserServiceImpl(userRepository);
        shoppingCatRepository = new ShoppingCartRepositoryImpl(connection);
        shoppingCatService = new ShoppingCartServiceImpl(shoppingCatRepository);
    }

    public static UserService getUserServiceImpl() {
        return userService;
    }

    public static ShoppingCartService getShoppingCatServiceImpl() {
        return shoppingCatService;
    }

}
