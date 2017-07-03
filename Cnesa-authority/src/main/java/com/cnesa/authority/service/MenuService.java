package com.cnesa.authority.service;

import com.cnesa.authority.entity.Menu;
import com.cnesa.authority.entity.User;
import com.cnesa.common.model.EasyuiTree;

import java.util.List;

/**
 * Created by shangpeibao on 16/12/7.
 */
public interface MenuService {


    List<EasyuiTree> selectMenuTreeByUser(User user);

    List<EasyuiTree> selectResourceTreeByUser(User user);

    List<Menu> selectAllTreeGrid();

    List<EasyuiTree> selectAllTrees();

    void insert(Menu menu);

    void delete(String id);

    Menu selectById(String id);

    void update(Menu menu);

    /**
     * 获取用户项目菜单
     * @param userId 用户ID
     * @param projectId 项目ID
     * @return
     */
    List<EasyuiTree> selectTreeByUserIdAndProjectId(String userId, String projectId);

    /**
     * 查询功能类型所有菜单
     * @param functionType  功能类型
     * @return
     */
    List<EasyuiTree> selectAllMenuTrees(int functionType);
}
