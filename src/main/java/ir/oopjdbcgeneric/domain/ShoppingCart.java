package ir.oopjdbcgeneric.domain;

import ir.oopjdbcgeneric.base.domain.BaseEntity;

import lombok.Getter;

import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class ShoppingCart<ID extends Serializable> extends BaseEntity<ID> {
    private String productName;
    private double price;
    private int count;

    public ShoppingCart(ID id, String productName, double price, int count) {
        super(id);
        this.productName = productName;
        this.price = price;
        this.count = count;
    }

    public ShoppingCart(ID id) {
        super(id);
    }

    public ShoppingCart(ID id, String productName, double price) {
        super(id);
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "productName :  " + productName+
                ",       price : " + price +
                ",            count : " + count +"\n";
    }
}
