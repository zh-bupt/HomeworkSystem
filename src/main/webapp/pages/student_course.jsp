<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/20
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

<html>

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
            <div class="crumb-list"><i class="icon-font"></i><a href="main.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">课程管理</span><span class="crumb-step">&gt;</span><span class="crumb-name">课程详情</span></div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                <%--<h2>搜索课程</h2>--%>
                <%--<s:form action="Action" id="searchForm">--%>
                    <table  class="result-tab" width="50%" style="margin: 20px">
                        <s:if test="group != null">
                            <h2>您所在的小组</h2>
                            <%--<s:if test="true" >--%>
                            <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
                            <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?${studentId}'"/>--%>
                            <%--<table border="1px" cellpadding="8px" class="search-tab">--%>
                                <tr>
                                    <th>组号</th>
                                    <th>组名</th>
                                    <th>组长</th>
                                    <th>人数</th>
                                    <th>成员</th>
                                    <th>小组成绩</th>
                                </tr>
                                <tr>
                                    <td><s:property value="group.getGroupId()"/> </td>
                                    <td><s:property value="group.getName()"/> </td>
                                    <td><s:property value="group.getLeader().getStudentName()"/> </td>
                                    <td><s:property value="group.getNum()"/> </td>
                                    <td>
                                        <s:iterator value="memberList" >
                                            <s:property value="studentName"/>
                                        </s:iterator>
                                    </td>
                                    <td><s:property value="group.getGroupScore()" /></td>

                                </tr>
                            <%--</table>--%>
                        </s:if>
                        <s:else>
                            <h2>创建小组</h2>
                            <s:form action="addGroupAction">
                                <s:textfield name="groupId" label="组号" value=""/>
                                <s:textfield name="name" label="组名" value=""/>
                                <s:textfield name="studentIds" label="学号(多个用','隔开)" value=""/>
                                <s:token/>
                                <s:submit/>
                            </s:form>
                        </s:else>

                        <%--<tr>--%>
                            <%--<th width="70">课程ID:</th>--%>
                            <%--<td><input class="common-text" placeholder="" name="courseId"  id="courseId"  type="text" style="width:150px"></td>--%>

                            <%--<td style="padding-left:50px"><button class="btn btn-primary btn2" type="submit" >查询</button></td>--%>
                        <%--</tr>--%>
                    </table>
                <%--</s:form>--%>
                <%--</form>--%>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a><i class="icon-font"></i>该课程的所有作业</a>
                    </div>
                </div>
                <div class="result-content">
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
                                <th>提交作业</th>
                            </tr>
                            <s:iterator value="homeworkList" >
                                <tr>
                                    <td><input type="checkbox" value="homeworkId" name="homeworkId"></td>
                                    <td><s:property value="homeworkId"/> </td>
                                    <td><s:property value="content"/> </td>
                                    <td><s:date name="releaseTime" format="yyyy-MM-dd"/> </td>
                                    <td><s:date name="deadline" format="yyyy-MM-dd"/> </td>
                                    <td><input class="link-update btn btn-warning btn2"  type="button" name="delete" value="提交" onclick="javascript:window.location.href='setCurrentHomeworkAction.action?homeworkId=${homeworkId}'"/></td>
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