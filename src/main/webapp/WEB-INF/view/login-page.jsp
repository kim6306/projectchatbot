<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="assets/css/style3.css" rel="stylesheet">
</head>
<body>

<div class="center">
    <h1>ลงชื่อเข้าสู่ระบบ</h1>
    <div class="text"><c:if test="${param.error != null}">ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง</c:if><c:if
            test="${param.logout != null}">คุณออกจากระบบแล้ว</c:if></div>

        <div class="container">
            <form:form action="${pageContext.request.contextPath}/login" method="POST">
            <div class="txt_field">
                <p>Username:<input type="text" name="username"/></p>
            </div>
            <div class="txt_field">
                <p>Password:<input type="password" name="password"/></p>
            </div>
            <input type="submit" value="Login"/>

            </form:form>
        </div>
        <c:if test="${loginFailed == true}">
            <h4>ไม่สามารถเข้าสู่ระบบได้เนื่องจากชื่อผู้ใช้หรือรหัสผ่านผิด กรุณาลองใหม่อีกครั้ง</h4>
        </c:if>

</div>
</body>
</html>