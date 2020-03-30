package com.zt.cad.linemanager.entity.db.tab;

import android.graphics.Color;
import android.text.TextUtils;

import com.zt.cad.linemanager.util.out.AccessTableName;
import com.zt.cad.linemanager.util.out.ExcelCount;
import com.zt.cad.linemanager.util.out.ExcelName;

import org.litepal.crud.LitePalSupport;

import java.util.Date;

import cn.faker.repaymodel.util.db.litpal.LitPalUtils;

@AccessTableName(name = "JS_LINE")
@ExcelName(TabName = "管线表")
public class TabLineEntity extends LitePalSupport {
    private long id;
    private long projectId;
    private long typeId;
    private long lineCadId;//CAD管块id
    private long startPointId;//起点数据库Id
    private long endPointId = -1;//终点数据库id
    @ExcelCount(order = 101, name = "起点纬度")
    private double start_latitude;
    @ExcelCount(order = 102, name = "起点经度")
    private double start_longitude;
    @ExcelCount(order = 103, name = "终点纬度")
    private double end_latitude;
    @ExcelCount(order = 104, name = "终点经度")
    private double end_longitude;
    @ExcelCount(order = 0, name = "管类")
    private String Gxlx;//管线类型
    @ExcelCount(order = 1, name = "管线类型")
    private String Gxoutlx;//管线类型输出

    // TODO: 2019/5/29 起始物号和终止物号 用pointID去查
    @ExcelCount(order = 2, name = "起点点号")
    private String Qswh;
    @ExcelCount(order = 3, name = "终点点号")
    private String Zzwh;

    @ExcelCount(order = 4, name = "起点埋深")
    private String Qdms;
    @ExcelCount(order = 5, name = "终点埋深")
    private String Zzms;
    @ExcelCount(order = 6, name = "材质")
    private String Gxcl;//材质
    @ExcelCount(order = 7, name = "埋设方式")
    private String Msfs;
    @ExcelCount(order = 8, name = "管径")
    private String Gjdm;//管径
    @ExcelCount(order = 9, name = "线型")
    private String xx;
    @ExcelCount(order = 10, name = "流向")
    private String lx;//流向
    @ExcelCount(order = 11, name = "套管材质")
    private String tgcz;
    @ExcelCount(order = 12, name = "条数")
    private String Ts;
    @ExcelCount(order = 13, name = "压力")
    private String yl;
    /*    @ExcelCount(order = 14,name = "电压")
        private String dy;*/
    @ExcelCount(order = 15, name = "总孔数")
    private String Zks;
    @ExcelCount(order = 16, name = "已用孔数")
    private String Yyks;
    @ExcelCount(order = 17, name = "所在位置")
    private String Szwz;//所在位置
    @ExcelCount(order = 18, name = "管线范畴")
    private String gxfc;

    //    @ExcelCount(order = 19,name = "起点淤积")
    private String Qdyj;
    //    @ExcelCount(order = 20,name = "终点淤积")
    private String Zdyj;
    //    @ExcelCount(order = 21,name = "运行状态")
    private String Yxzt;
    //    @ExcelCount(order = 22,name = "倒虹管段")
    private String Dhgd;
    @ExcelCount(order = 23, name = "建设年代")
    private String Jsnd;
    @ExcelCount(order = 24, name = "权属单位")
    private String Qsdw;

    @ExcelCount(order = 25, name = "使用状况")
    private String Syzt;
    //    @ExcelCount(order = 18,name = "探测方式")
    private String tcfs;

    //    @ExcelCount(order = 26,name = "设施运行状态")
    private String ssyxzt;
    //    @ExcelCount(order = 27,name = "管线质量")
    private String gxzl;
    //    @ExcelCount(order = 28,name = "管道等级")
    private String gddj;
    //    @ExcelCount(order = 29,name = "隐患情况说明")
    private String yhqk;
    @ExcelCount(order = 28, name = "更新状态")
    private String gxzt;
    @ExcelCount(order = 29, name = "是否利用")
    private String sfly;
    @ExcelCount(order = 30, name = "是否长输")
    private String sfcs;
    @ExcelCount(order = 100, name = "备注")
    private String Remarks;
    private Date updateTime;
    private Date createTime;

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

    public long getLineCadId() {
        return lineCadId;
    }

    public void setLineCadId(long lineCadId) {
        this.lineCadId = lineCadId;
    }

    public long getStartPointId() {
        return startPointId;
    }

    public void setStartPointId(long startPointId) {
        this.startPointId = startPointId;
    }

    public long getEndPointId() {
        return endPointId;
    }

    public void setEndPointId(long endPointId) {
        this.endPointId = endPointId;
    }

    public double getStart_latitude() {
        return start_latitude;
    }

