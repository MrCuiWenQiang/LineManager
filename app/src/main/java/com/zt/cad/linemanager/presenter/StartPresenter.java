package com.zt.cad.linemanager.presenter;


import com.zt.cad.linemanager.contract.StartContract;
import com.zt.cad.linemanager.model.SystemInitModel;
import com.zt.cad.linemanager.util.AccessUtil;

import cn.faker.repaymodel.mvp.BaseMVPPresenter;

// TODO: 2020/3/26 初始化需要把符号图块全部复制过去
public class StartPresenter extends BaseMVPPresenter<StartContract.View> implements StartContract.Presenter {
    private SystemInitModel initModel = new SystemInitModel();

    @Override
    public void initData() {
        String filePath = AccessUtil.copyAssetsFileToSdcard("add.dwg");
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
