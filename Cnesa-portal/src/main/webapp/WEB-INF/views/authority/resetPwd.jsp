<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#userResetPwdForm').form({
            url : '${path }/user/resetPwd',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
                var pwd = $("#pwdId").val();
                var rePwd = $("#rePwdId").val();
                if (!isValid) {
                    progressClose();
                }
                if (pwd != rePwd) {
                    progressClose();
                    $.messager.alert('提示', '两次输入密码不一致！', 'info');
                }
                return isValid && (pwd === rePwd);
            },
            success : function(result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                    parent.$.messager.alert('提示', result.msg, 'info');
                    parent.$.modalDialog.handler.dialog('close');
                } else {
                    parent.$.messager.alert('错误', result.msg, 'error');
                }
            }
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;">
        <form id="userResetPwdForm" method="post">
            <input name="userId" type="hidden" value="${userId}">
            <table>
                <tr>
                    <th>新密码：</th>
                    <td><input id="pwdId" name="pwd" type="password" placeholder="请输入新密码" class="easyui-validatebox" data-options="required:true"></td>
                </tr>
                <tr>
                    <th>确认密码：</th>
                    <td><input id="rePwdId" name="rePwd" type="password" placeholder="再次输入新密码" class="easyui-validatebox" data-options="required:true"></td>
                </tr>
            </table>
        </form>
    </div>
</div>