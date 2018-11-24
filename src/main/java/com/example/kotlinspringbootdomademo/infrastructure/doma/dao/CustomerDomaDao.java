package com.example.kotlinspringbootdomademo.infrastructure.doma.dao;

import com.example.kotlinspringbootdomademo.infrastructure.doma.entity.CustomerDomaEntity;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.*;

import java.util.List;

@ConfigAutowireable
@Dao
public interface CustomerDomaDao {
    @Select
    List<CustomerDomaEntity> selectAll();

    @Insert
    int insert(CustomerDomaEntity entity);

    @Update
    int update(CustomerDomaEntity entity);

    @Select
    CustomerDomaEntity selectById(int id);

    @Delete
    int delete(CustomerDomaEntity entity);
}