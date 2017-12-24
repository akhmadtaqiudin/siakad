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
	          <h3 class="page-header">Ubah Data Guru</h3>	
	          <div class="errors">
				 <s:fielderror name="invalidguru"/>
			  </div>
				<s:form namespace="/guru" method="POST" theme="bootstrap" cssClass="form-horizontal">
				  	<s:textfield name="guru.nip" label="NIP " labelSeparator=":" readonly="true" />
				  	<s:textfield name="guru.namaGuru" label="Nama Guru " labelSeparator=":" />
				  	<s:textfield name="guru.jenisKelamin" label="Jenis Kelamin " labelSeparator=":"/>
				  	<s:textfield name="guru.pendidikanTerakhir" label="Pendidikan Terakhir " labelSeparator=":" />
				  	<s:textfield name="guru.tempatLahir" label="Tempat Lahir " labelSeparator=":" />
				  	<s:textfield name="guru.tanggalLahir" label="Tanggal Lahir " labelSeparator=":"/>
				  	<s:textfield name="guru.noTlp" label="No Telephon " labelSeparator=":" />
				  	<s:textarea name="guru.alamat" label="Alamat " labelSeparator=":" />
					<hr>
				  	<div class="footer">
						<s:submit action="SearchGuru" value="Cansel" cssClass="btn btn-default"/>
						<s:submit action="SaveEditGuru" value="Edit" cssClass="btn btn-primary"/>
					</div>
				</s:form>
		    </div>      
        	</div>
		</div>
	</body>
</html>
