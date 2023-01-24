package singleton;

import java.util.ArrayList;

import model.Transaction;

public class Database {
	private ArrayList<Transaction> tranList;
	private static Database instance;
	
	private Database(){
		tranList = new ArrayList<>();
	}
	
	public static Database getInstance(){
		if(instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	public ArrayList<Transaction> getTranList(){
		return this.tranList;
	}
	
	public void addTranList(Transaction t) {
		this.tranList.add(t);
	}
}
