<%@ page contentType="text/html ; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form:form action="${pageContext.request.contextPath}/topic/${topic_detail.id}/save" method="POST">
        <div class="txt_field">
            <p class="ct">หัวข้อ:**<input type="text" id="topictext" name="topictext" value="${topic_detail.topictext}" ></p>
            <select name="category_id" id="category_id">
                <c:forEach items="${category_detail}" var="category">
                    <c:choose>
                        <c:when test="${category.id eq topic_detail.category}">
                            <option value="${category.id}">${category.catetext}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${category.id}">${category.catetext}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    <div class="btn">
        <input type="submit" value="บันทึก" class="save"/>
        <input type="button" value="ลบ" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบหัวข้อนี้?')))
        { window.location.href='${pageContext.request.contextPath}/topic/${topic_detail.id}/delete';
        return false; }"class="cancel-button"/>
    </div>
    <div class="btn">
        <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/topic/list';
        return false;" class="cancel-button"/>
        <input type="button" value="เชื่อมคำถาม" onclick="window.location.href='${pageContext.request.contextPath}/topic/${topic_detail.id}/view-qfaqs';
        return false;"/>
    </div>

</form:form></div>
</div>
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>