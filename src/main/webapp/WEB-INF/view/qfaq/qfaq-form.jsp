<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style2.css" rel="stylesheet"></link>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script>
        function validateForm() {
            var x = document.forms["formRegister"]["qfaqtext"].value;
            var y = document.forms["formRegister"]["afaqtext"].value;
            if (x == "" || x == null && y == "" || y == null) {
                alert("กรุณากรอกข้อมูล");
                return false;
            }
            else if(x == "" || x == null){
                alert("กรุณากรอกข้อมูล");
                return false;
            }
            else if(y == "" || y == null){
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
    <div class="cta-form">
    <i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน(*) หมายถึงห้ามว่าง</i>
    </div>
        <div class="txt_field">
            <form:form action="${pageContext.request.contextPath}/qfaq/save" modelAttribute="qfaqafaq"  method="GET" name="formRegister" onsubmit="return validateForm()">
            เลือกหมวดหมู่หัวข้อคำถาม(FAQ):<form:select name="topic_id" id="topic_id" path="topicid">
                <c:forEach items="${topics}" var="topic">
                    <option value="${topic.topic_id}">${topic.topic_name}</option>
                </c:forEach>
            </form:select>
        </div>

        <div class="txt_field">
            ระบุคำถาม(Question)** : <form:input path="qfaqtext" name="qfaqtext"/>
            <c:if test="${ShowAlert1==true}">
                <p>มีคำถามนี้อยู่ในระบบแล้ว</p>
            </c:if>
        </div>

        <div class="txt_field">
            ระบุคำตอบ(Answer)** : <form:input path="afaqtext" name="afaqtext"/>
            <c:if test="${ShowAlert2==true}">
                <p>มีคำตอบนี้อยู่ในระบบแล้ว</p>
            </c:if>
        </div>
        <input type="submit" value="บันทึก" class="save"/>
        <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/qfaq/list';
        return false;" class="cancel-button"/>
</form:form>
</div>
        </div>
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>