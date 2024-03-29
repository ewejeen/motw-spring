<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/user/signIn.css" media="all" />
<title>#MOTW :: Sign In</title>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>

<script src="${pageContext.request.contextPath }/resources/js/rsa/jsbn.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/rsa/rsa.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/rsa/prng4.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/rsa/rng.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/rememberMe.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/signInFn.js"></script>
<script>
	if(${sessionId ne null }){
		alert('You are already signed in.');
		history.go(-1);	
	}

	function enterkey() {
		if (window.event.keyCode == 13) {
			validateEncryptedForm();
		}
	}
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/header.jsp" />
		
		<script>
			$('document').ready(function(){
				$('.header').hide();		
			});
		</script>
		
		<div class="signIn">
			<div class="signInForm">
				<ul>
				    <li class="top">
                        <img src="${pageContext.request.contextPath }/resources/img/logo_v3.png" alt="logo">
				        <h1>Sign In</h1>    
				    </li>
					
					<li>
                        <span>Username</span> 
                        <a class="fg" href="nameFind.jsp">Forgot username?</a>
                        <input type="text" name="username" id="username" onkeyup="enterkey()">
					</li>
					<li>
                        <span>Password</span> 
                        <a class="fg" href="pwFind.jsp">Forgot password?</a> 
				        <input type="password" name="userPw" id="userPw" onkeyup="enterkey()">
				        <input type="hidden" id="rsaPublicKeyModulus" value="<%=request.getAttribute("publicKeyModulus")%>" />
          				<input type="hidden" id="rsaPublicKeyExponent" value="<%=request.getAttribute("publicKeyExponent")%>" />
					</li>
					<li>
                        <input type="checkbox" name="autoIn" id="autoIn"/>
                        <p>Remember me</p>
                    </li>
                    <li>
                        <input type="button" value="Sign in" onclick="validateEncryptedForm()" />
                    </li>
					<span class="noacc">Don't have an account? <a class="noacc" href="signUp">Sign up now!</a></span>
				</ul>
			</div>
			
			
			<div id="google_id_login" style="text-align: center">
				<a href="${google_url}">구글 로그인</a>
			</div>
			
			<form id="signInFormRSA" name="signInFormRSA" action="signIn.mo" method="post">
	            <input type="hidden" name="securedName" id="securedName" value="" />
	            <input type="hidden" name="securedPw" id="securedPw" value="" />
	        </form>
		</div>
	</div>
</body>
</html>
