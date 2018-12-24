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
                <h2>作业详情</h2>
                <table class="search-tab">
                    <tr>
                        <th width="70">作业ID:</th>
                        <td><s:property value="homework.getHomeworkId()"/>
                            <%--<input class="common-text" placeholder="" name="courseId"  id="courseId"  type="text" style="width:150px">--%>
                        </td>
                        <th width="70">发布时间:</th>
                        <td><s:date name="homework.getReleaseTime()" format="yyyy-MM-dd"/>
                            <%--<input class="common-text" placeholder="" name="courseName"  id="courseName"  type="text" style="width:150px">--%>
                        </td>
                        <th width="70">截至时间:</th>
                        <td><s:date name="homework.getDeadline()" format="yyyy-MM-dd"/>
                            <%--<input class="common-text" placeholder="" name="courseName"  id="courseName"  type="text" style="width:150px">--%>
                        </td>
                        <th width="100">所占百分比:</th>
                        <td><s:property value="homework.getPercentage()"/>%
                            <%--<input class="common-text" placeholder="" name="courseName"  id="courseName"  type="text" style="width:150px">--%>
                        </td>
                        <th width="70">内容:</th>
                        <td><s:property value="homework.getContent()"/>
                            <%--<input class="common-text" placeholder="" name="courseName"  id="courseName"  type="text" style="width:150px">--%>
                        </td>

                    </tr>
                </table>
            </div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <s:form id="searchForm" action="searchHomeworkGroupAction">
                <table class="search-tab">
                    <tr>
                        <th width="210">查询组号:</th>
                        <%--<td>--%>
                            <%--<li>--%>
                                <%--<input type="radio" name="searchType" class="radio-inline" style="margin: 10px;color: #1A1A1A" value="按组号" checked>按组号--%>
                                <%--<input type="radio" name="searchType" class="radio-inline" style="margin: 10px;color: #1A1A1A" value="按时间">按时间--%>
                            <%--</li>--%>
                        <%--</td>--%>
                        <%--<s:actionerror/>--%>
                        <%--<s:textfield name="searchTeacherWord" label="查询" value=""/>--%>
                        <%--<s:if test="searchWay==null">--%>
                        <%--<s:radio name="searchWay" list="{ '班级','学号', '姓名' }" value="'学号'"  label="搜索方式"/>--%>
                        <%--</s:if>--%>
                        <%--<s:else>--%>
                        <%--<s:radio name="searchWay" list="{ '班级', '学号', '姓名' }"  label="搜索方式"/>--%>
                        <%--</s:else>--%>
                        <%--<s:submit/>--%>

                        <td><input class="common-text" placeholder="" name="searchHomeworkGroupWord"  id="readername"  type="text" style="width:150px"></td>
                        <th width="210">查询开始时间:</th>
                        <td><input class="common-text" placeholder="" name="searchHomeworkGroupStartTime"    type="date" style="width:150px"></td>
                        <th width="210">查询截止时间:</th>
                        <td><input class="common-text" placeholder="" name="searchHomeworkGroupEndTime"    type="date" style="width:150px"></td>
                        <td style="padding-left:50px"><button class="btn btn-primary btn2" type="submit" >确定</button></td>
                    </tr>
                </table>
                </s:form>
            </div>
        </div>


        <div class="result-wrap">
            <%--<form name="myform" id="myform" method="post">--%>
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
                                <th>小组名称</th>
                                <th>提交时间</th>
                                <th>分数</th>
                                <th>评语</th>
                                <th>下载</th>
                                <th>批阅</th>
                            </tr>
                            <s:iterator value="homeworkGroupList" status="status" >
                                <tr>
                                    <td><input type="checkbox" value="fileDir" name="fileDir"></td>
                                    <td><s:property value="%{groupList[#status.index].groupId}"/> </td>
                                    <td><s:property value="%{groupList[#status.index].name}"/> </td>
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
            <%--</form>--%>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>