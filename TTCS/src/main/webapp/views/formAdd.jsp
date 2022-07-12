<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Add Student</title>
</head>
<body>
	<div class="container mt-3 p-3"}>
		<a href="home">
			<button type="button" class="btn btn btn-danger">
				<i class="fa fa-arrow-circle-o-left" aria-hidden="true"></i> Quay
				lại
			</button>
		</a>
	</div>

	<div class="container p-3 shadow-lg"
		style="width: 650px; background-color: #E8F2F7; border-radius: 20px">
		<h2 class="text-primary" align="center">Thêm mới học sinh</h2>

		<form action="addStudent" method="post">
			<c:if test="${alert == 1 }">
				<div class="alert alert-danger alert-dismissible fade show">
					<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
					<strong>Xảy ra lỗi!</strong> Trường họ tên, trường, lớp không được để trống
				</div>
			</c:if>
			<c:if test="${alert == 2 }">
				<div class="alert alert-info alert-dismissible fade show">
					<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
					<strong>Thao tác thành công</strong> Tiếp tục thêm mới học sinh
				</div>
			</c:if>
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" placeholder="name"
					name="hoten"> <label>Họ tên</label>
			</div>
			<div class="row">
				<div class="col">
					<div class="form-floating mb-3 mt-3">		
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" placeholder="school" name="school"> <label>Trường</label>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="form-floating mb-3 mt-3">
						<input type="text" class="form-control" placeholder="ngaysinh" name="ngaysinh"> <label>Ngày sinh</label>
					</div>
				</div>
			</div>


			<div class="mb-3 mt-3 d-flex justify-content-around">
				<div>
					<label class="form-label">Lớp</label>
				</div>
				<div class="">
					<select class="form-select form-control" name="lop"
						style="width: 100px">
						<option value="">---</option>
						<option value="Toán">Toán</option>
						<option value="Lý">Lý</option>
						<option value="Hoá">Hoá</option>
						<option value="Anh">Anh</option>
					</select>
				</div>
				<div>
					<input type="text" class="form-control" placeholder="Điểm thứ 1"
						value="0" name="d1" style="width: 120px">
				</div>
				<div>
					<input type="text" class="form-control" placeholder="Điểm thứ 2	"
						value="0" name="d2" style="width: 120px">
				</div>
				<div>
					<input type="text" class="form-control" placeholder="Điểm thứ 3	"
						value="0" name="d3" style="width: 120px">
				</div>
			</div>

			<div align="right">
				
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember" <c:if test="${alert==2 }"> checked</c:if>
					style="margin-left: 50px"> Thêm liên tục
				</label>
				<label class="form-check-label"> <input
					class="form-check-input" type="hidden" name="remember" value="none" 
					style="margin-left: 50px">
				</label>
				<button type="reset" class="btn btn-warning">
					Reload <i class="fa fa-refresh" aria-hidden="true"></i>
				</button>
				<button type="submit" class="btn btn-primary ">
					Thêm <i class="fa fa-plus" aria-hidden="true"></i>
				</button>
			</div>
		</form>
	</div>
</body>
</html>
<style>
body {
	background-color: #A9DBF4;
}

.btn {
	border-radius: 20px;
	border: 1px solid white;
}
.form-control{
	border-radius : 20px;
}
</style>