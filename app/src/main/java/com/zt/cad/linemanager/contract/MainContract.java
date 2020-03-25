package com.zt.cad.linemanager.contract;

import com.zt.cad.linemanager.entity.db.SysProjectEntity;

import java.util.List;

public class MainContract {
    public interface View {
        void createProject_fail(String s);

        void editProject_fail(String s);

        void queryProject_fail(String msg);

        void queryProject_success(List<SysProjectEntity> sysProjectEntities);
    }

    public interface Presenter {
        void queryProject();

        void createProject(String name);

        void removeProject(long id);

        void editProject(long id, String name);
    }

    public interface Model {
    }
}
