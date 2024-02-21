<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/U-page.css" rel="stylesheet" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<nav>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</nav>
<div class="container">
    <h1 class="textcenter">แก้ไขคำถามคำตอบ FAQ</h1>
    <div class="space">
        <div class="wrapper">
            <%
                int i = 0;
                int j = 0;
                int k = 0;
                int l = 0;
            %>
<%--            <c:forEach var="category" items="${categories}">--%>
            <c:forEach var="topic" items="${topics}">
                <input type="button" value="เพิ่มคำถามและคำตอบ" onclick="window.location.href='${pageContext.request.contextPath}/qfaq/add-qfaq-page/${topic.topic_id}';" class="add-button"/>
                <table class="table table-striped table-bordered table-hover" >
                    <thead>
                    <tr>
                        <th>กลุ่มคำถามที่ <%=(i+1)%> ${topic.topic_name} </th>
                        <th>แก้ไข</th>
                        <th>ลบ</th>
                        <th>เพิ่มคำตอบ</th>
<%--                        <th>ลบกลุ่มคำถามนี้ <a style="margin-right: 50px;" class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหัวข้อนี้?')))--%>
<%--                                { window.location.href='${pageContext.request.contextPath}/topic/delete/${topic.topic_id}';--%>
<%--                                return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a></th>--%>
                    </tr>
                    </thead>
<%--                    <c:forEach var="topic" items="${topics}">--%>
<%--                    <tbody>--%>
<%--                    <tr>--%>
<%--                        <td class="C1" >Topic <%=(j+1)%> </td>--%>
<%--                        <td class="C1" ><a href="${pageContext.request.contextPath}/topic/update/${topic.topic_id}">--%>
<%--                            <img src="${pageContext.request.contextPath}/assets/img/pencil.png" width="25px"></a></td>--%>

<%--                        <td class="C1" ><a class="delete-button" onclick="window.location.href='${pageContext.request.contextPath}/qfaq/add-qfaq-page/${topic.topic_id}';">--%>
<%--                            <img src="${pageContext.request.contextPath}/assets/img/plus.png" width="30px"></a></td>--%>
<%--                    </tr>--%>
<%--                    </tbody>--%>
                    <c:forEach var="qfaq" items="${topic.qfaqs}">
                        <tbody>
                        <tr>
                            <td class="C1" > Question <%=(k+1)%> : ${qfaq.qfaq_name}</td>
                            <td class="C1" ><a href="${pageContext.request.contextPath}/qfaq/update/${qfaq.qfaq_id}">
                                <img src="${pageContext.request.contextPath}/assets/img/pencil.png" width="25px"></a></td>
                            <td class="C1" > <a class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบคำถามนี้?')))
                                    { window.location.href='${pageContext.request.contextPath}/qfaq/delete/${qfaq.qfaq_id}';
                                    return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a> </td>
                            <td class="C1" ><a class="delete-button" onclick="window.location.href='${pageContext.request.contextPath}/afaq/add-afaq-page/${qfaq.qfaq_id}';">
                                <img src="${pageContext.request.contextPath}/assets/img/plus.png" width="30px"></a></td>
                        </tr>
                        </tbody>
                        <c:forEach var="afaq" items="${qfaq.afaqs}">
                            <tbody >
                            <tr class="underline">
                                <td class="C1" > Answer <%=(k+1)%>.<%=(l+1)%> : ${afaq.afaq_name}</td>
                                <td class="C1" ><a href="${pageContext.request.contextPath}/afaq/update/${afaq.afaq_id}">
                                    <img src="${pageContext.request.contextPath}/assets/img/pencil.png" width="25px"></a></td>
                                <td class="C1" >
                                    <c:if test="${qfaq.afaqs.size() > 1}">
                                    <a style="margin-right: 50px;" class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบคำตอบนี้?')))
                                            { window.location.href='${pageContext.request.contextPath}/afaq/delete/${afaq.afaq_id}';
                                            return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a>
                                        </c:if>
                                <td class="C1" ></td>
                            </tr>
                            </tbody >
                            <%l++;%>
                        </c:forEach >
                        <%l = 0;%>
                        <%k++;%>
                    </c:forEach>
                    <%k = 0;%>
                        <%j++;%>
<%--                    </c:forEach>--%>
                    <%i++;%>
                </table >
            </c:forEach >
        </div>
    </div>
</div>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>
</body>
</html>