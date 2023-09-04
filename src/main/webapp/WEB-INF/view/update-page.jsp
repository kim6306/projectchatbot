<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="assets/css/style.css" rel="stylesheet" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<h1 class="textcenter">คำถามที่พบบ่อย</h1>
<div class="textc">
    <a class="flex">การสมัครเรียน</a>
    <a class="flex">กิจกรรม</a>
</div>
<div class="space">


    <div class="wrapper">
        <%
            int i = 0;
            int j = 0;
        %>
        <c:forEach var="topic" items="${topics}">
            <%i++;%>
            <div class="faq">
                <button class="accordion">FAQ <%=i%>. ${topic.topictext}
                    <div class="item2">
                        <a class="item3"href="${pageContext.request.contextPath}/topic/${topic.id}/update">
                            <img src="${pageContext.request.contextPath}/assets/img/screwdriver.png" width="25px">แก้ไข</a>
                    </div>
                    <div class="item2">
                        <a class="item3" href="${pageContext.request.contextPath}/topic/${topic.id}/view-qfaqs">
                            <img src="${pageContext.request.contextPath}/assets/img/link.png" width="30px">เชื่อมคำถาม</a>
                    </div>
                    <div class="item2">
                        <a class="item3" href="${pageContext.request.contextPath}/qfaq/create">
                            <img src="${pageContext.request.contextPath}/assets/img/plus.png" width="35px">เพื่อคำถาม</a>
                    </div>
                    <i class="fa-solid fa-chevron-down"> </i></button>
                <div class="panel">
                    <c:forEach  var="qfaqs" items="${topic.qfaqs}">
                        <%j++;%>
                        <c:forEach  var="afaqs" items="${qfaqs.afaqs}">

                            <div class="panel">
                                <div class="flex3">
                                    <p>Question <%=i%>.<%=j%> ${qfaqs.qfaqtext}</p>
                                    <div class="flex2">
                                        <div class="item2">
                                            <a class="item3" href="${pageContext.request.contextPath}/qfaq/${qfaqs.id}/update">
                                                <img src="${pageContext.request.contextPath}/assets/img/screwdriver.png" width="25px">แก้ไข</a>
                                        </div>
                                        <div class="item2">
                                            <a class="item3" href="${pageContext.request.contextPath}/qfaq/${qfaqs.id}/view-afaqs">
                                                <img src="${pageContext.request.contextPath}/assets/img/link.png" width="30px">เชื่อมคำตอบ</a>
                                        </div>
                                        <div class="item2">
                                            <a class="item3" href="${pageContext.request.contextPath}/qfaq/create">
                                                <img src="${pageContext.request.contextPath}/assets/img/plus.png" width="35px">เพิ่มคำตอบ</a>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <div class="flex3">
                                    <p>Answer <%=i%>.<%=j%> ${afaqs.afaqtext}</p>
                                    <div class="item2">
                                        <a class="item3" href="${pageContext.request.contextPath}/afaq/${afaqs.id}/update">
                                            <img src="${pageContext.request.contextPath}/assets/img/screwdriver.png" width="25px">แก้ไข</a>
                                    </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:forEach>
                    <%j = 0;%>
                </div>
            </div>

        </c:forEach >
    </div>
</div>


<script>
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            this.parentElement.classList.toggle("active");

            var panel = this.nextElementSibling;
            if (panel.style.display === "block") {
                panel.style.display = "none";
            } else {
                panel.style.display = "block";
            }
        });
    }

    var modal = document.getElementById('id01');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>

</body>
</html>