package com.modul.mapel.services;

import java.util.List;

import com.modul.mapel.model.Mapel;

public interface MapelService {

	int insertMapel(Mapel record);
	int updateMapel(Mapel record);
	int deletMapel(Mapel record);
	int countMapel(Mapel record);
	List<Mapel> selectAllMapel(Mapel allRecord);
	List<Mapel> selectAll();
	Mapel selectWhere(Mapel record);
}
