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
    <meta charset="utf-8">
    <title>登录</title>
    <link href="../assets/css/admin_login.css" rel="stylesheet" type="text/css" />
    <script src="../assets/js/jquery-3.2.1.js"></script>
    <script src="../assets/layer/layer.js"></script>
</head>
<body>
<%--<h1>系统登录</h1>--%>
<%--<s:form action="loginAction">--%>
    <%--<s:actionerror/>--%>
    <%--<s:textfield name="id" label="ID" value=""/>--%>
    <%--<s:password name="password" label="密码" value=""/>--%>
    <%--<s:if test="role==null">--%>
        <%--<s:radio name="role" list="{ '管理员', '教师','学生' }" value="'学生'"  label="用户身份"/>--%>
    <%--</s:if>--%>
    <%--<s:else>--%>
        <%--<s:radio name="role" list="{ '管理员', '教师','学生' }"  label="用户身份"/>--%>
    <%--</s:else>--%>
    <%--<s:submit/>--%>
<%--</s:form>--%>
<div style=" background:url(../assets/images/background.jpg) no-repeat;
    background-attachment:fixed;
    background-position: center;
    background-size:100% 100%;
    -webkit-background-size:100% 100%;
    -moz-background-size: 100% 100%;
    -o-background-size: 100% 100%;
    padding:200px 0;
    /*color:#fff;*/
    height: 1080px"  >
    <div class="admin_login_wrap" >
        <h1 style="color: #FFFFFF">系统登录</h1>
        <div class="adming_login_border">
            <div class="admin_input">
                <%--<form id="form_for_login" action="login.jsp" method="post" onsubmit="return submitCheck();">--%>
                <s:form id="form_for_login" action="loginAction">
                    <ul class="admin_items">

                            <li><label for="account">用户ID：</label></li>
                            <li><input type="text" name="id" id="account" size="35" class="admin_input_style" /></li>
                            <%--<s:textfield name="id" value="" id="account" size="35" class="admin_input_style"/>--%>

                            <li><label for="password">密码：</label></li>
                            <li><input type="password" name="password"  id="password" size="35" class="admin_input_style" /></li>
                            <%--<s:password name="password" value="" id="password" size="35" class="admin_input_style"/>--%>
                            <%--<s:if test="role==null">--%>
                            <%--<radio name="role" list="{ '管理员', '教师','学生' }" value="'学生'"  label="用户身份"  class="radio-inline"  class="admin_input_style"></radio>--%>
                            <li>
                                <input type="radio" name="role" class="radio-inline" style="margin: 10px;color: #1A1A1A" value="管理员">管理员
                                <input type="radio" name="role" class="radio-inline" style="margin: 10px;color: #1A1A1A" value="教师">教师
                                <input type="radio" name="role" class="radio-inline" style="margin: 10px;color: #1A1A1A" value="学生" checked>学生
                            </li>
                            <%--</s:if>--%>
                            <%--<s:else>--%>
                                <%--<s:radio name="role" list="{ '管理员', '教师','学生' }"  label="用户身份"  class="radio-inline"/>--%>
                            <%--</s:else>--%>
                            <li><button tabindex="3" type="submit" class="btn btn-primary" id="btn-submit1">登录</button></li>
                            <s:actionerror/>
                            <%--<s:submit value="登录" class="btn btn-primary" id="btn-submit1"/>--%>



                    </ul>
                <%--</form>--%>
                </s:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
