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
            var x = document.forms["formRegister"]["qfaqtext"].value;
            var y = document.forms["formRegister"]["afaqtext"].value;
            if ((x == "" || x == null) && (y == "" || y == null)) {
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

        function sayhello () {
            let dropdown = document.getElementById("topic_id");
            let value = dropdown.value;
            let text = dropdown.options[dropdown.selectedIndex].text;
            console.log('VALUE IS ' + text);
            fetch('http://localhost:8080/project_war_exploded/rest/test/' + text).then(response => (response.text().then(
                text => {
                    console.log(text);
                    document.getElementById("questionId").textContent=text;
                    document.getElementById("answerId").textContent=text;
                }
            )));

        }
        // const textarea = document.querySelector("textarea");
        // textarea.addEventListener("keyup", e =>{
        //     let scHeight = e.target.scrollHeight;
        //     textarea.style.height = scHeight + 'px';
        // })
    </script>
    <style>
        .width{
            margin-top: 30px;
            max-width: 800px;
            /*height: 60px;*/
        }
        .txt_field input{
            width: 100%;
            padding: 0 5px;
            height: 50px;
            font-size: 16px;
            border: none;
            background: gainsboro;
            outline: none;
            border-radius: 10px;
        }
        .txt_field2 textarea{
            width: 100%;
            padding: 0 5px;
            height: 100px;
            font-size: 16px;
            border: none;
            background: gainsboro;
            outline: none;
            border-radius: 10px;
            resize: none;
            margin-bottom: 20px;
            max-height: 330px;
        }
        h4{
            text-align: left;
        }
    </style>
</head>
    <body>
        <nav>
            <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
        </nav>
        <div class="width">
<div id="container">
            <form action="${pageContext.request.contextPath}/qfaq/save"  method="POST" name="formRegister" onsubmit="return validateForm()">
                <input type="hidden" name="topic_id" value="${topicId}">
 <h4>กลุ่มหัวข้อคำถาม : ${topicName}</h4>
        <div class="txt_field">
            ระบุคำถาม(Q): <h4 id="questionId"></h4>
            <input name="qfaqtext"/>
            <c:if test="${showalert1==true}">
                <p>มีคำถามนี้อยู่ในระบบแล้ว</p>
            </c:if>
        </div>

        <div class="txt_field2">
            ระบุคำตอบ(A): <h4 id="answerId"></h4>
            <textarea name="afaqtext"/></textarea>
            <c:if test="${showalert2==true}">
                <p>มีคำตอบนี้อยู่ในระบบแล้ว</p>
            </c:if>
        </div>
        <input type="submit" value="บันทึก" class="save"/>
        <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/update-page';
        return false;" class="cancel-button"/>
</form>
</div>
        </div>
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>