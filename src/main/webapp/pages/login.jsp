<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/11
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>系统登录</h1>
<s:form action="loginAction">
    <s:actionerror/>
    <s:textfield name="id" label="ID" value=""/>
    <s:password name="password" label="密码" value=""/>
    <s:if test="role==null">
        <s:radio name="role" list="{ '管理员', '教师','学生' }" value="'学生'"  label="用户身份"/>
    </s:if>
    <s:else>
        <s:radio name="role" list="{ '管理员', '教师','学生' }"  label="用户身份"/>
    </s:else>
    <s:submit/>
</s:form>

</body>
</html>
