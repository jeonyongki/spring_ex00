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
    <h6 class="m-0 font-weight-bold text-primary">DataTables Example<br></h6>
  </div>
  <div class="card-body">
    <div class="table-responsive">
      <form id="actionForm" method="get" action="/board/list">
        <input type="hidden" name="pageNum" value="${cri.pageNum}">
        <input type="hidden" name="amount" value="${cri.amount}">
      </form>
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
          <c:if test="${pageMaker.prev}">
          <li class="page-item">
            <a class="page-link" href="${pageMaker.beginPage -1}" tabindex="-1">Previous</a>
          </li>
          </c:if>
          <c:forEach begin="${pageMaker.beginPage}" end="${pageMaker.endPage}" var="num">
          <li class="page-item ${cri.pageNum == num ? 'active' : ''} ">
            <a class="page-link" href="${num}">${num} </a>
          </li>
          </c:forEach>
          <c:if test="${pageMaker.next}">
          <li class="page-item">
            <a class="page-link" href="${pageMaker.endPage +1}">Next</a>
          </li>
          </c:if>
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

  const actionForm = document.querySelector("#actionForm");
  //게시글 조회
  document.querySelector(".tbody").addEventListener("click", (evt) => {
    const target = evt.target.closest("tr");
    const bno = target.dataset.bno;
    console.log(bno);
    // console.log(`/board/read/\${bno}`);//역슬래시로 템플릿리터럴 중복방지.
    // window.location=`/board/read/\${bno}`; //정적 처리

    const before = document.querySelector("#clonedActionForm");
    if(before) before.remove();

    //폼전송 clone 처리
    const clonedActionForm = actionForm.cloneNode(true);
    clonedActionForm.setAttribute("action", `/board/read/\${bno}`);
    clonedActionForm.setAttribute("id", 'clonedActionForm');
    console.log(clonedActionForm);
    document.body.appendChild(clonedActionForm);
    clonedActionForm.submit();
  },false);

  //페이지 조회
  document.querySelector(".pagination").addEventListener("click", evt => {
    evt.preventDefault();
    const target = evt.target;
    console.log(target);
    const targetPage = target.getAttribute("href");
    console.log(targetPage);

    //window.location=`/board/list?pageNum=\${targetPage}`; //정적인 방법
    //동적인 방법
    actionForm.setAttribute("action", "/board/list");
    actionForm.querySelector("input[name='pageNum']").value = targetPage;
    actionForm.submit();
  },false)

</script>
<%@ include file="../includes/end.jsp"%>