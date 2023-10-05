package ir.oopjdbcgeneric.repository.impl;

import ir.oopjdbcgeneric.base.repository.impl.BaseEntityRepositoryImpl;
import ir.oopjdbcgeneric.domain.User;
import ir.oopjdbcgeneric.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRepositoryImpl extends BaseEntityRepositoryImpl<Integer, User<Integer>>
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected void fillParamForStatement(PreparedStatement preparedStatement, User<Integer> entity) throws SQLException {
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getUsername());
        preparedStatement.setString(4, entity.getPassword());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getMobileNumber());

    }

    @Override
    protected String getCountOfQuestionMarkForParams() {
        return "(?,?,?,?,?,?)";
    }

    @Override
    protected String getColumnName() {
        return "(firstName, lastName, username, password, email, mobileNumber)";
    }

    @Override
    protected String getTableName() {
        return "users";
    }

    @Override
    public User<Integer> login(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               return mapResultsetToEntity(resultSet);
            }
        }
        return null;
    }

    private User<Integer> mapResultsetToEntity(ResultSet resultSet) throws SQLException {
        User<Integer> user = new User<>(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getString(7))
                ;
        user.setId(resultSet.getInt(1));
        return user;
    }
}
