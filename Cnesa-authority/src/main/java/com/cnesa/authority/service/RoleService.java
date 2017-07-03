package com.cnesa.authority.service;

import com.cnesa.authority.entity.Role;
import com.cnesa.common.model.EasyuiPage;
import com.cnesa.common.model.EasyuiTree;

import java.util.List;
import java.util.Map;

/**
 * Created by shangpeibao on 16/12/6.
 */
public interface RoleService {

    List<String> selectRoleIdListByUserId(String id);

    List<Map<String,String>> selectRoleResourceListByRoleId(String roleId);

    void selectDataGrid(EasyuiPage easyuiPage);

    void insert(Role role);

    Role selectById(String id);

    void update(Role role);

    List<String> selectResourceIdListByRoleId(String roleId);

    void updateRoleMenu(String roleId, String menuIds);

    void delete(String id);

    List<EasyuiTree> selectRoleTree();
}
