package com.aurum.www.DTHApplication.service.Impl;

import com.aurum.www.DTHApplication.entity.Registration;
import com.aurum.www.DTHApplication.entity.SetupBox;
import com.aurum.www.DTHApplication.exception.DuplicateIdException;
import com.aurum.www.DTHApplication.exception.ResourceNotFoundException;
import com.aurum.www.DTHApplication.repo.RegistrationRepo;
import com.aurum.www.DTHApplication.repo.SetupBoxRepo;
import com.aurum.www.DTHApplication.service.IRegistartion;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationImpl implements IRegistartion {

    private RegistrationRepo registrationRepo;
    private SetupBoxRepo setupBoxRepo;
    public RegistrationImpl(RegistrationRepo registrationRepo,SetupBoxRepo setupBoxRepo){
        this.registrationRepo=registrationRepo;
        this.setupBoxRepo=setupBoxRepo;
    }
    @Override
    public Registration saveRegistration(Registration registration) {
        try {
            SetupBox setupBox = setupBoxRepo.findById(registration.getSetupBox().getId()).orElseThrow(
                    () -> new ResourceNotFoundException("The SetupBox Data is not found while saving registration.")
            );
            return registrationRepo.save(registration);
        }
        catch (DuplicateKeyException e){
            throw new DuplicateIdException("You are not allowed to insert duplicate  value in the database.");
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepo.findAll();
    }
}
