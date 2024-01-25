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
                    <form action="${pageContext.request.contextPath}/afaq/save" method="POST" name="formRegister" onsubmit="return validateForm()">
                        <input value="${qfaqId}" name="qfaq_id" type="hidden">
                        <div class="txt_field">
                            ระบุคำตอบ(Answer)** : <input name="afaqtext">
                            <c:if test="${ShowAlert2==true}">
                                <p>มีคำตอบนี้อยู่ในระบบแล้ว</p>
                            </c:if>
                        </div>
                        <input type="submit" value="บันทึก" class="save"/>
                        <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/update'; return false;" class="cancel-button"/>
                    </form>
            </div>
        </div>
        </div>
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
    </body>
</html>