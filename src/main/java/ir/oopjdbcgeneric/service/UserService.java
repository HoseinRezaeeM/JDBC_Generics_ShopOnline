package ir.oopjdbcgeneric.service;

import ir.oopjdbcgeneric.base.service.BaseEntityService;
import ir.oopjdbcgeneric.domain.User;

import java.sql.SQLException;

public interface UserService extends BaseEntityService<Integer, User<Integer>> {
    User login(String username) throws SQLException;
}
