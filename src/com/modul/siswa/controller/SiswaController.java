package com.modul.siswa.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modul.login.controller.CoreAction;
import com.modul.siswa.model.Siswa;
import com.modul.siswa.services.SiswaService;

public class SiswaController extends CoreAction{

	private static final long serialVersionUID = 1L;
	private Siswa siswa;
	private List<Siswa> listSiswa = new ArrayList<>();
	private SiswaService siswaService = (SiswaService) new ClassPathXmlApplicationContext("config-db.xml").getBean("siswaService");
	
	public String searchAllSiswa(){
		System.out.println("Jalankan method searchAllSiswa");
		
		if(siswa == null){
			siswa = new Siswa();
			siswa.setNamaSiswa("");
		}

		listSiswa = siswaService.selectAllSiswa(siswa);
		return SUCCESS;
	}
	
	public String searchAll(){
		System.out.println("Jalankan method searchAll");

		listSiswa = siswaService.selectAll();
		return SUCCESS;
	}
	
	public String searchWhereSiswa(){
		System.out.println("Jalankan method searchWhereSiswa");		
		siswa = siswaService.selectWhere(siswa);
		return SUCCESS;
	}
	
	public String addSiswa(){
		System.out.println("Jalankan method addSiswa");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String d[] = sdf.format(new Date()).split("/"),date="";
		date+=d[0]+d[1]+d[2];
		
		String id = "";
		id  = siswaService.countSiswa(siswa);
		
		if(id==null){
			id = "0";
		}else{
			id = id.substring(8);
		}
		
		int z = Integer.parseInt(id);
		z++;
		if(z <99 && z>=10){
			date+="00"+z;
		}else if(z>99 && z<1000){
			date+="0"+z;
		}else if(z>=999){
			date+=z;
		}else{
			date+="000"+z;
		}
		
		siswa.setNis(date);
		siswaService.insertSiswa(siswa);
		return SUCCESS;
	}
	
	public String editSiswa(){
		System.out.println("Jalankan method editSiswa");
		siswaService.updateSiswa(siswa);
		return SUCCESS;
	}
	
	public String deletSiswa(){
		System.out.println("Jalankan method deletSiswa");
		siswaService.deletSiswa(siswa);
		return SUCCESS;
	}
	
	public Siswa getSiswa() {
		return siswa;
	}
	public void setSiswa(Siswa siswa) {
		this.siswa = siswa;
	}
	public List<Siswa> getListSiswa() {
		return listSiswa;
	}
	public void setListSiswa(List<Siswa> listSiswa) {
		this.listSiswa = listSiswa;
	}
	public SiswaService getSiswaService() {
		return siswaService;
	}
	public void setSiswaService(SiswaService siswaService) {
		this.siswaService = siswaService;
	}
}
