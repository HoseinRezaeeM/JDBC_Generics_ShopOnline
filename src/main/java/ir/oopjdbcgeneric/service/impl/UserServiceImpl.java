package ir.oopjdbcgeneric.service.impl;

import ir.oopjdbcgeneric.base.service.impl.BaseEntityServiceImpl;
import ir.oopjdbcgeneric.domain.User;
import ir.oopjdbcgeneric.repository.UserRepository;
import ir.oopjdbcgeneric.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserServiceImpl extends BaseEntityServiceImpl<Integer, User<Integer>,UserRepository> implements UserService {
private final Scanner scanner =new Scanner(System.in);

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public User login(String username) throws SQLException {
       return repository.login(username);
    }
}
