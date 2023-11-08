<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<nav>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</nav>
<div class="container">
    <div class="body">
        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>รายการ คำตอบ</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="afaq" items="${afaqs}">
                <tr>
                    <td class="C1"><a href="${pageContext.request.contextPath}/afaq/${afaq.afaq_id}/update">${afaq.afaq_name}</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>