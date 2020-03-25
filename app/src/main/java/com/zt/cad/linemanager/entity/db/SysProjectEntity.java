package com.zt.cad.linemanager.entity.db;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

public class SysProjectEntity extends LitePalSupport implements Serializable {
    private long id;
    private String name;
    private String cadPath;
    private String updateTimer;
    private String createTimer;

    public SysProjectEntity() {
    }

    public SysProjectEntity(long id, String name, String updateTimer) {
        this.id = id;
        this.name = name;
        this.updateTimer = updateTimer;
    }

    public SysProjectEntity(String name, String cadPath, String createTimer) {
        this.name = name;
        this.cadPath = cadPath;
        this.createTimer = createTimer;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCadPath() {
        return cadPath;
    }

    public void setCadPath(String cadPath) {
        this.cadPath = cadPath;
    }

    public String getUpdateTimer() {
        return updateTimer;
    }

    public void setUpdateTimer(String updateTimer) {
        this.updateTimer = updateTimer;
    }

    public String getCreateTimer() {
        return createTimer;
    }

    public void setCreateTimer(String createTimer) {
        this.createTimer = createTimer;
    }
}
