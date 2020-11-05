package com.kavy.rookiespringbootmybatis3.service.Impl;

import com.kavy.rookiespringbootmybatis3.dao.ItemMapper;
import com.kavy.rookiespringbootmybatis3.entity.Item;
import com.kavy.rookiespringbootmybatis3.entity.ItemVo;
import com.kavy.rookiespringbootmybatis3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
   private ItemMapper itemMapper;

    /**
     * 增删改查
     * @param item
     */
    @Override
    public void addItem(Item item) {
        itemMapper.addItem(item);
    }

    @Override
    public void deleteItem(Integer itemId) {
        itemMapper.deleteItem(itemId);
    }

    @Override
    public void updateItem(Item item) {
            itemMapper.updateItem(item);
    }

    @Override
    public Item queryItemById(Integer itemId) {

        return itemMapper.queryItemById(itemId);
    }

    @Override
    public Item queryItemByIdAndName(Integer itemId, String itemName) {

        return itemMapper.queryItemByIdAndName(itemId,itemName);
    }

    /**
     * 参数传递
     * @param itemVo
     * @return
     */
    @Override
    public Item queryByItemVo(ItemVo itemVo) {
        return itemMapper.queryByItemVo(itemVo);
    }

    @Override
    public Item queryItemByMap(Map<String, Object> itemMap) {
        return itemMapper.queryItemByMap(itemMap);
    }

    @Override
    public List<Item> queryItemByList(List<Integer> idsList) {
        return itemMapper.queryItemByList(idsList);
    }

    @Override
    public void deleteByIdsList(List<Integer> idsList) {
        itemMapper.deleteByIdsList(idsList);
    }

    @Override
    public void insertItemList(List<Item> itemList) {
        itemMapper.insertItemList(itemList);
    }

    @Override
    public void updateItemList(List<Integer> idsList) {
        itemMapper.updateItemList(idsList);
    }

    @Override
    public List<Item> queryItemLikeByName(String itemName) {

        return itemMapper.queryItemLikeByName(itemName);
    }

    @Override
    public List<Item> queryItemLikeByItemVo(ItemVo itemVo) {
        return itemMapper.queryItemLikeByItemVo(itemVo);
    }

    @Override
    public Map<String, Item> queryMapItem(String itemName) {
        return itemMapper.queryMapItem(itemName);
    }


}
