<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form:form action="${pageContext.request.contextPath}/topic/save"  method="POST" name="formRegister">
        <div class="txt_field">
            <p class="ct">หัวข้อ:**<input type="text" id="topictext" name="topictext"></p>
            <select name="category_id" id="category_id">
                <c:forEach items="${categorys}" var="category">
                    <option value="${category.id}">${category.catetext}</option>
                </c:forEach>
            </select>
        </div>
    <div class="btn">
        <input type="submit" value="บันทึก" class="save"/>
        <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/topic/list';
                return false;" class="cancel-button"/>
    </div>
    </form:form>
        </div>
        </div>
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>