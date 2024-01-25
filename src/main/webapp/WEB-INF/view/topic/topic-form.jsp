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
        <form action="${pageContext.request.contextPath}/topic/save" method="POST" name="formRegister" onsubmit="return validateForm()">
            <input type="hidden" value="${categoryId}" name="category_id">
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
        </form>
    </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp" />
</body>
</html>