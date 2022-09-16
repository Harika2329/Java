package com.example.pointcalculater.service;

import com.example.pointcalculater.model.Customer;
import com.example.pointcalculater.model.Points;



public interface PointService {
    public Points getPointsByCustomerId(Long customerId);
    public Customer getCustomerByCustomerId(int customerId);

}
