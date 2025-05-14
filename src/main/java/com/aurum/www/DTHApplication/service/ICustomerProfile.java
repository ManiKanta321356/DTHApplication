package com.aurum.www.DTHApplication.service;

import com.aurum.www.DTHApplication.entity.CustomerProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerProfile {
    CustomerProfile saveCustomer(CustomerProfile profile);
    List<CustomerProfile> getAllCustomers();
}
