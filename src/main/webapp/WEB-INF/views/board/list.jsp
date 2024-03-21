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
<h1 class="h3 mb-2 text-gray-800">Tables</h1>
<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
  For more information about DataTables, please visit the <a target="_blank"
                                                             href="https://datatables.net">official DataTables documentation</a>.</p>

<!-- DataTales Example -->
<div class="card shadow mb-4">
  <div class="card-header py-3">
    <h6 class="m-0 font-weight-bold text-primary">DataTables Example<br>${cri}</h6>
  </div>
  <div class="card-body">
    <div class="table-responsive">
      <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
          <th>Bno</th>
          <th>Title</th>
          <th>Writer</th>
          <th>RegDate</th>
          <th>UpdateDate</th>
        </tr>
        </thead>
        <tbody class="tbody">
        <c:forEach var="board" items="${list}">
          <tr data-bno="${board.bno}">
            <td><c:out value="${board.bno}"/></td>
            <td><c:out value="${board.title}"/></td>
            <td><c:out value="${board.writer}"/></td>
            <td><c:out value="${board.regDate}"/></td>
            <td><c:out value="${board.updateDate}"/></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <div>
        <ul class="pagination">
          <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Previous</a>
          </li>
          <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item active">
            <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
          </li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item">
            <a class="page-link" href="#">Next</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</div>
<%-- modal --%>
<div id="myModal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>정상적으로 처리되었습니다.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<%@ include file="../includes/footer.jsp"%>
<script>
  const result = '${bno}';

  const myModal = new bootstrap.Modal(document.getElementById('myModal'));
  console.log(myModal);

  if(result){
    myModal.show();
  }

  document.querySelector(".tbody").addEventListener("click", (evt) => {
    const target = evt.target.closest("tr");
    const bno = target.dataset.bno;
    console.log(bno);
    console.log(`/board/read/\${bno}`);//역슬래시로 템플릿리터럴 중복방지.
    window.location=`/board/read/\${bno}`;
  },false);
</script>
<%@ include file="../includes/end.jsp"%>