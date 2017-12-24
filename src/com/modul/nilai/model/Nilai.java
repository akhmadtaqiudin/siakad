package com.modul.nilai.model;

import com.modul.mapel.model.Mapel;

public class Nilai extends Mapel{

	private int kodeNilai;
	private String namaSiswa;
	private int nilaiSiswa;
	private String predikat;
	public int getKodeNilai() {
		return kodeNilai;
	}
	public void setKodeNilai(int kodeNilai) {
		this.kodeNilai = kodeNilai;
	}
	public String getNamaSiswa() {
		return namaSiswa;
	}
	public void setNamaSiswa(String namaSiswa) {
		this.namaSiswa = namaSiswa;
	}
	public int getNilaiSiswa() {
		return nilaiSiswa;
	}
	public void setNilaiSiswa(int nilaiSiswa) {
		this.nilaiSiswa = nilaiSiswa;
	}
	public String getPredikat() {
		return predikat;
	}
	public void setPredikat(String predikat) {
		this.predikat = predikat;
	}
}
