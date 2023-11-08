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
            %>
            <input type="button" value="เพิ่มหัวข้อ" onclick="window.location.href='${pageContext.request.contextPath}/topic/create'; return false;" class="add-button"/>
            <c:forEach var="topic" items="${topics}">
                <%i++;%>
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>Topic <%=i%> <a href="${pageContext.request.contextPath}/topic/${topic.topic_id}/update">${topic.topic_name}</a> </th>
                        <th>เพิ่ม</th>
                        <th>แก้ไข</th>
                        <th>ลบ <a class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหัวข้อนี้?')))
                                { window.location.href='${pageContext.request.contextPath}/topic/${topic.topic_id}/delete';
                                return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a></th>
                    </tr>
                    </thead>
                    <c:forEach  var="qfaq" items="${topic.qfaqs}">
                        <%j++;%>
                        <tbody>
                        <tr>
                            <td class="C1"> Q<%=i%>.<%=j%> ${qfaq.qfaq_name}</td>
                            <td class="C1"></td>
                            <td class="C1"><a href="${pageContext.request.contextPath}/qfaq/${qfaq.qfaq_id}/update">
                                <img src="${pageContext.request.contextPath}/assets/img/pencil.png" width="30px"></a></td>
                            <td class="C1"><a class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบคำถามนี้?')))
                                    { window.location.href='${pageContext.request.contextPath}/qfaq/${qfaq.qfaq_id}/delete';
                                    return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a></td>
                        </tr>
                        </tbody>

                        <c:forEach  var="afaq" items="${qfaq.afaqs}">
                            <tbody>
                            <tr>
                                <td class="C1" > A<%=i%>.<%=j%> ${afaq.afaq_name}</td>
                                <td class="C1" ></td>
                                <td class="C1" ><a href="${pageContext.request.contextPath}/afaq/${afaq.afaq_id}/update">
                                    <img src="${pageContext.request.contextPath}/assets/img/pencil.png" width="30px"></a></td>
                                <td class="C1" ><a class="delete-button" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบคำตอบนี้?')))
                                        { window.location.href='${pageContext.request.contextPath}/afaq/${afaq.afaq_id}/delete';
                                        return false; }"><img src="${pageContext.request.contextPath}/assets/img/delete.png" width="30px"></a></td>
                            </tr>
                            </tbody>

                        </c:forEach>
                    </c:forEach>
                    <%j = 0;%>
                    <tbody>
                    <tr>
                        <td class="C1" >เพิ่มคำถามและคำตอบ</td>
                        <td class="C1" ><a href="${pageContext.request.contextPath}/qfaq/create">
                            <img src="${pageContext.request.contextPath}/assets/img/plus.png" width="35px"></a></td>
                        <td class="C1" ></td>
                        <td class="C1" ></td>
                    </tr>
                    </tbody>
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