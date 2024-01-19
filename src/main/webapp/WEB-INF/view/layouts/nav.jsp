<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="${pageContext.request.contextPath}/logout" method="POST" name="frmLogout"></form:form>
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
                <security:authorize access="hasRole('ADMIN')">
                    <li><a href="${pageContext.request.contextPath}/update">แก้ไข</a>
                    </li>
                </security:authorize>
                <security:authorize access="hasRole('ADMIN')">
                    <li><a href="${pageContext.request.contextPath}/topic/create">เพิ่มกลุ่มคำถามFAQ<i class="fas fa-caret-down"></i></a>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/topic/list">แก้ไขหัวข้อ</a></li>
                        </ul>
                    </li>
                </security:authorize>
<%--                <security:authorize access="hasRole('ADMIN')">--%>
<%--                    <li><a href="${pageContext.request.contextPath}/qfaq/create">เพิ่มคำถาม<i class="fas fa-caret-down"></i></a>--%>
<%--                        <ul class="submenu">--%>
<%--                            <li><a href="${pageContext.request.contextPath}/qfaq/list">แก้ไขคำถาม</a></li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                </security:authorize>--%>
<%--                <security:authorize access="hasRole('ADMIN')">--%>
<%--                    <li><a href="${pageContext.request.contextPath}/afaq/create">เพิ่มคำตอบ<i class="fas fa-caret-down"></i></a>--%>
<%--                        <ul class="submenu">--%>
<%--                            <li><a href="${pageContext.request.contextPath}/afaq/list">แก้ไขคำตอบ</a></li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                </security:authorize>--%>
                <security:authorize access="!isAuthenticated()">
                    <li><a href="${pageContext.request.contextPath}/login">เข้าสู่ระบบ
                        <img src="${pageContext.request.contextPath}/assets/img/login.png" width="20px"></a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li><a onclick="javascript: frmLogout.submit();">ออกจากระบบ
                        <img src="${pageContext.request.contextPath}/assets/img/login.png" width="20px"></a></li>
                </security:authorize>
            </ul>
        </div>
    </header>
    </body>
</div>

</html>
<!-- End Header -->