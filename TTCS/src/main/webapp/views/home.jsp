<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Home</title>
</head>
<body>
	<div class="container mt-2">
		<h2>Danh sách học sinh tất cả học sinh Trung tâm Luyện thi THPTQG</h2>
		<p>năm học 2022-2023</p>
		<div class="row">
			<div class="col-sm-3">
				<ul class="list-group">
					<li class="list-group-item active"><i class="fa fa-bars" aria-hidden="true"></i>  Danh mục chức năng</li>
					<a href="home"><li class="list-group-item"><i class="fa fa-address-book-o" aria-hidden="true"></i>  Danh sách học
							sinh</li></a>
					<a href="addStudent"><li class="list-group-item"><i class="fa fa-plus-square-o" aria-hidden="true"></i> Thêm học
							sinh</li></a>
					<li class="list-group-item"><i class="fa fa-graduation-cap" aria-hidden="true"></i> Quản lí thông tin học sinh
						<ul class="list-group">

							<a href="qldiem?lop=Toán"><li class="list-group-item">Lớp Toán</li></a>
							<a href="qldiem?lop=Lý"><li class="list-group-item">Lớp Lý</li></a>
							<a href="qldiem?lop=Hoá"><li class="list-group-item">Lớp Hoá</li></a>
							<a href="qldiem?lop=Anh"><li class="list-group-item">Lớp Anh</li></a>
						</ul>
					</li>

					<li class="list-group-item"><i class="fa fa-newspaper-o" aria-hidden="true"></i> Quản lí điểm từng lớp
						<ul class="list-group">

							<a href="qltt?lop=Toán"><li class="list-group-item">Lớp Toán</li></a>
							<a href="qltt?lop=Lý"><li class="list-group-item">Lớp Lý</li></a>
							<a href="qltt?lop=Hoá"><li class="list-group-item">Lớp Hoá</li></a>
							<a href="qltt?lop=Anh"><li class="list-group-item">Lớp Anh</li></a>
						</ul>
					</li>
				</ul>
			</div>

			<div class="col-sm-9">

				<div class="row">
					<div class="col-sm-6">
						<form action="home" method="post">
							<div class="input-group mb-3">

								<input class="form-control" name="ten" type="text"
									placeholder="Tìm kiếm..."
									style="width: 250px" />
								<button class="btn btn-success input-group-text" type="submit">
									<i class="fa fa-search" aria-hidden="true"></i>
								</button>
								
							</div>
						</form>
					</div>

					<div class="col-sm-6">

						<form action="homecheck" method="post">
							<div class="input-group">
								<input class="input-group-text" type="submit"
									value="Hiển thị danh sách theo lớp..." /> <select class="form-select"
									name="monhoc" id="selectsubmit">
									<option value="">---</option>
									<option value="Toán">Toán</option>
									<option value="Lý">Lý</option>
									<option value="Hoá">Hóa</option>
									<option value="Anh">Anh</option>
								</select>
							</div>
						</form>

					</div>

				</div>


				<table class="table table-bordered table-striped">
					<thead class="table-info">
						<tr>
							<th>Họ tên</th>
							<th>Ngày sinh</th>
							<th>Trường</th>
							<th>Lớp</th>	
							<th>Điểm trung bình</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="list">
							<tr>
								<td>${list.hoten}</td>
								<td>${list.ngaysinh }</td>
								<td>${list.truong}</td>
								<td>${list.lop}</td>
								<td align="center">${list.dtb}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

	</div>
</body>
</html>

<style>
a {
	text-decoration: none;
}

a>li:hover {
	background-color: #cff4fc;
}

ul {
	list-style-type: none;
}

.list-group-item:hover ul {
	display: block
}

.list-group-item>ul {
	display: none;
}
</style>

<script>
	
</script>