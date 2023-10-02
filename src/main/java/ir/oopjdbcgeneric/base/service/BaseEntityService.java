package ir.oopjdbcgeneric.base.service;

import ir.oopjdbcgeneric.base.domain.BaseEntity;

import java.io.Serializable;
import java.sql.SQLException;

public interface BaseEntityService<ID extends Serializable ,TYPE extends BaseEntity<ID>>{
    void Save(TYPE entity) throws SQLException;
}
