<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/11
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>教师登陆演示</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/教师登陆演示/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/教师登陆演示/data.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
</head>
<body>
<div id="base" class="">

    <!-- Unnamed (矩形) -->
    <div id="u209" class="ax_default box_3">
        <img id="u209_img" class="img " src="images/教师登陆演示/u209.png"/>
    </div>

    <!-- Unnamed (矩形) -->
    <div id="u210" class="ax_default box_1">
        <img id="u210_img" class="img " src="images/教师登陆演示/u210.png"/>
        <div id="u210_text" class="text ">
            <p><span>北京邮电大学软件工程作业管理系统</span></p>
        </div>
    </div>

    <!-- Unnamed (矩形) -->
    <div id="u211" class="ax_default box_1">
        <img id="u211_img" class="img " src="images/教师登陆演示/u211.png"/>
        <div id="u211_text" class="text ">
            <p><span>未登录</span></p>
        </div>
    </div>

    <!-- Unnamed (矩形) -->
    <%--<div id="u212" class="ax_default box_1">--%>
        <%--<img id="u212_img" class="img " src="images/教师登陆演示/u212.png"/>--%>
        <%--<div id="u212_text" class="text ">--%>
            <%----%>
        <%--</div>--%>
    <%--</div>--%>
    <s:form action="loginAction">

    <!-- Unnamed (矩形) -->
    <div id="u213" class="ax_default label">
        <img id="u213_img" class="img " src="images/教师登陆演示/u213.png"/>
        <div id="u213_text" class="text ">
        <p><span>用户账号</span></p>
        </div>
    </div><s:textfield id="u212" name="id" value=""/>
    <!-- Unnamed (矩形) -->
    <div id="u214" class="ax_default label">
        <img id="u214_img" class="img " src="images/教师登陆演示/u213.png"/>
        <div id="u214_text" class="text ">
            <p><span>账号密码</span></p>
        </div>
    </div>

    <%--<!-- Unnamed (矩形) -->--%>
    <%--<div id="u215" class="ax_default box_1">--%>
        <%--<img id="u215_img" class="img " src="images/教师登陆演示/u212.png"/>--%>
        <%--<div id="u215_text" class="text ">--%>
            <%----%>
        <%--</div>--%>
    <%--</div>--%>
        <s:password id="u215" name="password"  value=""/>
        <s:radio  name="role" list="{ '管理员', '教师','学生' }" value="'学生'"  label="用户身份" />
        <%--<s:if test="role==null" >--%>
            <%--<s:radio id="u216" name="role" list="{ '管理员', '教师','学生' }" value="'学生'"  label="用户身份"/>--%>
        <%--</s:if>--%>
        <%--<s:else>--%>
            <%--<s:radio id="u218" name="role" list="{ '管理员', '教师','学生' }"  label="用户身份"/>--%>
        <%--</s:else>--%>
    <%--<!-- Unnamed (矩形) -->--%>
    <%--<div id="u215" class="ax_default label">--%>
        <%--<img id="u216_img" class="img " src="images/教师登陆演示/u216.png"/>--%>
        <%--<div id="u216_text" class="text ">--%>
            <%----%>
        <%--</div>--%>
    <%--</div>--%>

    <!-- Unnamed (矩形) -->

    <%--<s:form action="loginAction">--%>
        <%--<s:actionerror/>--%>
        <%--<s:textfield name="id" label="ID" value=""/>--%>
        <%--<s:password name="password" label="密码" value=""/>--%>
        <%--<s:if test="role==null">--%>
            <%--<s:radio name="role" list="{ '管理员', '教师','学生' }" value="'学生'"  label="用户身份"/>--%>
        <%--</s:if>--%>
        <%--<s:else>--%>
            <%--<s:radio name="role" list="{ '管理员', '教师','学生' }"  label="用户身份"/>--%>
        <%--</s:else>--%>

        <%--<div id="u217" class="ax_default button" selectiongroup="page1">--%>
            <%--<img id="u217_img" class="img " src="images/教师登陆演示/u217.png"/>--%>
            <%--<div id="u217_text" class="text ">--%>
                <%----%>
            <%--</div>--%>
        <%--</div>--%>
        <s:submit id="u217" value="登录"/>
    </s:form>
</div>
</body>
</html>

</body>
</html>
