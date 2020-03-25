package com.zt.cad.linemanager;
import org.litepal.LitePal;
import cn.faker.repaymodel.BasicApplication;
import cn.faker.repaymodel.util.LocImageUtility;
import cn.faker.repaymodel.util.LogUtil;
import cn.faker.repaymodel.util.ToastUtility;

public class MyApplication extends BasicApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        setting();
    }


    private void setting() {
        LogUtil.isShow = true;
        ToastUtility.setToast(getApplicationContext());
        LitePal.initialize(this);
        LogUtil.isShow = true;
        LocImageUtility.setImageUtility(this);
    }


}
