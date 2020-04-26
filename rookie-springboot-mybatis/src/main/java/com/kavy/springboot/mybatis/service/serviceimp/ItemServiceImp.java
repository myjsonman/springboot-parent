package com.kavy.springboot.mybatis.service.serviceimp;

import com.kavy.springboot.mybatis.dao.ItemMapper;
import com.kavy.springboot.mybatis.entity.Item;
import com.kavy.springboot.mybatis.service.ItemService;
import com.kavy.springboot.mybatis.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public ResultJson<String> insert(Item item) {
        itemMapper.insert(item);
        return ResultJson.success();
    }

    @Override
    public ResultJson<String> delete(int id) {
        return null;
    }

    @Override
    public ResultJson<String> update(Item item) {
        return null;
    }

    @Override
    public Item load(Integer itemId) {

        return itemMapper.load(itemId);
    }
}
