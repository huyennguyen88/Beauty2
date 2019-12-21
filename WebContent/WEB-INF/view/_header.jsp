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
      <a href="#about" class="w3-bar-item w3-button">GIỚI THIỆU</a>
      <c:choose>
      	<c:when test="${not empty user }">
      		<a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/logout" >ĐĂNG XUẤT</a>
      	</c:when>
      	<c:otherwise>
      		<a class="w3-bar-item w3-button" data-toggle="modal" data-target="#loginModal" >ĐĂNG NHẬP</a>
      	</c:otherwise>
      </c:choose>
      

    </div>
  </div>
</div>
