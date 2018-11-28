<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/22
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>提交作业</title>
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
                        <li><a href="/teacher/listHomeworkGroupAction.action"><i class="icon-font">&#xe005;</i>作业管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="main.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">课程管理</span><span class="crumb-step">&gt;</span><span class="crumb-name">课程详情</span><span class="crumb-step">&gt;</span><span class="crumb-name">提交作业</span></div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                <%--<s:form action="addStudentForCourseByTypeAction" id="searchForm">--%>
                    <table class="search-tab">
                        <tr>
                                <%--<th width="140">学号:</th>--%>
                            <%--<s:textfield  class="common-text" name="studentId" label="学号" value="" style="width:150px"/>--%>
                                <%--&lt;%&ndash;<td><input class="common-text" placeholder="" name="studentId"  id="studentId"  type="text" style="width:150px"></td>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<th width="140">姓名:</th>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<td><input class="common-text" placeholder="" name="studentName"  id="studentName"  type="text" style="width:150px"></td>&ndash;%&gt;--%>
                            <%--<td style="padding-left:50px">--%>
                                <%--<s:token/>--%>
                                <%--<s:submit  class="btn btn-primary btn2" value="添加"/>--%>
                                    <%--<button class="btn btn-primary btn2" type="submit" >添加</button>--%>

                            </td>
                        </tr>
                    </table>
                <%--</s:form>--%>
                <%--</form>--%>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <%--<a href="addReader.jsp"><i class="icon-font"></i>添加读者</a>--%>
                            <h3>上传作业</h3>
                            <s:form action="submitHomeworkAction" method="post" enctype="multipart/form-data">
                                <s:file name="groupHomework" label="选择提交的文件" />
                                <s:submit value="提交" />
                                <s:token/>
                            </s:form>
                    </div>
                </div>
                <div class="result-content">
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
