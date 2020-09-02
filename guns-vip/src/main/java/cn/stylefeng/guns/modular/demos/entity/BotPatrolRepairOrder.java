package cn.stylefeng.guns.modular.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 缺陷检修工单
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
@TableName("bot_patrol_repair_order")
public class BotPatrolRepairOrder implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 缺陷联系单表id
     */
      @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    /**
     * 缺陷联系单id
     */
    @TableField("patrol_defect_id")
    private String patrolDefectId;

    /**
     * 缺陷联系单code
     */
    @TableField("defect_code")
    private String defectCode;

    /**
     * 机组id
     */
    @TableField("unit_id")
    private String unitId;

    /**
     * 设备类型
     */
    @TableField("device_type")
    private String deviceType;

    /**
     * 设备id
     */
    @TableField("device_id")
    private String deviceId;

    /**
     * 工单状态-1待接单2待返单3待验收9已完成
     */
    @TableField("order_statue")
    private String orderStatue;

    /**
     * 缺陷内容
     */
    @TableField("defect_content")
    private String defectContent;

    /**
     * 缺陷级别-ABC
     */
    @TableField("defect_grade")
    private String defectGrade;

    /**
     * 缺陷所属专业-机务、电气、热工、外包
     */
    @TableField("defect_specialty")
    private String defectSpecialty;

    /**
     * 所属轮值-一二三四值
     */
    @TableField("run_zhi")
    private String runZhi;

    /**
     * 发现日期
     */
    @TableField("discovery_date")
    private Date discoveryDate;

    /**
     * 发现时间
     */
    @TableField("discovery_time")
    private Date discoveryTime;

    /**
     * 发现人id
     */
    @TableField("discovery_person_id")
    private String discoveryPersonId;

    /**
     * 通知检修时间
     */
    @TableField("info_maintenance_time")
    private Date infoMaintenanceTime;

    /**
     * 消缺时限
     */
    @TableField("time_limit")
    private Integer timeLimit;

    /**
     * 消缺时限单位-小时、天
     */
    @TableField("time_limit_unit")
    private String timeLimitUnit;

    /**
     * 接单时间
     */
    @TableField("receive_time")
    private Date receiveTime;

    /**
     * 接单人
     */
    @TableField("receive_person_id")
    private String receivePersonId;

    /**
     * 消缺人id
     */
    @TableField("eliminate_person_id")
    private String eliminatePersonId;

    /**
     * 挂起原因
     */
    @TableField("hang_up_reason")
    private String hangUpReason;

    /**
     * 挂起人id
     */
    @TableField("hang_up_person_id")
    private String hangUpPersonId;

    /**
     * 挂起时间
     */
    @TableField("hang_up_time")
    private Date hangUpTime;

    /**
     * 返单消缺时间
     */
    @TableField("return_eliminate_time")
    private Date returnEliminateTime;

    /**
     * 返单消缺人id
     */
    @TableField("return_eliminate_person_id")
    private String returnEliminatePersonId;

    /**
     * 故障类型
     */
    @TableField("return_fault_type")
    private String returnFaultType;

    /**
     * 更换部件
     */
    @TableField("return_change_part")
    private String returnChangePart;

    /**
     * 处理措施
     */
    @TableField("return_reatment_measure")
    private String returnReatmentMeasure;

    /**
     * 申请延期时间
     */
    @TableField("return_apply_over_time")
    private Integer returnApplyOverTime;

    /**
     * 申请延期时长单位
     */
    @TableField("return_apply_over_time_unit")
    private String returnApplyOverTimeUnit;

    /**
     * 延期申请结果-0驳回1通过
     */
    @TableField("return_apply_result")
    private String returnApplyResult;

    /**
     * 延期申请审批人id
     */
    @TableField("return_apply_check_person_id")
    private String returnApplyCheckPersonId;

    /**
     * 延期申请审批时间
     */
    @TableField("return_apply_check_time")
    private Date returnApplyCheckTime;

    /**
     * 实际延期时间
     */
    @TableField("return_over_time")
    private Integer returnOverTime;

    /**
     * 实际延期单位
     */
    @TableField("return_over_time_unit")
    private String returnOverTimeUnit;

    /**
     * 返单时间
     */
    @TableField("return_time")
    private Date returnTime;

    /**
     * 返单人id
     */
    @TableField("return_person_id")
    private String returnPersonId;

    /**
     * 验收结果-1闭环验收、2作废
     */
    @TableField("check_result")
    private String checkResult;

    /**
     * 验收人id
     */
    @TableField("check_person_id")
    private String checkPersonId;

    /**
     * 验收时间
     */
    @TableField("check_time")
    private Date checkTime;

    /**
     * 创建人,与sys_user表关联
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;

    /**
     * 修改人,与sys_user表关联
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField("update_date")
    private Date updateDate;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 删除标记
     */
    @TableField("del_flag")
    private String delFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatrolDefectId() {
        return patrolDefectId;
    }

    public void setPatrolDefectId(String patrolDefectId) {
        this.patrolDefectId = patrolDefectId;
    }

    public String getDefectCode() {
        return defectCode;
    }

    public void setDefectCode(String defectCode) {
        this.defectCode = defectCode;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOrderStatue() {
        return orderStatue;
    }

    public void setOrderStatue(String orderStatue) {
        this.orderStatue = orderStatue;
    }

    public String getDefectContent() {
        return defectContent;
    }

    public void setDefectContent(String defectContent) {
        this.defectContent = defectContent;
    }

    public String getDefectGrade() {
        return defectGrade;
    }

    public void setDefectGrade(String defectGrade) {
        this.defectGrade = defectGrade;
    }

    public String getDefectSpecialty() {
        return defectSpecialty;
    }

    public void setDefectSpecialty(String defectSpecialty) {
        this.defectSpecialty = defectSpecialty;
    }

    public String getRunZhi() {
        return runZhi;
    }

    public void setRunZhi(String runZhi) {
        this.runZhi = runZhi;
    }

    public Date getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(Date discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public Date getDiscoveryTime() {
        return discoveryTime;
    }

    public void setDiscoveryTime(Date discoveryTime) {
        this.discoveryTime = discoveryTime;
    }

    public String getDiscoveryPersonId() {
        return discoveryPersonId;
    }

    public void setDiscoveryPersonId(String discoveryPersonId) {
        this.discoveryPersonId = discoveryPersonId;
    }

    public Date getInfoMaintenanceTime() {
        return infoMaintenanceTime;
    }

    public void setInfoMaintenanceTime(Date infoMaintenanceTime) {
        this.infoMaintenanceTime = infoMaintenanceTime;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getTimeLimitUnit() {
        return timeLimitUnit;
    }

    public void setTimeLimitUnit(String timeLimitUnit) {
        this.timeLimitUnit = timeLimitUnit;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getReceivePersonId() {
        return receivePersonId;
    }

    public void setReceivePersonId(String receivePersonId) {
        this.receivePersonId = receivePersonId;
    }

    public String getEliminatePersonId() {
        return eliminatePersonId;
    }

    public void setEliminatePersonId(String eliminatePersonId) {
        this.eliminatePersonId = eliminatePersonId;
    }

    public String getHangUpReason() {
        return hangUpReason;
    }

    public void setHangUpReason(String hangUpReason) {
        this.hangUpReason = hangUpReason;
    }

    public String getHangUpPersonId() {
        return hangUpPersonId;
    }

    public void setHangUpPersonId(String hangUpPersonId) {
        this.hangUpPersonId = hangUpPersonId;
    }

    public Date getHangUpTime() {
        return hangUpTime;
    }

    public void setHangUpTime(Date hangUpTime) {
        this.hangUpTime = hangUpTime;
    }

    public Date getReturnEliminateTime() {
        return returnEliminateTime;
    }

    public void setReturnEliminateTime(Date returnEliminateTime) {
        this.returnEliminateTime = returnEliminateTime;
    }

    public String getReturnEliminatePersonId() {
        return returnEliminatePersonId;
    }

    public void setReturnEliminatePersonId(String returnEliminatePersonId) {
        this.returnEliminatePersonId = returnEliminatePersonId;
    }

    public String getReturnFaultType() {
        return returnFaultType;
    }

    public void setReturnFaultType(String returnFaultType) {
        this.returnFaultType = returnFaultType;
    }

    public String getReturnChangePart() {
        return returnChangePart;
    }

    public void setReturnChangePart(String returnChangePart) {
        this.returnChangePart = returnChangePart;
    }

    public String getReturnReatmentMeasure() {
        return returnReatmentMeasure;
    }

    public void setReturnReatmentMeasure(String returnReatmentMeasure) {
        this.returnReatmentMeasure = returnReatmentMeasure;
    }

    public Integer getReturnApplyOverTime() {
        return returnApplyOverTime;
    }

    public void setReturnApplyOverTime(Integer returnApplyOverTime) {
        this.returnApplyOverTime = returnApplyOverTime;
    }

    public String getReturnApplyOverTimeUnit() {
        return returnApplyOverTimeUnit;
    }

    public void setReturnApplyOverTimeUnit(String returnApplyOverTimeUnit) {
        this.returnApplyOverTimeUnit = returnApplyOverTimeUnit;
    }

    public String getReturnApplyResult() {
        return returnApplyResult;
    }

    public void setReturnApplyResult(String returnApplyResult) {
        this.returnApplyResult = returnApplyResult;
    }

    public String getReturnApplyCheckPersonId() {
        return returnApplyCheckPersonId;
    }

    public void setReturnApplyCheckPersonId(String returnApplyCheckPersonId) {
        this.returnApplyCheckPersonId = returnApplyCheckPersonId;
    }

    public Date getReturnApplyCheckTime() {
        return returnApplyCheckTime;
    }

    public void setReturnApplyCheckTime(Date returnApplyCheckTime) {
        this.returnApplyCheckTime = returnApplyCheckTime;
    }

    public Integer getReturnOverTime() {
        return returnOverTime;
    }

    public void setReturnOverTime(Integer returnOverTime) {
        this.returnOverTime = returnOverTime;
    }

    public String getReturnOverTimeUnit() {
        return returnOverTimeUnit;
    }

    public void setReturnOverTimeUnit(String returnOverTimeUnit) {
        this.returnOverTimeUnit = returnOverTimeUnit;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnPersonId() {
        return returnPersonId;
    }

    public void setReturnPersonId(String returnPersonId) {
        this.returnPersonId = returnPersonId;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckPersonId() {
        return checkPersonId;
    }

    public void setCheckPersonId(String checkPersonId) {
        this.checkPersonId = checkPersonId;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "BotPatrolRepairOrder{" +
        "id=" + id +
        ", patrolDefectId=" + patrolDefectId +
        ", defectCode=" + defectCode +
        ", unitId=" + unitId +
        ", deviceType=" + deviceType +
        ", deviceId=" + deviceId +
        ", orderStatue=" + orderStatue +
        ", defectContent=" + defectContent +
        ", defectGrade=" + defectGrade +
        ", defectSpecialty=" + defectSpecialty +
        ", runZhi=" + runZhi +
        ", discoveryDate=" + discoveryDate +
        ", discoveryTime=" + discoveryTime +
        ", discoveryPersonId=" + discoveryPersonId +
        ", infoMaintenanceTime=" + infoMaintenanceTime +
        ", timeLimit=" + timeLimit +
        ", timeLimitUnit=" + timeLimitUnit +
        ", receiveTime=" + receiveTime +
        ", receivePersonId=" + receivePersonId +
        ", eliminatePersonId=" + eliminatePersonId +
        ", hangUpReason=" + hangUpReason +
        ", hangUpPersonId=" + hangUpPersonId +
        ", hangUpTime=" + hangUpTime +
        ", returnEliminateTime=" + returnEliminateTime +
        ", returnEliminatePersonId=" + returnEliminatePersonId +
        ", returnFaultType=" + returnFaultType +
        ", returnChangePart=" + returnChangePart +
        ", returnReatmentMeasure=" + returnReatmentMeasure +
        ", returnApplyOverTime=" + returnApplyOverTime +
        ", returnApplyOverTimeUnit=" + returnApplyOverTimeUnit +
        ", returnApplyResult=" + returnApplyResult +
        ", returnApplyCheckPersonId=" + returnApplyCheckPersonId +
        ", returnApplyCheckTime=" + returnApplyCheckTime +
        ", returnOverTime=" + returnOverTime +
        ", returnOverTimeUnit=" + returnOverTimeUnit +
        ", returnTime=" + returnTime +
        ", returnPersonId=" + returnPersonId +
        ", checkResult=" + checkResult +
        ", checkPersonId=" + checkPersonId +
        ", checkTime=" + checkTime +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        ", remarks=" + remarks +
        ", delFlag=" + delFlag +
        "}";
    }
}
