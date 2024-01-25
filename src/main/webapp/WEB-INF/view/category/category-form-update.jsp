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
        <form action="${pageContext.request.contextPath}/category/update" method="POST">
          <div class="txt_field">
            <p class="ct">คำตอบ:**</p>
          </div>
          <div class="btn">
            <input type="submit" value="บันทึก" class="save"/>
          </div>
          <div class="btn">
            <input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/update-page';
        return false;" class="cancel-button"/>
          </div>
        </form></div>
    </div>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
  </body></html>