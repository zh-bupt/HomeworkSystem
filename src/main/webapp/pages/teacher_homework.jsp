<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/22
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>小组提交作业</title>
</head>
<body>
<h1>小组提交作业</h1>

</body>
</html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理系统</title>
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
                <%--<li><a href="/pages/admin_student.jsp" target="_blank">学生管理</a></li>--%>

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
            <div class="crumb-list"><i class="icon-font"></i><a href="main.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">课程管理</span></div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                <s:form action="searchTeacherAction" id="searchForm">
                    <table class="search-tab">
                        <tr>
                            <th width="140">姓名/工号:</th>
<%--TODO 修改这里为显示作业的内容--%>
                            <td><input class="common-text" placeholder="" name="searchTeacherWord"  id="readername"  type="text" style="width:150px"></td>
                            <td style="padding-left:50px"><button class="btn btn-primary btn2" type="submit" >查询</button></td>
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
                    </div>
                </div>
                <div class="result-content">
                    <s:if test="homeworkGroupList.size() > 0">
                        <%--<s:if test="true" >--%>
                        <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
                        <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?${studentId}'"/>--%>
                        <table border="1px" cellpadding="8px" class="result-tab" width="100%">
                            <tr id="col-title">
                                <th>选中</th>
                                <th>小组编号</th>
                                <th>作业编号</th>
                                <th>提交时间</th>
                                <th>分数</th>
                                <th>评语</th>
                                <th>下载</th>
                                <th>批阅</th>
                            </tr>
                            <s:iterator value="homeworkGroupList" >
                                <tr>
                                    <td><input type="checkbox" value="fileDir" name="fileDir"></td>
                                    <td><s:property value="group_.getGroupId()"/> </td>
                                    <td><s:property value="homeworkId"/> </td>
                                    <td><s:date name="submissionTime" format="yyyy-MM-dd"/> </td>
                                    <td><s:property value="score"/> </td>
                                    <td><s:property value="comment"/> </td>
                                        <%--<td><input type="button" name="update" value="查看提交" onclick="javascript:window.location.href='/teacher/listHomeworkGroupAction.action?homeworkId=${homeworkId}'"/></td>--%>

                                    <td><input   class="link-update btn btn-success btn2"  type="button" name="download" value="下载" onclick="javascript:window.location.href='/teacher/downloadHomeworkAction.action?homeworkId=${homeworkId}&groupId=${group_.getGroupId()}&homeworkFileName=${fileDir}'"/></td>
                                    <td><input   class="link-update btn btn-warning btn2"  type="button" name="update" value="批阅" onclick="javascript:window.location.href='/teacher/checkHomeworkPageAction.action?homeworkId=${homeworkId}&groupId=${group_.getGroupId()}'"/></td>

                                <%--<td><a href="/teacher/downloadHomeworkAction.action?fileDir=${fileDir}">下载</a></td>--%>
                                </tr>
                            </s:iterator>
                        </table>
                    </s:if>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>