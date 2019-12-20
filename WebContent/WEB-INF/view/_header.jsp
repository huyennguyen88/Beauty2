<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-card" id="myNavbar">

    <a href="#home" class="w3-bar-item w3-button w3-wide">LOGO</a>
    <!-- Right-sided navbar links -->
    <div class="w3-right w3-hide-small">
      <a href="${pageContext.request.contextPath}/home"class="w3-bar-item w3-button">TRANG CHỦ</a>
      <a href= "${pageContext.request.contextPath}/askform" class="w3-bar-item w3-button">HỎI ĐÁP</a>
      <a href="#about" class="w3-bar-item w3-button">GIỚI THIỆU</a>
      <c:choose>
      	<c:when test="${not empty user }">
      		<button class="w3-bar-item w3-button"  >Đăng xuất</button>
      	</c:when>
      	<c:otherwise>
      		<button class="w3-bar-item w3-button" data-toggle="modal" data-target="#loginModal" >Đăng nhập</button>
      	</c:otherwise>
      </c:choose>
      

    </div>
  </div>
</div>
