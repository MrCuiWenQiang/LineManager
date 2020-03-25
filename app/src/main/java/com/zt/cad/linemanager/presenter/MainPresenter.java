package com.zt.cad.linemanager.presenter;


import com.zt.cad.linemanager.contract.MainContract;
import com.zt.cad.linemanager.entity.db.SysProjectEntity;
import com.zt.cad.linemanager.util.AccessUtil;

import java.util.List;

import cn.faker.repaymodel.mvp.BaseMVPPresenter;
import cn.faker.repaymodel.util.DateUtils;
import cn.faker.repaymodel.util.db.DBThreadHelper;
import cn.faker.repaymodel.util.db.litpal.LitPalUtils;

public class MainPresenter extends BaseMVPPresenter<MainContract.View> implements MainContract.Presenter {


    @Override
    public void queryProject() {
        DBThreadHelper.startThreadInPool(new DBThreadHelper.ThreadCallback<List<SysProjectEntity>>() {

            @Override
            protected List<SysProjectEntity> jobContent() throws Exception {
                return LitPalUtils.selectWhere(SysProjectEntity.class);
            }

            @Override
            protected void jobEnd(List<SysProjectEntity> sysProjectEntities) {
                if (sysProjectEntities != null && sysProjectEntities.size() > 0) {
                    getView().queryProject_success(sysProjectEntities);
                } else {
                    getView().queryProject_fail("暂无工程");
                }
            }
        });
    }

    @Override
    public void createProject(final String name) {
        if (name==null){
            getView().createProject_fail("创建失败:名称不能为空");
            return;
        }
        DBThreadHelper.startThreadInPool(new DBThreadHelper.ThreadCallback<Boolean>() {

            @Override
            protected Boolean jobContent() throws Exception {
                int count = LitPalUtils.selectCount(SysProjectEntity.class, "name = ?", name);
                if (count > 0) {
                    return false;
                }
                String filePath = AccessUtil.copyAssetsFileToSdcard(name+".dwg");
                String createTimer = DateUtils.getCurrentDateTime();
                SysProjectEntity entity = new SysProjectEntity(name, filePath, createTimer);
                return entity.save();
            }

            @Override
            protected void jobEnd(Boolean aBoolean) {
                if (aBoolean){
                    queryProject();
                }else {
                    getView().createProject_fail("创建失败:已存在相同名称");
                }
            }
        });
    }

    @Override
    public void removeProject(final long id) {
        DBThreadHelper.startThreadInPool(new DBThreadHelper.ThreadCallback<Boolean>() {

            @Override
            protected Boolean jobContent() throws Exception {
                 LitPalUtils.deleteData(SysProjectEntity.class, "id = ?", id+"");
                return true;
            }

            @Override
            protected void jobEnd(Boolean aBoolean) {
                queryProject();
            }
        });
    }

    @Override
    public void editProject(final long id,final String name) {
        if (name==null){
            getView().editProject_fail("修改失败:名称不能为空");
        }
        DBThreadHelper.startThreadInPool(new DBThreadHelper.ThreadCallback<Boolean>() {

            @Override
            protected Boolean jobContent() throws Exception {
                SysProjectEntity entity = LitPalUtils.selectsoloWhere(SysProjectEntity.class, "id = ?", id+"");
               if (entity==null){
                   return false;
               }
                entity.setUpdateTimer(DateUtils.getCurrentDateTime());
                entity.setName(name);
                return entity.save();
            }

            @Override
            protected void jobEnd(Boolean aBoolean) {
                queryProject();
            }
        });
    }
}
