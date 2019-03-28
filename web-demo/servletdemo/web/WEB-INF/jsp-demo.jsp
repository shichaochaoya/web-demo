<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/1
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--控制运转流程--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=request.getAttribute("name") %><br><%--等价于${name}--%>


<%--el表达式--%>${user.age}<%--取一个对象--%>
${user.name}

<%--jstl标签--%>

<c:if test="${user.age < 28}">
    <%--如果成立就执行--%>
    <input type="button" value="小于28岁"><br>
</c:if>


<c:forEach items="${users}" var="user">
    <input type="text" value="${user.name}">
    <input type="button" value="${user.age}"><br>
</c:forEach>


</body>
<script type="text/javascript">

    var Ajax = {/*定义了一个阿贾克斯数组，包含两个函数*/
        get: function (url, fun) {
            var obj = new XMLHttpRequest();
            obj.open('GET', url, true);

            /*监控状态改变*/
            obj.onreadystatechange = function () {
                if (obj.readyState == 4 && obj.status == 200){
                    fun.call(this,obj.responseText)
                }
            };
            obj.send(null);
        },

        post: function (url, data , fun) {
            var obj = new XMLHttpRequest();
            obj.open('POST', url, true);

            /*监控状态改变*/
            obj.onreadystatechange = function () {
                if (obj.readyState == 4 && obj.status == 200){
                    fun.call(this,obj.responseText)
                }
            };
            obj.send(data);
        }
    }

    Ajax.get('/demo1',fResult);
    function fResult(data) {
        alert(data);
    }


</script>
</html>
