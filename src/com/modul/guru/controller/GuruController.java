package com.modul.guru.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modul.guru.model.Guru;
import com.modul.guru.services.guruService;
import com.modul.login.controller.CoreAction;

public class GuruController extends CoreAction{

	private static final long serialVersionUID = 1L;
	private Guru guru;
	private List<Guru> listGuru = new ArrayList<>();
	private guruService guruService = (guruService) new ClassPathXmlApplicationContext("config-db.xml").getBean("guruService");

	public String searchAllGuru(){
		System.out.println("Jalankan method searchAllGuru");
		
		if(guru == null){
			guru = new Guru();
			guru.setNamaGuru("");
		}

		listGuru = guruService.selectAllGuru(guru);
		return SUCCESS;
	}
	
	public String searchWhereGuru(){
		System.out.println("Jalankan method searchWhereGuru");		
		guru = guruService.selectWhere(guru);
		return SUCCESS;
	} 
	
	public String addGuru(){
		System.out.println("Jalankan method addGuru");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String d[] = sdf.format(new Date()).split("/"),date="";
		date+=d[0]+d[1]+d[2];
		
		String id = "";
		id  = guruService.countGuru(guru);
		
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
		
		guru.setNip(date);
		guruService.insertGuru(guru);
		return SUCCESS;
	}
	
	public String editGuru(){
		System.out.println("Jalankan method editGuru");
		guruService.updateGuru(guru);
		return SUCCESS;
	}
	
	public String deletGuru(){
		System.out.println("Jalankan method deletGuru");
		guruService.deletGuru(guru);
		return SUCCESS;
	}
	
	public Guru getGuru() {
		return guru;
	}
	public void setGuru(Guru guru) {
		this.guru = guru;
	}
	public List<Guru> getListGuru() {
		return listGuru;
	}
	public void setListGuru(List<Guru> listGuru) {
		this.listGuru = listGuru;
	}
	public guruService getGuruService() {
		return guruService;
	}
	public void setGuruService(guruService guruService) {
		this.guruService = guruService;
	}
}
