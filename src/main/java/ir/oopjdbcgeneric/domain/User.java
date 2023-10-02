package ir.oopjdbcgeneric.domain;

import ir.oopjdbcgeneric.base.domain.BaseEntity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@SuppressWarnings("unused")
public class User<ID extends Serializable> extends BaseEntity<ID> {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String mobileNumber;



    public User(ID id, String firstName, String lastName, String username, String password, String email, String mobileNumber) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }
}
