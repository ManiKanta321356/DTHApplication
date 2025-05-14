package com.aurum.www.DTHApplication.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "setupBox")
public class SetupBox
{
    @Id
    private int id;
    private String ipAddress;
    private String setUpBoxType;
    private String setUpBoxId;
    private String status;
    private String version;
    private String software;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSetUpBoxType() {
        return setUpBoxType;
    }

    public void setSetUpBoxType(String setUpBoxType) {
        this.setUpBoxType = setUpBoxType;
    }

    public String getSetUpBoxId() {
        return setUpBoxId;
    }

    public void setSetUpBoxId(String setUpBoxId) {
        this.setUpBoxId = setUpBoxId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }
}
