package com.modul.nilai.services;

import java.util.List;

import com.modul.nilai.model.Nilai;

public interface NilaiService {

	int insertNilai(Nilai record);
	int updateNilai(Nilai record);
	int deletNilai(Nilai record);
	int countNilai(Nilai record);
	List<Nilai> selectAllNilai(Nilai allRecord);
	List<Nilai> selectRaport(Nilai allRecord);
	Nilai selectWhere(Nilai record);
}
