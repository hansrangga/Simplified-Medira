package main;

import java.util.ArrayList;
import java.util.Scanner;

import adapter.Converter;
import adapter.Digital;
import adapter.Tunai;
import factory.Alergi;
import factory.DataFactory;
import factory.NonAlergi;
import model.Transaction;
import singleton.Database;

public class Main {
	Scanner sc = new Scanner(System.in);
	Database db = Database.getInstance();
	
	private void cls() {
		for(int i=0; i<25; i++) {
			System.out.println();
		}
	}
	
	public void tambahTran() {
		cls();
		String tipe, nama, jenis = null, valalergi, alergi1 = null, alergi2 = null, payment;
		int umur;
		double harga;
		
		DataFactory df = null;
		
		do {
			System.out.println("Ketik pilihan anda saat datang ke klinik kami [Kunjungan | Kontrol]: ");
			tipe = sc.nextLine();
		} while(!(tipe.equals("Kunjungan") || tipe.equals("Kontrol")));
		
		do {
			System.out.println("Ketik nama lengkap anda [Panjangnya antara 3 - 25]");
			nama = sc.nextLine();
		} while(nama.length()<3 || nama.length()>25);
		
		do {
			System.out.println("Ketik umur anda saat ini [Minimal 1 karakter angka]: ");
			umur = sc.nextInt();
			sc.nextLine();
		} while(umur < 0);
		
		do {
			System.out.println("Ketik jenis kelamin anda [Pria | Wanita][Case sensitive]: ");
			jenis = sc.nextLine();
		} while(!(jenis.equals("Pria") || jenis.equals("Wanita")));
		
		do {
			System.out.println("Apakah anda punya alergi obat? [Y | N][Case sensitive]: ");
			valalergi = sc.nextLine();
			
			if(valalergi.equals("Y")) {
				do {
					System.out.println("Ketik alergi pertama terhadap obat apa: ");
					alergi1 = sc.nextLine();
				} while(alergi1.isEmpty());
				
				do {
					System.out.println("Ketik alergi kedua terhadap obat apa: ");
					alergi2 = sc.nextLine();
				} while(alergi2.isEmpty());
				
				df = new Alergi();
			}
			else {
				df = new NonAlergi();
			}
		} while(!(valalergi.equals("Y") || valalergi.equals("N")));
		
		do {
			System.out.println("Ketik harga transaksi: ");
			harga = sc.nextDouble();
			sc.nextLine();
		} while(harga < 0);
		
		do {
			System.out.println("Ketik tipe pembayaran anda [Tunai | Digital][Case sensitive]: ");
			payment = sc.nextLine();
		} while (!(payment.equals("Tunai") || payment.equals("Digital")));
		
		Transaction t = df.addTransaction(tipe, nama, umur, jenis, 
				alergi1, alergi2, harga, payment);
		db.addTranList(t);
		System.out.println("Transaksi Dibuat!");
		System.out.print("Tekan enter untuk melanjutkan...");
		sc.nextLine();
	}
	
	public void lihatTran() {
		cls();
		ArrayList<Transaction> tranList = db.getTranList();
		if(tranList.isEmpty()) {
			System.out.println("Belum ada data transaksi");
			System.out.print("Tekan enter untuk melanjutkan...");
			sc.nextLine();
			return;
		}
		
		Converter convert = null;
		for(int i=0; i<tranList.size(); i++) {
			if(tranList.get(i).getPayment().equals("Tunai")) {
				convert = new Tunai(tranList.get(i));
			}
			else if(tranList.get(i).getPayment().equals("Digital")) {
				convert = new Digital(tranList.get(i));
			}
			convert.print();
		}
	}
	
	public Main() {
		int menu = -1;
		do {
			cls();
			System.out.println("Medira Clinic");
			System.out.println("======================");
			System.out.println("1. Tambah Transaksi");
			System.out.println("2. Lihat Transaksi");
			System.out.println("3. Keluar");
			System.out.println("Pilih: ");
			menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 1) {
				tambahTran();
			}
			else if (menu == 2) {
				lihatTran();
			}
		} while(menu != 3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
