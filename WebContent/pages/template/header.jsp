<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SIAKAD</title>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/library/css/bootstrap.min.css"/>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/library/css/bootstrap-old.css"/>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/library/css/jquery-ui.css"/> 
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/library/css/style.min.css"/>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/library/css/custom.css"/>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/library/js/jquery-3.1.0.min.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/library/js/jquery-ui.js"></script> 
	    <script type="text/javascript" src="${pageContext.request.contextPath}/library/js/jstree.min.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/library/js/bootstrap.min.js" ></script>
	</head>
	<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
	   <div class="container">
	      <div class="navbar-header">
	         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	         <span class="sr-only">Toggle navigation</span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	         </button>
	         <a class="navbar-brand">SIAKAD</a>
	       </div>
	       <div id="navbar" class="navbar-collapse collapse">
	         <ul class="nav navbar-nav navbar-right">
	           <li>
	            <a class="navbar-right usr" href="${pageContext.request.contextPath}/authentication/logout.action">
		          <span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;<s:property value="#session['userName'].userName" /> Logout
		        </a>
	          </li>
	         </ul>
	       </div>
	    </div>
	 </div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
	    	   <ul class="nav nav-sidebar">
		           <li class="active"><a href="${pageContext.request.contextPath}/authentication/Welcome.action">Menu <span class="sr-only">(current)</span></a></li>
		           <li><a href="${pageContext.request.contextPath}/guru/SearchGuru.action">Guru</a></li>
		           <li><a href="${pageContext.request.contextPath}/siswa/SearchSiswa.action">Siswa</a></li>
		           <li><a href="${pageContext.request.contextPath}/mapel/SearchMapel.action">Mata Pelajaran</a></li>
		           <li><a href="${pageContext.request.contextPath}/nilai/SearchNilai.action">Nilai</a></li>
		           <li><a href="${pageContext.request.contextPath}/nilai/SearchRaport.action">Raport</a></li>
		       </ul>
		    </div>
		</div>
	</div>
	</body>
</html>