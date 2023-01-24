package factory;

import model.Transaction;

public class Alergi extends DataFactory {

	@Override
	public Transaction addTransaction(String tipe, String nama, int umur, String jenis, String alergi1, String alergi2,
			double harga, String payment) {
		// TODO Auto-generated method stub
		Transaction t = new Transaction();
		t.setTipe(tipe);
		t.setNama(nama);
		t.setUmur(umur);
		t.setJenis(jenis);
		t.setAlergi1(alergi1);
		t.setAlergi2(alergi2);
		t.setHarga(harga);
		t.setPayment(payment);
		return t;
	}
}
