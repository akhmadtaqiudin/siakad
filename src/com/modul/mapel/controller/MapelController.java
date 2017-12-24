package com.modul.mapel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modul.login.controller.CoreAction;
import com.modul.mapel.model.Mapel;
import com.modul.mapel.services.MapelService;

public class MapelController extends CoreAction{

	private static final long serialVersionUID = 1L;
	private Mapel mapel;
	private List<Mapel> listMapel = new ArrayList<>();
	private MapelService mapelService = (MapelService) new ClassPathXmlApplicationContext("config-db.xml").getBean("mapelService");

	public String searchAllMapel(){
		System.out.println("Jalankan method searchAllMapel");
		
		if(mapel == null){
			mapel = new Mapel();
			mapel.setNamaMapel("");
		}

		listMapel = mapelService.selectAllMapel(mapel);
		return SUCCESS;
	}
	
	public String searchAll(){
		System.out.println("Jalankan method searchAll");		
		listMapel = mapelService.selectAll();
		return SUCCESS;
	}
	
	public String searchWhereMapel(){
		System.out.println("Jalankan method searchWhereMapel");		
		mapel = mapelService.selectWhere(mapel);
		return SUCCESS;
	}
	
	public String addMapel(){
		System.out.println("Jalankan method addMapel");
		mapelService.insertMapel(mapel);
		return SUCCESS;
	}
	
	public String editMapel(){
		System.out.println("Jalankan method editMapel");
		mapelService.updateMapel(mapel);
		return SUCCESS;
	}
	
	public String deletMapel(){
		System.out.println("Jalankan method deletMapel");
		mapelService.deletMapel(mapel);
		return SUCCESS;
	}
	
	public Mapel getMapel() {
		return mapel;
	}
	public void setMapel(Mapel mapel) {
		this.mapel = mapel;
	}
	public List<Mapel> getListMapel() {
		return listMapel;
	}
	public void setListMapel(List<Mapel> listMapel) {
		this.listMapel = listMapel;
	}
	public MapelService getMapelService() {
		return mapelService;
	}
	public void setMapelService(MapelService mapelService) {
		this.mapelService = mapelService;
	}
}
