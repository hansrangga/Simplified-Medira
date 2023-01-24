package adapter;

import java.util.Random;

import model.Transaction;

public class Digital implements Converter {
	private Transaction convert = null;
	
	public Digital(Transaction convert) {
		this.convert = convert;
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		String address = "";
		for(int i=0; i<10; i++) {
			char a = ' ';
			do {
				a = (char)(rand.nextInt(100)+'0');
			} while((a < 'a' || a > 'z') && (a < '0' || a > '9'));
			
			address += a;
		}
		
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
		System.out.println("Total Harga: Rp. "+ convert.getHarga()*1.2 + " dengan Nomor Akun : " + address);
		System.out.println("============================================");
	}
	
}
