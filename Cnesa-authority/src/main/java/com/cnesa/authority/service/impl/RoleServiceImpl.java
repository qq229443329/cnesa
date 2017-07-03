package com.cnesa.authority.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.cnesa.authority.common.AuthorityConstant;
import com.cnesa.authority.dao.RoleDao;
import com.cnesa.authority.dao.RoleMenuDao;
import com.cnesa.authority.dao.UserRoleDao;
import com.cnesa.authority.entity.*;
import com.cnesa.common.model.EasyuiPage;
import com.cnesa.common.model.EasyuiTree;
import com.cnesa.authority.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色操作
 *
 * Created by shangpeibao on 16/12/6.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private UserRoleDao userRoleDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private RoleMenuDao roleMenuDao;

    public List<String> selectRoleIdListByUserId(String userId) {
        if (StringUtils.hasLength(userId)) {
            return userRoleDao.selectRoleIdListByUserId(userId);
        }
        return null;
    }

    public List<Map<String, String>> selectRoleResourceListByRoleId(String roleId) {
        if (StringUtils.hasLength(roleId)) {
            return roleDao.selectRoleResourceListByRoleId(roleId);
        }
        return null;
    }

    public void selectDataGrid(EasyuiPage easyuiPage) {
        Page<Role> page = new Page<Role>(easyuiPage.getNowpage(), easyuiPage.getSize());
        List<Role> list = roleDao.selectRoleList(page, easyuiPage.getSort(), easyuiPage.getOrder());
        easyuiPage.setRows(list);
        easyuiPage.setTotal(page.getTotal());
    }

    public void insert(Role role) {
        if (role != null) {
            role.setCreateTime(new Date(System.currentTimeMillis()));
            roleDao.insert(role);
        }
    }

    public Role selectById(String id) {
        if (StringUtils.hasLength(id)) {
            return roleDao.selectByPrimaryKey(id);
        }
        return null;
    }

    public void update(Role role) {
        if (role != null) {
            String id = role.getId();
            if (StringUtils.hasLength(id)) {
                Role oldRole = roleDao.selectByPrimaryKey(id);
                role.setCreateTime(oldRole.getCreateTime());
            }
            role.setUpdateTime(new Date(System.currentTimeMillis()));
            roleDao.updateByPrimaryKey(role);
        }
    }

    public List<String> selectResourceIdListByRoleId(String roleId) {
        List<String> ids = new ArrayList<String>();
        if (StringUtils.hasLength(roleId)) {
            ids = roleMenuDao.selectMenuIdsByRoleId(roleId);
        }
        return ids;
    }

    public void updateRoleMenu(String roleId, String menuIds) {
        if (StringUtils.hasLength(roleId)) {
            //先删除以前所有授权
            roleMenuDao.deleteByRoleId(roleId);
            RoleMenu roleMenu;

            //添加薪的授权
            if (StringUtils.hasLength(menuIds)) {
                String[] menuIdArray = menuIds.split(",");
                for (String menuId : menuIdArray) {
                    roleMenu = new RoleMenu();
                    roleMenu.setRoleId(roleId);
                    roleMenu.setMenuId(menuId);
                    roleMenuDao.insert(roleMenu);
                }
            }
        }
    }

    public void delete(String id) {
        if (StringUtils.hasLength(id)) {
            //先删除已授权记录
            roleMenuDao.deleteByRoleId(id);
            //再删除角色
            roleDao.deleteByPrimaryKey(id);
        }
    }

    public List<EasyuiTree> selectRoleTree() {
        List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andStatusEqualTo(AuthorityConstant.ROLE_STATUS_SHOW);
        roleExample.setOrderByClause("seq asc");
        List<Role> roles = roleDao.selectByExample(roleExample);
        if (roles != null) {
            EasyuiTree easyuiTree;
            for (Role role : roles) {
                easyuiTree = new EasyuiTree();
                easyuiTree.setId(role.getId());
                easyuiTree.setText(role.getRoleName());
                easyuiTrees.add(easyuiTree);
            }
        }
        return easyuiTrees;
    }
}
