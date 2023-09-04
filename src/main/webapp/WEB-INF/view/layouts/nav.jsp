<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="${pageContext.request.contextPath}/logout" method="POST" name="frmLogout"></form:form>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>เข้าสู่ระบบ Information Technology</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/nav.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@300;400&display=swap" rel="stylesheet">
    <style>
        .top-nav li{
            background: #aa1818;
            border-bottom: 4px solid #aa1919;
            float: left;
            font-size: 10px;
            height: 30px;
            padding-top: 10px;
            position: relative;
            text-align: center;
            width: 14.26%;
        }
        .top-nav li a{
            color: #fff;
            padding-top: 7px;
            position: absolute;
            top: 0;
            left: 0;
            width: 150px;
            height: 25px;
            font-size: 13px;
            text-decoration: none;
        }
    </style>
</head>
<body bgcolor="#ffffff" >
<header>
    <div class="navbar navbar-default navbar-static-top">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}"> <img src="${pageContext.request.contextPath}/assets/img/logo.png" class="hidden-xs" alt="" width="250px" style="margin-left: 5px;"></a>
            <ul class="p">
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
    </div>
</header>
<nav >
    <ul class="top-nav" >
        <li><a href="${pageContext.request.contextPath}">
            <img src="${pageContext.request.contextPath}/assets/img/home.png" width="20px"> หน้าหลัก</a></li>

                        <security:authorize access="hasRole('ADMIN')">
                            <li><a href="${pageContext.request.contextPath}/update">แก้ไข</a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ADMIN')">
                            <li><a href="${pageContext.request.contextPath}/topic/create">เพิ่มหัวข้อ</a>
                                <ul class="submenu">
                                    <li><a href="${pageContext.request.contextPath}/topic/list">แก้ไขหัวข้อ</a></li>
                                </ul>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ADMIN')">
                            <li><a href="${pageContext.request.contextPath}/qfaq/create">เพิ่มคำถาม</a>
                                <ul class="submenu">
                                    <li><a href="${pageContext.request.contextPath}/qfaq/list">แก้ไขคำถาม</a></li>
                                </ul>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ADMIN')">
                            <li><a href="${pageContext.request.contextPath}/afaq/create">เพิ่มคำตอบ</a>
                                <ul class="submenu">
                                    <li><a href="${pageContext.request.contextPath}/afaq/list">เพิ่มแก้ไขคำถาม</a></li>
                                </ul>
                            </li>
                        </security:authorize>
                    </ul>
                </nav>
                <hr>
            </div>
        </header>
    </ul>
</nav>

<!-- End Header -->
