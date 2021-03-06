<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="com.modul.siswa.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/pages/template/header.jsp"></jsp:include>
<title>SIAKAD</title>
<script type="text/javascript">
	$(window).ready(function(){
		$("#rst").on("click", function(){
	    	$("#nama").val("");
	    });
		$(".del").click(function(){
		    if (!confirm("Apakah anda yakin ingin hapus file tersebut")){
		      return false;
		    }
		});
		$("#TableListSiswa  > thead tr th, tr td").css({"text-align": "center", "vertical-align": "middle"});
    }); 
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">			
	        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	          <h3 class="page-header">Data Master Siswa</h3>	
	          <s:form namespace="/siswa" >
					<s:textfield id="nama" name="siswa.namaSiswa" placeholder="Nama Siswa " />
					<s:submit value="Tambah" action="AddSiswa" cssClass="btn btn-primary btn-sm btn-add" />
					<input id="rst" type="button" value="Reset" class="btn btn-default btn-sm" />
					<s:submit value="Search" action="SearchSiswa" cssClass="btn btn-default btn-sm btn-src" /> 				
			  </s:form>
			  <display:table id="TableListSiswa" name="listSiswa" pagesize="10"
				 requestURI="/siswa/SearchSiswa.action" class="table table-bordered table-hover table-striped" >
					<display:column title="NIS " property="nis" />
					<display:column title="Nama Siswa " property="namaSiswa" />
					<display:column title="Jenis Kelamin " property="jenisKelamin" />
					<display:column title="Kelas " property="kelas" />
					<display:column title="Jurusan " property="jurusan" />
					<display:column title="Tempat Lahir " property="tempatLahirSiswa" />
					<display:column title="Tanggal Lahir " property="tanggalLahirSiswa" format="{0,date,dd/MM/yyyy}" />
					<display:column title="Nomor Telephon " property="noTlpSiswa" />
					<display:column title="Alamat " property="alamatSiswa" />
					<display:column title="Action">
					    <a class="btn btn-default btn-xs" href="${pageContext.request.contextPath}/siswa/EditSiswa.action?siswa.nis=<%=((Siswa) pageContext.getAttribute("TableListSiswa")).getNis()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit</a>
						<a class="btn btn-danger btn-xs del" href="${pageContext.request.contextPath}/siswa/DeletSiswa.action?siswa.nis=<%=((Siswa) pageContext.getAttribute("TableListSiswa")).getNis()%>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Delete</a>
					</display:column>
			  </display:table>          
        	</div>
		</div>
	</div>
</body>
</html>