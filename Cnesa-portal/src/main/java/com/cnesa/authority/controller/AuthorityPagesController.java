package com.cnesa.authority.controller;

import base.BaseController;
import com.cnesa.authority.entity.Company;
import com.cnesa.authority.entity.Menu;
import com.cnesa.authority.entity.Role;
import com.cnesa.authority.entity.User;
import com.cnesa.authority.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 *  权限页面跳转控制
 *
 * Created by shangpeibao on 16/12/8.
 */
@Controller
public class AuthorityPagesController extends BaseController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private CompanyService companyService;

    /**
     * 权限管理
     * @return
     */
    @RequestMapping(value = "/resource/manager", method = RequestMethod.GET)
    public String resourceManager() {
        return "authority/resource";
    }

    /**
     * 添加资源
     * @return
     */
    @RequestMapping(value = "/resource/addResource", method = RequestMethod.GET)
    public String addResource() {
        return "authority/resourceAdd";
    }

    /**
     * 编辑资源页
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/resource/editPage")
    public String resourceEditPage(Model model, @RequestParam(value = "id", required = true) String id) {
        try {
            Menu menu = menuService.selectById(id);
            model.addAttribute("resource", menu);
        } catch (Exception e) {
            logger.error("--AuthorityPagesController--resourceEditPage--查询资源菜单失败--{}--", e.getMessage(), e);
        }
        return "authority/resourceEdit";
    }

    /**
     * 角色管理
     * @return
     */
    @RequestMapping(value = "/role/manager", method = RequestMethod.GET)
    public String roleManager() {
        return "authority/role";
    }

    /**
     * 添加角色
     * @return
     */
    @RequestMapping(value = "/role/addPage")
    public String roleAddPage() {
        return "authority/roleAdd";
    }

    /**
     * 角色授权
     * @return
     */
    @RequestMapping(value = "/role/grantPage")
    public String roleGrantpage(@RequestParam(value = "id", required = true, defaultValue = "") String id, Model model) {
        model.addAttribute("id", id);
        return "authority/roleGrant";
    }

    /**
     * 角色编辑
     * @param id 角色ID
     * @param model
     * @return
     */
    @RequestMapping(value = "/role/editPage", method = RequestMethod.GET)
    public String roleEditPage(@RequestParam(value = "id", required = true, defaultValue = "") String id, Model model) {
        try {
            Role role = roleService.selectById(id);
            model.addAttribute("role", role);
        } catch (Exception e) {
            logger.error("--AuthorityPagesController--roleEditPage--获取角色失败--{}--", e.getMessage(), e);
        }
        return "authority/roleEdit";
    }

    /**
     * 用户管理
     * @return
     */
    @RequestMapping(value = "/user/manager", method = RequestMethod.GET)
    public String userManager() {
        return "authority/user";
    }

    /**
     * 用户编辑
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/user/editUser", method = RequestMethod.GET)
    public String userEdit(@RequestParam(value = "id", required = true, defaultValue = "") String id, Model model) {
        try {
            User user = userService.selectById(id);
            if (user != null && StringUtils.hasLength(user.getId())) {
//                List<UserProject> projects = userProjectService.selectByUserId(user.getId());
//                List<String> projectIds = new ArrayList<String>();
//                if (projects != null) {
//                    for (UserProject p : projects) {
//                        projectIds.add("'" + p.getProjectId() + "'");
//                    }
//                }
//                user.setProjectIds(projectIds);
            }
            List<Role> roles = user.getRolesList();
            List<String> roleIds = new ArrayList<String>();
            for (Role role : roles) {
                roleIds.add("'" + role.getId() + "'");
            }
            user.setRoleIds(roleIds);
            model.addAttribute("user", user);
        } catch (Exception e) {
            logger.error("--UserController--editUser--获取用户失败--{}--", e.getMessage(), e);
        }
        return "authority/userEdit";
    }

    /**
     * 用户添加
     * @return
     */
    @RequestMapping(value = "/user/addUser", method = RequestMethod.GET)
    public String userAdd() {
        return "authority/userAdd";
    }

    /**
     * 修改密码页
     *
     * @return
     */
    @RequestMapping(value = "/user/editPwdPage", method = RequestMethod.GET)
    public String editPwdPage() {
        return "authority/userEditPwd";
    }

    /**
     * 重置其他用户密码
     * @param model
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/user/resetPwdPage", method = RequestMethod.GET)
    public String resetPwdPage(Model model, @RequestParam(value = "id", required = true, defaultValue = "") String id) {
        model.addAttribute("userId", id);
        return "authority/resetPwd";
    }

    /**
     * 部门管理
     * @return
     */
    @RequestMapping(value = "/organization/manager", method = RequestMethod.GET)
    public String organizationManager() {
        return "authority/organization";
    }

    /**
     * 添加部门
     * @return
     */
    @RequestMapping(value = "/organization/addPage", method = RequestMethod.GET)
    public String organizationAdd() {
        return "authority/organizationAdd";
    }

    /**
     * 部门编辑
     * @param id 部门ID
     * @param model
     * @return
     */
    @RequestMapping(value = "/organization/editOrganization", method = RequestMethod.GET)
    public String organizationEdit(@RequestParam(value = "id", required = true, defaultValue = "") String id, Model model) {
        model.addAttribute("organization", organizationService.selectOrganizationById(id));
        return "authority/organizationEdit";
    }

    /**
     * 显示企业列表
     * @return
     */
    @RequestMapping(value = "/company/manager", method = RequestMethod.GET)
    public String companyManager() {
        return "authority/company";
    }

    /**
     * 显示添加企业
     * @return
     */
    @RequestMapping(value = "/company/addPage", method = RequestMethod.GET)
    public String addCompany() {
        return "authority/companyAdd";
    }

    /**
     * 显示编辑企业页面
     * @param model
     * @param id  企业ID
     * @return
     */
    @RequestMapping(value = "/company/editPage", method = RequestMethod.GET)
    public String editCompany(Model model, @RequestParam("id") String id) {
        try {
            Company company = companyService.selectById(id);
            model.addAttribute("company", company);
        } catch (Exception e) {
            logger.error("--CmsPagesController--editCompany--查询企业失败--{}--", e);
        }
        return "authority/companyEdit";
    }
}
