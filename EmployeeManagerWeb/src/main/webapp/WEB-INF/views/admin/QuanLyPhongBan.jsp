
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Phòng ban</title>
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css"/>'>
    <script type="text/javascript" src='<c:url value="/resources/js/jquery-3.7.1.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js"/>'></script>
    <style type="text/css">
        .custom-width {
            width: 5%;
            position: relative;
            left: 20px;
        }

        .search {
            position: relative;
            left: 20px;
        }

        .legend {
            position: relative;
            left: 20px;
            bottom: 5px;
        }
    </style>
</head>
<body>
<c:url value="/admin/phongban/them" var="urlSave"/>
<c:url value="/admin/phongban/sua" var="urlUpdate"/>
<c:url value="/admin/phongban/xoa" var="urlDelete"/>
<div style="text-align: center; position: relative; top: 10px">
    <h2>Quản lý thông tin phòng ban</h2>
</div>
<div class="container-fluid">
    <div style="width: 100%; text-align: right; padding-bottom: 5px;">
        <a class="btn btn-primary" href="${urlSave}">Thêm mới</a>
    </div>
    <table class="table table-striped table-bordered">
        <tr>
            <th>Mã phòng</th>
            <th>Tên phòng</th>
            <th>Điện thoại</th>
            <th style="width:40px;"></th>
            <th style="width:40px;"></th>
        </tr>
        <c:if test="${not empty lstPhongBan}">
            <c:forEach var="pb" items="${lstPhongBan}">
                <tr>
                    <td>${pb.maPhong}</td>
                    <td>${pb.tenPhong}</td>
                    <td></td>
                    <td> <a class="btn btn-primary" href="${urlUpdate}/${pb.maPhong}">Sửa</a></td>
                    <td> <a class="btn btn-danger" href="${urlDelete}/${pb.maPhong}" onclick="return confirm('Bạn có chắc chắn muốn xóa thông tin này ?');">Xóa</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
</html>
