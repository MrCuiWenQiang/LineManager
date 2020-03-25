package com.zt.cad.linemanager.view;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.zt.cad.linemanager.R;
import com.zt.cad.linemanager.contract.MainContract;
import com.zt.cad.linemanager.entity.db.SysProjectEntity;
import com.zt.cad.linemanager.presenter.MainPresenter;
import com.zt.cad.linemanager.view.adapter.MainProjectAdapter;

import java.io.File;
import java.util.List;

import cn.faker.repaymodel.mvp.BaseMVPAcivity;
import cn.faker.repaymodel.util.SpaceItemDecoration;
import cn.faker.repaymodel.util.ToastUtility;
import cn.faker.repaymodel.widget.view.BaseRecycleView;

public class MainActivity extends BaseMVPAcivity<MainContract.View, MainPresenter> implements MainContract.View, View.OnClickListener {

    String[] PERMISSIONS_STORAGE = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    private RecyclerView rv_list;
    private MainProjectAdapter adapter = new MainProjectAdapter();

    @Override
    protected int getLayoutContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initContentView() {
        setTitle("项目列表", R.color.white);
        setToolBarBackgroundColor(R.color.t_rule);
        isShowBackButton(false);
        rv_list = findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_list.addItemDecoration(new SpaceItemDecoration(5));
        rv_list.setAdapter(adapter);


        setRightBtn("创建项目", R.color.white, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog();
            }
        });
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        int write_permission = ActivityCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (write_permission != 0) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 1);
        }

        int read_permission = ActivityCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE");
        if (read_permission != 0) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 1);
        }
        mPresenter.queryProject();
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseRecycleView.OnItemClickListener<SysProjectEntity>() {
            @Override
            public void onItemClick(View view, SysProjectEntity data, int position) {
                File file = new File(data.getCadPath());
                if (!file.exists()){
                    ToastUtility.showToast("无法打开:工程CAD文件不存在");
                    return;
                }
                Intent intent = new Intent(getContext(), CADMainActivity.class);
                intent.putExtra(CADMainActivity.PROJECT_TAG, data);
                startActivity(intent);
            }
        });
    }

    @Override
    public void createProject_fail(String s) {
        dimiss();
        ToastUtility.showToast(s);
    }

    @Override
    public void editProject_fail(String s) {
        dimiss();
        ToastUtility.showToast(s);
    }

    @Override
    public void queryProject_fail(String msg) {
        dimiss();
        ToastUtility.showToast(msg);
    }

    @Override
    public void queryProject_success(List<SysProjectEntity> sysProjectEntities) {
        dimiss();
        adapter.setDatas(sysProjectEntities);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    private void showEditDialog() {
        final QMUIDialog.EditTextDialogBuilder builder = new QMUIDialog.EditTextDialogBuilder(getContext());
        builder.setTitle("项目创建")
                .setPlaceholder("请在此输入项目名称")
                .setInputType(InputType.TYPE_CLASS_TEXT)
                .addAction("创建", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        CharSequence text = builder.getEditText().getText();
                        if (text == null || text.length() <= 0) {
                            ToastUtility.showToast("请输入名称");
                            return;
                        }
                        showLoading();
                        mPresenter.createProject(text.toString());
                    }
                }).addAction("取消", new QMUIDialogAction.ActionListener() {
            @Override
            public void onClick(QMUIDialog dialog, int index) {
                dialog.dismiss();
            }
        }).show();
    }
}
