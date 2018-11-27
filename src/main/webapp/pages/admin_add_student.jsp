<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/27
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理</title>
</head>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理系统</title>
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
                <li><a  href="/admin/listTeacherAction.action" target="_blank">教师管理</a></li>
                <li><a class="on" href="/pages/admin_student.jsp" target="_blank">学生管理</a></li>

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
                        <li><a href="/pages/admin_student.jsp"><i class="icon-font">&#xe005;</i>查找学生</a></li>
                        <li><a href="/pages/admin_add_student.jsp"><i class="icon-font">&#xe005;</i>添加学生</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="main.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">学生管理</span></div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                <s:form action="addTeacherAction" id="searchForm">
                    <table class="search-tab">
                        <tr>
                                <%--<s:textfield name="studentId" label="学号" value=""/>--%>
                                <%--<s:textfield name="studentName" label="姓名" value=""/>--%>
                                <%--<s:textfield name="classId" label="班级" value=""/>--%>
                                <%--<s:textfield name="sex" label="性别" value=""/>--%>
                                <%--<s:textfield name="email" label="邮箱" value=""/>--%>
                                <%--<s:password name="password" label="密码" value=""/>--%>
                                <%--<s:date name="entranceDate" format="YYYY-MM-DD"/>--%>
                            <th width="140">学号:</th>
                            <td><input class="common-text" placeholder="" name="studentId"  id="studentId"  type="text" style="width:150px"></td>
                            <th width="140">姓名:</th>
                            <td><input class="common-text" placeholder="" name="studentName"  id="studentName"  type="text" style="width:150px"></td>
                            <th width="140">班级:</th>
                            <td><input class="common-text" placeholder="" name="classId"  id="classId"  type="text" style="width:150px"></td>
                            <th width="140">性别:</th>
                            <td><input class="common-text" placeholder="" name="sex"  id="sex"  type="text" style="width:150px"></td>
                            <th width="140">邮箱:</th>
                            <td><input class="common-text" placeholder="" name="email"  id="email"  type="text" style="width:150px"></td>
                            <th width="140">入学时间:</th>
                            <td><input class="common-text" placeholder="" name="entranceDate"  id="entranceDate"  type="date" style="width:150px"></td>
                            <th width="140">密码:</th>
                            <td><input class="common-text" placeholder="" name="password"  id="password"  type="password" style="width:150px"></td>
                            <td style="padding-left:50px"><button class="btn btn-primary btn2" type="submit" >添加</button></td>
                        </tr>
                    </table>
                </s:form>
                <%--</form>--%>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <%--<a href="addReader.jsp"><i class="icon-font"></i>添加读者</a>--%>
                        <h3>上传学生名单文件</h3>
                            <s:form action="addStudentByFileAction" method="post" enctype="multipart/form-data">
                                <s:file name="studentExcel" label="选择上传的文件" />
                            <s:submit value="上传" />
                            </s:form>
                    </div>
                </div>
                <div class="result-content">




                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>

