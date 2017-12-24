<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="com.modul.mapel.model.*"%>
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
		$("#TableListMapel  > thead tr th, tr td").css({"text-align": "center", "vertical-align": "middle"});
    }); 
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">			
	        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	          <h3 class="page-header">Data Master Pelajaran</h3>	
	          <s:form namespace="/mapel" >
					<s:textfield id="nama" name="mapel.namaMapel" placeholder="Nama Pelajaran " />
					<s:submit value="Tambah" action="AddMapel" cssClass="btn btn-primary btn-sm btn-add" />
					<input id="rst" type="button" value="Reset" class="btn btn-default btn-sm" />
					<s:submit value="Search" action="SearchMapel" cssClass="btn btn-default btn-sm btn-src" /> 				
			  </s:form>
			  <display:table id="TableListMapel" name="listMapel" pagesize="10"
				 requestURI="/mapel/SearchMapel.action" class="table table-bordered table-hover table-striped" >
					<display:column title="Kode Pelajaran " property="kodeMapel" />
					<display:column title="Nama Pelajaran " property="namaMapel" />
					<display:column title="Tahun Ajaran " property="tahunAjaran" format="{0,date,dd/MM/yyyy}" />
					<display:column title="Action">
					    <a class="btn btn-default btn-xs" href="${pageContext.request.contextPath}/mapel/EditMapel.action?mapel.kodeMapel=<%=((Mapel) pageContext.getAttribute("TableListMapel")).getKodeMapel()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit</a>
						<a class="btn btn-danger btn-xs del" href="${pageContext.request.contextPath}/mapel/DeletMapel.action?mapel.kodeMapel=<%=((Mapel) pageContext.getAttribute("TableListMapel")).getKodeMapel()%>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Delete</a>
					</display:column>
			  </display:table>          
        	</div>
		</div>
	</div>
</body>
</html>