<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/assets/css/style2.css" rel="stylesheet"></link>
        <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    </head>
    <body><jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<%--        <div class="center">--%>
    <div class="width">

<div id="container">
    <div class="cta-form">
    <i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน(*) หมายถึงห้ามว่าง</i>
    </div>
    <form:form action="${pageContext.request.contextPath}/topic/save" modelAttribute="topic" method="POST" name="formRegister">
    <form:hidden path="id"/>
    <div class="txt_field">
            <p class="ct">หัวข้อ:**<form:input path="topictext"/>
    </div>
    <div class="btn">
        <input type="submit" value="บันทึก" class="save"/>
        <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/topic/list';
                return false;" class="cancel-button"/>
    </div>


</form:form></div>
        </div>
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>