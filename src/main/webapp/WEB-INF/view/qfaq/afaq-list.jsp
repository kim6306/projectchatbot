<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml>
<html>
<head>
  <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<nav>
  <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</nav>
<div class="container">
  <div class="header">
    <h2>คำตอบ</h2>
  </div>
  <div class="table-container">
    <form action="${pageContext.request.contextPath}/qfaq/${qfaq.qfaq_id}/afaq/add" method="post">
      <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
          <th>รายการ คำตอบ</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="afaqs" items="${afaq}">
          <tr>
            <td class="C1"><p>${afaqs.afaq_name}</p></td>
            <td><button type="submit" name="afaq" value="${afaqs.afaq_id}" class="add-button">เพิ่ม</button></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
  </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>