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
                <td><s:date name="createTime" format="yyyy-MM-dd"/> </td>
                <td><input type="button" name="update" value="课程详情" onclick="javascript:window.location.href='/student/setCurrentCourseAction.action?courseId=${courseId}'"/> </td>
            </tr>
        </s:iterator>
    </table>
</s:if>
<h2>您管理的所有小组</h2>
<s:if test="groupManagedList.size() > 0">
    <table border="1px" cellpadding="8px">
        <tr>
            <th>课程名</th>
            <th>小组号</th>
            <th>小组名</th>
            <th>人数</th>
            <th>小组成员</th>
            <th>打分</th>
        </tr>
        <s:iterator value="groupManagedList" status="userStatus">
            <%--点击某一个组进入打分窗口--%>
            <tr>
                <td><s:property value="course.getCourseName()"/> </td>
                <td><s:property value="groupId"/> </td>
                <td><s:property value="name"/> </td>
                <td><s:property value="num"/> </td>
                <td> <s:iterator value="groupStudentSet">
                        <s:property value="student.getStudentName()"/>
                    </s:iterator>
                </td>
                <td><input type="button" name="update" value="打分" onclick="javascript:window.location.href='/student/getContributionPageAction?groupId=${groupId}'"/> </td>
                <%--d使用JS弹出文本框，输入分配后传给action--%>
            </tr>
        </s:iterator>
    </table>
</s:if>
<br/>
<br/>
</body>
</html>
