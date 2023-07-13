<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Modify</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Modify Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                        <form action="/board/modify" role="form" method="post">
                        
                            <div class="form-group">
                            	<label>Bno</label>
                            	<input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
                            </div>
                            
                            <div class="form-group">
                            	<label>Title</label>
                            	<input class="form-control" name="title" value="${board.title}">
                            </div>
                            
                            <div class="form-group">
                            	<label>Text Area</label>
                            	<textarea rows="3" name=content class="form-control">${board.content}</textarea>
                            </div>
                            
                            <div class="form-group">
                            	<label>Writer</label>
                            	<input class="form-control" name="Writer" value="${board.writer}" readonly="readonly">
                            </div>
                            
                            <div class="form-group">
                            	<label>RegDate</label>
                            	<input class="form-control" name="regdate" 
                            	value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regdate}"/>'
                            	readonly="readonly">
                            </div>
                            
                            <div class="form-group">
                            	<label>Update Date</label>
                            	<input class="form-control" name="updateDate" 
                            	value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.updateDate}"/>'
                            	readonly="readonly">
                            </div>
                            
                            
                                                  <!-- 값 전송하는 방식 -->
                            <button type="submit" data-oper="modify" class="btn btn-dafault">Modify</button>&nbsp;&nbsp;
                            <button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>&nbsp;&nbsp;
                            <button type="submit" data-oper="list" class="btn btn-info">List</button>
                            
                        </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

 
 <%@ include file="../includes/footer.jsp"%>

<script>
	$(document).ready(function(){
		
		var formObj = $("form");
		
		$("button").on("click", function(e){
			
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === "remove"){
				formObj.attr("action", "/board/remove");
				}else if(operation === "list"){
					//move to list
					formObj.attr("action", "/board/list").attr("method","get");
					formObj.empty(); //get 으로 보내면서 (empty) 비우기 때문에 뒤로가기하면 비워져서 내용 안보임
					
				//	self.location = "/board/list";
				//	return;
				}
				formObj.submit(); //전송
			});
	});

</script>
 
