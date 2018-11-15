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

<h3>上传该课程学生名单文件</h3>
<s:form action="addStudentForCourseByFileAction" method="post" enctype="multipart/form-data">
    <s:file name="studentExcel" label="选择上传的文件" />
    <s:submit value="上传" />
</s:form>

</body>
</html>
