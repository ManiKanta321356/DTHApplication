package com.aurum.www.DTHApplication.service.Impl;

import com.aurum.www.DTHApplication.entity.Registration;
import com.aurum.www.DTHApplication.entity.SetupBox;
import com.aurum.www.DTHApplication.enums.IDProof;
import com.aurum.www.DTHApplication.enums.SetUpBoxType;
import com.aurum.www.DTHApplication.enums.Status;
import com.aurum.www.DTHApplication.repo.RegistrationRepo;
import com.aurum.www.DTHApplication.repo.SetupBoxRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegistrationImplTest {

    @Mock
    RegistrationRepo registrationRepo;

    @Mock
    SetupBoxRepo setupBoxRepo;
    @InjectMocks
    RegistrationImpl registrationImpl;

    @Test
    public void testSaveRegistration(){

        SetupBox setupBox = new SetupBox(1,"192.1.0.1", SetUpBoxType.HD,"TD123", Status.ACTIVE,"v1.1.0","TataDish");

        Registration registration = new Registration(1,"4455 6666 6598 4363", IDProof.ADHAR_NUMBER, LocalDate.now(),"REG123","SELL789",setupBox);

        Mockito.when(setupBoxRepo.findById(1)).thenReturn(Optional.of(setupBox));
        Mockito.when(registrationRepo.save(registration)).thenReturn(registration);

        Registration registration1 = registrationImpl.saveRegistration(registration);


        Assertions.assertEquals(1,registration1.getId());
        Assertions.assertEquals(IDProof.ADHAR_NUMBER, registration1.getIdProofType());

    }

    @Test
    public void testSaveRegistration1() {
        SetupBox setupBox = new SetupBox(2, "192.1.0.2", SetUpBoxType.SD, "TD456", Status.INACTIVE, "v2.0.0", "AirtelDish");

        Registration registration = new Registration(2, "P1234567", IDProof.VOTER_ID, LocalDate.now(), "REG124", "SELL790", setupBox);

        Mockito.when(setupBoxRepo.findById(2)).thenReturn(Optional.of(setupBox));
        Mockito.when(registrationRepo.save(registration)).thenReturn(registration);

        Registration registration1 = registrationImpl.saveRegistration(registration);

        Assertions.assertEquals("P1234567", registration1.getIdProofNumber());
        Assertions.assertEquals(IDProof.VOTER_ID, registration1.getIdProofType());
    }

    @Test
    public void testSaveRegistration2() {
        SetupBox setupBox = new SetupBox(3, "10.0.0.3", SetUpBoxType.HD, "TD789", Status.ACTIVE, "v1.2.3", "SunDirect");

        Registration registration = new Registration(3, "VOTER5678", IDProof.VOTER_ID, LocalDate.now(), "REG125", "SELL791", setupBox);

        Mockito.when(setupBoxRepo.findById(3)).thenReturn(Optional.of(setupBox));
        Mockito.when(registrationRepo.save(registration)).thenReturn(registration);

        Registration registration1 = registrationImpl.saveRegistration(registration);

        Assertions.assertEquals("VOTER5678", registration1.getIdProofNumber());
        Assertions.assertEquals("SELL791", registration1.getSellerId());
    }

    @Test
    public void testSaveRegistration3() {
        SetupBox setupBox = new SetupBox(4, "172.16.0.4", SetUpBoxType.SD, "TD999", Status.ACTIVE, "v3.0.0", "DishTV");

        Registration registration = new Registration(4, "DL9098765", IDProof.PAN_NUMBER, LocalDate.now(), "REG126", "SELL792", setupBox);

        Mockito.when(setupBoxRepo.findById(4)).thenReturn(Optional.of(setupBox));
        Mockito.when(registrationRepo.save(registration)).thenReturn(registration);

        Registration registration1 = registrationImpl.saveRegistration(registration);

        Assertions.assertEquals("REG126", registration1.getRegistrationId());
        Assertions.assertEquals(IDProof.PAN_NUMBER, registration1.getIdProofType());
    }

    @Test
    public void testSaveRegistration5() {
        SetupBox setupBox = new SetupBox(5, "10.10.10.5", SetUpBoxType.HD, "TD888", Status.INACTIVE, "v1.4.0", "D2H");

        Registration registration = new Registration(5, "PAN1234567", IDProof.PAN_NUMBER, LocalDate.now(), "REG127", "SELL793", setupBox);

        Mockito.when(setupBoxRepo.findById(5)).thenReturn(Optional.of(setupBox));
        Mockito.when(registrationRepo.save(registration)).thenReturn(registration);

        Registration registration1 = registrationImpl.saveRegistration(registration);

        Assertions.assertEquals(5, registration1.getId());
        Assertions.assertEquals("PAN1234567", registration1.getIdProofNumber());
    }



}