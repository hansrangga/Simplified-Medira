package factory;

import model.Transaction;

public class NonAlergi extends DataFactory{

	@Override
	public Transaction addTransaction(String tipe, String nama, int umur, String jenis, String alergi1, String alergi2,
			double harga, String payment) {
		// TODO Auto-generated method stub
		Transaction t = new Transaction();
		t.setTipe(tipe);
		t.setNama(nama);
		t.setUmur(umur);
		t.setJenis(jenis);
		t.setAlergi1("Tidak ada");
		t.setAlergi2("Tidak ada");
		t.setHarga(harga);
		t.setPayment(payment);
		return t;
	}
}
