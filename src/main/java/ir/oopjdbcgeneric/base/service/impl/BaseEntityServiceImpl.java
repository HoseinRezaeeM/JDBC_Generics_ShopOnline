package ir.oopjdbcgeneric.base.service.impl;

import ir.oopjdbcgeneric.base.domain.BaseEntity;
import ir.oopjdbcgeneric.base.repository.BaseEntityRepository;
import ir.oopjdbcgeneric.base.service.BaseEntityService;

import java.io.Serializable;
import java.sql.SQLException;

public class BaseEntityServiceImpl<ID extends Serializable, TYPE extends BaseEntity<ID>,
        R extends BaseEntityRepository<ID, TYPE>> implements BaseEntityService<ID, TYPE> {

    protected R repository;

    public BaseEntityServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void Save(TYPE entity) throws SQLException {
        repository.Save(entity);
    }
}
