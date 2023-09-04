<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>${title}</title>
    <link href="${pageContext.request.contextPath}/assets/css/csslist.css" rel="stylesheet">
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="body">
    <%
        int i = 0;
    %>
    <ul>
        <h2>หัวข้อ<br><input type="button" value="เพิ่มหัวข้อ"
                          onclick="window.location.href='${pageContext.request.contextPath}/topic/create';
                                  return false;"class="add-button"/></h2>
        <c:forEach var="topic" items="${topics}">
            <%i++;%>
            <div>
                <ol>
                    <li><span><%=i%></span><a href="${pageContext.request.contextPath}/topic/${topic.id}/update">${topic.topictext}</a></li>
                </ol>
            </div>


        </c:forEach>
    </ul>
</div>

</div>


<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>