package com.aurum.www.DTHApplication.service;

import com.aurum.www.DTHApplication.entity.Registration;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IRegistartion {

    Registration saveRegistration(Registration registration);

    List<Registration> getAllRegistrations();
}
