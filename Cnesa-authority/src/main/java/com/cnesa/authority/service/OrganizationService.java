package com.cnesa.authority.service;

import com.cnesa.authority.entity.Organization;
import com.cnesa.common.model.EasyuiTree;

import java.util.List;

/**
 * Created by shangpeibao on 16/12/9.
 */
public interface OrganizationService {

    List<EasyuiTree> selectTree();

    List<Organization> selectTreeGrid();

    void insert(Organization organization);

    Organization selectOrganizationById(String id);

    void update(Organization organization);

    void delelte(String id);
}
