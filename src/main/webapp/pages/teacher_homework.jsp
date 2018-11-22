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
</head>
<body>
<h1>小组提交作业</h1>
<s:if test="homeworkGroupList.size() > 0">
    <%--<s:if test="true" >--%>
    <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
    <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?${studentId}'"/>--%>
    <table border="1px" cellpadding="8px">
        <tr>
            <th>选中</th>
            <th>小组编号</th>
            <th>作业编号</th>
            <th>提交时间</th>
            <th>分数</th>
            <th>评语</th>
            <th>下载</th>

        </tr>
        <s:iterator value="homeworkGroupList" >
            <tr>
                <td><input type="checkbox" value="fileDir" name="fileDir"></td>
                <td><s:property value="groupId"/> </td>
                <td><s:property value="homeworkId"/> </td>
                <td><s:property value="submissionTime"/> </td>
                <td><s:property value="score"/> </td>
                <td><s:property value="comment"/> </td>
                <%--<td><input type="button" name="update" value="查看提交" onclick="javascript:window.location.href='/teacher/listHomeworkGroupAction.action?homeworkId=${homeworkId}'"/></td>--%>
                <%--<td><input type="button" name="download" value="下载" onclick="javascript:window.location.href='/teacher/downloadHomeworkAction.action?fileDir=${fileDir}'"/></td>--%>
                <td><a href="/teacher/downloadHomeworkAction.action?fileDir=${fileDir}">下载</a></td>
            </tr>
        </s:iterator>
    </table>
</s:if>
</body>
</html>
