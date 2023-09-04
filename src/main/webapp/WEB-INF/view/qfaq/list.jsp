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
        <%
            int i = 0;
        %>
        <ul>
            <h2>คำถาม<br><input type="button" value="เพิ่มหัวข้อ"
           onclick="window.location.href='${pageContext.request.contextPath}/qfaq/create'; return false;"class="add-button"/></h2>
    <c:forEach var="qfaq" items="${qfaqs}">
        <%i++;%>
            <div>
                <ol>
                    <li><span><%=i%></span><a href="${pageContext.request.contextPath}/qfaq/${qfaq.id}/update">${qfaq.qfaqtext}</a></li>
                </ol>
            </div>
        </c:forEach></tbody>
</ul>
    </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>