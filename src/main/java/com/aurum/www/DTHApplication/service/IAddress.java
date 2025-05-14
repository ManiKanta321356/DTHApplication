package com.aurum.www.DTHApplication.service;

import com.aurum.www.DTHApplication.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddress {

    Address saveAddress(Address address);
    List<Address> getAllAddresses();

}
