package com.aurum.www.DTHApplication.controller;

import com.aurum.www.DTHApplication.entity.Registration;
import com.aurum.www.DTHApplication.service.IRegistartion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private IRegistartion iRegistartion;
    public RegistrationController(IRegistartion iRegistartion){
        this.iRegistartion=iRegistartion;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveRegistration(@RequestBody Registration registration){
        Registration registration1 = iRegistartion.saveRegistration(registration);
        if(registration == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Data is Saved Successfully",HttpStatus.CREATED);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllRegistrations(){
        List<Registration> list = iRegistartion.getAllRegistrations();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
