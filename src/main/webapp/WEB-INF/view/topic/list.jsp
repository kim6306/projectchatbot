<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>${title}</title>
    <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="container">
    <div class="body">
        <h2>หัวข้อ</h2>
        <input type="button" value="เพิ่มหัวข้อ" onclick="window.location.href='${pageContext.request.contextPath}/topic/create'; return false;" class="add-button"/>

        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>รายการ หัวข้อ</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="topic" items="${topics}">
                <tr>
                    <td class="C1"><a href="${pageContext.request.contextPath}/topic/${topic.id}/update">${topic.topictext}</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>