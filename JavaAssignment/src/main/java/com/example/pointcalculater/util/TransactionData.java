package com.example.pointcalculater.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.pointcalculater.model.Customer;
import com.example.pointcalculater.model.Transaction;

public class TransactionData {

	
	
	public static List<Transaction>  getAllTransactionData() {
		List<Transaction> transactions=new ArrayList<>();

		Transaction transaction1=new Transaction();
		transaction1.setCustomerId(1l);
		transaction1.setTransactionAmount(120);
		transaction1.setTransactionDate(new Timestamp(new Date().getTime()));
		transaction1.setTransactionId(1l);			
		transactions.add(transaction1);

		Transaction transaction2=new Transaction();
		transaction2.setCustomerId(2l);
		transaction2.setTransactionAmount(454);
		transaction2.setTransactionDate(new Timestamp(new Date().getTime()));
		transaction2.setTransactionId(2l);			
		transactions.add(transaction2);


		Transaction transaction3=new Transaction();
		transaction3.setCustomerId(3l);
		transaction3.setTransactionAmount(182);
		transaction3.setTransactionDate(new Timestamp(new Date().getTime()));
		transaction3.setTransactionId(3l);			
		transactions.add(transaction3);



		Transaction transaction4=new Transaction();
		transaction4.setCustomerId(1l);
		transaction4.setTransactionAmount(100);
		transaction4.setTransactionDate(Timestamp.valueOf("2022-08-09 00:00:00"));
		transaction4.setTransactionId(4l);			
		transactions.add(transaction4);



		Transaction transaction5=new Transaction();
		transaction5.setCustomerId(2l);
		transaction5.setTransactionAmount(54);
		transaction5.setTransactionDate(Timestamp.valueOf("2022-08-09 00:00:00"));
		transaction5.setTransactionId(5l);			
		transactions.add(transaction5);



		Transaction transaction6=new Transaction();
		transaction6.setCustomerId(3l);
		transaction6.setTransactionAmount(223);
		transaction6.setTransactionDate(Timestamp.valueOf("2022-08-09 00:00:00"));
		transaction6.setTransactionId(6l);			
		transactions.add(transaction6);



		Transaction transaction7=new Transaction();
		transaction7.setCustomerId(1l);
		transaction7.setTransactionAmount(190);
		transaction7.setTransactionDate(Timestamp.valueOf("2022-07-09 00:00:00"));
		transaction7.setTransactionId(7l);			
		transactions.add(transaction7);

		Transaction transaction8=new Transaction();
		transaction8.setCustomerId(2l);
		transaction8.setTransactionAmount(101);
		transaction8.setTransactionDate(Timestamp.valueOf("2022-07-09 00:00:00"));
		transaction8.setTransactionId(7l);			
		transactions.add(transaction8);


		Transaction transaction9=new Transaction();
		transaction9.setCustomerId(3l);
		transaction9.setTransactionAmount(211);
		transaction9.setTransactionDate(Timestamp.valueOf("2022-07-09 00:00:00"));
		transaction9.setTransactionId(7l);			
		transactions.add(transaction9);

		return transactions;

	}

	
}
