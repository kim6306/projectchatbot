<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style2.css" rel="stylesheet"></link>
    <script>
        function validateForm() {
            var x = document.forms["formRegister"]["qfaqtext"].value;
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
        <i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน(*) หมายถึงห้ามว่าง</i><br/><br>

        <form:form action="${pageContext.request.contextPath}/qfaq/${qfaq.qfaq_id}/saveupdate" name="formRegister" method="POST" onsubmit="return validateForm()">
            <div class="txt_field">
                เลือกหมวดหมู่หัวข้อคำถาม(FAQ):
                <select name="topic_id" id="topic_id">
                    <c:forEach items="${topics}" var="topic">
                        <option value="${topic.topic_id}">${topic.topic_name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="txt_field">
                <p class="ct">คำถาม:**<input type="text" id="qfaqtext" name="qfaqtext" value="${qfaq.qfaq_name}"></p>
                <c:if test="${ShowAlert3==true}">
                    <p>มีคำถามนี้อยู่ในระบบแล้ว</p>
                </c:if>
            </div>

            <div class="btn">
                <input type="submit" value="บันทึก" class="save"/>
                <input type="button" value="ลบ" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบคำถามนี้?')))
                        { window.location.href='${pageContext.request.contextPath}/qfaq/${qfaq.qfaq_id}/delete';
                        return false; }" class="cancel-button"/>
            </div>

            <div class="btn">
                <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/qfaq/list';
                        return false;" class="cancel-button"/>
                <input type="button" value="เชื่อมคำตอบ" onclick="window.location.href='${pageContext.request.contextPath}/qfaq/${qfaq.qfaq_id}/view-afaqs';
                        return false;"/>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
