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
        <style>
            .width{
                margin-top: 50px;
            }
            .txt_field textarea{
                width: 100%;
                padding: 0 5px;
                height: 150px;
                font-size: 16px;
                border: none;
                background: gainsboro;
                outline: none;
                border-radius: 10px;
                resize: none;
                margin-bottom: 20px;
                max-height: 330px;
            }
        </style>
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
                        <h4>${qfafname}</h4>
                        <div class="txt_field">
                            ระบุคำตอบ(Answer)** : <textarea name="afaqtext"> </textarea>
                            <c:if test="${showsalert2==true}">
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