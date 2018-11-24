<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/15
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入struts2的标签库 -->
<%@ taglib uri="/struts-tags" prefix="s"%>

<body>
跳转错误页面。。<br>
<!-- fielderror标签输出action的fieldErrors属性保存的字段错误，fieldErrors是一个map类型的属性。 -->
<s:fielderror />
<!-- 生产一个查看debug信息的链接 -->
<%--<s:debug />--%>
</body>
