<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style4.css" rel="stylesheet"></link>
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
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</nav>
<div class="width">
    <div id="container">
        <form:form action="${pageContext.request.contextPath}/topic/${topic_detail.topic_id}/save" name="formRegister" method="POST" onsubmit="return validateForm()">
            <div class="txt_field">
                เลือกหมวดหมู่:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select name="category_id" id="category_id">
                    <c:forEach items="${category_detail}" var="category">
                        <option value="${category.category_id}">${category.category_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="txt_field">
                ระบุหมวดหมู่หัวข้อคำถาม(FAQ):<input type="text" id="topictext" name="topictext" value="${topic_detail.topic_name}">
                <c:if test="${ShowAlert==true}">
                    <p>มีหัวข้อนี้อยู่ในระบบแล้ว</p>
                </c:if>
            </div>
            <div class="btn">
                <input type="submit" value="บันทึก" class="save"/>
                <input type="button" value="ลบ" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหัวข้อนี้?'))) { window.location.href='${pageContext.request.contextPath}/topic/${topic_detail.topic_id}/delete'; return false; }" class="cancel-button"/>
            </div>
            <div class="btn">
                <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/update'; return false;" class="cancel-button"/>
            </div>
        </form:form>
    </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>