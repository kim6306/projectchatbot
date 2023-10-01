<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="container">
  <div class="body">
    <h2>หัวข้อ</h2>
    <input type="button" value="เพิ่มคำถาม"
           onclick="window.location.href='${pageContext.request.contextPath}/topic/${topic.id}/qfaq/add';return false;" class="add-button"/>
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
          <td>
            <input type="button" value="ลบ"
                   onclick="window.location.href='${pageContext.request.contextPath}/topic/${topic.id}/qfaq/${qfaq.id}/remove';
                           return false;" class="add-button"/>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>