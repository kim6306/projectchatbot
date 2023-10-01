<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="container">
    <div class="body">
        <h2>คำถาม</h2>
        <input type="button" value="เพิ่มคำถาม"
               onclick="window.location.href='${pageContext.request.contextPath}/qfaq/create'; return false;"class="add-button"/>

        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>รายการ คำถาม</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="qfaq" items="${qfaqs}">
                <tr>
                    <td class="C1"><a href="${pageContext.request.contextPath}/qfaq/${qfaq.id}/update">${qfaq.qfaqtext}</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>