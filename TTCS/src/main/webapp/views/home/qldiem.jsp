<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách lớp ${nameClass }</title>
</head>
<body>
<div class="container mt-3"}>
		<a href="home">
			
				<i class="fa fa-arrow-circle-o-left" aria-hidden="true"></i> Quay
				lại
			
		</a>
	</div>

	<div class="container mt-3 shadow-lg p-3 mb-5 bg-white"
		style="background-color: white; padding: 20px 10px 20px 10px; border-radius: 20px; border : 1px solid black">
		
		<h2>Quản lí thông tin học sinh lớp ${nameClass } </h2>
		<p>Năm học 2021-2022</p>
		<div align="left"><input class="form-control" id="myInput" type="text" placeholder="Tìm kiếm ..." style="width: 250px; margin-bottom: 5px"></div>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Họ tên</th>
					<th>Ngày sinh</th>
					<th>Trường</th>
					<th>Lớp</th>
					<th align="center">Chỉnh sửa</th>
				</tr>
			</thead>
			<tbody id="myTable">
				<c:forEach var="list" items="${listDiem }">
					<tr>
						<td>${list.hoten }</td>
						<td>${list.ngaysinh }</td>
						<td>${list.truong }</td>
						<td>${list.lop }</td>
						<td align="center">
							<button type="button" class="btn btn-info">
								<a href="qldiem?action=FormUpdate&id=${list.id }"><i
									class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
							</button>
							<button type="button" class="btn btn-danger	"
								data-bs-toggle="modal" data-bs-target="#delete-${list.id }">
								<i class="fa fa-trash-o" aria-hidden="true"></i>
							</button>
							
							
							
							 <!-- The Modal -->
							<div class="modal fade" id="delete-${list.id }">
								<div class="modal-dialog">
									<div class="modal-content">

										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title">Bạn chắc chắn xoá?</h4>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal"></button>
										</div>

										<!-- Modal body -->
										<div class="modal-body"><h6 class="text-primary">${list.hoten } - ${list.ngaysinh } - ${list.truong }</h6></div>

										<!-- Modal footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger">
											<a href="qldiem?action=delete&id=${list.id }&lop=${nameClass}"><i class="fa fa-trash-o" aria-hidden="true"></i> Xoá</a>
											</button>
										</div>

									</div>
								</div>
							</div>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
<style>
a {
	text-decoration: none;
	color: white;
}

a:hover {
	color: white;
}

body {
	background-color: #BFFDE8;
}
</style>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>