<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bot! | Login</title>
<!--===============================================================================================-->	
	<link rel="icon" href="<c:url value='/static/images/MK circle logo.png'/> " type="image/ico" />
<!--===============================================================================================-->
	<link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value='/static/css/font-awesome.min.css'/>" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value='/static/css/animate.css'/>" rel="stylesheet">
<!--===============================================================================================-->	
	<link href="<c:url value='/static/css/hamburgers.min.css'/>" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value='/static/css/util.css'/>" rel="stylesheet">
	<link href="<c:url value='/static/css/main.css'/>" rel="stylesheet">
<!--===============================================================================================-->
</head>
<body>

<s:url value="/login" var="url_login"></s:url>

<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="<c:url value='/static/images/img-01.png'/> " alt="">
				</div>
				

				<f:form action="${url_login}" modelAttribute="command" cssClass="login100-form validate-form">
				<span class="login100-form-title">
				
						<img src="<c:url value='/static/images/MK circle logo.png'/> " width=50 height=50 alt="">Bot! | Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
					
									<c:if test="${param.err eq 'err' }">
				
				<Strong style="color:red;">Invalid Credentials</Strong>

 
				</c:if>
						<f:input path="UserName" cssClass="input100" placeholder="Email" />
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
						
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<f:password path="Password" cssClass="input100" placeholder="Password"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn"><i class="fa fa-sign-in"></i>
							&nbsp; Login
						</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1">
							Forgot
						</span>
						<a class="txt2" href="#">
							Username / Password?
						</a>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="#">
							Create your Account
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				
				</f:form>
					
			</div>
		</div>
	</div>
	
<!--===============================================================================================-->	
	 <script src="<c:url value='/static/js/jquery.min.js' />"></script>
<!--===============================================================================================-->
	<script src="<c:url value='/static/js/popper.js' />"></script>
	<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<!--===============================================================================================-->

<!--===============================================================================================-->
	<script src="<c:url value='/static/js/tilt.jquery.min.js' />"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="<c:url value='/static/js/main.js' />"></script>
</body>
</html>