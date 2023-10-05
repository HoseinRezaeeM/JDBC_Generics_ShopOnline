package ir.oopjdbcgeneric.base.repository.impl;

import ir.oopjdbcgeneric.base.domain.BaseEntity;
import ir.oopjdbcgeneric.base.repository.BaseEntityRepository;
import lombok.Getter;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("unused")
@Getter
public abstract class BaseEntityRepositoryImpl<ID extends Serializable,TYPE extends BaseEntity<ID>> implements BaseEntityRepository<ID,TYPE> {

    private final Connection connection;
    public BaseEntityRepositoryImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public void Save(TYPE entity) throws SQLException {
        String sql ="INSERT INTO " + getTableName() + "  " + getColumnName() + " VALUES " +  getCountOfQuestionMarkForParams() ;
       try (PreparedStatement statement =connection.prepareStatement(sql)){
           fillParamForStatement(statement, entity);
           statement.executeUpdate();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    protected abstract void fillParamForStatement(PreparedStatement preparedStatement, TYPE entity) throws SQLException;

    protected abstract String getCountOfQuestionMarkForParams();

    protected abstract String getColumnName();

    protected abstract String getTableName();
}
