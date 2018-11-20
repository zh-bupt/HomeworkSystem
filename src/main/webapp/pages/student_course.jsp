<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/20
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>课程管理</title>
</head>
<body>
<h3>作业列表</h3>
<s:if test="homeworkList.size() > 0">
    <%--<s:if test="true" >--%>
    <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
    <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?${studentId}'"/>--%>
    <table border="1px" cellpadding="8px">
        <tr>
            <th>选中</th>
            <th>编号</th>
            <th>内容</th>
            <th>发布时间</th>
            <th>截止时间</th>
        </tr>
        <s:iterator value="homeworkList" >
            <tr>
                <td><input type="checkbox" value="homeworkId" name="homeworkId"></td>
                <td><s:property value="homeworkId"/> </td>
                <td><s:property value="content"/> </td>
                <td><s:property value="releaseTime"/> </td>
                <td><s:property value="deadline"/> </td>
                <td><input type="button" name="update" value="查看" onclick="javascript:window.location.href='deleteCourseStudentAction.action?studentId=${studentId}'"/></td>
                <td><input type="button" name="delete" value="提交" onclick="javascript:window.location.href='deleteCourseStudentAction.action?studentId=${studentId}'"/></td>
                <td<s:form action="submitHomeworkAction" method="post" enctype="multipart/form-data">
                        <s:file name="groupHomework" label="选择上传的作业" />
                        <s:submit value="上传" />
                    </s:form>>
                </td>

            </tr>
        </s:iterator>
    </table>
</s:if>
</body>
</html>
