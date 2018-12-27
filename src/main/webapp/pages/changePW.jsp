<%--
  Created by IntelliJ IDEA.
  User: kwong
  Date: 2018/11/18
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>课程修改</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../assets/css/pagination.css">
    <script type="text/javascript" src="../assets/js/libs/modernizr.min.js"></script>
    <script src="../assets/js/jquery-3.2.1.js"></script>
    <script src="../assets/layer/layer.js"></script>
    <script src="../assets/js/dateFormat.js"></script>
    <style type="text/css">
        td,#col-title th{text-align: center;}
    </style>
</head>
<body>

<div class="admin_login_wrap">

    <div class="adming_login_border">
        <div class="admin_input">
            <h1>修改密码</h1>
            <%--<s:form id="form_for_comment" action="updateStudentAction" >--%>
                <%--<ul class="admin_items">--%>

                    <%--<li>--%>
                        <%--<label for="password">初始密码</label>--%>
                        <%--<input type="password" name="password" id="password" size="35" class="admin_input_style" />--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<label for="pwd1">新密码</label>--%>
                        <%--<input type="password" name="password"  id="pwd1" size="35" class="admin_input_style" />--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<label for="pwd2">重复密码</label>--%>
                        <%--<input type="password" name="rePassword" id="pwd2" size="35" class="admin_input_style"  onchange="checkpwd()"/>--%>
                        <%--<div id="msg" style="color:red;"></div>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<button tabindex="3" type="submit" class="btn btn-primary" id="btn-update">修改</button>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</s:form>--%>
            <form action="updateStudentAction" id="searchForm" name="form1">
                <%--<form  id="add-book"  enctype="multipart/form-data">--%>
                <input type="hidden" value="add" name="type">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th>学号：</th>
                        <td>
                            <input class="common-text required"  id="studentId" name="studentId" size="50" value="${student.getStudentId()}" type="text" readonly>
                        </td>
                    </tr>
                    <tr>
                        <th>姓名：</th>
                        <td>
                            <input class="common-text required" id="studentName" name="studentName" size="50" value="${student.getStudentName()}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th>班级：</th>
                        <td>
                            <input class="common-text required"  id="classId" name="classId" size="50" value="${student.getClassId()}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th>性别：</th>
                        <td>
                            <s:if test="student.getSex().equals(\"男\")">
                                <input type="radio" name="sex" class="radio-inline" style="margin: 10px" value="男" checked>男
                                <input type="radio" name="sex" class="radio-inline" style="margin: 10px" value="女">女
                            </s:if>
                            <s:else>
                                <input type="radio" name="sex" class="radio-inline" style="margin: 10px" value="男">男
                                <input type="radio" name="sex" class="radio-inline" style="margin: 10px" value="女" checked>女
                            </s:else>

                        </td>
                    </tr>
                    <tr>
                        <th>邮箱：</th>
                        <td>
                            <input class="common-text"  name="email" size="50" value="${student.getEmail()}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th>入学日期：</th>
                        <td>
                            <input type="date"  name="entranceDate" id="entranceDate" min="1900-01-01"  value="${student.getEntranceDate().toString().split(" ")[0]}" class="common-text">
                        </td>
                    </tr>
                    <tr>
                        <th>原始密码：</th>
                        <td>
                            <input class="common-text" value="${student.getPassword()}" name="oldPassword" size="50" type="password">
                        </td>
                    </tr>
                        <%--<li>--%>
                        <%--<label for="pwd1">新密码</label>--%>
                        <%--<input type="password" name="password"  id="pwd1" size="35" class="admin_input_style" />--%>
                        <%--</li>--%>
                        <%--<li>--%>
                        <%--<label for="pwd2">重复密码</label>--%>
                        <%--<input type="password" name="rePassword" id="pwd2" size="35" class="admin_input_style"  onchange="checkpwd()"/>--%>
                        <%--<div id="msg" style="color:red;"></div>--%>
                        <%--</li>--%>
                    <tr>
                        <th>新密码：</th>
                        <td>
                            <input class="common-text" value="" name="password" id="pwd1" size="50" type="password">
                        </td>
                    </tr>
                    <tr>
                        <th>重复密码：</th>
                        <td>
                            <input class="common-text" value="" name="reRassword" id="pwd2" size="50" type="password"  onchange="checkpwd()">
                            <div id="msg" style="color:red;"></div>
                        </td>

                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button class="btn btn-primary btn6 mr10" type="submit" id="btn">提交</button>
                            <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody>
                </table>
                <%--</form>--%>

            </form>

        </div>
    </div>
</div>

</body>
</html>

<script type="text/javascript">
    function checkpwd(){
        var p1=document.form1.pwd1.value;//获取密码框的值
        var p2=document.form1.pwd2.value;//获取重新输入的密码值
        if(p1==""){
            alert("请输入密码！");//检测到密码为空，提醒输入//
            document.form1.pwd1.focus();//焦点放到密码框
            // document.getElementById("btn").disabled = "true";
            return false;//退出检测函数
        }//如果允许空密码，可取消这个条件
        if(p1!=p2){//判断两次输入的值是否一致，不一致则显示错误信息
            document.getElementById("msg").innerHTML="两次输入密码不一致，请重新输入";//在div显示错误信息
            // document.getElementById("btn").disabled = "true";
            return false;
        }else{
         //密码一致，可以继续下一步操作
            document.getElementById("msg").innerHTML="";
         //    document.getElementById("btn").disabled = "false";
        }
    }
</script>