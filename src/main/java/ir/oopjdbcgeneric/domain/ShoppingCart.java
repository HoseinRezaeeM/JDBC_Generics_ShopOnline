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
    private int idUser;

    public ShoppingCart(ID id) {
        super(id);
    }

    public ShoppingCart(ID id, String productName, double price, int count, int idUser) {
        super(id);
        this.productName = productName;
        this.price = price;
        this.count = count;
        this.idUser =idUser;
    }


    public ShoppingCart(ID id, String productName, double price,int idUser) {
        super(id);
        this.productName = productName;
        this.price = price;
        this.idUser = idUser;

    }



    @Override
    public String toString() {
        return "productName :  " + productName+
                ",       price : " + price +
                ",            count : " + count +
                ",              ID : "+idUser+ "\n";
    }
}
