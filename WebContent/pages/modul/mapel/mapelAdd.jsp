<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/pages/template/header.jsp"></jsp:include>
<title>SIAKAD</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">			
	        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	          <h3 class="page-header">Tambah Data Pelajaran</h3>	
	          <div class="errors">
				 <s:fielderror name="invalidguru"/>
			  </div>
				<s:form namespace="/mapel" method="POST" theme="bootstrap" cssClass="form-horizontal">
				  	<s:textfield name="mapel.namaMapel" label="Nama Pelajaran " labelSeparator=":"/>
				  	<s:textfield name="mapel.tahunAjaran" label="Tahun Ajaran " labelSeparator=":" />
				  	<hr>
				  	<div class="footer">
						<s:submit action="SearchMapel" value="Cansel" cssClass="btn btn-default"/>
						<s:submit action="SaveMapel" value="Save" cssClass="btn btn-primary"/>
					</div>
				</s:form>
		    </div>      
        	</div>
		</div>
	</body>
</html>
