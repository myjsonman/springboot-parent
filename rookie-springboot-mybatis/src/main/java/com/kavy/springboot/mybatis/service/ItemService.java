package com.kavy.springboot.mybatis.service;

import com.kavy.springboot.mybatis.entity.Item;
import com.kavy.springboot.mybatis.utils.ResultJson;

public interface ItemService {
    /**
     * 新增
     */
    public ResultJson<String> insert(Item item);

    /**
     * 删除
     */
    public ResultJson<String> delete(int id);

    /**
     * 更新
     */
    public ResultJson<String> update(Item item);

    /**
     * 根据主键 id 查询
     */
    public Item load(Integer itemId);

}
