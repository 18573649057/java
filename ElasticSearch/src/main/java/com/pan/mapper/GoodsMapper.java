package com.pan.mapper;

import com.pan.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsMapper {


    /**
     * 查询所有
     */
    public List<Goods> findAll();

}
