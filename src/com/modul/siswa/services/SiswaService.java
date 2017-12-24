package com.modul.siswa.services;

import java.util.List;

import com.modul.siswa.model.Siswa;

public interface SiswaService {

	int insertSiswa(Siswa record);
	int updateSiswa(Siswa record);
	int deletSiswa(Siswa record);
	String countSiswa(Siswa record);
	List<Siswa> selectAllSiswa(Siswa allRecord);
	Siswa selectWhere(Siswa record);
	List<Siswa> selectAll();
}
