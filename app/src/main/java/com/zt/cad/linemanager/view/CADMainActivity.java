package com.zt.cad.linemanager.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import com.MxDraw.McDbAttribute;
import com.MxDraw.McDbBlockReference;
import com.MxDraw.McDbBlockTable;
import com.MxDraw.McDbBlockTableRecord;
import com.MxDraw.McDbEntity;
import com.MxDraw.McGePoint3d;
import com.MxDraw.MrxDbgUiPrPoint;
import com.MxDraw.MxDrawActivity;
import com.MxDraw.MxDrawDragEntity;
import com.MxDraw.MxFunction;
import com.MxDraw.MxLibDraw;
import com.zt.cad.linemanager.R;
import com.zt.cad.linemanager.entity.db.SysProjectEntity;

import org.cocos2dx.lib.Cocos2dxEditBox;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;
import org.cocos2dx.lib.ResizeLayout;

// TODO: 2020/3/26 删除和移动事件 不知如何监听
// TODO: 2020/3/26  移动事件不再管 随便移动 自己改数据 删除事件未定
// TODO: 2020/3/26 划线按照交互式直线绘图来 绘图完毕后 利用数据查询 查出最近点 决定起点和终点
// TODO: 2020/3/26 画点使用动态画图块  iCommand==22
public class CADMainActivity extends MxDrawActivity implements View.OnClickListener {
    protected boolean m_isLoadAndroidLayoutUi = false;
    public static final String PROJECT_TAG = "PROJECT_TAG";
    private SysProjectEntity data;
    private long lId = 0;//被点击对象id

    private ImageButton ibDrawPoint;
    private ImageButton ibDrawLine;
    private ImageButton ibDrawInfo;
    private ImageButton ibDrawDelete;

