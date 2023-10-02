package ir.oopjdbcgeneric.base.repository;

import ir.oopjdbcgeneric.base.domain.BaseEntity;

import java.io.Serializable;
import java.sql.SQLException;

@SuppressWarnings("unused")
public interface BaseEntityRepository<ID extends Serializable,TYPE extends BaseEntity<ID>> {
    void Save(TYPE entity) throws SQLException;

}
