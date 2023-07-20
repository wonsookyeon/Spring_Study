<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-07-12
  Time: 오후 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>
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
					<label>Bno</label> <input class="form-control" name="bno"
						value="${board.bno}" readonly="readonly">
				</div>

				<div class="form-group">
					<label>Title</label> <input class="form-control" name="title"
						value="${board.title}" readonly="readonly">
				</div>

				<div class="form-group">
					<label>Content</label> <input class="form-control" name="content"
						value="${board.content}" readonly="readonly">
				</div>

				<button data-oper="modify" class="btn btn-default">Modify</button>
				&nbsp;&nbsp;&nbsp;
				<button data-oper="list" class="btn btn-info">List</button>

				<form action="/board/modify" method="get" id="operForm">
					<input type="hidden" id="bno" value="${board.bno}" name="bno">
					<input type="hidden" id="pageNum" value="${cri.pageNum}"
						name="pageNum"> <input type="hidden" id="amount"
						value="${cri.amount}" name="amount"> <input type="hidden"
						name=type value="${cri.type}"> <input type="hidden"
						name=keyword value="${cri.keyword}">
				</form>

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!-- 댓글처리 -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>Reply
				<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno='12'>
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong>
								<small class="pull-right text-muted">2023-07-20</small>
							</div>
							<p>Good Job!</p>
						</div>
					</li>
				</ul>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- 댓글처리 끝 -->

<!--  Modal Start -->
        <div class="modal" id="myModal">
          <div class="modal-dialog">
            <div class="modal-content">
            
              <!-- Modal Header -->
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
              </div>
              
              <!-- Modal body -->
              <div class="modal-body">
                
                <div class="form-group">
                   <label>Reply</label>
                   <input class="form-control" name=reply value='댓글 내용 입력!'>
                </div>

                <div class="form-group">
                   <label>Replyer</label>
                   <input class="form-control" name=replyer value='작성자 입력!'>
                </div>

                <div class="form-group">
                   <label>Reply Date</label>
                   <input class="form-control" name=replyDate value=''>
                </div>
                
              </div>
              <!-- Modal footer -->
              <div class="modal-footer">
                <button type="button" id='modalModBtn' class="btn btn-warning">수정</button>
                <button type="button" id='modalRemoveBtn' class="btn btn-danger">삭제</button>
                <button type="button" id='modalRegisterBtn' class="btn btn-primary">등록</button>
                <button type="button" id='modalCloseBtn' class="btn btn-default" data-dismiss="modal">닫기</button>
              </div>
            </div>
          </div> 
         </div>           
           <!--  Modal End -->




<%@include file="../includes/footer.jsp"%>

<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>
	//var bnoValue = '${board.bno}';
	
	$(document).ready(function(){
      var bnoValue = '${board.bno}';
      
      var replyUL = $(".chat");
      
      showList(1);
      
      function showList(page){

			replyService.getList({bno : bnoValue, page : page || 1}, function(list){
				var str="";
	            if(list == null || list.length == 0){
	               replyUL.html("");
	               return;
	            }


				for(var i=0, len=list.length || 0; i<len; i++){        //12
					 str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>";  //user00
					 str += "<div><div class='header'><strong class='primary-font'>" + list[i].replyer + "</strong>";
								                                                                //2023-07-20
					 str += "<small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate) +"</small>";
									//Good Job!
					 str += "</div><p>"+list[i].reply+"</p></div></li>";
	            }
	            replyUL.html(str);
	            
	         }); // function end
		} //showList end
		
		var modal = $(".modal");
	    var modalInputReply = modal.find("input[name='reply']");
	    var modalInputReplyer = modal.find("input[name='replyer']");
	    var modalInputReplyDate = modal.find("input[name='replyDate']");
	       
	    var modalModBtn = $("#modalModBtn");
	    var modalRemoveBtn = $("#modalRemoveBtn");
	    var modalRegisterBtn = $("#modalRegisterBtn");
		
		   //ID
		$("#addReplyBtn").on("click", function(){
			
			modal.find("input").val("");
			modalInputReplyDate.closest("div").hide(); // ReplyDate div 숨기기
			modal.find("button[id != 'modalCloseBtn']").hide(); //modalCloseBtn이 아닌것은 숨기기
			
			modalRegisterBtn.show(); // 등록버튼 보여주기
			
			$(".modal").modal("show");
			//modal.modal("show");
			
		}); //Modal Show
		
		$("#modalRegisterBtn").on("click", function(){
			var reply = {
					reply : modalInputReply.val(),
					replyer : modalInputReplyer.val(),
					bno : bnoValue
			};
			
			replyService.add(reply, function(data){
				alert("댓글 등록이 성공했습니다.");
				
				modal.find("input").val("");
				modal.modal("hide");
				
				showList(1); //댓글화면 재생성
			});
		}); //등록
		
		// 댓글수정화면 띄우기
		$(".chat").on("click", "li", function(e){
			var rno = $(this).data("rno");
			//console.log("rno : " + rno);
			
			replyService.get(rno, function(reply){
				modalInputReply.val(reply.reply);
				modalInputReplyer.val(reply.replyer);
				modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
				modal.data("rno", reply.rno);
				
				modal.find("button[id != 'modalCloseBtn']").hide();
				modalModBtn.show();
				modalRemoveBtn.show();
				
				$(".modal").modal("show");
			});
		}); //.chat end
		
		//수정
		modalModBtn.on("click", function(e){
			
			var reply = {
					rno : modal.data("rno"),
					reply : modalInputReply.val()
			};
			
			replyService.update(reply, function(result){
				
				alert("수정 성공");
				modal.modal("hide");
				showList(1);
			});
			
		});
		
		//삭제
		modalRemoveBtn.on("click", function(e){
			
			var rno = modal.data("rno");
			
			replyService.remove(rno, function(result){
				
				alert("삭제 성공");
				modal.modal("hide");
				showList(1);
			});
			
		});
		
		   
		   
		
	});
	
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
			       //
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
/*
	//가져오기
	replyService.get(23, function(data){
		console.log(data);
		alert(data.rno + " " + data.bno + " " + data.reply);
	})
*/	
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

<style>
	.chat>li:hover{ cursor:pointer }
</style>