<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/28
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>


<head>
    <title>学生系统</title>
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
                <li><a class="on" href="/student/listCourseAction.action" target="_blank">课程管理</a></li>
                <%--<li><a href="/student/" target="_blank">学生管理</a></li>--%>

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
                        <li><a href="/student/listCourseAction.action"><i class="icon-font">&#xe005;</i>您的课程</a></li>
                        <li><a href="/student/listGroupAction.action"><i class="icon-font">&#xe005;</i>您的小组</a></li>

                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a>首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">小组管理</span></div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                <%--<h2>搜索课程</h2>--%>
                <%--<s:form action="addCourseAction" id="searchForm">--%>
                    <%--<table class="search-tab">--%>
                        <%--<tr>--%>
                            <%--<th width="70">课程ID:</th>--%>
                            <%--<td><input class="common-text" placeholder="" name="courseId"  id="courseId"  type="text" style="width:150px"></td>--%>
                            <%--<td style="padding-left:50px"><button class="btn btn-primary btn2" type="submit" >查询</button></td>--%>
                        <%--</tr>--%>
                    <%--</table>--%>
                <%--</s:form>--%>
                <%--</form>--%>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a><i class="icon-font"></i>您管理的小组</a>
                    </div>
                </div>
                <div class="result-content">
                    <s:if test="groupManagedList.size() > 0">
                        <table border="1px" cellpadding="8px" class="result-tab" width="100%">
                            <tr id="col-title">
                                <th>课程名</th>
                                <th>小组号</th>
                                <th>小组名</th>
                                <th>人数</th>
                                <th>小组成员</th>
                                <th>打分</th>
                            </tr>
                            <s:iterator value="groupManagedList" status="userStatus">
                                <%--点击某一个组进入打分窗口--%>
                                <tr>
                                    <td><s:property value="course.getCourseId()"/> </td>
                                    <td><s:property value="groupId"/> </td>
                                    <td><s:property value="name"/> </td>
                                    <td><s:property value="num"/> </td>
                                    <td> <s:iterator value="groupStudentList">
                                        <s:property value="student.getStudentName()"/>
                                    </s:iterator>
                                    </td>
                                    <td><input  class="link-update btn btn-warning btn2" type="button" name="update" value="打分" onclick="javascript:window.location.href='/student/setCurrentGroupAction?groupId=${groupId}'"/> </td>
                                        <%--d使用JS弹出文本框，输入分配后传给action--%>
                                </tr>
                            </s:iterator>
                        </table>
                    </s:if>
                </div>
            </form>
        </div>
        <div class="result-wrap">
            <form name="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a><i class="icon-font"></i>您所在的小组</a>
                    </div>
                </div>
                <div class="result-content">
                    <s:if test="groupList.size() > 0">
                        <table border="1px" cellpadding="8px" class="result-tab" width="100%">
                            <tr id="col-title">
                                <th>课程名</th>
                                <th>小组号</th>
                                <th>小组名</th>
                                <th>人数</th>
                                <th>小组成员</th>
                                <th>组长</th>
                            </tr>
                            <s:iterator value="groupList" status="userStatus">
                                <%--点击某一个组进入打分窗口--%>
                                <tr>
                                    <td><s:property value="course.getCourseId()"/> </td>
                                    <td><s:property value="groupId"/> </td>
                                    <td><s:property value="name"/> </td>
                                    <td><s:property value="num"/> </td>
                                    <td> <s:iterator value="groupStudentList">
                                        <s:property value="student.getStudentName()"/>
                                    </s:iterator>
                                    </td>
                                    <td><s:property value="leader.getStudentName()"/> </td>
                                        <%--d使用JS弹出文本框，输入分配后传给action--%>
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

