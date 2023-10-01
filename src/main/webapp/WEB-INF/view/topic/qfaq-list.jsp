<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml>
<html>
<head>
  <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet"></head>
<body>
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="container">
  <div class="header">
    <h2>คำถาม</h2>
  </div>
  <div class="table-container">
    <form action="${pageContext.request.contextPath}/topic/${topic.id}/qfaq/add" method="post">
      <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
          <th>รายการ คำถาม</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="qfaq" items="${qfaq}">
          <tr>
            <td class="C1"><p>${qfaq.qfaqtext}</p></td>
            <td><button type="submit" name="qfaq" value="${qfaq.id}" class="add-button">เพิ่ม</button></td>
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