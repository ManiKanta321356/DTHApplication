package com.aurum.www.DTHApplication.controller;

import com.aurum.www.DTHApplication.entity.SetupBox;
import com.aurum.www.DTHApplication.service.ISetupBox;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/setupbox")
public class SetupBoxController {

    private ISetupBox iSetupBox;

    public SetupBoxController(ISetupBox iSetupBox){
        this.iSetupBox=iSetupBox;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveSetUpBox(@RequestBody SetupBox setupBox){
        SetupBox setupBox1 = iSetupBox.saveSetUpBox(setupBox);
        if(setupBox1 == null){
            return  new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Data is saved Successfully" , HttpStatus.CREATED);
        }
    }

    @GetMapping("all")
    public ResponseEntity<Object> getAllSetUpBoxes(){
        List<SetupBox> list = iSetupBox.getAllSetUpBoxes();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
