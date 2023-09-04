<%@ page contentType="text/html ; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPEhtml>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/assets/css/style2.css" rel="stylesheet"></link>
    </head>
    <body>
        <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<%--        <div class="center">--%>
        <div class="width">

<div id="container"><i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน(*) หมายถึงห้ามว่าง</i><br><br>
    <form:form action="${pageContext.request.contextPath}/topic/save" modelAttribute="topic" method="POST">
    <form:hidden path="id"/>
        <div class="txt_field">
            <p class="ct">หัวข้อ:**<form:input path="topictext"/>
                <form:errors path="topictext" cssClass="error"/></p>
        </div>
    <div class="btn">
        <input type="submit" value="บันทึก" class="save"/>
        <input type="button" value="ลบ" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหัวข้อนี้?')))
        { window.location.href='${pageContext.request.contextPath}/topic/${topic.id}/delete';
        return false; }"class="cancel-button"/>
    </div>
    <div class="btn">
        <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/topic/list';
        return false;" class="cancel-button"/>
        <input type="button" value="เชื่อมคำถาม" onclick="window.location.href='${pageContext.request.contextPath}/topic/${topic.id}/view-qfaqs';
        return false;"/>
    </div>

</form:form></div>
</div>
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>