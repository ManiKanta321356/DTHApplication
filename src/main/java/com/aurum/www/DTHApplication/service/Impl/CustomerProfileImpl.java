package com.aurum.www.DTHApplication.service.Impl;

import com.aurum.www.DTHApplication.entity.Address;
import com.aurum.www.DTHApplication.entity.CustomerProfile;
import com.aurum.www.DTHApplication.exception.DuplicateIdException;
import com.aurum.www.DTHApplication.exception.ResourceNotFoundException;
import com.aurum.www.DTHApplication.repo.AddressRepo;
import com.aurum.www.DTHApplication.repo.CustomerProfileRepo;
import com.aurum.www.DTHApplication.service.ICustomerProfile;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerProfileImpl implements ICustomerProfile
{

    private CustomerProfileRepo customerProfileRepo;
    private AddressRepo addressRepo;

    public CustomerProfileImpl(CustomerProfileRepo customerProfileRepo , AddressRepo addressRepo){
        this.customerProfileRepo=customerProfileRepo;
        this.addressRepo=addressRepo;
    }

    @Override
    public CustomerProfile saveCustomer(CustomerProfile profile) {
        try{
            Address address = addressRepo.findById(profile.getAddress().getAddressId()).orElseThrow(
                    ()-> new ResourceNotFoundException("The Address Data is not found while saving registration.")
            );
            return customerProfileRepo.save(profile);
        }
        catch (DuplicateKeyException e){
            throw new DuplicateIdException("You are not allowed to insert duplicate value in the database.");
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileRepo.findAll();
    }
}
