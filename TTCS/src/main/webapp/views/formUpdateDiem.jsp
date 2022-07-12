<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form sửa điểm học sinh</title>
</head>
<body>
	<div class="container mt-3 p-4 shadow-lg"
		style="width: 750px; border: 2px solid yellow; border-radius: 20px; background-color: #EEEDE7">
		<h2 class="text-warning" align="center">Form sửa điểm học sinh</h2>
		<form action="qltt" method="get">
			<input type="hidden" value="handlerUpdateinfo" name="action" /> <input
				type="hidden" value="${ModelUpdate.id }" name="id" /> <input
				type="hidden" value="${ModelUpdate.lop }" name="lop" />
			
			<div class="row mt-3">
				<div class="col">
				<input type="text" class="form-control" name="hoten"
					value="${ModelUpdate.hoten }" disabled>
				</div>
				<div class="col">
				<input type="text" class="form-control" name="ngaysinh"
					value="${ModelUpdate.ngaysinh }" disabled>
				</div>
				<div class="col">
				<input type="text" class="form-control" name="truong"
					value="${ModelUpdate.truong }" disabled>
				</div>
			</div>

			<div class="row  mb-3 mt-3">
				<div class="col">
					<div class="form-floating">
						<input type="text" class="form-control" placeholder="Điểm số 1"
							name="d1" value="${ModelUpdate.diem1 }"> <label>Điểm
							số 1</label>
					</div>
				</div>
				<div class="col">
					<div class="form-floating">
						<input type="text" class="form-control" placeholder="Điểm số 2"
							name="d2" value="${ModelUpdate.diem2 }"> <label>Điểm
							số 2</label>
					</div>

				</div>
				<div class="col">
					<div class="form-floating">
						<input type="text" class="form-control" placeholder="Điểm số 3"
							name="d3" value="${ModelUpdate.diem3 }"> <label>Điểm
							số 3</label>
					</div>
				</div>
			</div>
			<div align="right">
				<button type="reset" class="btn btn-warning">
					Reload <i class="fa fa-refresh" aria-hidden="true"></i>
				</button>
				<button type="submit" class="btn btn-warning">
					<span class="spinner-grow spinner-grow-sm"></span> Xác nhận
				</button>
			</div>
		</form>
	</div>
</body>
</html>
<style>
body {
	background-color: #7281CA;
}

.form-control {
	border-radius: 20px;
}
</style>