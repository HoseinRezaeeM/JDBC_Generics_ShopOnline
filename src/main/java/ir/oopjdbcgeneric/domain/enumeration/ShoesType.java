package ir.oopjdbcgeneric.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShoesType {
    sport("sport",200),
    formal("formal",150),
    boot("boot",250),
    heels("heels",300);

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private  double price;



}
