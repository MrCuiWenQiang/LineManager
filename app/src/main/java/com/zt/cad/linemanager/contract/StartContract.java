package com.zt.cad.linemanager.contract;

public class StartContract {
    public interface View {
        void initData_success();
        void initData_fail(String msg);
    }

    public interface Presenter {
        void initData();
    }

    public interface Model {
    }
}
