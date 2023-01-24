package factory;

import model.Transaction;

public abstract class DataFactory {
	public DataFactory(){}
	
	public abstract Transaction addTransaction(String tipe,
			String nama, int umur, String jenis, String alergi1, 
			String alergi2, double harga, String payment);
}
