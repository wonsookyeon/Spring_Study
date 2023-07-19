<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-07-12
  Time: 오후 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Get</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">Board Get</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
          <div class="form-group">
            <label>Bno</label>
            <input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
          </div>

        <div class="form-group">
          <label>Title</label>
          <input class="form-control" name="title" value="${board.title}" readonly="readonly">
        </div>

        <div class="form-group">
          <label>Content</label>
          <input class="form-control" name="content" value="${board.content}" readonly="readonly">
        </div>

        <button data-oper="modify" class="btn btn-default">Modify</button>&nbsp;&nbsp;&nbsp;
        <button data-oper="list" class="btn btn-info">List</button>

        <form action="/board/modify" method="get" id="operForm">
          <input type="hidden" id="bno" value="${board.bno}" name="bno">
          <input type="hidden" id="pageNum" value="${cri.pageNum}" name="pageNum">
          <input type="hidden" id="amount" value="${cri.amount}" name="amount">
          <input type="hidden" name=type value="${cri.type}">
          <input type="hidden" name=keyword value="${cri.keyword}">
        </form>

      </div>
      <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp" %>

<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>
	var bnoValue = '${board.bno}';
/*	//댓글삽입
	replyService.add(   //js의 function add 실행
			{reply:"Js Test", replyer : "tester", bno:bnoValue},
			
			function(result){
				alert("result : " + result);
			}
	);
*/	

/*	//댓글 가져오기
	 replyService.getList({bno:bnoValue}, function(list){
		for(let i=0, len = list.length || 0 ; i<len; i++){
			console.log(list[i]);
		}
	});
*/

/*
	//삭제
	replyService.remove(21, function(data){
		
		if(data === "success")
			alert("Removed");
	},	function(err){
			alert("error");
	});
*/

/*
	//수정
	replyService.update({rno:23, reply:"reply22업데이트"},
		function(data){
			if(data === "success") alert("update 성공");
	});
*/

	//가져오기
	replyService.get(23, function(data){
		console.log(data);
		alert(data.rno + " " + data.bno + " " + data.reply);
	})
	
</script>

<script>
  $(document).ready(function (e){
    var operForm = $("#operForm");

    $("button[data-oper='modify']").on("click",function (){
      operForm.attr("action","/board/modify").submit();
    });
    $("button[data-oper='list']").on("click",function (){
      operForm.find("#bno").remove();
      operForm.attr("action","/board/list").submit();
    });
  });
</script>