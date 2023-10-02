package ir.oopjdbcgeneric.repository.impl;

import ir.oopjdbcgeneric.base.repository.impl.BaseEntityRepositoryImpl;
import ir.oopjdbcgeneric.domain.ShoppingCart;
import ir.oopjdbcgeneric.repository.ShoppingCartRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unnused")
public class ShoppingCartRepositoryImpl extends BaseEntityRepositoryImpl<Integer, ShoppingCart<Integer>>
        implements ShoppingCartRepository {


    public ShoppingCartRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected void fillParamForStatement(PreparedStatement preparedStatement, ShoppingCart<Integer> entity, boolean isCart) throws SQLException {
        preparedStatement.setString(1,entity.getProductName());
        preparedStatement.setDouble(2,entity.getPrice());

    }

    @Override
    protected String getCountOfQuestionMarkForParams() {
        return "(?,?)";
    }

    @Override
    protected String getColumnName() {
        return "(productName,price)";
    }

    @Override
    protected String getTableName() {
        return "shoppingCart";
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql="DELETE FROM shoppingcart where id=?";
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public List<ShoppingCart> countAllList() throws SQLException {
        String sql = "SELECT Count(id) as count ,productname ,price FROM shoppingcart GROUP BY productname, price";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ShoppingCart> entities = new ArrayList<>();

            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
            return entities;
        }
    }

    private ShoppingCart<Integer> mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int count = resultSet.getInt("count");
        String productName = resultSet.getString("productname");
        double price = resultSet.getDouble("price");
        return new ShoppingCart<>(null, productName, price,count);
    }

    @Override
    public int sumPriceList() throws SQLException {
        String sql="SELECT SUM(price) FROM shoppingcart";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
       ResultSet resultset =preparedStatement.executeQuery();
       int result=0;
       while (resultset.next()){
           result =resultset.getInt(1);
       }

        return result;
    }
}
