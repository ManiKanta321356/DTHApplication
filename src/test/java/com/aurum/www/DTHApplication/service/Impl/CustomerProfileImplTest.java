package com.aurum.www.DTHApplication.service.Impl;

import com.aurum.www.DTHApplication.entity.Address;
import com.aurum.www.DTHApplication.entity.CustomerProfile;
import com.aurum.www.DTHApplication.enums.Country;
import com.aurum.www.DTHApplication.enums.Gender;
import com.aurum.www.DTHApplication.enums.State;
import com.aurum.www.DTHApplication.repo.AddressRepo;
import com.aurum.www.DTHApplication.repo.CustomerProfileRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerProfileImplTest {

    @Mock
    CustomerProfileRepo customerProfileRepo;

    @Mock
    AddressRepo addressRepo;

    @InjectMocks
    CustomerProfileImpl customerProfile;
    @Test
    public void testSaveCustomer(){
        Address address = new Address(101, "12A", "MSD Street", State.GOA, 534316, "Vijayawada", Country.INDIA);
        CustomerProfile customerProfile1 = new CustomerProfile(1,630598765,"Mani","Anisetti","mani@gmail.com", Gender.MALE,630946596,address);

        Mockito.when(addressRepo.findById(101)).thenReturn(Optional.of(address));
        Mockito.when(customerProfileRepo.save(customerProfile1)).thenReturn(customerProfile1);

        CustomerProfile savedProfile = customerProfile.saveCustomer(customerProfile1);

        Assertions.assertEquals(101,101);
        Assertions.assertTrue(savedProfile.getGender() == Gender.MALE);
        Assertions.assertTrue(savedProfile.getAddress().getCountry() == Country.INDIA);
    }

    @Test
    public void testSaveCustomer1() {
        Address address = new Address(102, "22B", "KPHB Colony", State.TELANGANA, 500072, "Hyderabad", Country.INDIA);
        CustomerProfile profile = new CustomerProfile(2, 9876543210L, "Anjali", "Sharma", "anjali@example.com", Gender.FEMALE, 9123456789L, address);

        Mockito.when(addressRepo.findById(102)).thenReturn(Optional.of(address));
        Mockito.when(customerProfileRepo.save(profile)).thenReturn(profile);

        CustomerProfile savedProfile = customerProfile.saveCustomer(profile);

        Assertions.assertEquals("Anjali", savedProfile.getFirstName());
        Assertions.assertEquals(State.TELANGANA, savedProfile.getAddress().getState());
    }

    @Test
    public void testSaveCustomer2() {
        Address address = new Address(103, "44C", "MG Road", State.KARNATAKA, 560001, "Bangalore", Country.INDIA);
        CustomerProfile profile = new CustomerProfile(3, 888888888, "Ravi", "Kumar", "ravi@example.com", Gender.MALE, 999999999, address);

        Mockito.when(addressRepo.findById(103)).thenReturn(Optional.of(address));
        Mockito.when(customerProfileRepo.save(profile)).thenReturn(profile);

        CustomerProfile savedProfile = customerProfile.saveCustomer(profile);

        Assertions.assertEquals("Bangalore", savedProfile.getAddress().getCity());
        Assertions.assertEquals(Gender.MALE, savedProfile.getGender());
    }


    @Test
    public void testSaveCustomer3() {
        Address address = new Address(104, "10D", "Shivaji Nagar", State.MAHARASHTRA, 411005, "Pune", Country.INDIA);
        CustomerProfile profile = new CustomerProfile(4, 998877665, "Alex", "Harmozi", "alex@example.com", Gender.OTHERS, 987654321, address);

        Mockito.when(addressRepo.findById(104)).thenReturn(Optional.of(address));
        Mockito.when(customerProfileRepo.save(profile)).thenReturn(profile);

        CustomerProfile savedProfile = customerProfile.saveCustomer(profile);

        Assertions.assertEquals("Pune", savedProfile.getAddress().getCity());
        Assertions.assertEquals(Gender.OTHERS, savedProfile.getGender());
    }

    @Test
    public void testSaveCustomer4() {
        Address address = new Address(105, "5E", "RTC Complex", State.ANDHRA_PRADESH, 520001, "Guntur", Country.INDIA);
        CustomerProfile profile = new CustomerProfile(5, 777777777, "SitaRama", "Rao", "sita@example.com", Gender.FEMALE, 888888888, address);

        Mockito.when(addressRepo.findById(105)).thenReturn(Optional.of(address));
        Mockito.when(customerProfileRepo.save(profile)).thenReturn(profile);

        CustomerProfile savedProfile = customerProfile.saveCustomer(profile);

        Assertions.assertEquals("SitaRama", savedProfile.getFirstName());
        Assertions.assertEquals(State.ANDHRA_PRADESH, savedProfile.getAddress().getState());
    }






}