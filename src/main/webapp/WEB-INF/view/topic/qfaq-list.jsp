<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml>
<html>
<head>
  <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet"></head>
<body>
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="body">
  <%
    int i = 0;
  %>
<form action="${pageContext.request.contextPath}/topic/${topic.id}/qfaq/add" method="post">
  <div>
    <h2>คำถาม</h2>
  </div>
    <c:forEach var="qfaq" items="${qfaq}">
      <%i++;%>
      <div>
        <ol>
          <li><span><%=i%></span><p>${qfaq.qfaqtext}</p></li>
          <li>Action<span></span><button type="submit" name="qfaq" value="${qfaq.id}">เพิ่ม</button></li>
        </ol>
      </div>
    </c:forEach></tbody>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>