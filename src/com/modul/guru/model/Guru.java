package com.modul.guru.model;

import java.util.Date;

public class Guru {

	private String nip;
	private String namaGuru;
	private String jenisKelamin;
	private String pendidikanTerakhir;
	private String tempatLahir;
	private Date tanggalLahir;
	private String Agama;
	private String noTlp;
	private String alamat;
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getNamaGuru() {
		return namaGuru;
	}
	public void setNamaGuru(String namaGuru) {
		this.namaGuru = namaGuru;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getTempatLahir() {
		return tempatLahir;
	}
	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
	public Date getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public String getNoTlp() {
		return noTlp;
	}
	public void setNoTlp(String noTlp) {
		this.noTlp = noTlp;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getPendidikanTerakhir() {
		return pendidikanTerakhir;
	}
	public void setPendidikanTerakhir(String pendidikanTerakhir) {
		this.pendidikanTerakhir = pendidikanTerakhir;
	}
	public String getAgama() {
		return Agama;
	}
	public void setAgama(String agama) {
		Agama = agama;
	}
}
