package ir.oopjdbcgeneric.service.impl;

import ir.oopjdbcgeneric.base.service.impl.BaseEntityServiceImpl;
import ir.oopjdbcgeneric.domain.ShoppingCart;
import ir.oopjdbcgeneric.repository.ShoppingCartRepository;
import ir.oopjdbcgeneric.service.ShoppingCartService;

import java.sql.SQLException;
import java.util.List;

public class ShoppingCartServiceImpl extends BaseEntityServiceImpl<Integer, ShoppingCart<Integer>, ShoppingCartRepository> implements ShoppingCartService {
    public ShoppingCartServiceImpl(ShoppingCartRepository repository) {
        super(repository);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        repository.delete(id);
    }

    @Override
    public List<ShoppingCart> countAllList() throws SQLException {
        return repository.countAllList();
    }

    @Override
    public void sumPriceList() throws SQLException {
        System.out.println("Print the total prices of shopping cart items : "+repository.sumPriceList()+"\n");
    }
}
