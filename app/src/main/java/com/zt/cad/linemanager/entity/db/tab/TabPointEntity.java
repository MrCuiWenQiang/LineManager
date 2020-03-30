package com.zt.cad.linemanager.entity.db.tab;

import android.text.TextUtils;

import com.zt.cad.linemanager.util.out.AccessTableName;
import com.zt.cad.linemanager.util.out.ExcelCount;
import com.zt.cad.linemanager.util.out.ExcelName;

import org.litepal.crud.LitePalSupport;


/**
 *
 * 管点表
 */
@AccessTableName(name = "JS_POINT")
@ExcelName(TabName = "管点表")
public class TabPointEntity extends LitePalSupport {
    private long id;
    private long projectId;
    private long typeId;//类型id
    private long cadId;//CAD管块id
    @ExcelCount(order = 0, name = "管类")
    private String gxlx;
    @ExcelCount(order = 1, name = "物探点号")
    private String wtdh;
    @ExcelCount(order = 2, name = "特征")
    private String tzd;
    @ExcelCount(order = 3, name = "附属物")
    private String fsw;
    @ExcelCount(order = 4, name = "井底深")
    private String jds;
    @ExcelCount(order = 5, name = "数据来源")
    private String Sjly;
    @ExcelCount(order = 6, name = "获取时机")
    private String hqsj;
    @ExcelCount(order = 7, name = "井盖类型")
    private String jglx;
    @ExcelCount(order = 8, name = "井盖规格")
    private String jggg;
    @ExcelCount(order = 9, name = "偏心井点号")
    private String pxjw;
    @ExcelCount(order = 10, name = "偏距")
    private String pj;
    //    @ExcelCount(order = 12, name = "测绘横坐标")
    private double chlatitude;
    //    @ExcelCount(order = 13, name = "测绘纵坐标")
    private double chlongitude;
    //    @ExcelCount(order = 11, name = "地面高程")
    private String dmgc;
    @ExcelCount(order = 12, name = "井盖材质")
    private String jgcz;
    //    @ExcelCount(order = 16, name = "权属单位")
    private String qsdw;
    @ExcelCount(order = 13, name = "建设年代")
    private String Jsrq;
    @ExcelCount(order = 14, name = "所在位置")
    private String szwz;
    @ExcelCount(order = 15, name = "管点范畴")
    private String fc;
    //    @ExcelCount(order = 11, name = "井类型")
    private String jlx;
    //    @ExcelCount(order = 12, name = "井直径")
    private String jzj;
    //    @ExcelCount(order = 13, name = "井脖深")
    private String jbs;
    //    @ExcelCount(order = 18, name = "井盖状态")
    private String jgzt;
    //    @ExcelCount(order = 20, name = "使用状态")
    private String syzt;
    //    @ExcelCount(order = 21, name = "探测方式")
    private String tcfs;
    //    @ExcelCount(order = 22, name = "所在河道")
    private String szhd;
    //    @ExcelCount(order = 23, name = "排水户名称")
    private String pshmc;
    //    @ExcelCount(order = 22, name = "影像资料文件编号")
    private String wjbh;
    //    @ExcelCount(order = 25, name = "隐患情况说明")
    private String qksm;
    @ExcelCount(order = 23, name = "是否长输")
    private String Sfcs;
    @ExcelCount(order = 23, name = "更新状态")
    private String Gxzt;
    @ExcelCount(order = 23, name = "是否利用")
    private String Sfly;
    @ExcelCount(order = 24, name = "测量点号")
    private String cldh;
    @ExcelCount(order = 120, name = "备注")
    private String remarks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getCadId() {
        return cadId;
    }

    public void setCadId(long cadId) {
        this.cadId = cadId;
    }

    public String getGxlx() {
        return gxlx;
    }

    public void setGxlx(String gxlx) {
        this.gxlx = gxlx;
    }

    public String getWtdh() {
        return wtdh;
    }

    public void setWtdh(String wtdh) {
        this.wtdh = wtdh;
    }

    public String getTzd() {
        return tzd;
    }

    public void setTzd(String tzd) {
        this.tzd = tzd;
    }

    public String getFsw() {
        return fsw;
    }

    public void setFsw(String fsw) {
        this.fsw = fsw;
    }

    public String getJds() {
        return jds;
    }

    public void setJds(String jds) {
        this.jds = jds;
    }

    public String getSjly() {
        return Sjly;
    }

    public void setSjly(String sjly) {
        Sjly = sjly;
    }

    public String getHqsj() {
        return hqsj;
    }

    public void setHqsj(String hqsj) {
        this.hqsj = hqsj;
    }

    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    public String getJggg() {
        return jggg;
    }

    public void setJggg(String jggg) {
        this.jggg = jggg;
    }

    public String getPxjw() {
        return pxjw;
    }

    public void setPxjw(String pxjw) {
        this.pxjw = pxjw;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public double getChlatitude() {
        return chlatitude;
    }

    public void setChlatitude(double chlatitude) {
        this.chlatitude = chlatitude;
    }

    public double getChlongitude() {
        return chlongitude;
    }

    public void setChlongitude(double chlongitude) {
        this.chlongitude = chlongitude;
    }

    public String getDmgc() {
        return dmgc;
    }

    public void setDmgc(String dmgc) {
        this.dmgc = dmgc;
    }

    public String getJgcz() {
        return jgcz;
    }

    public void setJgcz(String jgcz) {
        this.jgcz = jgcz;
    }

    public String getQsdw() {
        return qsdw;
    }

    public void setQsdw(String qsdw) {
        this.qsdw = qsdw;
    }

    public String getJsrq() {
        return Jsrq;
    }

    public void setJsrq(String jsrq) {
        Jsrq = jsrq;
    }

    public String getSzwz() {
        return szwz;
    }

    public void setSzwz(String szwz) {
        this.szwz = szwz;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getJlx() {
        return jlx;
    }

    public void setJlx(String jlx) {
        this.jlx = jlx;
    }

    public String getJzj() {
        return jzj;
    }

    public void setJzj(String jzj) {
        this.jzj = jzj;
    }

    public String getJbs() {
        return jbs;
    }

    public void setJbs(String jbs) {
        this.jbs = jbs;
    }

    public String getJgzt() {
        return jgzt;
    }

    public void setJgzt(String jgzt) {
        this.jgzt = jgzt;
    }

    public String getSyzt() {
        return syzt;
    }

    public void setSyzt(String syzt) {
        this.syzt = syzt;
    }

    public String getTcfs() {
        return tcfs;
    }

    public void setTcfs(String tcfs) {
        this.tcfs = tcfs;
    }

    public String getSzhd() {
        return szhd;
    }

    public void setSzhd(String szhd) {
        this.szhd = szhd;
    }

    public String getPshmc() {
        return pshmc;
    }

    public void setPshmc(String pshmc) {
        this.pshmc = pshmc;
    }

    public String getWjbh() {
        return wjbh;
    }

    public void setWjbh(String wjbh) {
        this.wjbh = wjbh;
    }

    public String getQksm() {
        return qksm;
    }

    public void setQksm(String qksm) {
        this.qksm = qksm;
    }

    public String getSfcs() {
        return Sfcs;
    }

    public void setSfcs(String sfcs) {
        Sfcs = sfcs;
    }

    public String getGxzt() {
        return Gxzt;
    }

    public void setGxzt(String gxzt) {
        Gxzt = gxzt;
    }

    public String getSfly() {
        return Sfly;
    }

    public void setSfly(String sfly) {
        Sfly = sfly;
    }

    public String getCldh() {
        return cldh;
    }

    public void setCldh(String cldh) {
        this.cldh = cldh;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
