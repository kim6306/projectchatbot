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
      <div id="container"><i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน(*) หมายถึงห้ามว่าง</i><br/><br>
        <form:form action="${pageContext.request.contextPath}/category/save" modelAttribute="category" method="POST">
          <form:hidden path="id"/>
          <div class="txt_field">
            <p class="ct">คำตอบ:**<form:input path="catetext"/><form:errors path="catetext" cssClass="error"/></p>
          </div>
          <div class="btn">
            <input type="submit" value="บันทึก" class="save"/>
            <input type="button" value="ลบ" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบคำตอบนี้?')))
        { window.location.href='${pageContext.request.contextPath}/category/${category.id}/delete';
        return false; }"class="cancel-button"/>
          </div>
          <div class="btn">
            <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/category/list';
        return false;" class="cancel-button"/>
          </div>
        </form:form></div>
    </div>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
  </body></html>