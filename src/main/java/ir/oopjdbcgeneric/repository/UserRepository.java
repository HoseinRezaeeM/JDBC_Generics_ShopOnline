package ir.oopjdbcgeneric.repository;

import ir.oopjdbcgeneric.base.repository.BaseEntityRepository;
import ir.oopjdbcgeneric.domain.User;

import java.sql.SQLException;

public interface UserRepository extends BaseEntityRepository<Integer, User<Integer>> {
    User login(String username) throws SQLException;

}
