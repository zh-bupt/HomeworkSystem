<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/27
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
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
                <li><a class="on" href="/admin/listTeacherAction.action" target="_blank">教师管理</a></li>
                <li><a href="/pages/admin_student.jsp" target="_blank">学生管理</a></li>

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
                        <li><a><i class="icon-font">&#xe005;</i>查找教师</a></li>
                        <li><a href="/pages/admin_add_teacher.jsp"><i class="icon-font">&#xe005;</i>添加教师</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="main.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">教师管理</span></div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                    <s:form action="searchTeacherAction" id="searchForm">
                    <table class="search-tab">
                        <tr>
                            <th width="140">姓名/工号:</th>

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
                    <s:if test="teacherList.size() > 0">
                        <%--<s:if test="true" >--%>
                        <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
                        <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteTeacherAction.action?${teacherId}'"/>--%>
                        <table border="1px" cellpadding="8px" class="result-tab" width="100%">
                            <tr id="col-title">
                                <th>选中</th>
                                <th>工号</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>职称</th>
                                <th>联系电话</th>
                                <th>邮箱</th>
                                <th>操作</th>
                            </tr>
                            <s:iterator value="teacherList" >
                                <tr>
                                    <td><input type="checkbox" value="teacherId" name="teacherId"></td>
                                    <td><s:property value="teacherId"/> </td>
                                    <td><s:property value="teacherName"/> </td>
                                    <td><s:property value="sex"/> </td>
                                    <td><s:property value="profession"/> </td>
                                    <td><s:property value="telephone"/> </td>
                                    <td><s:property value="email"/> </td>
                                    <td><input  class="link-update btn btn-warning btn2"  type="button" name="update" value="修改" onclick="javascript:window.location.href='/pages/teacher.jsp?teacherId=${teacherId}'"/>
                                        <input class="link-del btn btn-danger btn2" type="button" name="delete" value="删除" onclick="delete_user(${teacherId})"/></td>
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
<script>
    function delete_user(id) {
        if(confirm("确定要删除该教师？")){
            // window.location.href = "delreader.jsp?id="+id;
            window.location.href="deleteTeacherAction.action?teacherId="+id
        }
        document.form1.action("deleteTeacherAction.action?teacherId="+id);

    }
</script>

</body>
</html>

