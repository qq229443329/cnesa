<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#companyAddForm').form({
            url : '${path }/company/add',
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
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
                    parent.$.modalDialog.handler.dialog('close');
                } else {
                    parent.$.messager.alert('错误', result.msg, 'error');
                }
            }
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false" >
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;" >
        <form id="companyAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>企业名称</td>
                    <td><input name="name" type="text" placeholder="请输入企业名称" class="easyui-validatebox span2" data-options="required:true" value=""></td>
                    <td>企业编码</td>
                    <td><input name="code" type="text" placeholder="请输入企业编码" class="easyui-validatebox span2" data-options="required:true" value=""></td>
                </tr>
                <tr>
                    <td>企业描述</td>
                    <td colspan="3"><input name="description" style="width: 370px;"></td>
                </tr>
                <tr>
                    <td>所属行业</td>
                    <td><input name="industry"></td>
                    <td>企业规模</td>
                    <td><input name="peopleSize" value="0" class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="editable:false"></td>
                </tr>
                <tr>
                    <td>企业法人</td>
                    <td><input name="legalPeople"></td>
                    <td>法人电话</td>
                    <td><input name="legalMobile" class="easyui-numberbox"></td>
                </tr>
                <tr>
                    <td>企业联系人</td>
                    <td><input name="contactPeople"></td>
                    <td>联系人电话</td>
                    <td><input name="contactMobile" class="easyui-numberbox"></td>
                </tr>
                <tr>
                    <td>企业许可证</td>
                    <td><input name="busniessNum"></td>
                    <td>工作时间</td>
                    <td><input name="workingTime"></td>
                </tr>
                <tr id="showImage">
                    <td>营业执照</td>
                    <td colspan="3"><input id="busniessLicense" name="busniessLicense" class="easyui-filebox" data-options="prompt:'选择上传文件'" style="width:100%"></td>
                </tr>
                <tr>
                    <td>企业logo</td>
                    <td colspan="3"><input id="iconLogo" name="iconLogo" class="easyui-filebox" data-options="prompt:'选择上传文件'" style="width:100%"></td>
                </tr>
                <tr>
                    <td>所在区域</td>
                    <td colspan="3"><input name="region" style="width: 370px;"></td>
                </tr>
                <tr>
                    <td>详细地址</td>
                    <td colspan="3"><textarea name="location" rows="" cols="50" ></textarea></td>
                </tr>
            </table>
        </form>
    </div>
</div>