<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/nav.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@300;400&display=swap" rel="stylesheet">
</head>
<div class="bgc">
    <body>
    <header>
        <a href="${pageContext.request.contextPath}">
            <img src="${pageContext.request.contextPath}/assets/img/LogoITSCI.png" class="logo" width="250px"></a>
        <div class="navber">
            <ul>
                <li><a href="${pageContext.request.contextPath}">หน้าแรก</a></li>
                    <c:if test="${administrator != null}">
                        <li><a href="${pageContext.request.contextPath}/update-page">แก้ไข</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/topic/add-topic-page">เพิ่มกลุ่มคำถามFAQ<i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/topic/list-page">แก้ไขหัวข้อ</a></li>
                            </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/logout">ออกจากระบบ
                            <img src="${pageContext.request.contextPath}/assets/img/login.png" width="20px"></a></li>
                    </c:if>
                    <c:if test="${administrator == null}">
                        <li><a href="${pageContext.request.contextPath}/login-page">เข้าสู่ระบบ
                            <img src="${pageContext.request.contextPath}/assets/img/login.png" width="20px"></a></li>
                    </c:if>


            </ul>
        </div>
    </header>
    </body>
</div>

</html>
<!-- End Header -->