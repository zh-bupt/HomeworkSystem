<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/11
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
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
                <%--<li><a class="on" href="admin_student.jsp">首页</a></li>--%>
                <li><a href="/admin/listTeacherAction.action" target="_blank">教师管理</a></li>
                <li><a class="on" href="/admin/listStudentAction.action" target="_blank">学生管理</a></li>


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

<%--<s:form action="addStudentAction">--%>
    <%--&lt;%&ndash;<s:actionerror/>&ndash;%&gt;--%>

    <%--<s:textfield name="studentId" label="学号" value=""/>--%>
    <%--<s:textfield name="studentName" label="姓名" value=""/>--%>
    <%--<s:textfield name="classId" label="班级" value=""/>--%>
    <%--<s:textfield name="sex" label="性别" value=""/>--%>
    <%--<s:textfield name="email" label="邮箱" value=""/>--%>
    <%--<s:password name="password" label="密码" value=""/>--%>
    <%--<s:date name="entranceDate" format="YYYY-MM-DD"/>--%>
    <%--<s:token/>--%>
    <%--<s:submit/>--%>
<%--</s:form>--%>
<%--<h3>上传学生名单文件</h3>--%>
<%--<s:form action="addStudentByFileAction" method="post" enctype="multipart/form-data">--%>
    <%--<s:file name="studentExcel" label="选择上传的文件" />--%>
    <%--<s:token/>--%>
    <%--<s:submit value="上传" />--%>
<%--</s:form>--%>
<%--<h3>查询学生</h3>--%>



<%--<h2>添加教师</h2>--%>
<%--<s:form action="addTeacherAction">--%>
    <%--<s:textfield name="teacherId" label="工号" value=""/>--%>
    <%--<s:textfield name="teacherName" label="姓名" value=""/>--%>
    <%--<s:textfield name="teacherSex" label="性别" value=""/>--%>
    <%--<s:textfield name="profession" label="职称" value=""/>--%>
    <%--<s:textfield name="telephone" label="联系电话" value=""/>--%>
    <%--<s:textfield name="teacherEmail" label="邮箱" value=""/>--%>
    <%--<s:password name="teacherPassword" label="密码" value=""/>--%>
    <%--<s:token/>--%>
    <%--<s:submit/>--%>
<%--</s:form>--%>

<%--<h3>查询教师</h3>--%>
<%--<s:form action="searchTeacherAction">--%>
    <%--&lt;%&ndash;<s:actionerror/>&ndash;%&gt;--%>
    <%--<s:textfield name="searchTeacherWord" label="查询" value=""/>--%>
    <%--<s:if test="searchWay==null">--%>
        <%--<s:radio name="searchWay" list="{ '工号', '姓名' }" value="'姓名'"  label="搜索方式"/>--%>
    <%--</s:if>--%>
    <%--<s:else>--%>
        <%--<s:radio name="searchWay" list="{ '工号', '姓名' }"  label="搜索方式"/>--%>
    <%--</s:else>--%>
    <%--<s:submit/>--%>
<%--</s:form>--%>


<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <ul class="sub-menu">
                        <li><a href="/admin/listStudentAction"><i class="icon-font">&#xe005;</i>查找学生</a></li>
                        <li><a href="/pages/admin_add_student.jsp"><i class="icon-font">&#xe005;</i>添加学生</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>首页<span class="crumb-step">&gt;</span><span class="crumb-name">学生管理</span></div>
        </div>
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <%--<form method="post" action="readerManage.jsp" id="searchForm">--%>
                    <s:form id="searchForm" action="searchStudentAction">
                    <table class="search-tab">
                        <tr>
                            <th width="210">班级/姓名/学号:</th>

                                <%--<s:actionerror/>--%>
                                <%--<s:textfield name="searchTeacherWord" label="查询" value=""/>--%>
                                <%--<s:if test="searchWay==null">--%>
                                    <%--<s:radio name="searchWay" list="{ '班级','学号', '姓名' }" value="'学号'"  label="搜索方式"/>--%>
                                <%--</s:if>--%>
                                <%--<s:else>--%>
                                    <%--<s:radio name="searchWay" list="{ '班级', '学号', '姓名' }"  label="搜索方式"/>--%>
                                <%--</s:else>--%>
                                <%--<s:submit/>--%>

                            <td><input class="common-text" placeholder="" name="searchStudentWord"  id="readername"  type="text" style="width:150px"></td>
                            <td style="padding-left:50px"><button class="btn btn-primary btn2" type="submit" >查询</button></td>
                        </tr>
                    </table>
                <%--</form>--%>
                    </s:form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a><i class="icon-font"></i>学生列表</a>
                    </div>
                </div>
                <div class="result-content">
                    <s:if test="studentList.size() > 0">
                        <%--<s:if test="true" >--%>
                        <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
                        <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?${studentId}'"/>--%>
                        <table border="1px" cellpadding="8px" class="result-tab" width="100%">
                            <tr  id="col-title">
                                <th>选中</th>
                                <th>班级</th>
                                <th>学号</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>邮箱</th>
                                <th>入学时间</th>
                                <th>操作</th>
                            </tr>
                            <s:iterator value="studentList" >
                                <tr>
                                    <td><input type="checkbox" value="studentId" name="studentId"></td>
                                    <td><s:property value="classId"/> </td>
                                    <td><s:property value="studentId"/> </td>
                                    <td><s:property value="studentName"/> </td>
                                    <td><s:property value="sex"/> </td>
                                    <td><s:property value="email"/> </td>
                                    <td><s:date name="entranceDate" format="yyyy-MM-dd"/> </td>
                                    <td><input  class="link-update btn btn-warning btn2" type="button" name="update" value="修改" onclick="javascript:window.location.href='/admin/updateStudentPageAction?studentId=${studentId}'"/>
                                        <input  class="link-del btn btn-danger btn2" type="button" name="delete" value="删除" onclick="delete_user(${studentId})"/></td>
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
<p hidden id="formerCateId">${type=="search"?formerCateId:0}</p>
<script>
    function delete_user(id) {
        if(confirm("确定要删除该学生？")){
            // window.location.href = "delreader.jsp?id="+id;
            window.location.href="deleteStudentAction.action?studentId="+id;
        }
        document.form1.action("deleteStudentAction.action?studentId="+id);
    }
</script>

</body>
</html>
