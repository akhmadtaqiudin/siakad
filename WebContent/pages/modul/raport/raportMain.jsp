<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="com.modul.raport.model.*"%>
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
		$("#TableListRaport  > thead tr th, tr td").css({"text-align": "center", "vertical-align": "middle"});
    }); 
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">			
	        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	          <h3 class="page-header">Data Raport Siswa</h3>	
	          <s:form namespace="/nilai" >
					<s:textfield id="nama" name="nilai.namaSiswa" placeholder="Nama Siswa " />
					<s:hidden name="nilai.namaMapel"></s:hidden>
					<s:submit value="Export Raport" action="ExportExcel" cssClass="btn btn-primary btn-sm btn-add" />
					<input id="rst2" type="button" value="Reset" class="btn btn-default btn-sm" />
					<s:submit value="Search" action="SearchRaport" cssClass="btn btn-default btn-sm btn-src" />							
			  </s:form>
			  <display:table id="TableListRaport" name="listRaport" pagesize="10"
				 requestURI="/nilai/SearchRaport.action" class="table table-bordered table-hover table-striped" >
					<display:column title="Nama Siswa " property="namaSiswa" />
					<display:column title="Nama Pelajaran " property="namaMapel" />
					<display:column title="Tahun Ajaran " property="tahunAjaran" />
					<display:column title="Nilai " property="nilaiSiswa" />
					<display:column title="Predikat " property="predikat" />
			  </display:table>          
        	</div>
		</div>
	</div>
</body>
</html>