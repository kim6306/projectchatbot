<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml>
<html>
<head>
  <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="body">
  <%
    int i = 0;
  %>
<input type="button" value="เพิ่มคำตอบ"
       onclick="window.location.href='${pageContext.request.contextPath}/qfaq/${qfaq.id}/afaq/add';return false;"class="add-button"/>
  <div>
    <h2>คำตอบ</h2>
  </div>
<c:forEach var="afaq" items="${afaq}">
  <%i++;%>
    <div>
      <ol>
        <li><span><%=i%></span><a href="${pageContext.request.contextPath}/afaq/${afaq.id}/update">${afaq.afaqtext}</a></li>
        <li>Action<span></span><a href="${pageContext.request.contextPath}/qfaq/${qfaq.id}/afaq/${afaq.id}/remove">ลบ</a></li>
      </ol>
    </div>
  </c:forEach></tbody>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>