package com.kavy.springboot.mybatis.service.serviceimp;

import com.kavy.springboot.mybatis.dao.ItemMapper;
import com.kavy.springboot.mybatis.entity.Item;
import com.kavy.springboot.mybatis.service.ItemService;
import com.kavy.springboot.mybatis.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item load(Integer itemId) {

        return itemMapper.load(itemId);
    }

    /**
     * 增删改
     * @param item
     * @return
     */
    @Override
    public void addItem(Item item) {

        itemMapper.addItem(item);
    }

    @Override
    public void updateItemById(Item item) {
        itemMapper.updateItemById(item);
    }



    @Override
    public Item selectItemById(Integer itemId) {
        return itemMapper.selectItemById(itemId);
    }

    @Override
    public List<Item> selectItemList() {
        return itemMapper.selectItemList();
    }

    @Override
    public Item getItemByItemIdAndItemName(Integer itemId, String itemName) {
        return itemMapper.getItemByItemIdAndItemName(itemId,itemName);
    }

    @Override
    public void deleteItemById(Integer itemId) {
        itemMapper.deleteItemById(itemId);

    }
}
