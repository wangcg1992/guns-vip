package cn.stylefeng.guns.modular.demos.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 设备信息表
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
@Data
public class BotDeviceInfoResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    private String id;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备编码
     */
    private String deviceCode;

    /**
     * 设备型号
     */
    private String deviceModel;

    /**
     * 设备类型id
     */
    private String deviceTypeId;

    /**
     * 机组id
     */
    private String unitId;

    /**
     * 系统id
     */
    private String systemId;

    /**
     * 主要材料
     */
    private String mainMaterial;

    /**
     * 重量
     */
    private Double weight;

    /**
     * 投运时间
     */
    private Date putIntoOperateTime;

    /**
     * 出厂时间
     */
    private Date outFactoryTime;

    /**
     * 安装时间
     */
    private Date installTime;

    /**
     * 安装位置
     */
    private String installPosition;

    /**
     * 设备生产厂家id
     */
    private String deviceFactoryId;

    /**
     * 初始价值
     */
    private BigDecimal originalCost;

    /**
     * 设备功能
     */
    private String deviceFunction;

    /**
     * 操作方法
     */
    private String operationMothod;

    /**
     * 设计寿命
     */
    private Double designLifetime;

    /**
     * 维修次数
     */
    private Integer repairCount;

    /**
     * 维保要求
     */
    private String repairRequirement;

    /**
     * 预警次数
     */
    private Integer warningCount;

    /**
     * 替换次数
     */
    private Integer replaceCount;

    /**
     * 设备运行状态
     */
    private String deviceStatue;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 二维码图片地址
     */
    private String qrCodeImageUrl;

    /**
     * 设备规格信息
     */
    private String specifications;

    /**
     * 设备参数范围信息
     */
    private String paramsRange;

    /**
     * 初始设备id,默认为本设备id
     */
    private String orDeviceId;

    /**
     * 运行电流
     */
    private Double runCurrentValue;

    /**
     * 运行电压
     */
    private Double runVoltageValue;

    /**
     * 额定功率
     */
    private Double ratedPower;

    /**
     * 转速
     */
    private Double speed;

    /**
     * 运行主设备id
     */
    private String runDeviceId;

    /**
     * 设备总台数
     */
    private Integer deviceCount;

    /**
     * 运行台数
     */
    private Integer operateCount;

    /**
     * 备用台数
     */
    private Integer backupCount;

    /**
     * 父设备id-针对电机
     */
    private String parentId;

    /**
     * 是否带电设备，默认为1(是)
     */
    private String isElectricDevice;

    /**
     * 是否更换(0表示不需更换，1表示需要更换)
     */
    private String isChange;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 删除者
     */
    private String deleteBy;

    /**
     * 删除时间
     */
    private Date deleteDate;

    /**
     * 备注
     */
    private String remarks;

}
