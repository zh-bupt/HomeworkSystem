<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/18
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>课程修改</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../assets/css/pagination.css">
    <script type="text/javascript" src="../assets/js/libs/modernizr.min.js"></script>
    <script src="../assets/js/jquery-3.2.1.js"></script>
    <script src="../assets/layer/layer.js"></script>
    <script src="../assets/js/dateFormat.js"></script>
    <style type="text/css">
        td,#col-title th{text-align: center;}
    </style>
</head>
<body>

<div class="admin_login_wrap">
    <h1>修改密码</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <s:form id="form_for_comment" action="updateCourseAction" >
                <ul class="admin_items">

                    <li>
                        <label for="password">初始密码</label>
                        <input type="password" name="password" id="password" size="35" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="newPassword">新密码</label>
                        <input type="password" name="newPassword"  id="newPassword" size="35" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="rePassword">重复密码</label>
                        <input type="password" name="rePassword" id="rePassword" size="35" class="admin_input_style" />
                    </li>
                    <li>
                        <button tabindex="3" type="submit" class="btn btn-primary" id="btn-update">修改</button>
                    </li>
                </ul>
            </s:form>
        </div>
    </div>
</div>

</body>
</html>

