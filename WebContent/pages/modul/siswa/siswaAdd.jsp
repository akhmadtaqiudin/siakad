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
	          <h3 class="page-header">Tambah Data Siswa</h3>	
	          <s:form namespace="/siswa" method="POST" theme="bootstrap" cssClass="form-horizontal">
				  	<s:textfield name="siswa.namaSiswa" label="Nama Siswa " labelSeparator=":"/>
				  	<s:textfield name="siswa.jenisKelamin" label="Jenis Kelamin " labelSeparator=":" />
				  	<s:textfield name="siswa.kelas" label="Kelas " labelSeparator=":"/>
				  	<s:textfield name="siswa.jurusan" label="Jurusan " labelSeparator=":" />
				  	<s:textfield name="siswa.tempatLahirSiswa" label="Tempat Lahir " labelSeparator=":"/>
				  	<s:textfield name="siswa.tanggalLahirSiswa" label="Tanggal Lahir " labelSeparator=":" />
				  	<s:textfield name="siswa.noTlpSiswa" label="No Telephon " labelSeparator=":"/>
				  	<s:textfield name="siswa.alamatSiswa" label="Alamat " labelSeparator=":" />
				  	<hr>
				  	<div class="footer">
						<s:submit action="SearchSiswa" value="Cansel" cssClass="btn btn-default"/>
						<s:submit action="SaveSiswa" value="Save" cssClass="btn btn-primary"/>
					</div>
				</s:form>
		    </div>      
        	</div>
		</div>
	</body>
</html>
