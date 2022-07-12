<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form sửa thông tin</title>
</head>
<body>

<div class="container mt-3 p-4 shadow-lg" style="width:550px; border : 2px solid yellow; border-radius:20px; background-color: #EEEDE7">
  <h2 class="text-warning" align="center">Form sửa thông tin</h2>
  <form action="qldiem" method="get">
  	<input type="hidden" value="handlerUpdateinfo" name="action" />
  	<input type="hidden"  value="${ModelUpdate.id }" name="id" />
  	<input type="hidden" value="${ModelUpdate.lop }" name="lop" />
  	
    <div class="form-floating mb-3 mt-3">
      <input type="text" class="form-control" placeholder="Nhập họ tên..." name="hoten" value="${ModelUpdate.hoten }">
      <label>Họ tên</label>
    </div>
    <div class="form-floating mb-3 mt-3">
      <input type="text" class="form-control" placeholder="Nhập ngày sinh ..." name="ngaysinh" value="${ModelUpdate.ngaysinh }">
      <label>Ngày sinh</label>
    </div>
    <div class="form-floating mt-3 mb-3">
      <input type="text" class="form-control" placeholder="Nhập tên trường... " name="truong" value="${ModelUpdate.truong	 }">
      <label>Trường</label>
    </div>
    <div align="center">
    <button type="reset" class="btn btn-warning">Reload <i class="fa fa-refresh" aria-hidden="true"></i></button>
    <button type="submit" class="btn btn-warning"> <span class="spinner-grow spinner-grow-sm"></span> Xác nhận</button>
    </div>
  </form>
</div>

</body>
</html>
<style>
	body{
		background-color : #7281CA;
	}
	.form-control{
		border-radius:20px;
	}
</style>