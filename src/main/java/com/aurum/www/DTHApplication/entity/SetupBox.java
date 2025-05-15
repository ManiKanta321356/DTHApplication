package com.aurum.www.DTHApplication.entity;

import com.aurum.www.DTHApplication.enums.SetUpBoxType;
import com.aurum.www.DTHApplication.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "setupBox")
public class SetupBox
{
    @Id
    private int id;
    private String ipAddress;
    private SetUpBoxType setUpBoxType;
    private String setUpBoxId;
    private Status status;
    private String version;
    private String software;

    public SetupBox(int id, String ipAddress, SetUpBoxType setUpBoxType, String setUpBoxId, Status status, String version, String software) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.setUpBoxType = setUpBoxType;
        this.setUpBoxId = setUpBoxId;
        this.status = status;
        this.version = version;
        this.software = software;
    }

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

    public SetUpBoxType getSetUpBoxType() {
        return setUpBoxType;
    }

    public void setSetUpBoxType(SetUpBoxType setUpBoxType) {
        this.setUpBoxType = setUpBoxType;
    }

    public String getSetUpBoxId() {
        return setUpBoxId;
    }

    public void setSetUpBoxId(String setUpBoxId) {
        this.setUpBoxId = setUpBoxId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
