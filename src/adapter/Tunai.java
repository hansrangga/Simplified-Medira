package adapter;

import model.Transaction;

public class Tunai implements Converter {
	private Transaction convert = null;
	
	public Tunai(Transaction convert) {
		this.convert = convert;
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Tipe Kedatangan: "+ convert.getTipe());
		System.out.println("Nama Pasien: "+ convert.getNama());
		System.out.println("Umur Pasien: "+ convert.getUmur());
		System.out.println("Jenis Kelamin Pasien: "+ convert.getJenis());
		if(convert.getAlergi1().equals("Tidak ada")) {
			System.out.println("Alergi: Tidak ada");
		}
		else {
			System.out.println("Alergi 1: "+ convert.getAlergi1());
			System.out.println("Alergi 2: "+ convert.getAlergi2());
		}
		System.out.println("Tipe pembayaran: "+ convert.getPayment());
		System.out.println("Total Harga: Rp. "+ convert.getHarga());
		System.out.println("============================================");
	}
}
