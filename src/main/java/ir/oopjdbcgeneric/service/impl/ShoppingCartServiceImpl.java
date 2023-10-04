package ir.oopjdbcgeneric.service.impl;

import ir.oopjdbcgeneric.base.service.impl.BaseEntityServiceImpl;
import ir.oopjdbcgeneric.domain.ShoppingCart;
import ir.oopjdbcgeneric.repository.ShoppingCartRepository;
import ir.oopjdbcgeneric.service.ShoppingCartService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartServiceImpl extends BaseEntityServiceImpl<Integer, ShoppingCart<Integer>, ShoppingCartRepository> implements ShoppingCartService {
    public ShoppingCartServiceImpl(ShoppingCartRepository repository) {
        super(repository);
    }
    Scanner scanner=new Scanner(System.in);
    @Override
    public void delete(Integer id) throws SQLException {
        repository.delete(id);
    }

    @Override
    public List<ShoppingCart> countAllList() throws SQLException {
        System.out.println("**** Print list ***");
        System.out.println("Enter ID :");
        int idUser =scanner.nextInt();
        return repository.countAllList(idUser);
    }

    @Override
    public void sumPriceList() throws SQLException {
        System.out.println("*** SUM Price list ***");
        System.out.println("Enter ID :");
        int idUser =scanner.nextInt();
        System.out.println("Print the total prices of shopping cart items : "+repository.sumPriceList(idUser)+"\n");
    }
}
