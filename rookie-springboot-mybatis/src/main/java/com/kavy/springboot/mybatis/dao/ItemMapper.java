package com.kavy.springboot.mybatis.dao;
import com.kavy.springboot.mybatis.entity.Item;
import org.apache.ibatis.annotations.Mapper;

/**
*  item
* @author  2020-04-23
*/
@Mapper
public interface ItemMapper  {

    /**
     * [新增]
     * @author
     * @date 2020/04/23
     **/
    void insert(Item item);

    /**
     * [查询] 根据主键 id 查询
     * @author
     * @date 2020/04/23
     **/
    Item load(Integer itemId);



}
