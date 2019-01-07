<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/27
  Time: 22:47
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
                <li><a class="on" href="/teacher/listCourseAction.action" target="_blank">课程管理</a></li>

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
            <div class="crumb-list"><i class="icon-font"></i><a >首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">学生管理</span></div>
        </div>
        <div class="result-wrap">
            <%--<form name="myform" id="myform" method="post">--%>
                <div class="result-title">
                    <div class="result-list">
                        <a ><i class="icon-font"></i>发布作业</a>
                    </div>
                </div>
                <div class="result-content">
                    <s:form  id="searchForm" action="addHomeworkAction" >
                        <%--<form  id="add-book"  enctype="multipart/form-data">--%>
                        <%--<input type="hidden" value="add" name="type">--%>
                        <table class="insert-tab" width="100%">
                            <tbody>
                            <tr>
                                <th>截止日期:</th>
                                <td>
                                    <input class="common-text" id="deadline" name="deadline" size="50" value="" type="date">
                                </td>
                            </tr>
                            <tr>
                                <th >所占百分比：</th>
                                <td>
                                    <input class="common-text" id="percentage" name="percentage" size="50" min="0" max="100" value="" type="number">
                                </td>
                            </tr>

                            <tr>
                                <th>内容：</th>
                                <td>
                                    <textarea name="content" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10"></textarea>
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
                    <div class="result-title">
                        <div class="result-list">
                            <a ><i class="icon-font"></i>作业列表</a>
                        </div>
                    </div>
                    <s:if test="homeworkList.size() > 0">
                        <%--<s:if test="true" >--%>
                        <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
                        <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?${studentId}'"/>--%>
                        <table border="1px" cellpadding="8px" class="result-tab" width="100%">
                            <tr id="col-title">
                                <th>选中</th>
                                <th>编号</th>
                                <th>内容</th>
                                <th>发布时间</th>
                                <th>截止时间</th>
                                <th>所占比例 %</th>
                                <th>操作</th>
                            </tr>
                            <s:iterator value="homeworkList" >
                                <tr>
                                    <td><input type="checkbox" value="homeworkId" name="homeworkId"></td>
                                    <td><s:property value="homeworkId"/> </td>
                                    <td><s:property value="content"/> </td>
                                    <td><s:date  name="releaseTime"  format="yyyy-MM-dd"/> </td>
                                    <td><s:date  name="deadline"  format="yyyy-MM-dd"/></td>
                                    <td><s:property value="percentage"/> </td>
                                    <td><input  class="link-update btn btn-success btn2"  type="button" name="update" value="查看提交" onclick="javascript:window.location.href='/teacher/setCurrentHomeworkAction.action?homeworkId=${homeworkId}'"/>
                                        <input  class="link-update btn btn-warning btn2"  type="button" name="update" value="修改" onclick="javascript:window.location.href='/teacher/updateHomeworkPageAction.action?homeworkId=${homeworkId}'"/>
                                        <input  class="link-del btn btn-danger btn2"  type="button" name="delete" value="删除" onclick="javascript:window.location.href='/teacher/deleteHomeworkAction.action?homeworkId=${homeworkId}'"/></td>
                                </tr>
                            </s:iterator>
                        </table>
                    </s:if>
                </div>
            <%--</form>--%>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>

