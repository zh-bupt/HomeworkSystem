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


<h2>教师列表</h2>
<s:if test="teacherList.size() > 0">
<%--<s:if test="true" >--%>
    <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
    <input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteTeacherAction.action?${teacherId}'"/>
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
