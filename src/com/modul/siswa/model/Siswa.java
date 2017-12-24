package com.modul.siswa.model;

import java.util.Date;

public class Siswa {

	private String nis;
	private String namaSiswa;
	private String jenisKelamin;
	private String kelas;
	private String jurusan;
	private String tempatLahirSiswa;
	private Date tanggalLahirSiswa;
	private String agama;
	private String noTlpSiswa;
	private String alamatSiswa;
	public String getNis() {
		return nis;
	}
	public void setNis(String nis) {
		this.nis = nis;
	}
	public String getNamaSiswa() {
		return namaSiswa;
	}
	public void setNamaSiswa(String namaSiswa) {
		this.namaSiswa = namaSiswa;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getKelas() {
		return kelas;
	}
	public void setKelas(String kelas) {
		this.kelas = kelas;
	}
	public String getJurusan() {
		return jurusan;
	}
	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}
	public String getTempatLahirSiswa() {
		return tempatLahirSiswa;
	}
	public void setTempatLahirSiswa(String tempatLahirSiswa) {
		this.tempatLahirSiswa = tempatLahirSiswa;
	}
	public Date getTanggalLahirSiswa() {
		return tanggalLahirSiswa;
	}
	public void setTanggalLahirSiswa(Date tanggalLahirSiswa) {
		this.tanggalLahirSiswa = tanggalLahirSiswa;
	}
	public String getNoTlpSiswa() {
		return noTlpSiswa;
	}
	public void setNoTlpSiswa(String noTlpSiswa) {
		this.noTlpSiswa = noTlpSiswa;
	}
	public String getAlamatSiswa() {
		return alamatSiswa;
	}
	public void setAlamatSiswa(String alamatSiswa) {
		this.alamatSiswa = alamatSiswa;
	}
	public String getAgama() {
		return agama;
	}
	public void setAgama(String agama) {
		this.agama = agama;
	}
}
