<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<nav>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</nav>
<h1 class="textcenter">คำถามที่พบบ่อย</h1>
<div class="textc">
    <a class="flex" id="AtS" href="${pageContext.request.contextPath}/AtS">การสมัครเรียน</a>
    <a class="flex" id="Act" href="${pageContext.request.contextPath}/Act">กิจกรรม</a>
</div>
<div>
    <form:form action="${pageContext.request.contextPath}/searchFAQ" method="POST" name="search">
        <input type="text" id="searchInput" style="width: 43%;" placeholder="Search Topic" name="se">
        <input type="submit" class="add-button">
    </form:form>
</div>
<div class="container">
    <div class="space">
        <div class="wrapper">
            <c:set var="i" value="0" />
            <c:set var="j" value="0" />
            <c:forEach var="topic" items="${topics}">
                <c:set var="i" value="${i+1}" />
                <div class="faq">
                    <button class="accordion">FAQ ${i}. ${topic.topic_name} <i class="fa-solid fa-chevron-down"></i></button>
                    <div class="panel">
                        <c:forEach var="qfaq" items="${topic.qfaqs}">
                            <c:set var="j" value="${j+1}" />
                            <c:forEach var="afaq" items="${qfaq.afaqs}">
                                <div class="panel">
                                    <div class="topma">
                                        <p>Q ${i}.${j} : ${qfaq.qfaq_name}</p>
                                        <p>A ${i}.${j} : ${afaq.afaq_name}</p>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:forEach>
                        <c:set var="j" value="0" />
                    </div>
                </div>
            </c:forEach>
        </div>
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
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
    function search() {
        var input = document.getElementById("searchInput").value.toLowerCase();
        var blocks = document.getElementsByClassName("block_manage_news");
        for (var i = 0; i < blocks.length; i++) {
            var block = blocks[i];
            var text = block.getAttribute("data-name").toLowerCase();
            if (text.includes(input)) {
                block.style.display = "block";
            } else {
                block.style.display = "none";
            }
        }
    }
</script>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>
</body>
</html>