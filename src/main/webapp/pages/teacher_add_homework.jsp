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
            <div class="crumb-list"><i class="icon-font"></i><a href="main.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">学生管理</span></div>
        </div>
        <%--<div class="search-wrap">--%>
            <!--用于查询得表单-->
            <%--<div class="search-content">--%>
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                <%--<s:form action="addStudentForCourseByTypeAction" id="searchForm">--%>
                    <%--<h3>发布作业</h3>--%>
                    <%--<table class="search-tab">--%>
                        <%--<tr>  &lt;%&ndash;<s:textfield  class="common-text" name="content" label="内容" value=""/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<s:textfield name="deadline" label="截止日期(yyyy-MM-dd)" value=""/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<s:textfield name="percentage" label="所占比例" value=""/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<s:token/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<s:textfield  name="studentId" label="学号" value="" style="width:150px"/>&ndash;%&gt;--%>
                            <%--<th width="140">内容:</th>--%>
                            <%--<td><textarea name="content" id="" cols="30" rows="10"></textarea></td>--%>
                            <%--<th width="140">截止日期:</th>--%>
                            <%--<td><input class="common-text" placeholder="" name="deadline"  id="deadline"  type="date" style="width:150px"></td>&lt;%&ndash;TODO 在页面限制输入为日期，可能出错&ndash;%&gt;--%>
                            <%--<th width="140">所占百分比:</th>--%>
                            <%--<td><input class="common-text" placeholder="" name="percentage"  id="percentage"  type="number" style="width:150px"></td>&lt;%&ndash;TODO 在页面限制输入为数字，可能出错&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<th width="140">姓名:</th>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<td><input class="common-text" placeholder="" name="studentName"  id="studentName"  type="text" style="width:150px"></td>&ndash;%&gt;--%>
                            <%--<td style="padding-left:50px">--%>
                                <%--<s:token/>--%>
                                <%--<s:submit  class="btn btn-primary btn2" value="添加"/>--%>
                                    <%--&lt;%&ndash;<button class="btn btn-primary btn2" type="submit" >添加</button>&ndash;%&gt;--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                    <%--</table>--%>
                <%--</s:form>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
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
                        <input type="hidden" value="add" name="type">
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
                        <%--<s:token/>--%>
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
                                    <td><input  class="link-update btn btn-success btn2"  type="button" name="update" value="查看提交" onclick="javascript:window.location.href='/teacher/listHomeworkGroupAction.action?homeworkId=${homeworkId}'"/>
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

