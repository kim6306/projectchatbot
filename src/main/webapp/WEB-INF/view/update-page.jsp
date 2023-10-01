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
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div class="container">
    <h1 class="textcenter">แก้ไข</h1>
    <div class="space">
        <div class="wrapper">
            <%
                int i = 0;
            %>
            <c:forEach var="topic" items="${topics}">
                <%i++;%>
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>รายการ FAQ.<%=i%></th>
                        <th>เพิ่ม</th>
                        <th>แก้ไข</th>
                        <th>เชื่อม</th>
                        <th>ลบ</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="C1" >Topic ${topic.topictext}</td>
                        <td class="C1" ><a href="${pageContext.request.contextPath}/qfaq/create">
                            <img src="${pageContext.request.contextPath}/assets/img/plus.png" width="35px"></a></td>
                        <td class="C1" ><a href="${pageContext.request.contextPath}/topic/${topic.id}/update">
                            <img src="${pageContext.request.contextPath}/assets/img/screwdriver.png" width="25px"></a></td>
                        <td class="C1" ><a href="${pageContext.request.contextPath}/topic/${topic.id}/view-qfaqs">
                            <img src="${pageContext.request.contextPath}/assets/img/link.png" width="30px"></a></td>
                        <td class="C1" ><a class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหัวข้อนี้?')))
                                { window.location.href='${pageContext.request.contextPath}/topic/${topic.id}/delete';
                                return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a></td>
                    </tr>
                    </tbody>
                    <c:forEach  var="qfaqs" items="${topic.qfaqs}">
                        <tbody>
                        <tr>
                            <td > Question ${qfaqs.qfaqtext}</td>
                            <td ></td>
                            <td ><a href="${pageContext.request.contextPath}/qfaq/${qfaqs.id}/update">
                                <img src="${pageContext.request.contextPath}/assets/img/screwdriver.png" width="25px"></a></td>
                            <td ><a href="${pageContext.request.contextPath}/qfaq/${qfaqs.id}/view-afaqs">
                                <img src="${pageContext.request.contextPath}/assets/img/link.png" width="30px"></a></td>
                            <td ></td>
                        </tr>
                        </tbody>

                        <c:forEach  var="afaqs" items="${qfaqs.afaqs}">
                            <tbody>
                            <tr>
                                <td class="C1" > Answer ${afaqs.afaqtext}</td>
                                <td class="C1" ></td>
                                <td class="C1" ><a href="${pageContext.request.contextPath}/afaq/${afaqs.id}/update">
                                    <img src="${pageContext.request.contextPath}/assets/img/screwdriver.png" width="25px"></a></td>
                                <td class="C1" ></td>
                                <td class="C1" ></td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </c:forEach>
                </table>
            </c:forEach >
        </div>
    </div>
</div>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>
</body>
</html>