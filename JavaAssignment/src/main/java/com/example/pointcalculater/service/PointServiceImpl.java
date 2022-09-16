package com.example.pointcalculater.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.pointcalculater.constant.Constants;
import com.example.pointcalculater.model.Customer;
import com.example.pointcalculater.model.Points;
import com.example.pointcalculater.model.Transaction;
import com.example.pointcalculater.util.CustomerData;
import com.example.pointcalculater.util.TransactionData;

@Service
public class PointServiceImpl implements PointService {

    
	@Override
	public 	Customer getCustomerByCustomerId(int customerId) {
		List<Customer> customers=CustomerData.getAllCustomers();
		if(customers.size()<customerId)
			return null;
		return customers.get(customerId-1);
	}

	@Override
	public Points getPointsByCustomerId(Long customerId) {

		Timestamp lastMonthTimestamp = getTimeStamp(Constants.daysInMonths);
		Timestamp lastSecondMonthTimestamp = getTimeStamp(2*Constants.daysInMonths);
		Timestamp lastThirdMonthTimestamp = getTimeStamp(3*Constants.daysInMonths);

		List<Transaction> lastMonthTransactions = getDataByCustomerIdAndTransactionDateBetween(customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
		List<Transaction> lastSecondMonthTransactions = getDataByCustomerIdAndTransactionDateBetween(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
		List<Transaction> lastThirdMonthTransactions = getDataByCustomerIdAndTransactionDateBetween(customerId, lastThirdMonthTimestamp,lastSecondMonthTimestamp);

		Long lastMonthRewardPoints = getPointsPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = getPointsPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = getPointsPerMonth(lastThirdMonthTransactions);

		Points points = new Points();
		points.setCustomerId(customerId);
		points.setLastMonthPoints(lastMonthRewardPoints);
		points.setLastSecondMonthPoints(lastSecondMonthRewardPoints);
		points.setLastThirdMonthPoints(lastThirdMonthRewardPoints);
		points.setTotalPoints(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return points;

	}

	private List<Transaction> getDataByCustomerIdAndTransactionDateBetween(Long customerId,
			Timestamp lastMonthTimestamp, Timestamp from) {

		List<Transaction> transactionsList =TransactionData.getAllTransactionData();
		List<Transaction> tList=new ArrayList<Transaction>();
		for (Transaction transaction : transactionsList) {
			if(transaction.getCustomerId()==customerId&&(transaction.getTransactionDate().getTime()>=lastMonthTimestamp.getTime()&&transaction.getTransactionDate().getTime()<=from.getTime()))

			{
				tList.add(transaction);
			}
		}

		return tList;
	}



	public Long getPointsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculatePoints(transaction))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	public Long calculatePoints(Transaction t) {
		if (t.getTransactionAmount() > Constants.firstRewardLimit && t.getTransactionAmount() <= Constants.secondRewardLimit) {
			return Math.round(t.getTransactionAmount() - Constants.firstRewardLimit);
		} else if (t.getTransactionAmount() >Constants.secondRewardLimit) {
			return Math.round(t.getTransactionAmount() - Constants.secondRewardLimit) * 2
					+ (Constants.secondRewardLimit - Constants.firstRewardLimit);
		} else
			return 0l;

	}

	public Timestamp getTimeStamp(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}



}
