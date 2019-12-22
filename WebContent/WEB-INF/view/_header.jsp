<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-card" id="myNavbar">
     <c:if test="${not empty user }">
     	<div class="w3-bar-item w3-button">XIN CHÀO ${user.name}!</div>
     </c:if>
	 
    <!-- Right-sided navbar links -->
    <div class="w3-right w3-hide-small">
      <a href="${pageContext.request.contextPath}/home"class="w3-bar-item w3-button">TRANG CHỦ</a>
      <c:choose>
      	<c:when test="${not empty user }">
      		<c:choose>
      			<c:when test="${user.getRole()==1 }">
      				<a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/consultant_home" >CÂU HỎI</a>
      			</c:when>
      			<c:otherwise>
      			    <c:if test="${user.getRole()==3}">
      			    	<a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/admin_home" >QUẢN LÝ</a>
      			    </c:if>
      			    <c:if test="${user.getRole()==0}">
      			    	<a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/member_home" >HOẠT ĐỘNG</a>
      			    </c:if>
      			</c:otherwise>
      		</c:choose>
      		<a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/logout" >ĐĂNG XUẤT</a>
      	</c:when>
      	<c:otherwise>
      		<a class="w3-bar-item w3-button" data-toggle="modal" data-target="#loginModal" >ĐĂNG NHẬP</a>
      	</c:otherwise>
      </c:choose>
    </div>
  </div>
</div>
