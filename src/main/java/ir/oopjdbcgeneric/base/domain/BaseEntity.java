package ir.oopjdbcgeneric.base.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@SuppressWarnings("unused")
public class BaseEntity<ID extends Serializable> {

    private ID id;


}
