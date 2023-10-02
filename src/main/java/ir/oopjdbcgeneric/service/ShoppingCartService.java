package ir.oopjdbcgeneric.service;

import ir.oopjdbcgeneric.base.service.BaseEntityService;
import ir.oopjdbcgeneric.domain.ShoppingCart;

import java.sql.SQLException;
import java.util.List;
@SuppressWarnings("unused")
public interface ShoppingCartService extends BaseEntityService<Integer, ShoppingCart<Integer>> {
    void delete(Integer id) throws SQLException;

    List<ShoppingCart> countAllList() throws SQLException;

    void sumPriceList() throws SQLException;

}
