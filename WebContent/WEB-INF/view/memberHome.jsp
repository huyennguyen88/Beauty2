<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Khai báo sử dụng JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BeautyZone</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Fira+Sans:400,500,600,700&display=swap&subset=vietnamese" rel="stylesheet"> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" integrity="sha384-KA6wR/X5RY4zFAHpv/CnoG2UW1uogYfdnP67Uv7eULvTveboZJg0qUpmJZb5VqzN" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/2512851989.js" crossorigin="anonymous"></script>

<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Fira Sans", sans-serif}

body, html {
  height: 100%;
  line-height: 1.8;
}
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("<%=request.getContextPath()%>/images/tomato.jpg");
  height: 500px;
}

.w3-bar .w3-button {
  padding: 16px;
}
</style>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container " id="home">
  <div class="w3-display-left w3-text-dark-grey" style="padding:48px">
    <span class="w3-jumbo w3-hide-small">My Activity</span><br>
    <span class="w3-xxlarge w3-hide-large w3-hide-medium">Start something that matters</span><br>
    <span class="w3-large">Stop wasting valuable time with projects that just isn't you.</span>
  </div> 
  <div class="w3-display-bottomleft w3-text-grey w3-large" style="padding:24px 48px">
    <i class="fab fa-facebook-square w3-hover-opacity"></i>
    <i class="fab fa-instagram w3-hover-opacity"></i>
    <i class="fab fa-twitter w3-hover-opacity"></i>
    <i class="fab fa-youtube w3-hover-opacity"></i>
  </div>
</header>
<p class="h2 text-center text-danger mt-4">Hoạt động của tôi:</p>
<div class= "container">
	<p class="h3 text-success">Câu hỏi đã trả lời</p>
	<ul class="list-unstyled">
		<c:forEach items="${doneList}" var="a">			
			<li>
				<div class="card my-2">
				  <div class="card-header h4">
				      ${a.title}
				  </div>
				  <div class="card-body">
				    <h5 class="card-title">Hỏi:</h5>
				    <small class="form-text text-muted">
						<fmt:formatDate type="both"  value="${a.askdate}"/>
				    </small>
				    <p class="card-text">${a.question_content}</p>
				    <h5 class="card-title">Trả lời:</h5>
				    <small class="form-text text-muted">
						<fmt:formatDate type="both"  value="${a.ansdate}"/>
				    </small>
				    <p class="card-text">${a.answer_content}</p>
				  </div>
				</div>				
			<li/>
	 	</c:forEach>
	</ul>
	
	<p class="h3 text-warning mt-4">Câu hỏi chưa được trả lời</p>
	<ul class="list-unstyled">
		<c:forEach items="${penList}" var="a">
		<li>
			<div class="card my-2">
			  <div class="card-header h4">
			      ${a.title}
			  </div>
			  <div class="card-body">
			    <small class="form-text text-muted">
					<fmt:formatDate type="both"  value="${a.created_at}"/>
			    </small>
			    <p class="card-text">${a.content}</p>
			  </div>
			</div>				
		<li/>
	 	</c:forEach>
	</ul>

</div>

<jsp:include page="_footer.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>