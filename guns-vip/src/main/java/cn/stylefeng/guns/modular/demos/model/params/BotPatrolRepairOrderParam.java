package cn.stylefeng.guns.modular.demos.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 缺陷检修工单
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
@Data
public class BotPatrolRepairOrderParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 缺陷联系单表id
     */
    private String id;

    /**
     * 缺陷联系单id
     */
    private String patrolDefectId;

    /**
     * 缺陷联系单code
     */
    private String defectCode;

    /**
     * 机组id
     */
    private String unitId;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 工单状态-1待接单2待返单3待验收9已完成
     */
    private String orderStatue;

    /**
     * 缺陷内容
     */
    private String defectContent;

    /**
     * 缺陷级别-ABC
     */
    private String defectGrade;

    /**
     * 缺陷所属专业-机务、电气、热工、外包
     */
    private String defectSpecialty;

    /**
     * 所属轮值-一二三四值
     */
    private String runZhi;

    /**
     * 发现日期
     */
    private Date discoveryDate;

    /**
     * 发现时间
     */
    private Date discoveryTime;

    /**
     * 发现人id
     */
    private String discoveryPersonId;

    /**
     * 通知检修时间
     */
    private Date infoMaintenanceTime;

    /**
     * 消缺时限
     */
    private Integer timeLimit;

    /**
     * 消缺时限单位-小时、天
     */
    private String timeLimitUnit;

    /**
     * 接单时间
     */
    private Date receiveTime;

    /**
     * 接单人
     */
    private String receivePersonId;

    /**
     * 消缺人id
     */
    private String eliminatePersonId;

    /**
     * 挂起原因
     */
    private String hangUpReason;

    /**
     * 挂起人id
     */
    private String hangUpPersonId;

    /**
     * 挂起时间
     */
    private Date hangUpTime;

    /**
     * 返单消缺时间
     */
    private Date returnEliminateTime;

    /**
     * 返单消缺人id
     */
    private String returnEliminatePersonId;

    /**
     * 故障类型
     */
    private String returnFaultType;

    /**
     * 更换部件
     */
    private String returnChangePart;

    /**
     * 处理措施
     */
    private String returnReatmentMeasure;

    /**
     * 申请延期时间
     */
    private Integer returnApplyOverTime;

    /**
     * 申请延期时长单位
     */
    private String returnApplyOverTimeUnit;

    /**
     * 延期申请结果-0驳回1通过
     */
    private String returnApplyResult;

    /**
     * 延期申请审批人id
     */
    private String returnApplyCheckPersonId;

    /**
     * 延期申请审批时间
     */
    private Date returnApplyCheckTime;

    /**
     * 实际延期时间
     */
    private Integer returnOverTime;

    /**
     * 实际延期单位
     */
    private String returnOverTimeUnit;

    /**
     * 返单时间
     */
    private Date returnTime;

    /**
     * 返单人id
     */
    private String returnPersonId;

    /**
     * 验收结果-1闭环验收、2作废
     */
    private String checkResult;

    /**
     * 验收人id
     */
    private String checkPersonId;

    /**
     * 验收时间
     */
    private Date checkTime;

    /**
     * 创建人,与sys_user表关联
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人,与sys_user表关联
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 删除标记
     */
    private String delFlag;

    @Override
    public String checkParam() {
        return null;
    }

}
