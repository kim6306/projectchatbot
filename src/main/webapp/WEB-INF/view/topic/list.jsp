<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>${title}</title>
    <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<nav>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</nav>
<div class="container">
    <div class="body">
        <%
            int i = 0;
            int j = 0;
        %>
        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>รายการหัวข้อ <%=(i+1)%> </th>
                <th>แก้ไขหัวข้อ</th>
                <th>ลบหัวข้อ</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="topic" items="${topics}">
                <%i++;%>
                <tr>
                    <td class="C1">${topic.topic_name}</td>
                    <td class="C1"><a href="${pageContext.request.contextPath}/topic/update/${topic.topic_id}">
                        <img src="${pageContext.request.contextPath}/assets/img/pencil.png" width="25px"></a></td>
                    <td class="C1"><a style="margin-right: 50px;" class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหัวข้อนี้?')))
                            { window.location.href='${pageContext.request.contextPath}/topic/delete/${topic.topic_id}';
                            return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>