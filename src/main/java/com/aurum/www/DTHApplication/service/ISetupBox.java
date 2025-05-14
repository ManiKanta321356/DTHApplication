package com.aurum.www.DTHApplication.service;

import com.aurum.www.DTHApplication.entity.SetupBox;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISetupBox {

    SetupBox saveSetUpBox(SetupBox setupBox);

    List<SetupBox> getAllSetUpBoxes();
}
