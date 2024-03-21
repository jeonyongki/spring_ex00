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
<h1 class="h3 mb-2 text-gray-800">Register</h1>
<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
  For more information about DataTables, please visit the <a target="_blank"
                                                             href="https://datatables.net">official DataTables documentation</a>.</p>

<!-- DataTales Example -->
<div class="card shadow mb-4">
  <div class="card-header py-3">
    <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
  </div>
  <div class="card-body">
    <form method="post" action="/board/register" name="rform">
<%--      title --%>
      <div class="input-group input-group-lg">
        <div class="input-group-prepend">
          <span class="input-group-text">Title</span>
        </div>
        <input type="text" name="title"class="form-control">
      </div>
<%--      content --%>
  <div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text">Content</span>
    <textarea class="form-control" name="content" rows="5" cols="200"></textarea>
  </div>
  </div>
<%--      writer --%>
  <div class="input-group input-group-lg">
    <div class="input-group-prepend">
      <span class="input-group-text">Writer</span>
    </div>
    <input type="text" name="writer"class="form-control">
  </div>
<%--      submit --%>
  <div class="input-group input-group-lg">
    <input class="btn btn-primary" type="submit" value="Submit">
  </div>
    </form>
  </div>
</div>

<%@ include file="../includes/footer.jsp"%>

<script>
  const name = 'AAA';
</script>

<%@ include file="../includes/end.jsp"%>