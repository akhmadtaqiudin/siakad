package com.modul.guru.services;

import java.util.List;

import com.modul.guru.model.Guru;

public interface guruService {

	int insertGuru(Guru record);
	int updateGuru(Guru record);
	int deletGuru(Guru record);
	String countGuru(Guru record);
	List<Guru> selectAllGuru(Guru allRecord);
	Guru selectWhere(Guru record);
}
