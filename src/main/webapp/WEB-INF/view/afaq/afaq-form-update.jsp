<%@ page contentType="text/html ; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/assets/css/style2.css" rel="stylesheet"></link>
    </head>
    <body>
        <nav>
            <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
        </nav>
            <%--        <div class="center">--%>
        <div class="width">
            <div id="container"><i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน(*) หมายถึงห้ามว่าง</i><br/><br>
                <form:form action="${pageContext.request.contextPath}/afaq/saveupdate" modelAttribute="afaq" method="POST">
                    <form:hidden path="afaq_id"/>
                    <div class="txt_field">
                        <p class="ct">คำตอบ:**<form:input path="afaq_name"/></p>
                        <c:if test="${ShowAlert==true}">
                            <p>มีคำถามนี้อยู่ในระบบแล้ว</p>
                        </c:if>
                    </div>

                    <div class="btn">
                        <input type="submit" value="บันทึก" class="save"/>
                        <input type="button" value="ลบ" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบคำตอบนี้?')))
    { window.location.href='${pageContext.request.contextPath}/afaq/${afaq.afaq_id}/delete';
    return false; }" class="cancel-button"/>
                        <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/afaq/list';
        return false;" class="cancel-button"/>
                    </div>
                </form:form></div>
        </div>
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
    </body></html>