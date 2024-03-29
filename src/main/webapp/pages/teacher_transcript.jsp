<%@ page import="org.apache.poi.ss.formula.functions.T" %>
<%@ page import="com.bupt.se.homework.action.TeacherAction" %>
<%@ page import="javax.persistence.criteria.CriteriaBuilder" %><%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/15
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
    <title>课程管理</title>
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
            <div class="crumb-list"><i class="icon-font"></i><a>首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">课程管理</span></div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                <%--<h2>添加课程</h2>--%>
                <%--<s:form action="addCourseAction" id="searchForm">--%>
                <%--<table class="search-tab">--%>
                <%--<tr>--%>
                <%--<th width="70">课程ID:</th>--%>
                <%--<td><input class="common-text" placeholder="" name="courseId"  id="courseId"  type="text" style="width:150px"></td>--%>
                <%--<th width="70">课程名称:</th>--%>
                <%--<td><input class="common-text" placeholder="" name="courseName"  id="courseName"  type="text" style="width:150px"></td>--%>
                <%--<td style="padding-left:50px"><button class="btn btn-primary btn2" type="submit" >添加</button></td>--%>
                <%--</tr>--%>
                <%--</table>--%>
                <%--</s:form>--%>
                <%--</form>--%>
                    <td style="padding-left:50px"><button class="btn btn-primary btn2" type="button" onclick="javascript:window.location.href='/teacher/exportTranscriptAction.action'">下载成绩单</button></td>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a><i class="icon-font"></i>该课程的学生成绩</a>
                    </div>
                </div>
                <div class="result-content">
                    <s:if test="transcript.size() > 0">
                        <%--<s:if test="true" >--%>
                        <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
                        <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?${studentId}'"/>--%>
                        <table border="1px" cellpadding="8px" class="result-tab" width="100%">
                            <tr id="col-title">
                                <%--<th>选中</th>--%>
                                <th>班级</th>
                                <th>学号</th>
                                <th>姓名</th>
                                <% for (int i=0;i< (Integer)session.getAttribute("homeworkNum")-1;i++){%>
                                    <%--<c:forEach var = "i" begin = "1" end='<%(Integer)session.getAttribute("homeworkNum")%>' step="1">--%>
                                        <th>作业 <%=i+1%> 成绩</th>
                                    <%--</c:forEach>--%>

                                <%}%>
                                <th>总成绩</th>
                            </tr>
                            <s:iterator value="transcript">
                                <tr>
                                    <%--<td><input type="checkbox" value="studentId" name="studentId"></td>--%>
                                    <td><s:property value="key.getClassId()"/> </td>
                                    <td><s:property value="key.getStudentId()"/> </td>
                                    <td><s:property value="key.getStudentName()"/> </td>
                                    <s:iterator value="value" status="status">
                                        <td><s:property value="value[#status.index]"/> </td>
                                    </s:iterator>
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