<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/4
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>教师系统</title>
</head>
<body>
<h1>Struts2+Spring+Hibernate integration example</h1>
<h2>Add Customer</h2>
<s:form action="addCourseAction">
    <s:textfield name="courseId" label="课程ID" value=""/>
    <s:textfield name="courseName" label="课程名称" value=""/>
    <s:textfield name="capacity" label="课程容量" value=""/>

    <s:submit/>
</s:form>

<h2>您的所有课程</h2>
<s:if test="courseList.size() > 0">
    <table border="1px" cellpadding="8px">
        <tr>
            <th>Customer Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Create Date</th>
        </tr>
        <s:iterator value="courseList" status="userStatus">
            <%--点击某一个课程即进入到该课程的详情页--%>
            <tr onclick="course.jsp">
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
