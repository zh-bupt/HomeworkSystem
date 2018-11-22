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
</head>
<body>
<h1>后台管理系统</h1>
<h2>添加学生</h2>
<s:form action="addStudentAction">
    <s:textfield name="studentId" label="学号" value=""/>
    <s:textfield name="studentName" label="姓名" value=""/>
    <s:textfield name="classId" label="班级" value=""/>
    <s:textfield name="sex" label="性别" value=""/>
    <s:textfield name="email" label="邮箱" value=""/>
    <s:password name="password" label="密码" value=""/>
    <s:date name="entranceDate" format="YYYY-MM-DD"/>
    <s:submit/>
</s:form>
<h3>上传学生名单文件</h3>
<s:form action="addStudentByFileAction" method="post" enctype="multipart/form-data">
    <s:file name="studentExcel" label="选择上传的文件" />
    <s:submit value="上传" />
</s:form>
<h3>查询学生</h3>
<s:form action="searchStudentAction">
    <s:actionerror/>
    <s:textfield name="searchStudentWord" label="查询" value=""/>
    <s:if test="searchWay==null">
        <s:radio name="searchWay" list="{ '班级', '姓名' }" value="'姓名'"  label="搜索方式"/>
    </s:if>
    <s:else>
        <s:radio name="searchWay" list="{ '班级', '姓名' }"  label="搜索方式"/>
    </s:else>
    <s:submit/>
</s:form>

<s:if test="studentList.size() > 0">
    <%--<s:if test="true" >--%>
    <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
    <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?${studentId}'"/>--%>
    <table border="1px" cellpadding="8px">
        <tr>
            <th>选中</th>
            <th>班级</th>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>入学时间</th>
        </tr>
        <s:iterator value="studentList" >
            <tr>
                <td><input type="checkbox" value="studentId" name="studentId"></td>
                <td><s:property value="classId"/> </td>
                <td><s:property value="studentId"/> </td>
                <td><s:property value="studentName"/> </td>
                <td><s:property value="sex"/> </td>
                <td><s:property value="email"/> </td>
                <td><s:property value="entranceDate"/> </td>
                <td><input type="button" name="update" value="修改" onclick="javascript:window.location.href='/pages/student.jsp?studentId=${studentId}'"/> </td>
                <td><input type="button" name="delete" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?studentId=${studentId}'"/></td>
            </tr>
        </s:iterator>
    </table>
</s:if>
<h2>添加教师</h2>
<s:form action="addTeacherAction">
    <s:textfield name="teacherId" label="工号" value=""/>
    <s:textfield name="teacherName" label="姓名" value=""/>
    <s:textfield name="teacherSex" label="性别" value=""/>
    <s:textfield name="profession" label="职称" value=""/>
    <s:textfield name="telephone" label="联系电话" value=""/>
    <s:textfield name="teacherEmail" label="邮箱" value=""/>
    <s:password name="teacherPassword" label="密码" value=""/>
    <s:submit/>
</s:form>
<h3>上传教师名单文件</h3>
<s:form action="addTeacherByFileAction" method="post" enctype="multipart/form-data">
    <s:file name="teacherExcel" label="选择上传的文件" />
    <s:submit value="上传" />
</s:form>

<h2>教师列表</h2>
<s:if test="teacherList.size() > 0">
<%--<s:if test="true" >--%>
    <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
    <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteTeacherAction.action?${teacherId}'"/>--%>
    <table border="1px" cellpadding="8px">
        <tr>
            <th>选中</th>
            <th>工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>职称</th>
            <th>联系电话</th>
            <th>邮箱</th>
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
                <td><input type="button" name="update" value="修改" onclick="javascript:window.location.href='/pages/teacher.jsp?teacherId=${teacherId}'"/> </td>
                <td><input type="button" name="delete" value="删除" onclick="javascript:window.location.href='deleteTeacherAction.action?teacherId=${teacherId}'"/></td>
            </tr>
        </s:iterator>
    </table>
</s:if>


</body>
</html>
