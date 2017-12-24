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
	          <h3 class="page-header">Tambah Data Nilai Siswa</h3>	
	       		<s:action namespace="/siswa" name="Search" id="sa"/>
				<s:action namespace="/mapel" name="Search" id="mp"/>
				<s:form namespace="/nilai" method="POST" theme="bootstrap" cssClass="form-horizontal">
					<s:select list="#sa.listSiswa" listKey="namaSiswa" listValue="namaSiswa" headerKey="0" 
						headerValue="== Pilih Nama Siswa ==" name="nilai.namaSiswa" label="Nama Siswa " labelSeparator=":" />
					<s:select list="#mp.listMapel" listKey="namaMapel" listValue="namaMapel" headerKey="0" 
						headerValue="== Pilih Nama Pelajaran ==" name="nilai.namaMapel" label="Nama Pelajaran " labelSeparator=":" />
				  	<s:textfield name="nilai.nilaiSiswa" label="Nilai " labelSeparator=":"/>
				  	<hr>
				  	<div class="footer">
						<s:submit action="SearchNilai" value="Cansel" cssClass="btn btn-default"/>
						<s:submit action="SaveNilai" value="Save" cssClass="btn btn-primary"/>
					</div>
				</s:form>
		    </div>      
        	</div>
		</div>
	</body>
</html>
