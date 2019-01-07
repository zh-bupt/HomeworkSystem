<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/8
  Time: 14:50
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
            <div class="crumb-list"><i class="icon-font"></i><a>首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">课程管理</span></div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                <h2>搜索课程</h2>
                <s:form action="searchCourseAction" id="searchForm">
                    <table class="search-tab">
                        <tr>
                            <th width="210">课程ID/课程名称:</th>
                            <td><input class="common-text" placeholder="" name="searchCourseWord"  id="searchCourseWord"  type="text" style="width:150px"></td>
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
                        <a><i class="icon-font"></i>您的所有课程</a>
                    </div>
                </div>
                <div class="result-content">
                    <s:if test="courseList.size() > 0">
                        <table border="1px" cellpadding="8px" class="result-tab" width="100%">
                            <tr id="col-title">
                                <th>课程编号</th>
                                <th>课程名</th>
                                <th>授课老师</th>
                                <th>创建时间</th>
                                <th>课程分数</th>
                                <th>操作</th>
                            </tr>
                            <s:iterator value="courseList" status="status">
                                <%--点击某一个课程即进入到该课程的详情页--%>
                                <tr>
                                    <td><s:property value="courseId"/> </td>
                                    <td><s:property value="courseName"/> </td>
                                    <td><s:property value="teacher.getTeacherName()"/> </td>
                                    <td><s:date name="createTime" format="yyyy-MM-dd"/> </td>
                                    <td><s:property value="%{courseScoreList[#status.index]}"/></td>
                                    <td><input  class="link-update btn btn-success btn2" type="button" name="update" value="课程详情" onclick="javascript:window.location.href='/student/setCurrentCourseAction.action?courseId=${courseId}'"/> </td>
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