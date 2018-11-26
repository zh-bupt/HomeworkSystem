<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/15
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>课程管理</title>
</head>
<body>
<h2>修改课程配置</h2>
<s:form action="updateCourseAction">
    <s:textfield name="courseName" label="课程名称" value=""/>
    <s:textfield name="capacity" label="课程容量" value=""/>
    <s:textfield name="groupPrefix" label="小组前缀" value=""/>
    <s:textfield name="groupMin" label="小组人数下限" value=""/>
    <s:textfield name="groupMax" label="小组人数上限" value=""/>
    <s:submit/>
</s:form>
<h2>添加学生</h2>
<s:form action="addStudentForCourseByTypeAction">
    <s:textfield name="studentId" label="学号" value=""/>
    <s:submit/>
</s:form>
<h3>上传该课程学生名单文件</h3>
<s:form action="addStudentForCourseByFileAction" method="post" enctype="multipart/form-data">
    <s:file name="studentExcel" label="选择上传的文件" />
    <s:submit value="上传" />
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

                <td><input type="button" name="delete" value="删除" onclick="javascript:window.location.href='/teacher/deleteStudentCourseAction.action?studentId=${studentId}'"/></td>
            </tr>
        </s:iterator>
    </table>
</s:if>
<h3>发布作业</h3>
<s:form action="addHomeworkAction">
    <s:textfield name="content" label="内容" value=""/>
    <s:textfield name="deadline" label="截止日期(yyyy-MM-dd)" value=""/>
    <s:textfield name="percentage" label="所占比例" value=""/>
    <s:submit/>
</s:form>
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
            <th>所占比例 %</th>
        </tr>
        <s:iterator value="homeworkList" >
            <tr>
                <td><input type="checkbox" value="homeworkId" name="homeworkId"></td>
                <td><s:property value="homeworkId"/> </td>
                <td><s:property value="content"/> </td>
                <td><s:date  name="releaseTime"  format="yyyy-MM-dd"/> </td>
                <td><s:date  name="deadline"  format="yyyy-MM-dd"/></td>
                <td><s:property value="percentage"/> </td>
                <td><input type="button" name="update" value="查看提交" onclick="javascript:window.location.href='/teacher/listHomeworkGroupAction.action?homeworkId=${homeworkId}'"/></td>
                <td><input type="button" name="delete" value="删除" onclick="javascript:window.location.href='/teacher/deleteHomeworkAction.action?homeworkId=${homeworkId}'"/></td>
            </tr>
        </s:iterator>
    </table>
</s:if>
</body>
<input type="button" name="download" value="导出成绩单" onclick="javascript:window.location.href='/teacher/ExportExcelAction'"/>
</html>
