package com.cnesa.authority.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.cnesa.authority.dao.RoleDao;
import com.cnesa.authority.dao.UserDao;
import com.cnesa.authority.dao.UserRoleDao;
import com.cnesa.authority.entity.User;
import com.cnesa.authority.entity.UserExample;
import com.cnesa.authority.entity.UserRole;
import com.cnesa.authority.entity.UserRoleExample;
import com.cnesa.authority.model.CurrentUser;
import com.cnesa.common.model.EasyuiPage;
import com.cnesa.authority.service.UserService;
import com.cnesa.common.utils.DigestUtils;
import com.cnesa.common.utils.TokenUtil;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户操作
 *
 * Created by shangpeibao on 16/12/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleDao roleDao;

    /**
     * 通过用户名查询用户列表
     * @param username 用户名
     * @return
     */
    public List<User> selectByUsername(String username) {
        if (StringUtils.hasLength(username)) {
            return userDao.selectByUsername(username);
        }
        return null;
    }

    /**
     * 通过用户查询用户列表
     * @param user 用户对象
     * @return
     */
    public List<User> selectByUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        if (StringUtils.hasLength(user.getId())) {
            criteria.andIdNotEqualTo(user.getId());
        }
        return userDao.selectByExample(userExample);
    }

    /**
     * 通过主键ID查询用户
     * @param id 用户ID
     * @return
     */
    public User selectById(String id) {
        if (StringUtils.hasLength(id)) {
            return userDao.selectUserById(id);
        }
        return null;
    }

    /**
     * 获取用户树列表分页显示
     * @param easyuiPage  easyui datagrid模型
     */
    public void selectDataGrid(EasyuiPage easyuiPage) {
        Page<User> page = new Page<User>(easyuiPage.getNowpage(), easyuiPage.getSize());
        List<User> list = userDao.selectUserPage(page, easyuiPage.getCondition());
        easyuiPage.setRows(list);
        easyuiPage.setTotal(page.getTotal());
    }

    public void upddate(User user) {
        User oldUser = userDao.selectUserById(user.getId());
        user.setPassword(oldUser.getPassword());
        userDao.updateByPrimaryKeySelective(user);

        String userId = user.getId();

        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserRole> userRoles = userRoleDao.selectByExample(userRoleExample);
        if (userRoles != null && !userRoles.isEmpty()) {
            for (UserRole userRole : userRoles) {
                userRoleDao.deleteByPrimaryKey(userRole.getId());
            }
        }

        List<String> roleIds = user.getRoleIds();
        if (roleIds != null) {
            //String[] idList = roleIds.split(",");
            UserRole userRole;
            for (String roleId : roleIds) {
                userRole = new UserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(userId);
                userRoleDao.insert(userRole);
            }
        }
    }

    public void insert(User user) {
        user.setCreateTime(new Date(System.currentTimeMillis()));
        userDao.insert(user);
        String userId = user.getId();
        List<String> roleIds = user.getRoleIds();
        UserRole userRole = new UserRole();

        for (String roleId : roleIds) {
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleDao.insert(userRole);
        }
    }

    public void updatePwdByUserId(String id, String pasword) {
        User user = new User();
        user.setId(id);
        user.setPassword(pasword);
        userDao.updateByPrimaryKeySelective(user);
    }

    public void upddateToken(String id, String tokenKey) {
        User user = new User();
        user.setId(id);
        user.setToken(tokenKey);
        userDao.updateByPrimaryKeySelective(user);
    }

    public String selectLoginByUsername(String username, String password) throws Exception {
        String token = null;
        List<User> list = userDao.selectByUsername(username);
        // 账号不存在
        if (list == null || list.isEmpty()) {
            throw new UnknownAccountException();
        }
        User user = list.get(0);
        // 账号未启用
        if (user.getStatus() == 0) {
            throw new DisabledAccountException();
        }
        if (user.getPassword().equals(DigestUtils.md5Hex(password))) {
//            List<String> roleList = userRoleDao.selectRoleIdListByUserId(user.getId());
            Set<String> urlSet = new HashSet<String>();
//            for (String roleId : roleList) {
//                List<Map<String, String>> roleResourceList = roleDao.selectRoleResourceListByRoleId(roleId);
//                if (roleResourceList != null) {
//                    for (Map<String, String> map : roleResourceList) {
//                        if (StringUtils.hasLength(map.get("url"))) {
//                            urlSet.add(map.get("url"));
//                        }
//                    }
//                }
//            }
            token = TokenUtil.signJWT(user.getId(), DigestUtils.md5Hex(password), urlSet);
            this.upddateToken(user.getId(), token);

        } else {
            throw new IncorrectCredentialsException();
        }
        return token;
    }

    public Map<String, String> selectAccountInfoByUserId(String userId) {
        if (StringUtils.hasLength(userId)) {
            return userDao.selectAccountByUserId(userId);
        }
        return null;
    }

    public boolean updateByExampleSelective(User user) {
        if (user != null) {
            int i = userDao.updateByPrimaryKeySelective(user);
            return i > 0;
        }
        return false;
    }

    public void deleteToken(String userId) {
        User user = userDao.selectByPrimaryKey(userId);
        user.setToken(null);
        user.setStatus(1);
        userDao.updateByPrimaryKey(user);
        CurrentUser.empty();
    }

    public void upddateStatus(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    public boolean deleteUser(String id) {
        if (StringUtils.hasLength(id)) {
            User user = userDao.selectUserById(id);
            if (user != null && !"admin".equals(user.getUsername())) {
                UserRoleExample example = new UserRoleExample();
                UserRoleExample.Criteria criteria = example.createCriteria();
                criteria.andUserIdEqualTo(id);
                userRoleDao.deleteByExample(example);
                userDao.deleteByPrimaryKey(id);
                return true;
            }
        }
        return false;
    }

}
