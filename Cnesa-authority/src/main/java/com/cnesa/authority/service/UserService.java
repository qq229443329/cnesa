package com.cnesa.authority.service;

import com.cnesa.authority.entity.User;
import com.cnesa.common.model.EasyuiPage;

import java.util.List;
import java.util.Map;

/**
 * Created by shangpeibao on 16/12/5.
 */
public interface UserService {

    List<User> selectByUsername(String username);

    List<User> selectByUser(User user);

    User selectById(String id);

    void selectDataGrid(EasyuiPage easyuiPage);

    void upddate(User user);

    void insert(User user);

    void updatePwdByUserId(String id, String password);

    void upddateToken(String id, String tokenKey);

    String selectLoginByUsername(String username, String password) throws Exception;

    /**
     * 获取用户账户信息
     * @param userId 用户ID
     * @return
     */
    Map<String, String> selectAccountInfoByUserId(String userId);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean updateByExampleSelective(User user);

    /**
     * 删除token
     * @param userId
     */
    void deleteToken(String userId);

    /**
     * 更新用户状态
     * @param user 用户对象
     */
    void upddateStatus(User user);

    /**
     * 删除用户
     * @param id 用户ID
     * @return
     */
    boolean deleteUser(String id);
}
