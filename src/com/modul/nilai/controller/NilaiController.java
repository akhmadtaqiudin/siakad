package com.modul.nilai.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modul.login.controller.CoreAction;
import com.modul.nilai.model.Nilai;
import com.modul.nilai.services.NilaiService;

public class NilaiController extends CoreAction{

	private static final long serialVersionUID = 1L;
	
	private InputStream inputStreamFile;
	private String reportFile;
	private long contentLength;
	private String fileName;
	private String waktu;
	private Calendar calendar = Calendar.getInstance();
	
	private Nilai nilai;
	private List<Nilai> listNilai = new ArrayList<>();
	private List<Nilai> listRaport = new ArrayList<>();
	private NilaiService nilaiService = (NilaiService) new ClassPathXmlApplicationContext("config-db.xml").getBean("nilaiService");

	public String searchAllNilai(){
		System.out.println("Jalankan method searchAllNilai");
		
		if(nilai == null){
			nilai = new Nilai();
			nilai.setNamaSiswa("");
		}

		listNilai = nilaiService.selectAllNilai(nilai);
		return SUCCESS;
	}
	
	public String searchWherenilai(){
		System.out.println("Jalankan method searchWherenilai");		
		nilai = nilaiService.selectWhere(nilai);
		return SUCCESS;
	}
	
	public String addNilai(){
		System.out.println("Jalankan method addNilai");
		
		int count = 0;
		count = nilaiService.countNilai(nilai);
		if(count > 0){
			addFieldError("invalinilai", "Nama Siswa : "+nilai.getNamaSiswa()+" dengan Nama Pelajaran : "+nilai.getNamaMapel()+" sudah terdaftar pada database, harap gunakan yang lain");
			return ERROR;
		}
		if(nilai.getNilaiSiswa() >= 90){
			nilai.setPredikat("A");
		}else if(nilai.getNilaiSiswa() >=70 && nilai.getNilaiSiswa() <= 89){
			nilai.setPredikat("B");
		}else if(nilai.getNilaiSiswa() >=55 && nilai.getNilaiSiswa() <= 69){
			nilai.setPredikat("C");
		}else{
			nilai.setPredikat("D");
		}
		nilaiService.insertNilai(nilai);
		return SUCCESS;
	}
	
	public String editNilai(){
		System.out.println("Jalankan method editNilai");
		if(nilai.getNilaiSiswa() >= 90){
			nilai.setPredikat("A");
		}else if(nilai.getNilaiSiswa() >=70 && nilai.getNilaiSiswa() <= 89){
			nilai.setPredikat("B");
		}else if(nilai.getNilaiSiswa() >=55 && nilai.getNilaiSiswa() <= 69){
			nilai.setPredikat("C");
		}else{
			nilai.setPredikat("D");
		}
		nilaiService.updateNilai(nilai);
		return SUCCESS;
	}
	
	public String deletNilai(){
		System.out.println("Jalankan method deletNilai");
		nilaiService.deletNilai(nilai);
		return SUCCESS;
	}
	
	public String searchRaport(){
		System.out.println("Jalankan method searchRaport");
		
		if(nilai == null){
			nilai = new Nilai();
			nilai.setNamaSiswa("");
			nilai.setNamaMapel("");
		}

		listRaport = nilaiService.selectRaport(nilai);
		return SUCCESS;
	}
	
