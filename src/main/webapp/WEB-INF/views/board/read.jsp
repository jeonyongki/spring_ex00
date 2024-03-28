<%--
  Created by IntelliJ IDEA.
  User: arin
  Date: 2024-03-19
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Read</h1>
<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
  For more information about DataTables, please visit the <a target="_blank"
                                                             href="https://datatables.net">official DataTables documentation</a>.</p>

<!-- DataTales Example -->
<div class="card shadow mb-4">
  <div class="card-header py-3">
    <h6 class="m-0 font-weight-bold text-primary">Board Read</h6>
  </div>
  <div class="card-body">
    <%--      bno --%>
    <div class="input-group input-group-lg">
      <div class="input-group-prepend">
        <span class="input-group-text">Bno</span>
      </div>
      <input type="text" name="title"class="form-control" value="<c:out value="${vo.bno}"/>" readonly>
    </div>
    <%--      title --%>
    <div class="input-group input-group-lg">
      <div class="input-group-prepend">
        <span class="input-group-text">Title</span>
      </div>
      <input type="text" name="title"class="form-control" value="<c:out value="${vo.title}"/>" readonly>
    </div>
    <%--      content --%>
    <div class="input-group input-group-lg">
      <div class="input-group-prepend">
        <span class="input-group-text">Content</span>
        <textarea class="form-control" name="content" rows="5" cols="200" readonly><c:out value="${vo.content}"/></textarea>
      </div>
    </div>
    <%--      writer --%>
    <div class="input-group input-group-lg">
      <div class="input-group-prepend">
        <span class="input-group-text">Writer</span>
      </div>
      <input type="text" name="writer"class="form-control" value="<c:out value="${vo.writer}"/>"readonly>
    </div>
    <%--      regDate --%>
    <div class="input-group input-group-lg">
      <div class="input-group-prepend">
        <span class="input-group-text">RegDate</span>
      </div>
      <input type="text" name="regDate"class="form-control" value="<c:out value="${vo.regDate}"/>"readonly>
    </div>
    <%--      submit --%>
    <div class="input-group input-group-lg">
      <button class="btn btn-info btnList">LIST</button>
      <button class="btn btn-warning btnModify">MODIFY</button>
    </div>
  </div>
</div>

<form id="actionForm" method="get" action="/board/list">
  <input type="hidden" name="pageNum" value="${cri.pageNum}">
  <input type="hidden" name="amount" value="${cri.amount}">
  <c:if test="${cri.types != null && cri.keyword != null}">
    <c:forEach var="type" items="${cri.types}">
      <input type="hidden" name="types" value="${type}">
    </c:forEach>
    <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
  </c:if>
</form>

<%@ include file="../includes/footer.jsp"%>

<script>

  const actionForm = document.querySelector("#actionForm");
  const bno = "${vo.bno}";

  document.querySelector(".btnList").addEventListener("click",(e) => {
    // window.location = "/board/list";
    actionForm.setAttribute("action","/board/list");
    actionForm.submit();
  }, false);

  document.querySelector(".btnModify").addEventListener("click",(e) => {
    <%--window.location = "/board/modify/${vo.bno}";--%>
    actionForm.setAttribute("action", `/board/modify/${bno}`);
    actionForm.submit();
  }, false);
</script>

<%@ include file="../includes/end.jsp"%>