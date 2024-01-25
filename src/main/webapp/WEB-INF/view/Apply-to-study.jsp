<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <link href="assets/css/styleAtS.css" rel="stylesheet" >
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
  <a class="flex" id="AtS" href="${pageContext.request.contextPath}/apply-to-study-page">สมัครเรียน</a>
  <a class="flex" id="Act" href="${pageContext.request.contextPath}/activity-page">กิจกรรม</a>
</div>
<%--<div>--%>
<%--  <input type="text" id="searchInput" style="width: 50%" onkeyup="search()" placeholder="Search for names.." title="Type in a name">--%>
<%--</div>--%>
<div class="space">


  <div class="wrapper">
    <%
      int i = 0;
      int j = 0;
    %>
    <c:forEach var="topic" items="${topics}">
      <%i++;%>
<%--      <div class="block_manage_news" data-name="${topic.topictext}">--%>
        <div class="faq">
          <button class="accordion">FAQ <%=i%>. ${topic.topic_name} <i class="fa-solid fa-chevron-down"> </i></button>
          <div class="panel">
            <c:forEach  var="qfaqs" items="${topic.qfaqs}">
              <%j++;%>
              <c:forEach  var="afaqs" items="${qfaqs.afaqs}">
                <div class="block_manage_news" data-name="${qfaqs.qfaq_name}${afaqs.afaq_name}">
                  <div class="panel">
                    <div class="topma">
                      <p>Question <%=i%>.<%=j%> ${qfaqs.qfaq_name}</p>
                      <p>Answer <%=i%>.<%=j%> ${afaqs.afaq_name}</p>
                    </div>

                  </div>
                </div>
              </c:forEach>
            </c:forEach>
            <%j = 0;%>
          </div>
        </div>
<%--      </div>--%>
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
