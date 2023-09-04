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
<form action="${pageContext.request.contextPath}/qfaq/${qfaq.id}/afaq/add" method="post">
  <div>
    <h2>คำตอบ</h2>
  </div>
    <tbody><c:forEach var="afaq" items="${afaq}">
      <%i++;%>
      <div>
        <ol>
          <li><span><%=i%></span><p>${afaq.afaqtext}</p></li>
          <li>Action<span></span><button type="submit" name="afaq" value="${afaq.id}">เพิ่ม</button></li>
        </ol>
      </div>
    </c:forEach></tbody>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>