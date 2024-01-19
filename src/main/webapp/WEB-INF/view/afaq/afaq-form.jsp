<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/assets/css/style4.css" rel="stylesheet"></link>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <script>
            function validateForm() {
                var x = document.forms["formRegister"]["afaqtext"].value;
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
                <div class="cta-form">
                    <i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน(*) หมายถึงห้ามว่าง</i>
                </div>
                <div class="txt_field">
                    <form:form action="${pageContext.request.contextPath}/afaq/save" modelAttribute="afaqqfaq"  method="GET" name="formRegister" onsubmit="return validateForm()">
                        <div class="txt_field">
                            เลือกคำถาม(Question): <form:select name="qfaq_id" id="qfaq_id" path="qfaqid">
                                <c:forEach items="${qfaqs}" var="qfaq">
                                    <option value="${qfaq.qfaq_id}">${qfaq.qfaq_name}</option>
                                </c:forEach>
                            </form:select>
                        </div>

                        <div class="txt_field">
                            ระบุคำตอบ(Answer)** : <form:input path="afaqtext"/>
                            <c:if test="${ShowAlert2==true}">
                                <p>มีคำตอบนี้อยู่ในระบบแล้ว</p>
                            </c:if>
                        </div>
                        <input type="submit" value="บันทึก" class="save"/>
                        <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/update'; return false;" class="cancel-button"/>
                    </form:form>
            </div>
        </div>
        </div>
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
    </body>
</html>