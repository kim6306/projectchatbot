<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="assets/css/U-page.css" rel="stylesheet" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<nav>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</nav>
<div class="container">
    <h1 class="textcenter">แก้ไข</h1>
    <div class="space">
        <div class="wrapper">
            <%
                int i = 0;
                int j = 0;
                int k = 0;
                int l = 0;
            %>
            <c:forEach var="category" items="${categories}">
                <div style="background-color: #632724">
                    <div style="display: inline-block; padding-top: 10px; padding-bottom: 10px;">
                        <span style="margin-left: 25px; margin-right: 50px; font-size: 34px; font-weight: bold;">หมวดหมู่ที่ <%=(i+1)%> : ${category.category_name}</span>
                        <img style="margin-right: 50px;" src="${pageContext.request.contextPath}/assets/img/pencil.png" width="30px" onclick="window.location.href='${pageContext.request.contextPath}/category/delete/${category.category_id}';">
                        <a style="margin-right: 50px;" class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหมวดหมู่นี้?'))) {window.location.href='${pageContext.request.contextPath}/category/delete/${category.category_id}'; return false;}"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a>
                        <a class="delete-button" onclick="window.location.href='${pageContext.request.contextPath}/topic/add-topic-page/${category.category_id}';"><img src="${pageContext.request.contextPath}/assets/img/plus.png" width="30px"></a>
                    </div>
                </div>
                <c:forEach var="topic" items="${category.topics}">
                    <div style="background-color: #923734;">
                        <div style="display: inline-block; padding-top: 10px; padding-bottom: 10px;">
                            <span style="margin-left: 50px; margin-right: 50px; font-size: 30px; font-weight: bold;">หัวข้อที่ <%=(j+1)%> : ${topic.topic_name}</span>
                            <a style="margin-right: 50px;" class="delete-button" onclick="window.location.href='${pageContext.request.contextPath}/topic/update-page/${topic.topic_id}';"><img src="${pageContext.request.contextPath}/assets/img/pencil.png" width="30px"></a>
                            <a style="margin-right: 50px;" class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหัวข้อนี้?')))
                                    { window.location.href='${pageContext.request.contextPath}/topic/delete/${topic.topic_id}';
                                    return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a>
                            <a class="delete-button" onclick="window.location.href='${pageContext.request.contextPath}/qfaq/add-qfaq-page/${topic.topic_id}';"><img src="${pageContext.request.contextPath}/assets/img/plus.png" width="30px"></a>
                        </div>
                    </div>
                    <c:forEach var="qfaq" items="${topic.qfaqs}">
                        <div style="background-color: #a93f3b">
                            <div style="display: inline-block; padding-top: 5px; padding-bottom: 5px;">
                                <span style="margin-left: 75px; margin-right: 50px; font-size: 24px; font-weight: bold;">Q<%=(k+1)%> ${qfaq.qfaq_name}</span>
                                <a style="margin-right: 50px;" class="delete-button" onclick="window.location.href='${pageContext.request.contextPath}/qfaq/update-page/${qfaq.qfaq_id}';"><img src="${pageContext.request.contextPath}/assets/img/pencil.png" width="30px"></a>
                                <a style="margin-right: 50px;" class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบคำถามนี้?')))
                                        { window.location.href='${pageContext.request.contextPath}/qfaq/delete/${qfaq.qfaq_id}';
                                        return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a>
                                <a class="delete-button" onclick="window.location.href='${pageContext.request.contextPath}/afaq/add-afaq-page/${qfaq.qfaq_id}';"><img src="${pageContext.request.contextPath}/assets/img/plus.png" width="30px"></a>
                            </div>
                        </div>
                        <c:forEach var="afaq" items="${qfaq.afaqs}">
                            <div style="background-color: #ba5754">
                                <div style="display: inline-block; padding-top: 5px; padding-bottom: 5px;">
                                    <span style="margin-left: 100px; margin-right: 50px; font-size: 24px; font-weight: bold;">A<%=(k+1)%>.<%=(l+1)%> ${afaq.afaq_name}</span>
                                    <a style="margin-right: 50px;" class="delete-button" onclick="window.location.href='${pageContext.request.contextPath}/afaq/update-page/${afaq.afaq_id}';"><img src="${pageContext.request.contextPath}/assets/img/pencil.png" width="30px"></a>
                                    <c:if test="${qfaq.afaqs.size() > 1}">
                                        <a style="margin-right: 50px;" class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบคำตอบนี้?')))
                                                { window.location.href='${pageContext.request.contextPath}/afaq/delete/${afaq.afaq_id}';
                                                return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a>
                                    </c:if>
                                </div>
                            </div>
                            <%l++;%>
                        </c:forEach>
                        <%l = 0;%>
                        <%k++;%>
                    </c:forEach>
                    <%j++;%>
                </c:forEach>
                <%i++;%>
            </c:forEach>
            <a class="delete-button" onclick="window.location.href='${pageContext.request.contextPath}/category/add-category-page';"><img src="${pageContext.request.contextPath}/assets/img/plus.png" width="30px"></a>
        </div>
    </div>
</div>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>
</body>
</html>