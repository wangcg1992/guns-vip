package cn.stylefeng.guns.modular.demos.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 设备信息表
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
@TableName("bot_device_info")
public class BotDeviceInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 设备名称
     */
    @TableField("device_name")
    private String deviceName;

    /**
     * 设备编码
     */
    @TableField("device_code")
    private String deviceCode;

    /**
     * 设备型号
     */
    @TableField("device_model")
    private String deviceModel;

    /**
     * 设备类型id
     */
    @TableField("device_type_id")
    private String deviceTypeId;

    /**
     * 机组id
     */
    @TableField("unit_id")
    private String unitId;

    /**
     * 系统id
     */
    @TableField("system_id")
    private String systemId;

    /**
     * 主要材料
     */
    @TableField("main_material")
    private String mainMaterial;

    /**
     * 重量
     */
    @TableField("weight")
    private Double weight;

    /**
     * 投运时间
     */
    @TableField("put_into_operate_time")
    private Date putIntoOperateTime;

    /**
     * 出厂时间
     */
    @TableField("out_factory_time")
    private Date outFactoryTime;

    /**
     * 安装时间
     */
    @TableField("install_time")
    private Date installTime;

    /**
     * 安装位置
     */
    @TableField("install_position")
    private String installPosition;

    /**
     * 设备生产厂家id
     */
    @TableField("device_factory_id")
    private String deviceFactoryId;

    /**
     * 初始价值
     */
    @TableField("original_cost")
    private BigDecimal originalCost;

    /**
     * 设备功能
     */
    @TableField("device_function")
    private String deviceFunction;

    /**
     * 操作方法
     */
    @TableField("operation_mothod")
    private String operationMothod;

    /**
     * 设计寿命
     */
    @TableField("design_lifetime")
    private Double designLifetime;

    /**
     * 维修次数
     */
    @TableField("repair_count")
    private Integer repairCount;

    /**
     * 维保要求
     */
    @TableField("repair_requirement")
    private String repairRequirement;

    /**
     * 预警次数
     */
    @TableField("warning_count")
    private Integer warningCount;

    /**
     * 替换次数
     */
    @TableField("replace_count")
    private Integer replaceCount;

    /**
     * 设备运行状态
     */
    @TableField("device_statue")
    private String deviceStatue;

    /**
     * 图片地址
     */
    @TableField("image_url")
    private String imageUrl;

    /**
     * 二维码图片地址
     */
    @TableField("qr_code_image_url")
    private String qrCodeImageUrl;

    /**
     * 设备规格信息
     */
    @TableField("specifications")
    private String specifications;

    /**
     * 设备参数范围信息
     */
    @TableField("params_range")
    private String paramsRange;

    /**
     * 初始设备id,默认为本设备id
     */
    @TableField("or_device_id")
    private String orDeviceId;

    /**
     * 运行电流
     */
    @TableField("run_current_value")
    private Double runCurrentValue;

    /**
     * 运行电压
     */
    @TableField("run_voltage_value")
    private Double runVoltageValue;

    /**
     * 额定功率
     */
    @TableField("rated_power")
    private Double ratedPower;

    /**
     * 转速
     */
    @TableField("speed")
    private Double speed;

    /**
     * 运行主设备id
     */
    @TableField("run_device_id")
    private String runDeviceId;

    /**
     * 设备总台数
     */
    @TableField("device_count")
    private Integer deviceCount;

    /**
     * 运行台数
     */
    @TableField("operate_count")
    private Integer operateCount;

    /**
     * 备用台数
     */
    @TableField("backup_count")
    private Integer backupCount;

    /**
     * 父设备id-针对电机
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 是否带电设备，默认为1(是)
     */
    @TableField("is_electric_device")
    private String isElectricDevice;

    /**
     * 是否更换(0表示不需更换，1表示需要更换)
     */
    @TableField("is_change")
    private String isChange;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField("update_date")
    private Date updateDate;

    /**
     * 删除者
     */
    @TableField("delete_by")
    private String deleteBy;

    /**
     * 删除时间
     */
    @TableField("delete_date")
    private Date deleteDate;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getPutIntoOperateTime() {
        return putIntoOperateTime;
    }

    public void setPutIntoOperateTime(Date putIntoOperateTime) {
        this.putIntoOperateTime = putIntoOperateTime;
    }

    public Date getOutFactoryTime() {
        return outFactoryTime;
    }

    public void setOutFactoryTime(Date outFactoryTime) {
        this.outFactoryTime = outFactoryTime;
    }

    public Date getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Date installTime) {
        this.installTime = installTime;
    }

    public String getInstallPosition() {
        return installPosition;
    }

    public void setInstallPosition(String installPosition) {
        this.installPosition = installPosition;
    }

    public String getDeviceFactoryId() {
        return deviceFactoryId;
    }

    public void setDeviceFactoryId(String deviceFactoryId) {
        this.deviceFactoryId = deviceFactoryId;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

    public String getDeviceFunction() {
        return deviceFunction;
    }

    public void setDeviceFunction(String deviceFunction) {
        this.deviceFunction = deviceFunction;
    }

    public String getOperationMothod() {
        return operationMothod;
    }

    public void setOperationMothod(String operationMothod) {
        this.operationMothod = operationMothod;
    }

    public Double getDesignLifetime() {
        return designLifetime;
    }

    public void setDesignLifetime(Double designLifetime) {
        this.designLifetime = designLifetime;
    }

    public Integer getRepairCount() {
        return repairCount;
    }

    public void setRepairCount(Integer repairCount) {
        this.repairCount = repairCount;
    }

    public String getRepairRequirement() {
        return repairRequirement;
    }

    public void setRepairRequirement(String repairRequirement) {
        this.repairRequirement = repairRequirement;
    }

    public Integer getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(Integer warningCount) {
        this.warningCount = warningCount;
    }

    public Integer getReplaceCount() {
        return replaceCount;
    }

    public void setReplaceCount(Integer replaceCount) {
        this.replaceCount = replaceCount;
    }

    public String getDeviceStatue() {
        return deviceStatue;
    }

    public void setDeviceStatue(String deviceStatue) {
        this.deviceStatue = deviceStatue;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getQrCodeImageUrl() {
        return qrCodeImageUrl;
    }

    public void setQrCodeImageUrl(String qrCodeImageUrl) {
        this.qrCodeImageUrl = qrCodeImageUrl;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getParamsRange() {
        return paramsRange;
    }

    public void setParamsRange(String paramsRange) {
        this.paramsRange = paramsRange;
    }

    public String getOrDeviceId() {
        return orDeviceId;
    }

    public void setOrDeviceId(String orDeviceId) {
        this.orDeviceId = orDeviceId;
    }

    public Double getRunCurrentValue() {
        return runCurrentValue;
    }

    public void setRunCurrentValue(Double runCurrentValue) {
        this.runCurrentValue = runCurrentValue;
    }

    public Double getRunVoltageValue() {
        return runVoltageValue;
    }

    public void setRunVoltageValue(Double runVoltageValue) {
        this.runVoltageValue = runVoltageValue;
    }

    public Double getRatedPower() {
        return ratedPower;
    }

    public void setRatedPower(Double ratedPower) {
        this.ratedPower = ratedPower;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getRunDeviceId() {
        return runDeviceId;
    }

    public void setRunDeviceId(String runDeviceId) {
        this.runDeviceId = runDeviceId;
    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public Integer getOperateCount() {
        return operateCount;
    }

    public void setOperateCount(Integer operateCount) {
        this.operateCount = operateCount;
    }

    public Integer getBackupCount() {
        return backupCount;
    }

    public void setBackupCount(Integer backupCount) {
        this.backupCount = backupCount;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIsElectricDevice() {
        return isElectricDevice;
    }

    public void setIsElectricDevice(String isElectricDevice) {
        this.isElectricDevice = isElectricDevice;
    }

    public String getIsChange() {
        return isChange;
    }

    public void setIsChange(String isChange) {
        this.isChange = isChange;
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

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "BotDeviceInfo{" +
        "id=" + id +
        ", deviceName=" + deviceName +
        ", deviceCode=" + deviceCode +
        ", deviceModel=" + deviceModel +
        ", deviceTypeId=" + deviceTypeId +
        ", unitId=" + unitId +
        ", systemId=" + systemId +
        ", mainMaterial=" + mainMaterial +
        ", weight=" + weight +
        ", putIntoOperateTime=" + putIntoOperateTime +
        ", outFactoryTime=" + outFactoryTime +
        ", installTime=" + installTime +
        ", installPosition=" + installPosition +
        ", deviceFactoryId=" + deviceFactoryId +
        ", originalCost=" + originalCost +
        ", deviceFunction=" + deviceFunction +
        ", operationMothod=" + operationMothod +
        ", designLifetime=" + designLifetime +
        ", repairCount=" + repairCount +
        ", repairRequirement=" + repairRequirement +
        ", warningCount=" + warningCount +
        ", replaceCount=" + replaceCount +
        ", deviceStatue=" + deviceStatue +
        ", imageUrl=" + imageUrl +
        ", qrCodeImageUrl=" + qrCodeImageUrl +
        ", specifications=" + specifications +
        ", paramsRange=" + paramsRange +
        ", orDeviceId=" + orDeviceId +
        ", runCurrentValue=" + runCurrentValue +
        ", runVoltageValue=" + runVoltageValue +
        ", ratedPower=" + ratedPower +
        ", speed=" + speed +
        ", runDeviceId=" + runDeviceId +
        ", deviceCount=" + deviceCount +
        ", operateCount=" + operateCount +
        ", backupCount=" + backupCount +
        ", parentId=" + parentId +
        ", isElectricDevice=" + isElectricDevice +
        ", isChange=" + isChange +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        ", deleteBy=" + deleteBy +
        ", deleteDate=" + deleteDate +
        ", remarks=" + remarks +
        "}";
    }
}
