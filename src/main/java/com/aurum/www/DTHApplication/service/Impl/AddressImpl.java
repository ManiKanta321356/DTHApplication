package com.aurum.www.DTHApplication.service.Impl;

import com.aurum.www.DTHApplication.entity.Address;
import com.aurum.www.DTHApplication.exception.DuplicateIdException;
import com.aurum.www.DTHApplication.repo.AddressRepo;
import com.aurum.www.DTHApplication.service.IAddress;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressImpl implements IAddress {

    private AddressRepo addressRepo;
    public AddressImpl(AddressRepo addressRepo){
        this.addressRepo=addressRepo;
    }
    @Override
    public Address saveAddress(Address address) {
        try {
            return addressRepo.save(address);
        }
        catch (DuplicateKeyException e){
            throw new DuplicateIdException("You are not allowed to insert duplicate value in the database.");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }
}
