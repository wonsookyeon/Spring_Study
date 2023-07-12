<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Register</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Register
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            
                            <div class="form-group">
                            	<label>Bno</label>
                            	<input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
                            </div>
                            
                            <div class="form-group">
                            	<label>title</label>
                            	<input class="form-control" name="title" value="${board.title}">
                            </div>
                            
                            <div class="form-group">
                            	<label>content</label>
                            	<input class="form-control" name="content" value="${board.content}">
                            </div>
                            
                            <button data-oper="modify" class="btn btn-dafault"
                            onclick="location.href='/board/modify?bno=${board.bno}'">modify</button>
                            
                            <button data-oper="list" class="btn btn-info"
                            onclick="location.href='/board/list'">List</button>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

 
 <%@ include file="../includes/footer.jsp"%>
 
