package com.cnesa.authority.service.impl;

import com.cnesa.authority.dao.OrganizationDao;
import com.cnesa.authority.entity.Organization;
import com.cnesa.authority.entity.OrganizationExample;
import com.cnesa.common.model.EasyuiTree;
import com.cnesa.authority.service.OrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 组织操作
 *
 * Created by shangpeibao on 16/12/9.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationDao organizationDao;

    /**
     * 查询组织树
     * @return
     */
    public List<EasyuiTree> selectTree() {
        List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
        List<Organization> organizations = organizationDao.selectByParentIdNull();
        if (organizations != null) {
            EasyuiTree easyuiTree;
            for (Organization org : organizations) {
                easyuiTree = new EasyuiTree();
                easyuiTree.setId(org.getId());
                easyuiTree.setText(org.getName());
                easyuiTree.setIconCls(org.getIcon());
                selectChildren(easyuiTree, org.getId());
                easyuiTrees.add(easyuiTree);
            }
        }
        return easyuiTrees;
    }

    public List<Organization> selectTreeGrid() {
        OrganizationExample organizationExample = new OrganizationExample();
        organizationExample.setDistinct(true);
        return organizationDao.selectByExample(organizationExample);
    }

    public void insert(Organization organization) {
        if (organization != null) {
            organization.setCreateTime(new Date(System.currentTimeMillis()));
            organizationDao.insert(organization);
        }
    }

    public Organization selectOrganizationById(String id) {
        if (StringUtils.hasLength(id)) {
            return organizationDao.selectByPrimaryKey(id);
        }
        return null;
    }

    public void update(Organization organization) {
        if (organization != null) {
            organization.setCreateTime(new Date(System.currentTimeMillis()));
            organizationDao.updateByPrimaryKey(organization);
        }
    }

    public void delelte(String id) {
        if (StringUtils.hasLength(id)) {
            organizationDao.deleteByPrimaryKey(id);
        }
    }

    /**
     * 递归遍历子节点组织
     * @param easyuiTree 树模型
     * @param id 父类id
     */
    private void selectChildren(EasyuiTree easyuiTree, String id) {
        List<Organization> organizations = organizationDao.selectByParentId(id);
        if (organizations != null) {
            List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
            EasyuiTree t;
            for (Organization org : organizations) {
                t = new EasyuiTree();
                t.setId(org.getId());
                t.setText(org.getName());
                t.setIconCls(org.getIcon());
                selectChildren(t, org.getId());
                easyuiTrees.add(t);
            }
            easyuiTree.setChildren(easyuiTrees);
        } else {
            easyuiTree.setState("close");
        }
    }
}
