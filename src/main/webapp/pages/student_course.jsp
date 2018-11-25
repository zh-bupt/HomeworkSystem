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
            <th>提交作业</th>
        </tr>
        <s:iterator value="homeworkList" >
            <tr>
                <td><input type="checkbox" value="homeworkId" name="homeworkId"></td>
                <td><s:property value="homeworkId"/> </td>
                <td><s:property value="content"/> </td>
                <td><s:property value="releaseTime"/> </td>
                <td><s:property value="deadline"/> </td>

                <td><input type="button" name="delete" value="提交" onclick="javascript:window.location.href='setCurrentHomeworkAction.action?homeworkId=${homeworkId}'"/></td>
                <%--<td><s:form action="submitHomeworkAction" method="post" enctype="multipart/form-data">--%>
                        <%--<s:file name="groupHomework" label="" />--%>
                        <%--<s:submit value="提交" />--%>
                    <%--</s:form>--%>
                <%--</td>--%>

            </tr>
        </s:iterator>
    </table>
</s:if>

<s:if test="groupMembers.size() > 0">
    <h2>您所在的小组</h2>
    <%--<s:if test="true" >--%>
    <%--<button onclick="/deleteTeacherAction.action?${teacherId}">删除</button>--%>
    <%--<input type="button" name="search" value="删除" onclick="javascript:window.location.href='deleteStudentAction.action?${studentId}'"/>--%>
    <table border="1px" cellpadding="8px">
        <tr>
            <th>组号</th>
            <th>组名</th>
            <th>组长</th>
            <th>人数</th>
            <th>成员</th>
            <th>小组成绩</th>
        </tr>
        <tr>
            <td><s:property value="groupId"/> </td>
            <td><s:property value="name"/> </td>
            <td><s:property value="leader.getStudentName()"/> </td>
            <td><s:property value="num"/> </td>
            <td>
                <s:iterator value="members" >
                    <s:property value="memberName"/>
                </s:iterator>
            </td>
            <td><s:property value="groupScore" /></td>

        </tr>
    </table>
</s:if>
<s:else>
    <h2>创建小组</h2>
    <s:form action="addGroupAction">
        <s:textfield name="groupId" label="组号" value=""/>
        <s:textfield name="name" label="组名" value=""/>
        <s:textfield name="studentIds" label="学号(多个用','隔开)" value=""/>
        <s:token/>
        <s:submit/>
    </s:form>
</s:else>
</body>
</html>
