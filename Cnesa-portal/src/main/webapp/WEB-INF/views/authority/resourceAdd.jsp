<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {

        $('#pid').combotree({
            url : '${path }/resource/resourceTree',
            parentField : 'parentId',
            lines : true,
            panelHeight : '500'
        });

        $('#resourceAddForm').form({
            url : '${path }/resource/add',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success : function(result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                    parent.$.modalDialog.openner_treeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
                    //parent.layout_west_tree.tree('reload');
                    parent.$.modalDialog.handler.dialog('close');
                }
            }
        });

    });
</script>
<div style="padding: 3px;">
    <form id="resourceAddForm" method="post">
        <table class="grid">
            <tr>
                <td>资源名称</td>
                <td><input name="name" type="text" placeholder="请输入资源名称" class="easyui-validatebox span2" data-options="required:true" ></td>
                <td>资源类型</td>
                <td>
                    <select name="resourceType" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                        <option value="0">菜单</option>
                        <option value="1">按钮</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>资源路径</td>
                <td><input name="url" type="text" placeholder="请输入资源路径" class="easyui-validatebox span2" data-options="width:140,height:29" ></td>
                <td>排序</td>
                <td><input name="seq" value="0"  class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="editable:false"></td>
            </tr>
            <tr>
                <td>菜单图标</td>
                <td ><input  name="icon" /></td>
                <td>状态</td>
                <td>
                    <select name="status" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                        <option value="1">正常</option>
                        <option value="0">停用</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>菜单描述</td>
                <td ><input  name="description" /></td>
                <td>菜单功能</td>
                <td >
                    <select name="functionType" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                        <option value="0">配置功能</option>
                        <option value="1">权限功能</option>
                        <option value="2">菜单功能</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>上级资源</td>
                <td><select id="pid" name="parentId" style="width: 130px; height: 29px;"></select>
                    <a class="easyui-linkbutton" href="javascript:void(0)" onclick="$('#pid').combotree('clear');" >清空</a></td>
                <td>展开/折叠</td>
                <td><select id="stateId" name="state" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                    <option value="open">展开</option>
                    <option value="closed">折叠</option>
                </select></td>
            </tr>
        </table>
    </form>
</div>