package com.aurum.www.DTHApplication.service.Impl;

import com.aurum.www.DTHApplication.entity.SetupBox;
import com.aurum.www.DTHApplication.exception.DuplicateIdException;
import com.aurum.www.DTHApplication.repo.SetupBoxRepo;
import com.aurum.www.DTHApplication.service.ISetupBox;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SetupBoxImpl implements ISetupBox {

    private SetupBoxRepo setupBoxRepo;
    public SetupBoxImpl(SetupBoxRepo setupBoxRepo){
        this.setupBoxRepo=setupBoxRepo;
    }
    @Override
    public SetupBox saveSetUpBox(SetupBox setupBox) {
        try{
            return setupBoxRepo.save(setupBox);
        }
        catch (DuplicateKeyException e){
            throw new DuplicateIdException("You are not allowed to insert duplicate  value in the database.");
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<SetupBox> getAllSetUpBoxes() {
        return setupBoxRepo.findAll();
    }
}
