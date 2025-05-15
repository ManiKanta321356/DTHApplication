package com.aurum.www.DTHApplication.service.Impl;

import com.aurum.www.DTHApplication.entity.SetupBox;
import com.aurum.www.DTHApplication.enums.SetUpBoxType;
import com.aurum.www.DTHApplication.enums.Status;
import com.aurum.www.DTHApplication.repo.SetupBoxRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SetupBoxImplTest {

    @Mock
    SetupBoxRepo setupBoxRepo;

    @InjectMocks
    SetupBoxImpl setupBox;

    @Test
    public void testSaveSetUpBox(){
        SetupBox setupBox1 = new SetupBox(1,"192.1.0.1", SetUpBoxType.HD,"TD123", Status.ACTIVE,"v1.1.0","TataDish");

        Mockito.when(setupBoxRepo.save(setupBox1)).thenReturn(setupBox1);

        SetupBox savedSetUpBox = setupBox.saveSetUpBox(setupBox1);
        Assertions.assertEquals(1,savedSetUpBox.getId());
        Assertions.assertTrue(savedSetUpBox.getSoftware() == "TataDish");
    }

    @Test
    public void testSaveSetUpBox1() {
        SetupBox setupBox1 = new SetupBox(2, "10.0.0.2", SetUpBoxType.SD, "SD456", Status.INACTIVE, "v2.0.1", "AirtelTV");

        Mockito.when(setupBoxRepo.save(setupBox1)).thenReturn(setupBox1);

        SetupBox savedBox = setupBox.saveSetUpBox(setupBox1);

        Assertions.assertEquals(2, savedBox.getId());
        Assertions.assertEquals("AirtelTV", savedBox.getSoftware());
    }

    @Test
    public void testSaveSetUpBox2() {
        SetupBox setupBox1 = new SetupBox(3, "172.16.5.5", SetUpBoxType.HD, "HD789", Status.ACTIVE, "v3.1.0", "DishNet");

        Mockito.when(setupBoxRepo.save(setupBox1)).thenReturn(setupBox1);

        SetupBox savedBox = setupBox.saveSetUpBox(setupBox1);

        Assertions.assertEquals("HD789", savedBox.getSetUpBoxId());
        Assertions.assertEquals(SetUpBoxType.HD, savedBox.getSetUpBoxType());
    }

    @Test
    public void testSaveSetUpBox3() {
        SetupBox setupBox1 = new SetupBox(4, "192.168.10.10", SetUpBoxType.SD, "SD321", Status.INACTIVE, "v1.0.5", "SunDirect");

        Mockito.when(setupBoxRepo.save(setupBox1)).thenReturn(setupBox1);

        SetupBox savedBox = setupBox.saveSetUpBox(setupBox1);

        Assertions.assertEquals(Status.INACTIVE, savedBox.getStatus());
        Assertions.assertEquals("SunDirect", savedBox.getSoftware());
    }

    @Test
    public void testSaveSetUpBox4() {
        SetupBox setupBox1 = new SetupBox(5, "10.10.0.1", SetUpBoxType.HD, "VD987", Status.ACTIVE, "v4.2.3", "Videocon");

        Mockito.when(setupBoxRepo.save(setupBox1)).thenReturn(setupBox1);

        SetupBox savedBox = setupBox.saveSetUpBox(setupBox1);

        Assertions.assertEquals("v4.2.3", savedBox.getVersion());
        Assertions.assertEquals("Videocon", savedBox.getSoftware());
    }


}