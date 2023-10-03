package ir.oopjdbcgeneric.domain.enumeration;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum ElectricApplianceType {
    radio("radio", 300),
    laptop("laptop", 1200),
    mobile("mobile", 1000),
    headphone("headphone",100),
    computer("computer",500),
    printer("printer",400);

    private String name;
    private double price;

    ElectricApplianceType(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
