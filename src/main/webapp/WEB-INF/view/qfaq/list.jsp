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
                <th>รายการ คำถาม</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="qfaq" items="${qfaqs}">

                    <td class="C1"><a href="${pageContext.request.contextPath}/qfaq/${qfaq.qfaq_id}/update">Q ${i}.${j} : ${qfaq.qfaq_name}</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>