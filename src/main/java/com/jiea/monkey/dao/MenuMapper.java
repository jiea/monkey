package com.jiea.monkey.dao;

import com.jiea.monkey.domain.Menu;

import java.util.List;

public interface MenuMapper {

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId
     * @return
     */
    List<Menu> queryMenusByParentId(Integer parentId);

    /**
     * 根据uesrId查询菜单Id
     * @param userId
     * @return
     */
    List<Integer> queryMenuIdsByUserId(Integer userId);
}