package com.zt.cad.linemanager.presenter;


import com.zt.cad.linemanager.contract.StartContract;
import com.zt.cad.linemanager.model.SystemInitModel;

import cn.faker.repaymodel.mvp.BaseMVPPresenter;

public class StartPresenter extends BaseMVPPresenter<StartContract.View> implements StartContract.Presenter {
    private SystemInitModel initModel = new SystemInitModel();

    @Override
    public void initData() {
        getView().initData_success();
/*        initModel.initType(new BaseMVPModel.CommotListener<Boolean>() {
            @Override
            public void result(Boolean aBoolean) {
                if (getView()==null){
                    return;
                }
                if (aBoolean){
                    getView().initData_success();
                }else {
                    getView().initData_fail("数据初始化失败");
                }
            }
        });*/
    }
}
