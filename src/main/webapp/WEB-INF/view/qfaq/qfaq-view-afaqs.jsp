<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml>
<html>
<head>
  <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="container">
  <div class="body">
    <h2>หัวข้อ</h2>
    <input type="button" value="เพิ่มคำตอบ"
           onclick="window.location.href='${pageContext.request.contextPath}/qfaq/${qfaq.id}/afaq/add';return false;" class="add-button"/>
    <table class="table table-striped table-bordered table-hover">
      <thead>
      <tr>
        <th>รายการ คำตอบ</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="afaq" items="${afaq}">
        <tr>
          <td class="C1"><p>${afaq.afaqtext}</p></td>
          <td>
            <input type="button" value="ลบ"
                   onclick="window.location.href='${pageContext.request.contextPath}/qfaq/${qfaq.id}/afaq/${afaq.id}/remove';
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
</body></html>