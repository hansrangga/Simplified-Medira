package model;

public class Transaction {
	private String tipe, nama;
	private int umur;
	private String jenis;
	private String alergi1, alergi2;
	private double harga;
	private String payment;
	
	//Getter Setter
	public String getTipe() {
		return tipe;
	}
	public void setTipe(String tipe) {
		this.tipe = tipe;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getUmur() {
		return umur;
	}
	public void setUmur(int umur) {
		this.umur = umur;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public String getAlergi1() {
		return alergi1;
	}
	public void setAlergi1(String alergi1) {
		this.alergi1 = alergi1;
	}
	public String getAlergi2() {
		return alergi2;
	}
	public void setAlergi2(String alergi2) {
		this.alergi2 = alergi2;
	}
	public double getHarga() {
		return harga;
	}
	public void setHarga(double harga) {
		this.harga = harga;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
}
