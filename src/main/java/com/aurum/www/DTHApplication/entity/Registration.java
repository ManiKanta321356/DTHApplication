package com.aurum.www.DTHApplication.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registrations")
public class Registration
{
    @Id
    private int id;
    @Indexed(unique = true)
    private String idProofNumber;
    private String idProofType;
    private String registrationDate;
    @Indexed(unique = true)
    private String registrationId;
    private String sellerId;
    @DBRef
    private SetupBox setupBox;

    public Registration(int id, String idProofNumber, String idProofType, String registrationDate, String registrationId, String sellerId, SetupBox setupBox) {
        this.id = id;
        this.idProofNumber = idProofNumber;
        this.idProofType = idProofType;
        this.registrationDate = registrationDate;
        this.registrationId = registrationId;
        this.sellerId = sellerId;
        this.setupBox = setupBox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdProofNumber() {
        return idProofNumber;
    }

    public void setIdProofNumber(String idProofNumber) {
        this.idProofNumber = idProofNumber;
    }

    public String getIdProofType() {
        return idProofType;
    }

    public void setIdProofType(String idProofType) {
        this.idProofType = idProofType;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public SetupBox getSetupBox() {
        return setupBox;
    }

    public void setSetupBox(SetupBox setupBox) {
        this.setupBox = setupBox;
    }
}
