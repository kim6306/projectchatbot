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

        function showOptions () {
            var spinner = document.getElementById("category_id");

            for (let i = 0; i < spinner.options.length; i++) {
                var option = spinner.options[i];
                if (option.text === '${topic.category_name}') {
                    option.selected = true;
                    break;
                }
            }
        }
    </script>
    <style>
        .width{
            margin-top: 50px;
        }
    </style>
</head>
<body onload="showOptions()">
<nav>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</nav>
<div class="width">
    <div id="container">
        <form action="${pageContext.request.contextPath}/topic/update" name="formRegister" method="POST" onsubmit="return validateForm()">
            <input type="hidden" value="${topic.topic_id}" name="topic_id">
            <div class="txt_field">
                เลือกหมวดหมู่:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select name="category_name" id="category_name">
                    <option>การสมัครเรียน</option>
                    <option>กิจกรรม</option>
                </select>
            </div>
            <div class="txt_field">
                ระบุกล่มหัวข้อคำถาม(FAQ):<input type="text" id="topictext" name="topictext" value="${topic.topic_name}">
                <c:if test="${ShowAlert==true}">
                    <p>มีหัวข้อนี้อยู่ในระบบแล้ว</p>
                </c:if>
            </div>
            <div class="btn">
                <input type="submit" value="บันทึก" class="save"/>
            </div>
            <div class="btn">
                <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/update-page'; return false;" class="cancel-button"/>
            </div>
<%--            <div class="btn">--%>
<%--                <input type="button" value="ลบหัวข้อ" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหัวข้อนี้?')))--%>
<%--                        { window.location.href='${pageContext.request.contextPath}/topic/delete/${topic.topic_id}';--%>
<%--                        return false; }" class="cancel-button"/>--%>
<%--            </div>--%>
        </form>
    </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>