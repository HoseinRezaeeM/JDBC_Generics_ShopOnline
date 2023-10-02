package ir.oopjdbcgeneric.repository;

import ir.oopjdbcgeneric.base.repository.BaseEntityRepository;
import ir.oopjdbcgeneric.domain.ShoppingCart;

import java.sql.SQLException;
import java.util.List;


@SuppressWarnings("unused")
public interface ShoppingCartRepository extends BaseEntityRepository<Integer, ShoppingCart<Integer>> {

    void delete(Integer id) throws SQLException;

    List<ShoppingCart> countAllList() throws SQLException;

    int sumPriceList() throws SQLException;


}
