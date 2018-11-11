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
</head>
<body>
<h1>Student</h1>
<h2>Add Student</h2>
<s:form action="addStudentAction">
    <s:textfield name="studentId" label="学号" value=""/>
    <s:textfield name="studentName" label="姓名" value=""/>
    <s:textfield name="classId" label="班级" value=""/>
    <s:textfield name="sex" label="性别" value=""/>
    <s:textfield name="email" label="邮箱" value=""/>
    <s:password name="password" label="密码" value=""/>
    <s:datetextfield name="entranceDate" format="YYYY-MM-DD"/>
    <s:submit/>
</s:form>

<h2>All Students</h2>

<s:if test="teacherList.size() > 0">
    <table border="1px" cellpadding="8px">
        <tr>
            <th>Customer Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Create Date</th>
        </tr>
        <s:iterator value="teacherList" status="userStatus">
            <tr>
                <td><s:property value="customerId"/> </td>
                <td><s:property value="name"/> </td>
                <td><s:property value="address"/> </td>
                <td><s:date name="createdDate" format="dd/MM/yyyy"/> </td>
            </tr>
        </s:iterator>
    </table>
</s:if>

<br/>
<br/>
</body>
</html>
