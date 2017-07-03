package com.cnesa.authority.shiro;

import com.cnesa.authority.model.ShiroUser;
import com.cnesa.authority.entity.User;
import com.cnesa.authority.service.RoleService;
import com.cnesa.authority.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by shangpeibao on 16/12/6.
 *
 * shiro 权限认证
 */
public class MyShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * Shiro权限认证
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        List<String> roleList = shiroUser.roleList;

        Set<String> urlSet = new HashSet<String>();
        for (String roleId : roleList) {
            List<Map<String, String>> roleResourceList = roleService.selectRoleResourceListByRoleId(roleId);
            if (roleResourceList != null) {
                for (Map<String, String> map : roleResourceList) {
                    if (StringUtils.hasLength(map.get("url"))) {
                        urlSet.add(map.get("url"));
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(urlSet);
        return info;
    }

    /**
     * Shiro登录认证
     * 原理：用户提交 用户名和密码
     * --- shiro 封装令牌
     * ---- realm 通过用户名将密码查询返回
     * ---- shiro 自动去比较查询出密码和用户输入密码是否一致
     * ---- 进行登陆控制
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        logger.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        List<User> list = userService.selectByUsername(token.getUsername());
        // 账号不存在
        if (list == null || list.isEmpty()) {
            return null;
        }
        User user = list.get(0);
        // 账号未启用
        if (user.getStatus() == 0) {
            return null;
        }
        List<String> roleList = roleService.selectRoleIdListByUserId(user.getId());
        ShiroUser shiroUser = new ShiroUser(user.getId(), user.getUsername(), user.getRealName(), "", roleList);
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(), getName());
    }
}
