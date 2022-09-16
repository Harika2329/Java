package com.example.pointcalculater.model;

public class Points {
    private long customerId;
	private long lastMonthPoints;
    private long lastSecondMonthPoints;
    private long lastThirdMonthPoints;
    private long totalPoints;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getLastMonthPoints() {
		return lastMonthPoints;
	}
	public void setLastMonthPoints(long lastMonthPoints) {
		this.lastMonthPoints = lastMonthPoints;
	}
	public long getLastSecondMonthPoints() {
		return lastSecondMonthPoints;
	}
	public void setLastSecondMonthPoints(long lastSecondMonthPoints) {
		this.lastSecondMonthPoints = lastSecondMonthPoints;
	}
	public long getLastThirdMonthPoints() {
		return lastThirdMonthPoints;
	}
	public void setLastThirdMonthPoints(long lastThirdMonthPoints) {
		this.lastThirdMonthPoints = lastThirdMonthPoints;
	}
	public long getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(long totalPoints) {
		this.totalPoints = totalPoints;
	}
	@Override
	public String toString() {
		return "Points [customerId=" + customerId + ", lastMonthPoints=" + lastMonthPoints + ", lastSecondMonthPoints="
				+ lastSecondMonthPoints + ", lastThirdMonthPoints=" + lastThirdMonthPoints + ", totalPoints="
				+ totalPoints + "]";
	}
	
   
}
