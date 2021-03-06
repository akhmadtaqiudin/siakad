<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SIAKAD</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/library/css/bootstrap.min.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/library/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/library/js/bootstrap.min.js" ></script>
<style type="text/css">
	body,html {
        height: 100%;
        margin:0px;
        background-repeat: no-repeat;
        background-image: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));
    }
    .card-container.card {
        max-width: 37%;
	    padding: 40px 40px;
	    border-radius: 10px;
	    margin-top: 95px;
    }
	.btn {
        font-weight: 700;
        height: 36px;
        -moz-user-select: none;
        -webkit-user-select: none;
        user-select: none;
        cursor: default;
    }
    .card {
        background-color: #F7F7F7;
        /* just in case there no content*/
        padding: 20px 25px 30px;
        margin: 0 auto 25px;
        margin-top: 50px;
        /* shadows and rounded borders */
        -moz-border-radius: 2px;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
      }
      .profile-img-card {
        width: 96px;
        height: 96px;
        margin: 0 auto 10px;
        display: block;
        -moz-border-radius: 50%;
        -webkit-border-radius: 50%;
        border-radius: 50%;
      }
      .profile-name-card {
        font-size: 16px;
        font-weight: bold;
        text-align: center;
        margin: 10px 0 0;
        min-height: 1em;
      }
      .reauth-user {
        display: block;
        color: #404040;
        line-height: 2;
        margin-bottom: 10px;
        font-size: 14px;
        text-align: center;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
      }
      .form-signin #inputUser,
      .form-signin #level,
      .form-signin #inputPassword {
        direction: ltr;
	    height: 35px;
	    font-size: 16px;
	    width: 157%;
      }
      .form-signin input[type=password],
      .form-signin input[type=text],
      .form-signin button {
        width: 100%;
        display: block;
        margin-bottom: 10px;
        z-index: 1;
        position: relative;
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
      }
      .form-signin input[type=submit].btn-block {
		  width: 157%;
		  margin-top: 39px;
	  }
      .form-signin .form-control:focus {
        border-color: rgb(104, 145, 162);
        outline: 0;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgb(104, 145, 162);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgb(104, 145, 162);
      }
      .btn.btn-signin {
        /*background-color: #4d90fe; */
        background-color: rgb(104, 145, 162);
        /* background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
        padding: 0px;
        font-weight: 700;
        font-size: 14px;
        height: 36px;
        -moz-border-radius: 3px;
        -webkit-border-radius: 3px;
        border-radius: 3px;
        border: none;
        -o-transition: all 0.218s;
        -moz-transition: all 0.218s;
        -webkit-transition: all 0.218s;
        transition: all 0.218s;
      }
      .btn.btn-signin:hover,
      .btn.btn-signin:active,
      .btn.btn-signin:focus {
        background-color: rgb(12, 97, 33);
      }
      .forgot-password {
        color: rgb(104, 145, 162);
      }
      .forgot-password:hover,
      .forgot-password:active,
      .forgot-password:focus {
        color: rgb(12, 97, 33);
      }
      .errors li{
		list-style: none;
		font-size: 12px;
	    background-color: #FFCCCC;
	    border: 1px solid #CC0000;
	    width: 98%;
	    border-radius: 7px;
	    padding: 5px;
	}
</style>
</head>
<body>
	<div class="container">
    	<div class="card card-container">
        	<div class="errors">
            	<s:fielderror name="invalid"/>
            </div>
	        <img id="profile-img" class="profile-img-card" src="${pageContext.request.contextPath}/library/images/avatar_2x.png" />
	        <p id="profile-name" class="profile-name-card"></p>
	        <s:form namespace="/authentication" action="auth" validate="true" method="post" cssClass="form-signin">
	        	<span id="reauth-user" class="reauth-user"></span>
	        	<s:textfield name="userName" cssClass="form-control" id="inputUser" required="true" placeholder="username" />
				<s:password name="password" cssClass="form-control" id="inputPassword" required="true" placeholder="password" />
				<s:select list="#{'admin':'Administrator','guru':'Guru','siswa':'Siswa'}" name="hakAkses" required="true" id="level"/>
				<s:submit cssClass="btn btn-lg btn-primary btn-block btn-signin" value="Sign in"/>
	        </s:form>
        </div>
      <!-- /card-container -->
    </div>
</body>
</html>