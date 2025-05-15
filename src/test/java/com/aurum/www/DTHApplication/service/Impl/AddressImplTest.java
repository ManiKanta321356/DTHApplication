package com.aurum.www.DTHApplication.service.Impl;

import com.aurum.www.DTHApplication.entity.Address;
import com.aurum.www.DTHApplication.enums.Country;
import com.aurum.www.DTHApplication.enums.State;
import com.aurum.www.DTHApplication.repo.AddressRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddressImplTest {

    @Mock
    AddressRepo addressRepo;
    @InjectMocks
    AddressImpl addressImpl;

    @Test
    public void saveAddressTest(){

        Address address=new Address(101,"12A","MSD Street", State.GOA,534316,"Vijayawada", Country.INDIA);

        when(addressRepo.save(address)).thenReturn(address);

        Address address1 = addressImpl.saveAddress(address);

        assertEquals(address.getAddressId(), address1.getAddressId());
        assertEquals(State.GOA,address1.getState());
        assertTrue(address.getPincode() == 534316);

    }

    @Test
    public void saveAddressTest1() {
        Address address = new Address(102, "11", "MG Road", State.MADHYA_PRADESH, 462001, "Bhopal", Country.INDIA);

        when(addressRepo.save(address)).thenReturn(address);

        Address result = addressImpl.saveAddress(address);

        assertEquals(462001, result.getPincode());
        assertEquals(State.MADHYA_PRADESH, result.getState());
    }


    @Test
    public void saveAddressTest2() {
        Address address = new Address(109, "50", "Benz Circle", State.ANDHRA_PRADESH, 520001, "Vijayawada", Country.INDIA);

        when(addressRepo.save(address)).thenReturn(address);

        Address result = addressImpl.saveAddress(address);

        assertEquals("Benz Circle", result.getStreet());
        assertEquals(State.ANDHRA_PRADESH, result.getState());
    }

    @Test
    public void saveAddressTest3() {
        Address address = new Address(111, "12A", "Oxford Street", State.TAMIL_NADU, 123456, "Chennai", Country.INDIA);

        when(addressRepo.save(address)).thenReturn(address);

        Address result = addressImpl.saveAddress(address);

        assertEquals(Country.INDIA, result.getCountry());
        assertEquals("Chennai", result.getCity());
        assertEquals(123456, result.getPincode());
    }



}