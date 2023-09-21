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
<div class="body">
    <%
        int i = 0;
    %>
    <ul>
        <h2>คำตอบ<br><input type="button" value="เพิ่มหมวดหมู่"
                            onclick="window.location.href='${pageContext.request.contextPath}/category/create'; return false;"class="add-button"/></h2>
        <c:forEach var="category" items="${categorys}">
            <%i++;%>
            <div>
                <ol>
                    <li><span><%=i%></span><a href="${pageContext.request.contextPath}/category/${category.id}/update">${category.catetext}</a></li>
                </ol>
            </div>
        </c:forEach>
    </ul>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>