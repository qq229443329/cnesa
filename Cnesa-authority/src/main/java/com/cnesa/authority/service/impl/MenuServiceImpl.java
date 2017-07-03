package com.cnesa.authority.service.impl;

import com.cnesa.authority.common.AuthorityConstant;
import com.cnesa.authority.dao.MenuDao;
import com.cnesa.authority.dao.RoleMenuDao;
import com.cnesa.authority.dao.UserDao;
import com.cnesa.authority.dao.UserRoleDao;
import com.cnesa.authority.entity.Menu;
import com.cnesa.authority.entity.MenuExample;
import com.cnesa.authority.entity.User;
import com.cnesa.authority.service.MenuService;
import com.cnesa.common.model.EasyuiTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  资源菜单操作
 *
 * Created by shangpeibao on 16/12/7.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;
    @Resource
    private UserRoleDao userRoleDao;
    @Resource
    private RoleMenuDao roleMenuDao;
    @Autowired
    private UserDao userDao;

    public List<EasyuiTree> selectMenuTreeByUser(User user) {
        List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
        //超级管理员
        if (user.getUserType() == AuthorityConstant.USER_TYPE_ADMIN) {
            List<Menu> menus = menuDao.selectAllByParentIdNullAndNotFunctionType(AuthorityConstant.MENU_FUNCTION_MENU);
            if (menus == null) {
                return null;
            }
            for (Menu menu : menus) {
                EasyuiTree easyuiTreeOne = new EasyuiTree();
                easyuiTreeOne.setId(menu.getId());
                easyuiTreeOne.setPid(menu.getParentId());
                easyuiTreeOne.setText(menu.getName());
                easyuiTreeOne.setAttributes(menu.getUrl());
                easyuiTreeOne.setIconCls(menu.getIcon());
                selectChildrenNotBtn(easyuiTreeOne, menu.getId(), menu.getState());
                easyuiTrees.add(easyuiTreeOne);
            }

            return easyuiTrees;
        }

        //普通用户
        List<Menu> menus = new ArrayList<Menu>();
        List<String> roleIds = userRoleDao.selectRoleIdListByUserId(user.getId());
        for (String roleId : roleIds) {
            List<Menu> menuList = menuDao.selectByRoleIdAndParentIdNullAndResourceType(roleId, AuthorityConstant.MENU_TYPE_RESOURCE);
            for (Menu menu : menuList) {
                menus.add(menu);
            }
        }

        for (Menu menu : menus) {
            EasyuiTree easyuiTreeOne = new EasyuiTree();
            easyuiTreeOne.setId(menu.getId());
            easyuiTreeOne.setPid(menu.getParentId());
            easyuiTreeOne.setText(menu.getName());
            easyuiTreeOne.setAttributes(menu.getUrl());
            easyuiTreeOne.setIconCls(menu.getIcon());
            selectChildrenNotBtnByRoleId(easyuiTreeOne, menu.getId(), roleIds);
            easyuiTrees.add(easyuiTreeOne);
        }

        return easyuiTrees;
    }

    public List<EasyuiTree> selectResourceTreeByUser(User user) {
        List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
        //超级管理员
        if (user.getUserType() == AuthorityConstant.USER_TYPE_ADMIN) {
            List<Menu> menus = menuDao.selectAllByParentIdNull();
            if (menus == null) {
                return null;
            }
            for (Menu menu : menus) {
                EasyuiTree easyuiTreeOne = new EasyuiTree();
                easyuiTreeOne.setId(menu.getId());
                easyuiTreeOne.setPid(menu.getParentId());
                easyuiTreeOne.setText(menu.getName());
                easyuiTreeOne.setAttributes(menu.getUrl());
                easyuiTreeOne.setIconCls(menu.getIcon());
                selectChildrenNotBtn(easyuiTreeOne, menu.getId(), menu.getState());
                easyuiTrees.add(easyuiTreeOne);
            }

            return easyuiTrees;
        }

        //普通用户
        List<Menu> menus = new ArrayList<Menu>();
        List<String> roleIds = userRoleDao.selectRoleIdListByUserId(user.getId());
        for (String roleId : roleIds) {
            List<Menu> menuList = menuDao.selectByRoleIdAndParentIdNullAndResourceType(roleId, AuthorityConstant.MENU_TYPE_RESOURCE);
            for (Menu menu : menuList) {
                menus.add(menu);
            }
        }

        for (Menu menu : menus) {
            EasyuiTree easyuiTreeOne = new EasyuiTree();
            easyuiTreeOne.setId(menu.getId());
            easyuiTreeOne.setPid(menu.getParentId());
            easyuiTreeOne.setText(menu.getName());
            easyuiTreeOne.setAttributes(menu.getUrl());
            easyuiTreeOne.setIconCls(menu.getIcon());
            selectChildrenNotBtnByRoleId(easyuiTreeOne, menu.getId(), roleIds);
            easyuiTrees.add(easyuiTreeOne);
        }

        return easyuiTrees;
    }

    public List<Menu> selectAllTreeGrid() {
        MenuExample menuExample = new MenuExample();
        menuExample.setOrderByClause("seq");
        return menuDao.selectByExample(menuExample);
    }


    public List<EasyuiTree> selectAllTrees() {
        List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
        List<Menu> menus = menuDao.selectAllByParentIdNull();
        if (menus != null) {
            for (Menu menu : menus) {
                EasyuiTree easyuiTreeOne = new EasyuiTree();
                easyuiTreeOne.setId(menu.getId());
                easyuiTreeOne.setPid(menu.getParentId());
                easyuiTreeOne.setText(menu.getName());
                easyuiTreeOne.setAttributes(menu.getUrl());
                easyuiTreeOne.setIconCls(menu.getIcon());
                selectChildrenDisplay(easyuiTreeOne, menu.getId());
                easyuiTrees.add(easyuiTreeOne);
            }
        }
        return easyuiTrees;
    }

    public void insert(Menu menu) {
        if (menu != null) {
            menu.setStatus(AuthorityConstant.MENU_STATUS_SHOW); //设置菜单默认显示
            menu.setCreateTime(new Date(System.currentTimeMillis()));
            if (!StringUtils.hasLength(menu.getParentId())) {
                menu.setParentId(null);
            }
            menuDao.insert(menu);
        }
    }

    public void delete(String id) {
        if (StringUtils.hasLength(id)) {
            //先删除已授权记录
            roleMenuDao.deleteByMenuId(id);
            //在删除资源
            menuDao.deleteByPrimaryKey(id);
        }
    }

    public Menu selectById(String id) {
        if (StringUtils.hasLength(id)) {
            return menuDao.selectByPrimaryKey(id);
        }
        return null;
    }

    public void update(Menu menu) {
        if (menu != null) {
            menu.setCreateTime(new Date(System.currentTimeMillis()));
            if (!StringUtils.hasLength(menu.getParentId())) {
                menu.setParentId(null);
            }
            menuDao.updateByPrimaryKey(menu);
        }
    }

    public List<EasyuiTree> selectTreeByUserIdAndProjectId(String userId, String projectId) {
        List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
        List<Menu> menus = new ArrayList<Menu>();
        List<String> roleIds = userRoleDao.selectRoleIdListByUserId(userId);
        for (String roleId : roleIds) {
            List<Menu> menuList = menuDao.selectByRoleIdAndParentIdNullAndResourceTypeAndProjectId(roleId, projectId, AuthorityConstant.MENU_TYPE_RESOURCE);
            for (Menu menu : menuList) {
                menus.add(menu);
            }
        }

        for (Menu menu : menus) {
            EasyuiTree easyuiTreeOne = new EasyuiTree();
            easyuiTreeOne.setId(menu.getId());
            easyuiTreeOne.setPid(menu.getParentId());
            easyuiTreeOne.setText(menu.getName());
            easyuiTreeOne.setAttributes(menu.getUrl());
            easyuiTreeOne.setIconCls(menu.getIcon());
            selectChildrenNotBtnByRoleIdAndProjectId(easyuiTreeOne, menu.getId(), roleIds, projectId);
            easyuiTrees.add(easyuiTreeOne);
        }

        return easyuiTrees;
    }

    public List<EasyuiTree> selectAllMenuTrees(int functionType) {
        List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        criteria.andFunctionTypeEqualTo(functionType);
        criteria.andParentIdIsNull();
        List<Menu> menus = menuDao.selectByExample(menuExample);
        if (menus != null) {
            for (Menu menu : menus) {
                EasyuiTree easyuiTreeOne = new EasyuiTree();
                easyuiTreeOne.setId(menu.getId());
                easyuiTreeOne.setPid(menu.getParentId());
                easyuiTreeOne.setText(menu.getName());
                easyuiTreeOne.setAttributes(menu.getUrl());
                easyuiTreeOne.setIconCls(menu.getIcon());
                selectChildrenByFunctionType(easyuiTreeOne, menu.getId(), functionType);
                easyuiTrees.add(easyuiTreeOne);
            }
        }
        return easyuiTrees;
    }

    /**
     * 递归得到资源树（菜单类型）
     * @param easyuiTree 当前数
     * @param pId id
     */
    private void selectChildrenNotBtn(EasyuiTree easyuiTree, String pId, String state) {
        List<Menu> menus = menuDao.selectAllByResourceTypeAndParentId(AuthorityConstant.MENU_TYPE_RESOURCE, pId);
        if (menus != null && menus.size() > 0) {
            easyuiTree.setState(state);
            List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
            for (Menu menu : menus) {
                EasyuiTree easyuiTreeOne = new EasyuiTree();
                easyuiTreeOne.setId(menu.getId());
                easyuiTreeOne.setPid(menu.getParentId());
                easyuiTreeOne.setText(menu.getName());
                easyuiTreeOne.setAttributes(menu.getUrl());
                easyuiTreeOne.setIconCls(menu.getIcon());
                selectChildrenNotBtn(easyuiTreeOne, menu.getId(), menu.getState());
                easyuiTrees.add(easyuiTreeOne);
            }
            easyuiTree.setChildren(easyuiTrees);
        } else {
            easyuiTree.setState("close");
        }
    }


    /**
     * 递归得到资源树(所有可见资源)
     * @param easyuiTree 当前数
     * @param pId id
     */
    private void selectChildrenDisplay(EasyuiTree easyuiTree, String pId) {
        List<Menu> menus = menuDao.selectAllByParentIdAndStatus(pId, AuthorityConstant.MENU_STATUS_SHOW);
        if (menus != null) {
            List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
            for (Menu menu : menus) {
                EasyuiTree easyuiTreeOne = new EasyuiTree();
                easyuiTreeOne.setId(menu.getId());
                easyuiTreeOne.setPid(menu.getParentId());
                easyuiTreeOne.setText(menu.getName());
                easyuiTreeOne.setAttributes(menu.getUrl());
                easyuiTreeOne.setIconCls(menu.getIcon());
                selectChildrenDisplay(easyuiTreeOne, menu.getId());
                easyuiTrees.add(easyuiTreeOne);
            }
            easyuiTree.setChildren(easyuiTrees);
        } else {
            easyuiTree.setState("closed");
        }
    }

    /**
     * 递归得到资源树(所有菜单功能)
     * @param easyuiTree 当前数
     * @param pId id
     */
    private void selectChildrenByFunctionType(EasyuiTree easyuiTree, String pId, Integer functionType) {
        List<Menu> menus = menuDao.selectAllByParentIdAndFunctionType(pId, functionType);
        if (menus != null) {
            List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
            for (Menu menu : menus) {
                EasyuiTree easyuiTreeOne = new EasyuiTree();
                easyuiTreeOne.setId(menu.getId());
                easyuiTreeOne.setPid(menu.getParentId());
                easyuiTreeOne.setText(menu.getName());
                easyuiTreeOne.setAttributes(menu.getUrl());
                easyuiTreeOne.setIconCls(menu.getIcon());
                selectChildrenDisplay(easyuiTreeOne, menu.getId());
                easyuiTrees.add(easyuiTreeOne);
            }
            easyuiTree.setChildren(easyuiTrees);
        } else {
            easyuiTree.setState("closed");
        }
    }

    /**
     * 递归得到资源树（菜单类型）
     * @param easyuiTree 当前数
     * @param pId id
     */
    private void selectChildrenNotBtnByRoleId(EasyuiTree easyuiTree, String pId, List<String> roleIds) {
        List<Menu> menus = menuDao.selectAllByStatusAndParentIdAndRoleIdIn(AuthorityConstant.MENU_STATUS_SHOW, pId, roleIds);
        if (menus != null) {
            List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
            for (Menu menu : menus) {
                EasyuiTree easyuiTreeOne = new EasyuiTree();
                easyuiTreeOne.setId(menu.getId());
                easyuiTreeOne.setPid(menu.getParentId());
                easyuiTreeOne.setText(menu.getName());
                easyuiTreeOne.setAttributes(menu.getUrl());
                easyuiTreeOne.setIconCls(menu.getIcon());
                selectChildrenNotBtnByRoleId(easyuiTreeOne, menu.getId(), roleIds);
                easyuiTrees.add(easyuiTreeOne);
            }
            easyuiTree.setChildren(easyuiTrees);
        } else {
            easyuiTree.setState("closed");
        }
    }

    /**
     * 递归得到资源树（菜单类型）
     * @param easyuiTree 当前数
     * @param pId id
     */
    private void selectChildrenNotBtnByRoleIdAndProjectId(EasyuiTree easyuiTree, String pId, List<String> roleIds, String projectId) {
        List<Menu> menus = menuDao.selectAllByStatusAndParentIdAndRoleIdInAndProjectId(AuthorityConstant.MENU_STATUS_SHOW, pId, roleIds, projectId);
        if (menus != null) {
            List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
            for (Menu menu : menus) {
                EasyuiTree easyuiTreeOne = new EasyuiTree();
                easyuiTreeOne.setId(menu.getId());
                easyuiTreeOne.setPid(menu.getParentId());
                easyuiTreeOne.setText(menu.getName());
                easyuiTreeOne.setAttributes(menu.getUrl());
                easyuiTreeOne.setIconCls(menu.getIcon());
                selectChildrenNotBtnByRoleId(easyuiTreeOne, menu.getId(), roleIds);
                easyuiTrees.add(easyuiTreeOne);
            }
            easyuiTree.setChildren(easyuiTrees);
        } else {
            easyuiTree.setState("closed");
        }
    }

}
