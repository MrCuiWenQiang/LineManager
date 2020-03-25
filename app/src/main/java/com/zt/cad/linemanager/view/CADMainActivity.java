package com.zt.cad.linemanager.view;

import android.os.Bundle;
import android.util.Log;

import com.MxDraw.MxDrawActivity;
import com.MxDraw.MxFunction;
import com.zt.cad.linemanager.R;
import com.zt.cad.linemanager.entity.db.SysProjectEntity;

import org.cocos2dx.lib.Cocos2dxEditBox;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;
import org.cocos2dx.lib.ResizeLayout;

public class CADMainActivity extends MxDrawActivity {
    protected boolean m_isLoadAndroidLayoutUi = false;
    public static final String PROJECT_TAG = "PROJECT_TAG";
    private String filePath;
    private SysProjectEntity data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        m_isLoadAndroidLayoutUi = true;
        super.onCreate(savedInstanceState);
        if (savedInstanceState==null){
            data = (SysProjectEntity) getIntent().getSerializableExtra(PROJECT_TAG);
            filePath = data.getCadPath();
        }
        MxFunction.openFile(filePath);
    }

    @Override
    public boolean createInterfaceLayout() {
        if (!m_isLoadAndroidLayoutUi) return false;

        setContentView(R.layout.ac_cadmain);
        ResizeLayout mFrameLayout = (ResizeLayout) this.findViewById(R.id.my_frame);

        Cocos2dxGLSurfaceView mGLSurfaceView = (Cocos2dxGLSurfaceView) this.findViewById(R.id.view_cad);
        Cocos2dxEditBox edittext = (Cocos2dxEditBox) this.findViewById(R.id.my_edittext);
        initInterfaceLayout(mFrameLayout, edittext, mGLSurfaceView);
//        String filePath = MxFunction.getWorkDir() + "/tree.dwg";
//        MxFunction.openFile(filePath);

        return true;
    }

    @Override
    public void mcrxEntryPoint(int iCode) {
        super.mcrxEntryPoint(iCode);
        if (iCode == kInitAppMsg) {
            copyShxFile("aaa.shx");
            MxFunction.setShowFileBrowse(false);
            MxFunction.setShowUpToolBar(true);
            MxFunction.setShowDownToolBar(true);
            MxFunction.setShowReturnButton(true);
            MxFunction.enableSelect(true);
            MxFunction.enableGridEdit(true);
            MxFunction.setShowTip(true);
            MxFunction.enablePopToolbar(true);
            //MxFunction.setViewColor(255,255,255);
            MxFunction.setToolFile("mxtool.json");
            MxFunction.setMenuFile("mxmenu.json");
            //MxFunction.setReadFileContent(ReadContent.kFastRead | ReadContent.kReadObjectsDictionary | ReadContent.kReadXrecord | ReadContent.kReadNamedObjectsDictionary );
            MxFunction.setReadFileContent(ReadContent.kFastRead | ReadContent.kReadObjectsDictionary | ReadContent.kReadxData | ReadContent.kReadNamedObjectsDictionary | ReadContent.kReadXrecord);

            // 注意，在读取扩展数据，或字典时，必须调用下面函数，指定要加的扩展数据应用名，或字典名字。
            // 如下，调用，加载Ports，PortLinks名的扩展数据。
            MxFunction.addSupportAppName("Ports");
            MxFunction.addSupportAppName("PortLinks");

            // 或如下调用，加载所有名称数据。
            MxFunction.addSupportAppName("*");

            //MxFunction.setReadFileContent(ReadContent.kFastRead | ReadContent.kReadObjectsDictionary | ReadContent.kReadNamedObjectsDictionary );

            MxFunction.enableUndo();
            MxFunction.setShowTitle(true);
            //MxFunction.setGridColor(255,0,0,0.5);
            //MxFunction.setGridWidth(2);

            // MxFunction.setShow(MxFunction.ShowType.kFavorite,false);
            // MxFunction.setShow(MxFunction.ShowType.kRecently,false);

            //
            //MxFunction.setLanguage(MxFunction.MxSystemLanager.kEn);
            MxFunction.enablePopToolbar(true);

            //MxFunction.setAsyncMode(true);

            MxFunction.setSaveZValue(true);
            MxFunction.disabledCommandToolbar(false);
            //MxFunction.enablePopToolbar(true);
            MxFunction.setSaveDwgVersion(MxFunction.DwgVersion.kCAD2007);
            MxFunction.clearDefaultFavorite();
            MxFunction.addDefaultFavorite("MyFavorite", MxFunction.getWorkDir() + "/fonts");
            //MxFunction.setArcDensityAngle(6);
            MxFunction.keepSelected(true);
            //MxFunction.setAutoSaveFile(false);
            //MxFunction.setOsnapZValue(true);

            //MxFunction.setSysVarLong("OSMODE");
            //MxFunction.setAutoRegen(true);

        } else if (iCode == kStartScene) {

        }


    }

    @Override
    public void selectModified(long lId) {//对象被选中
        Log.e("d22", "lId-" + lId);
        super.selectModified(lId);
    }

    @Override
    public int touchesEvent(int iType, double dX, double dY) {
        Log.e("d22", "type-" + iType);

        return 0;
    }
}
