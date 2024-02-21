<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style5.css" rel="stylesheet"></link>
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
        <form action="${pageContext.request.contextPath}/afaq/update" name="formRegister" method="POST" onsubmit="return validateForm()">
            <input name="afaq_id" value="${afaq.afaq_id}" type="hidden">

            <div class="txt_field">
                ระบุคำตอบ(Answer): <textarea id="afaqtext" name="afaqtext" value="${afaq.afaq_name}"></textarea>
                <c:if test="${ShowAlert==true}">
                    <p>มีคำถามนี้อยู่ในระบบแล้ว</p>
                </c:if>
            </div>

            <div class="btn">
                <input type="submit" value="บันทึก" class="save"/>
            </div>

            <div>
                <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/update-page';
                        return false;" class="cancel-button"/>
            </div>
        </form>
    </div>
</div>

<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>