	public String exportReport(){
		System.out.println("Jalankan method exportReport");
		
		searchRaport();
		File file=null;
        String filename="";        
        //get template
        InputStream inputStream=null;
        POIFSFileSystem fileSystem=null;
 	    reportFile = "raport".concat(".xls");
 	    
 	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String d[] = sdf.format(new Date()).split("/"),date="";
		date+=d[0]+d[1]+d[2];
 	    
		//file = new File("C:/tomcat-8/webapps"+"/"+"Raport_siswa_"+date+".xls");
 	    file = new File("/opt/apache-tomcat-8/webapps"+"/"+"Raport_siswa_"+date+".xls");
		System.out.println("file name"+file.getAbsolutePath());
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 	    
       //get Excel Template
		try {
			//inputStream = new FileInputStream ("C:/tomcat-8/webapps/"+reportFile);
			inputStream = new FileInputStream ("/opt/apache-tomcat-8/webapps/"+reportFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}		
       try {
			fileSystem = new POIFSFileSystem (inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
       
       filename = file.getAbsolutePath();
     	HSSFWorkbook workbook=null;
		try {
			workbook = new HSSFWorkbook(fileSystem);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int rowNum=15;
		int cellNum=0;
		HSSFRow myRow = null;
		HSSFSheet pengadaanBarang = workbook.getSheet("Sheet0");
		Row periode = pengadaanBarang.createRow(12);
		periode.createCell(0).setCellValue("Periode : "+date+" -");
		Row header = pengadaanBarang.createRow(14);
		header.createCell(cellNum++).setCellValue("Kode Raport");
		header.createCell(cellNum++).setCellValue("Nama Siswa");
		header.createCell(cellNum++).setCellValue("Nama Pelajaran");
		header.createCell(cellNum++).setCellValue("Tahun Ajaran");
		header.createCell(cellNum++).setCellValue("Nilai");
		header.createCell(cellNum++).setCellValue("Predikat");
		
		for(Nilai n : listRaport){
			int cell=0;
			myRow = pengadaanBarang.createRow(rowNum++);
			myRow.createCell(cell++).setCellValue(n.getKodeNilai());
			myRow.createCell(cell++).setCellValue(n.getNamaSiswa());
			myRow.createCell(cell++).setCellValue(n.getNamaMapel());
			myRow.createCell(cell++).setCellValue(n.getTahunAjaran());
			myRow.createCell(cell++).setCellValue(n.getNilaiSiswa());
			myRow.createCell(cell++).setCellValue(n.getPredikat());
		}
		rowNum++;
		rowNum++;
		rowNum++;
		rowNum++;
		Row footer = pengadaanBarang.createRow(rowNum++);
		footer.createCell(8).setCellValue(getWaktu());
		System.out.println("waktu pada footer"+getWaktu());
		rowNum++;
		rowNum++;
		rowNum++;
		Row ttd = pengadaanBarang.createRow(rowNum++);
		ttd.createCell(8).setCellValue("Petugas Tata Usaha");
		try{
	        FileOutputStream fileOut =  new FileOutputStream(filename);
	        workbook.write(fileOut);
	        fileOut.close();
	        workbook.close();

	        File file2 = new File(filename);
	        this.inputStreamFile = new FileInputStream(file2);
			contentLength = file2.length();
			fileName = file2.getName();
       } catch ( Exception ex ) {
           System.out.println(ex);
       }
		return SUCCESS;
	}
	
	public String getHari() {

		if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
		return "Minggu";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == 2) {
		return "Senin";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == 3) {
		return "Selasa";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == 4) {
		return "Rabu";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == 5) {
		return "Kamis";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == 6) {
		return "Jumat";
		} else {
		return "Sabtu";
		}
	}
	
	public String getBulan() {

		if (calendar.get(Calendar.MONTH) == 0) {
		return "Januari";
		} else if (calendar.get(Calendar.MONTH) == 1) {
		return "Februari";
		} else if (calendar.get(Calendar.MONTH) == 2) {
		return "Maret";
		} else if (calendar.get(Calendar.MONTH) == 3) {
		return "April";
		} else if (calendar.get(Calendar.MONTH) == 4) {
		return "Mei";
		} else if (calendar.get(Calendar.MONTH) == 5) {
		return "Juni";
		} else if (calendar.get(Calendar.MONTH) == 6) {
		return "Juli";
		} else if (calendar.get(Calendar.MONTH) == 7) {
		return "Agustus";
		} else if (calendar.get(Calendar.MONTH) == 8) {
		return "September";
		} else if (calendar.get(Calendar.MONTH) == 9) {
		return "Oktober";
		} else if (calendar.get(Calendar.MONTH) == 10) {
		return "November";
		} else {
		return "Desember";
		}
	}
	
	public String getWaktu(){
		
		String hari;
		String tanggal;
		String bulan;
		String tahun;
		hari = getHari();
		tanggal = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		bulan = getBulan();
		tahun = String.valueOf(calendar.get(Calendar.YEAR));
		return (hari + ", " + tanggal + " " + bulan + " " + tahun);
	}
	
	public Nilai getNilai() {
		return nilai;
	}
	public void setNilai(Nilai nilai) {
		this.nilai = nilai;
	}
	public List<Nilai> getListNilai() {
		return listNilai;
	}
	public void setListNilai(List<Nilai> listNilai) {
		this.listNilai = listNilai;
	}
	public List<Nilai> getListRaport() {
		return listRaport;
	}

	public void setListRaport(List<Nilai> listRaport) {
		this.listRaport = listRaport;
	}

	public NilaiService getNilaiService() {
		return nilaiService;
	}
	public void setNilaiService(NilaiService nilaiService) {
		this.nilaiService = nilaiService;
	}

	public InputStream getInputStreamFile() {
		return inputStreamFile;
	}

	public void setInputStreamFile(InputStream inputStreamFile) {
		this.inputStreamFile = inputStreamFile;
	}

	public String getReportFile() {
		return reportFile;
	}

	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setWaktu(String waktu) {
		this.waktu = waktu;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
}
