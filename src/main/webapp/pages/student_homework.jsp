<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/22
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body>

<h3>上传作业</h3>
<s:form action="submitHomeworkAction" method="post" enctype="multipart/form-data">
    <s:file name="groupHomework" label="选择提交的文件" />
    <s:submit value="提交" />
</s:form>
</body>
</html>
