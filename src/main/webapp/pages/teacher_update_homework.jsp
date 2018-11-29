<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/29
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>教师系统</title>

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
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a class="navbar-brand">查询结果</a></h1>
            <ul class="navbar-list clearfix">
                <%--<li><a class="on" href="/pages/admin_student.jsp">首页</a></li>--%>
                <li><a class="on" href="/admin/listTeacherAction.action" target="_blank">课程管理</a></li>
                <%--<li><a href="/pages/teacher_add_student.jsp" target="_blank">学生管理</a></li>--%>

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
                        <li><a href="/teacher/showCourseAction.action"><i class="icon-font">&#xe005;</i>课程信息</a></li>
                        <li><a href="/teacher/updateCoursePageAction.action"><i class="icon-font">&#xe005;</i>修改信息</a></li>
                        <li><a href="/teacher/addStudentPageAction.action"><i class="icon-font">&#xe005;</i>添加学生</a></li>
                        <li><a href="/teacher/showHomeworkAction.action"><i class="icon-font">&#xe005;</i>作业管理</a></li>

                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/teacher/listCourseAction.action">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/teacher/showCourseAction.action">课程管理</a><span class="crumb-step">&gt;</span><span>修改课程</span></div>
        </div>

        <!--add  form-->
        <div class="result-wrap">
            <div class="result-content">
                <h1>修改课程信息</h1>
                <s:form  id="searchForm" action="updateHomeworkAction" >
                    <%--<form  id="add-book"  enctype="multipart/form-data">--%>
                    <input type="hidden" value="add" name="type">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th>作业ID:</th>
                            <td>
                                <input class="common-text" id="homeworkId" name="homeworkId" size="50" value="${homework.getHomeworkId()}" disabled type="text">
                            </td>
                        </tr>
                        <tr>
                            <th >发布日期：</th>
                            <td>
                                <input class="date" id="releaseTime" name="releaseTime" min="1900-01-01" size="50" value="${homework.getReleaseTime().toString().split(" ")[0]}" disabled type="text">
                            </td>
                        </tr>
                        <tr>
                            <th >截止日期：</th>
                            <td>
                                <input class="date" id="deadline" name="deadline" min="1900-01-01" size="50" value="${homework.getDeadline().toString().split(" ")[0]}" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th>所占百分比：</th>
                            <td>
                                <input class="common-text" id="percentage" name="percentage" size="50" min="0" max="100" value="${homework.getPercentage()}" type="number">
                            </td>
                        </tr>
                        <tr>
                            <th>内容：</th>
                            <td>
                                <textarea name="content" class="common-textarea" id="content"   cols="30" style="width: 98%;" rows="10">${homework.getContent()}</textarea>
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