<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style4.css" rel="stylesheet" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script>
        function validateForm() {
            var x = document.forms["formRegister"]["topictext"].value;
            if (x == "" || x == null) {
                alert("กรุณากรอกข้อมูล");
                return false;
            }
        }
    </script>
</head>
<body>
<nav>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp" />
</nav>
<div class="width">
    <div id="container">
        <h1>เพิ่มหัวข้อ</h1>
        <div class="cta-form">
            <i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน(*) หมายถึงห้ามว่าง</i>
        </div>
        <form:form action="${pageContext.request.contextPath}/topic/save" method="POST" name="formRegister" onsubmit="return validateForm()">
            <div class="txt_field">
                เลือกหมวดหมู่:
                เลือกหมวดหมู่:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select name="category_id" id="category_id">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.category_id}">${category.category_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="txt_field">
                ระบุหมวดหมู่หัวข้อคำถาม(FAQ):<input type="text" id="topictext" name="topictext">
                <c:if test="${ShowAlert==true}">
                    <p>มีหัวข้อนี้อยู่ในระบบแล้ว</p>
                </c:if>
            </div>
            <div class="btn">
                <input type="submit" value="บันทึก" class="save" />
                <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/update-page'; return false;" class="cancel-button" />
            </div>
        </form:form>
</div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp" />
</body>
</html>