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
<h2>您的所有课程</h2>
<s:if test="courseList.size() > 0">
    <table border="1px" cellpadding="8px">
        <tr>
            <th>课程编号</th>
            <th>课程名</th>
            <th>人数上限</th>
            <th>创建时间</th>
        </tr>
        <s:iterator value="courseList" status="userStatus">
            <%--点击某一个课程即进入到该课程的详情页--%>
            <tr>
                <td><s:property value="courseId"/> </td>
                <td><s:property value="courseName"/> </td>
                <td><s:property value="capacity"/> </td>
                <td><s:property value="createTime"/> </td>
                <td><input type="button" name="update" value="课程详情" onclick="javascript:window.location.href='/student/setCurrentCourseAction.action?courseId=${courseId}'"/> </td>
            </tr>
        </s:iterator>
    </table>
</s:if>

<br/>
<br/>
</body>
</html>
