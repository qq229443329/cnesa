package com.cnesa.authority.dao;

import com.cnesa.authority.entity.Menu;
import com.cnesa.authority.entity.MenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> selectAllByParentIdNull();

    List<Menu> selectAllByResourceTypeAndParentId(@Param("resourceType") Integer resourceType, @Param("parentId") String parentId);

    List<Menu> selectAllByParentIdAndStatus(@Param("parentId") String parentId, @Param("status") Integer status);

    List<Menu> selectByRoleIdAndParentIdNullAndResourceType(@Param("roleId") String roleId, @Param("resourceType") Integer resourceType);

    List<Menu> selectAllByResourceTypeAndParentIdNullAndStatus(@Param("resourceType") Integer resourceType, @Param("status") Integer status);

    List<Menu> selectAllByStatusAndParentIdAndRoleIdIn(@Param("status") Integer status, @Param("parentId") String parentId, @Param("roleIds") List<String> roleIds);

    List<Menu> selectByRoleIdAndParentIdNullAndResourceTypeAndProjectId(@Param("roleId") String roleId, @Param("projectId") String projectId, @Param("resourceType") Integer resourceType);

    List<Menu> selectAllByStatusAndParentIdAndRoleIdInAndProjectId(@Param("status") Integer status, @Param("parentId") String parentId, @Param("roleIds") List<String> roleIds, @Param("projectId") String projectId);

    List<Menu> selectAllByParentIdAndFunctionType(@Param("parentId") String parentId, @Param("functionType") Integer functionType);

    List<Menu> selectAllByParentIdNullAndNotFunctionType(@Param("functionType") Integer functionType);
}