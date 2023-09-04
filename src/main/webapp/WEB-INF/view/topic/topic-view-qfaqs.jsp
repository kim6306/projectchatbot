<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml><html>
<head>
  <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="body">
  <%
    int i = 0;
  %>
  <input type="button" value="เพิ่มคำถาม"
         onclick="window.location.href='${pageContext.request.contextPath}/topic/${topic.id}/qfaq/add';return false;"class="add-button"/>
  <div>
    <h2>คำถาม</h2>
  </div>

  <c:forEach var="qfaq" items="${qfaq}">
    <%i++;%>
  <div>
    <ol>
      <li><span><%=i%></span><a href="${pageContext.request.contextPath}/qfaq/${qfaq.id}/update">${qfaq.qfaqtext}</a></li>
      <li>Action<span></span><a href="${pageContext.request.contextPath}/topic/${topic.id}/qfaq/${qfaq.id}/remove">ลบ</a></li>
    </ol>
  </div>
  </c:forEach>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>