    public void setStart_latitude(double start_latitude) {
        this.start_latitude = start_latitude;
    }

    public double getStart_longitude() {
        return start_longitude;
    }

    public void setStart_longitude(double start_longitude) {
        this.start_longitude = start_longitude;
    }

    public double getEnd_latitude() {
        return end_latitude;
    }

    public void setEnd_latitude(double end_latitude) {
        this.end_latitude = end_latitude;
    }

    public double getEnd_longitude() {
        return end_longitude;
    }

    public void setEnd_longitude(double end_longitude) {
        this.end_longitude = end_longitude;
    }

    public String getGxlx() {
        return Gxlx;
    }

    public void setGxlx(String gxlx) {
        Gxlx = gxlx;
    }

    public String getGxoutlx() {
        return Gxoutlx;
    }

    public void setGxoutlx(String gxoutlx) {
        Gxoutlx = gxoutlx;
    }

    public String getQswh() {
        return Qswh;
    }

    public void setQswh(String qswh) {
        Qswh = qswh;
    }

    public String getZzwh() {
        return Zzwh;
    }

    public void setZzwh(String zzwh) {
        Zzwh = zzwh;
    }

    public String getQdms() {
        return Qdms;
    }

    public void setQdms(String qdms) {
        Qdms = qdms;
    }

    public String getZzms() {
        return Zzms;
    }

    public void setZzms(String zzms) {
        Zzms = zzms;
    }

    public String getGxcl() {
        return Gxcl;
    }

    public void setGxcl(String gxcl) {
        Gxcl = gxcl;
    }

    public String getMsfs() {
        return Msfs;
    }

    public void setMsfs(String msfs) {
        Msfs = msfs;
    }

    public String getGjdm() {
        return Gjdm;
    }

    public void setGjdm(String gjdm) {
        Gjdm = gjdm;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getTgcz() {
        return tgcz;
    }

    public void setTgcz(String tgcz) {
        this.tgcz = tgcz;
    }

    public String getTs() {
        return Ts;
    }

    public void setTs(String ts) {
        Ts = ts;
    }

    public String getYl() {
        return yl;
    }

    public void setYl(String yl) {
        this.yl = yl;
    }

    public String getZks() {
        return Zks;
    }

    public void setZks(String zks) {
        Zks = zks;
    }

    public String getYyks() {
        return Yyks;
    }

    public void setYyks(String yyks) {
        Yyks = yyks;
    }

    public String getSzwz() {
        return Szwz;
    }

    public void setSzwz(String szwz) {
        Szwz = szwz;
    }

    public String getGxfc() {
        return gxfc;
    }

    public void setGxfc(String gxfc) {
        this.gxfc = gxfc;
    }

    public String getQdyj() {
        return Qdyj;
    }

    public void setQdyj(String qdyj) {
        Qdyj = qdyj;
    }

    public String getZdyj() {
        return Zdyj;
    }

    public void setZdyj(String zdyj) {
        Zdyj = zdyj;
    }

    public String getYxzt() {
        return Yxzt;
    }

    public void setYxzt(String yxzt) {
        Yxzt = yxzt;
    }

    public String getDhgd() {
        return Dhgd;
    }

    public void setDhgd(String dhgd) {
        Dhgd = dhgd;
    }

    public String getJsnd() {
        return Jsnd;
    }

    public void setJsnd(String jsnd) {
        Jsnd = jsnd;
    }

    public String getQsdw() {
        return Qsdw;
    }

    public void setQsdw(String qsdw) {
        Qsdw = qsdw;
    }

    public String getSyzt() {
        return Syzt;
    }

    public void setSyzt(String syzt) {
        Syzt = syzt;
    }

    public String getTcfs() {
        return tcfs;
    }

    public void setTcfs(String tcfs) {
        this.tcfs = tcfs;
    }

    public String getSsyxzt() {
        return ssyxzt;
    }

    public void setSsyxzt(String ssyxzt) {
        this.ssyxzt = ssyxzt;
    }

    public String getGxzl() {
        return gxzl;
    }

    public void setGxzl(String gxzl) {
        this.gxzl = gxzl;
    }

    public String getGddj() {
        return gddj;
    }

    public void setGddj(String gddj) {
        this.gddj = gddj;
    }

    public String getYhqk() {
        return yhqk;
    }

    public void setYhqk(String yhqk) {
        this.yhqk = yhqk;
    }

    public String getGxzt() {
        return gxzt;
    }

    public void setGxzt(String gxzt) {
        this.gxzt = gxzt;
    }

    public String getSfly() {
        return sfly;
    }

    public void setSfly(String sfly) {
        this.sfly = sfly;
    }

    public String getSfcs() {
        return sfcs;
    }

    public void setSfcs(String sfcs) {
        this.sfcs = sfcs;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
