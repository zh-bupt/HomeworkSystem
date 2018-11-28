<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/27
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>教师管理</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
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
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a class="navbar-brand">查询结果</a></h1>
            <ul class="navbar-list clearfix">
                <%--<li><a class="on" href="/pages/admin_student.jsp">首页</a></li>--%>
                <li><a class="on" href="/admin/listTeacherAction.action" target="_blank">教师管理</a></li>
                <li><a href="/pages/admin_student.jsp" target="_blank">学生管理</a></li>

            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">

                <%--<li><a href="adminRank.jsp">排行榜</a></li>--%>
                <li><a href="/pages/login.jsp">退出</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <ul class="sub-menu">
                        <li><a href="/admin/listTeacherAction.action"><i class="icon-font">&#xe005;</i>查找教师</a></li>
                        <li><a href="/pages/admin_add_teacher.jsp"><i class="icon-font">&#xe005;</i>添加教师</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a>首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">教师管理</a><span class="crumb-step">&gt;</span><span>添加教师</span></div>
        </div>

        <!--add  form-->
        <div class="result-wrap">
            <div class="result-content">
                <%--<form name="myform" id="myform" method="post">--%>
                <div class="result-title">
                    <div class="result-list">
                        <%--<a href="addReader.jsp"><i class="icon-font"></i>添加读者</a>--%>
                        <h3>上传教师名单文件</h3>
                        <s:form action="addTeacherByFileAction" method="post" enctype="multipart/form-data">
                            <s:file name="teacherExcel" label="选择上传的文件" />
                            <s:submit value="上传" class="btn btn-primary btn6 mr10"/>
                        </s:form>
                    </div>
                </div>
                <%--</form>--%>
                <h3>输入教师信息</h3>
                <s:form action="addTeacherAction" id="searchForm">
                    <%--<form  id="add-book"  enctype="multipart/form-data">--%>
                    <input type="hidden" value="add" name="type">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th>
                                <i class="require-red">*</i>工号：</th>
                            <td>
                                <input class="common-text required" id="teacherId" name="teacherId" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th width="120">
                                <i class="require-red">*</i>姓名：</th>
                            <td>
                                <input class="common-text required" id="teacherName" name="teacherName" size="50" value="" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th>性别：</th>
                            <td>
                                <input type="radio" name="sex" class="radio-inline" style="margin: 10px" value="男">男
                                <input type="radio" name="sex" class="radio-inline" style="margin: 10px" value="女">女
                            </td>
                        </tr>
                        <tr>
                            <th>联系电话：</th>
                            <td>
                                <input class="common-text required" id="telephone" name="telephone" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th>邮箱：</th>
                            <td>
                                <input class="common-text" name="teacherEmail" size="50"  type="text">
                            </td>
                        </tr>
                        <tr>
                            <th>密码：</th>
                            <td>
                                <input class="common-text" name="teacherPassword" size="50" type="password">
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <button class="btn btn-primary btn6 mr10" type="submit">提交</button>
                                <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <%--</form>--%>
                    <s:token/>
                </s:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

