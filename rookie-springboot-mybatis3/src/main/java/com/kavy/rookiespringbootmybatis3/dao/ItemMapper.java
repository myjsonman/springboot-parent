package com.kavy.rookiespringbootmybatis3.dao;

import com.kavy.rookiespringbootmybatis3.entity.Item;
import com.kavy.rookiespringbootmybatis3.entity.ItemVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemMapper {
    /**
     * 增删改查
     *
     */
     void  addItem(Item item);
     void  deleteItem(@Param("itemId") Integer itemId);
     void  updateItem(Item item);
     Item queryItemById( Integer itemId);

    /**
     * 参数处理
     */
    Item queryItemByIdAndName(@Param("itemId") Integer itemId, @Param("itemName")String itemName);

    //pojo传递参数
    Item queryByItemVo( ItemVo itemVo);

    //map传递
    Item queryItemByMap( Map<String,Object> itemMap);

    //list传递
    List<Item> queryItemByList(List<Integer> idsList);
    //批量删除
    void deleteByIdsList(List<Integer> idsList);
    //批量插入
    void insertItemList(List<Item> itemList);
    //批量更新
    void updateItemList(List<Integer> idsList);
    /**
     * 模糊查询
     */
    List<Item> queryItemLikeByName(String itemName);
    //pojo传递
    List<Item> queryItemLikeByItemVo(ItemVo itemVo);

    //多条记录封装成map返回 Map<String,Item> ：key是这条记录的主键,值是javaBean
    //MapKey指定它的key是itemName
    @MapKey("itemName")
    Map<String,Item> queryMapItem(String itemName);

}
