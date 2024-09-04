<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>

<%@include file="../layouts/header.jsp"%>

<h1 class="page-header my-4"><i class="far fa-file-alt"></i> ${board.title}</h1>

<div class="d-flex justify-content-between">
    <div><i class="fas fa-user"></i> ${board.writer}</div>
    <div>
        <i class="fas fa-clock"></i>
        <fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/>
    </div>
</div>

<div class="text-end">
    <c:forEach var="file" items="${board.attaches}">
        <div class="attach-file-item">
            <a href="/board/download/${file.no}" class="file-link">
                <i class="fa-solid fa-floppy-disk"></i>
                ${file.filename} (%{file.fileSize) <br>
            </a>
        </div>
    </c:forEach>
</div>

<hr>

<div>
    ${board.content}
</div>

<div class="mt-4">
    <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
    <a href="update?no=${board.no}" class="btn btn-primary"><i class="far fa-edit"></i> 수정</a>
    <a href="#" class="btn btn-primary delete"><i class="fas fa-trash-alt"></i> 삭제</a>
</div>

<%--삭제 -> post를 할 숨겨진 form 생성--%>
<form action="delete" method="post" id="deleteForm">
    <input type="hidden" name="no" value="${board.no}"/>
</form>
<%--name: no라는 이름은 서버 측 코드에서 해당 값을 받아 처리할 때 사용됩니다.
예를 들어, 서버에서는 request.getParameter("no")와 같은 방식으로 이 값을 읽을 수 있습니다.
서버로 전송될 때 식별될 이름 --%>
<%--value: 폼 필드의 값
이 필드의 실제 값으로, 서버로 전송될 데이터 --%>
<%--board.no가 123이면 no=123으로 전송--%>

<script src="/resources/js/board.js"></script>

<%@include file="../layouts/footer.jsp"%>