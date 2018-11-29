<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/28
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            </div>
        </div>
        <div class="result-wrap">
            <%--<form name="myform" id="myform" method="post">--%>
            <div class="result-title">
                <div class="result-list">
                    <a ><i class="icon-font"></i>组员打分</a>
                </div>
            </div>
            <div class="result-content">
                <%--<s:form  id="searchForm" action="checkHomeworkAction" >--%>
                    <%--<form  id="add-book"  enctype="multipart/form-data">--%>
                    <input type="hidden" value="add" name="type">
                    <table class="result-tab" width="50%">
                        <%--<tbody>--%>
                            <tr id="col-title">
                                <th>学号</th>
                                <th>姓名</th>
                                <th>分数</th>
                                <th>确定</th>
                            </tr>
                            <s:iterator value="memberList">

                                    <tr>
                                        <%--<s:form action="setContributionAction">--%>
                                        <td>
                                            <s:property value="studentId"/>
                                            <input class="common-text" disabled="true"  name="studentId"  value="${studentId}" type="hidden" >
                                        </td>
                                        <td>
                                            <s:property value="studentName"/>
                                        </td>
                                        <td>
                                            <input class="common-text" id="contribution" name="contribution" size="50" min="0" max="100" value="" type="number">
                                        </td>
                                        <%--<td><input class="link-update btn btn-warning btn2" type="button" name="update" value="确定" onclick="set_contribution(${studentId})"/></td>--%>
                                            <td><input class="link-update btn btn-warning btn2" type="button" name="update" value="确定" onclick="window.location.href='/student/setContributionAction?studentId=${studentId}&contribution='+document.getElementById('contribution').value"/></td>
                                        <%--</s:form>--%>
                                    </tr>
                            </s:iterator>
                        <%--</tbody>--%>
                    </table>
                    <%--</form>--%>
                    <%--<s:token/>--%>
                <%--</s:form>--%>
            </div>
            <%--</form>--%>
        </div>

    </div>
    <!--/main-->
</div>
</body>