    private View[] opens;
    private Double[] start;
    private long start_tah = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        m_isLoadAndroidLayoutUi = true;
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            data = (SysProjectEntity) getIntent().getSerializableExtra(PROJECT_TAG);
        } else {
            data = (SysProjectEntity) savedInstanceState.getSerializable(PROJECT_TAG);
        }
        String filePath = data.getCadPath();
        MxFunction.openFile(filePath);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(PROJECT_TAG, data);
    }

    @Override
    public boolean createInterfaceLayout() {
        if (!m_isLoadAndroidLayoutUi) return false;
        setContentView(R.layout.ac_cadmain);
        ResizeLayout mFrameLayout = findViewById(R.id.my_frame);
        Cocos2dxGLSurfaceView mGLSurfaceView = findViewById(R.id.view_cad);
        Cocos2dxEditBox edittext = findViewById(R.id.my_edittext);
        initInterfaceLayout(mFrameLayout, edittext, mGLSurfaceView);

        ibDrawPoint = findViewById(R.id.ib_draw_point);
        ibDrawLine = findViewById(R.id.ib_draw_line);
        ibDrawInfo = findViewById(R.id.ib_draw_info);
        ibDrawDelete = findViewById(R.id.ib_draw_delete);
        opens = new View[]{ibDrawPoint, ibDrawLine, ibDrawInfo, ibDrawDelete};

        ibDrawPoint.setOnClickListener(this);
        ibDrawLine.setOnClickListener(this);
        ibDrawInfo.setOnClickListener(this);
        ibDrawDelete.setOnClickListener(this);
        return true;
    }

    @Override
    public void mcrxEntryPoint(int iCode) {
        super.mcrxEntryPoint(iCode);
        if (iCode == kInitAppMsg) {
            copyShxFile("aaa.shx");
            MxFunction.setShowFileBrowse(false);
            MxFunction.setShowUpToolBar(false);
            MxFunction.setShowDownToolBar(true);
            MxFunction.setShowReturnButton(false);
            MxFunction.enableSelect(true);
            MxFunction.enableGridEdit(true);
            MxFunction.setShowTip(true);
            MxFunction.enablePopToolbar(true);
            MxFunction.setToolFile("mxtool.json");
            MxFunction.setMenuFile("mxmenu.json");
            MxFunction.setReadFileContent(ReadContent.kFastRead | ReadContent.kReadObjectsDictionary | ReadContent.kReadxData | ReadContent.kReadNamedObjectsDictionary | ReadContent.kReadXrecord);
            // 注意，在读取扩展数据，或字典时，必须调用下面函数，指定要加的扩展数据应用名，或字典名字。
            // 如下，调用，加载Ports，PortLinks名的扩展数据。
            MxFunction.addSupportAppName("Ports");
            MxFunction.addSupportAppName("PortLinks");

            // 或如下调用，加载所有名称数据。
            MxFunction.addSupportAppName("*");
            MxFunction.enableUndo();
            MxFunction.setShowTitle(true);
            MxFunction.enablePopToolbar(true);
            MxFunction.setSaveZValue(true);
            MxFunction.disabledCommandToolbar(false);
            MxFunction.setSaveDwgVersion(MxFunction.DwgVersion.kCAD2007);
            MxFunction.clearDefaultFavorite();
            MxFunction.addDefaultFavorite("MyFavorite", MxFunction.getWorkDir() + "/fonts");
            MxFunction.keepSelected(true);

        } else if (iCode == kStartScene) {

        }
    }

    @Override
    public void selectModified(long lId) {//对象被选中
        this.lId = lId;
        Log.e("d22", "lId-" + lId);
        super.selectModified(lId);
    }

    /**
     * @param iType 0 点击 3长按
     * @param dX
     * @param dY
     * @return
     */
    @Override
    public int touchesEvent(int iType, double dX, double dY) {
        double[] ret = MxFunction.docToView(dX, dY);//实际坐标
        switch (iType) {
            case 0: {
                pointClick(dX, dY, ret[0], ret[1]);
                break;
            }
        }
        return 0;
    }

    private void pointClick(double dx, double dy, double tX, double tY) {
        if (lId == 0) {//创建管点数据
            if (isDrawMarker()) {
                DynCreateBlock(dx, dy);
            } else if (isDrawLine()) {
                drawLine(dx, dy);
            }
        } else if (isMarkerInfo()) {//点and线详情
            McDbEntity entity = new McDbEntity(lId);
            String sName = MxFunction.getTypeName(lId);
            if (sName.equals("McDbLine")) {//线

            } else if (sName.equals("McDbBlockReference")) {
                //块
            }
        } else if (isDelete()) {
            MxFunction.deleteObject(lId);
//            saveData();
        } else if (isDrawLine()) {
            drawLine(dx, dy);
        }
    }


    private void drawLine(double dx, double dy) {
        long[] rgb = new long[3];
        rgb[0] = 255;
        rgb[1] = 0;
        rgb[2] = 0;
        if (start == null) {
            start = new Double[]{dx, dy};
            MxLibDraw.setDrawColor(rgb);
            start_tah = MxLibDraw.drawCircle(dx, dy, 10);
            return;
        }
        // 设置画图颜色.
        MxLibDraw.setDrawColor(rgb);
        MxLibDraw.setLineWidth(3);
        MxLibDraw.drawLine(start[0], start[1], dx, dy);
//        saveData();
        cleanTag();
        selectindex(2);
    }

    //清除画线标识
    private void cleanTag() {
        if (start_tah != 0) {
            MxFunction.deleteObject(start_tah);
            start_tah = 0;
        }
        start = null;
    }

    /**
     * 画点 图块
     */
    public void DynCreateBlock(double dx, double dy) {
        String sFileName = String.format("%s/%s.dwg", MxFunction.getWorkDir(), "add");
        String sBlkName = String.format("机房_%s", "add");

        MxLibDraw.insertBlock(sFileName, "TempBlkName");
        long lId = MxLibDraw.drawBlockReference(dx, dy,sBlkName, 1, 0);
        if (true)return;


        // 得到块表
        McDbBlockTable blkTab = MxFunction.getCurrentDatabase().getBlockTable();

        // 添加一个块表记录,块名为空，是个匿名块
        long lBlkRec = blkTab.add("");
        McDbBlockTableRecord blkRec = new McDbBlockTableRecord(lBlkRec);

        // 绘制直线
        long lLine = MxLibDraw.drawLine(100, 100, 200, 200);
        long lCircle = MxLibDraw.drawCircle(100, 100, 30);

        // 把绘制直线加到块表记录中.
        long lNewId = blkRec.addCloneEntity(lLine);
        blkRec.addCloneEntity(lCircle);

        // 删除之前临时画的对象。
        MxFunction.deleteObject(lLine);
        MxFunction.deleteObject(lCircle);

        // 绘制块引用，引用刚才做的匿名块
        long lIdBlkRef = MxLibDraw.drawBlockReference2(dx, dy, lBlkRec, 1, 0);
        McDbBlockReference blkRef = new McDbBlockReference(lIdBlkRef);
        McDbAttribute attrib = blkRef.appendAttribute();
        McGePoint3d pt = new McGePoint3d(50, 50, 0);
        attrib.setPosition(pt);
        attrib.setAlignmentPoint(pt);
        attrib.setTextString("TestAttrib");
        attrib.setHeight(30);
        attrib.setInvisible(false);
        blkRef.assertWriteEnabled();
    }


    /**
     * 保存数据 每次操作都保存一次 导致速度慢  so手动
     */
    private void saveData() {
        MxFunction.writeFile(data.getCadPath());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_draw_point: {
                selectindex(0);
                break;
            }
            case R.id.ib_draw_line: {
                selectindex(1);
                break;
            }
            case R.id.ib_draw_info: {
                selectindex(2);
                break;
            }
            case R.id.ib_draw_delete: {
                selectindex(3);
                break;
            }
        }
    }

    private void selectindex(int index) {
        boolean isSelected = opens[index].isSelected();
        for (int i = 0; i < opens.length; i++) {
            boolean value = (i == index);
            if (value) {
                if (isSelected) {
                    value = !value;
                }
            }
            opens[i].setTag(value);
            opens[i].setSelected(value);
        }
        cleanTag();
    }


    private boolean isDrawMarker() {
        if (ibDrawPoint.getTag() == null) {
            return false;
        } else {
            return (boolean) ibDrawPoint.getTag();
        }
    }

    private boolean isDrawLine() {
        if (ibDrawLine.getTag() == null) {
            return false;
        } else {
            return (boolean) ibDrawLine.getTag();
        }
    }


    private boolean isMarkerInfo() {
        if (ibDrawInfo.getTag() == null) {
            return false;
        } else {
            return (boolean) ibDrawInfo.getTag();
        }
    }

    private boolean isDelete() {
        if (ibDrawDelete.getTag() == null) {
            return false;
        } else {
            return (boolean) ibDrawDelete.getTag();
        }

    }

    @Override
    public void onKeyReleased(int iKeyCode) {
        super.onKeyReleased(iKeyCode);
        saveData();
        finish();
    }
}
