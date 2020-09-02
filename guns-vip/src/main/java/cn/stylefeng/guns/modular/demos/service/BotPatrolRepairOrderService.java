package cn.stylefeng.guns.modular.demos.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BotPatrolRepairOrder;
import cn.stylefeng.guns.modular.demos.model.params.BotPatrolRepairOrderParam;
import cn.stylefeng.guns.modular.demos.model.result.BotPatrolRepairOrderResult;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 缺陷检修工单 服务类
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
public interface BotPatrolRepairOrderService extends IService<BotPatrolRepairOrder> {

    /**
     * 新增
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    void add(BotPatrolRepairOrderParam param);

    /**
     * 删除
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    void delete(BotPatrolRepairOrderParam param);

    /**
     * 更新
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    void update(BotPatrolRepairOrderParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    BotPatrolRepairOrderResult findBySpec(BotPatrolRepairOrderParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<BotPatrolRepairOrderResult> findListBySpec(BotPatrolRepairOrderParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author wangcg
     * @Date 2020-08-24
     */
     LayuiPageInfo findPageBySpec(BotPatrolRepairOrderParam param);


    /**
     * 获取故障数量信息
     *
     * @author wangcg
     * @Date 2020-08-24
     */

    List<BotPatrolRepairOrderResult> queryDeviceType(BotPatrolRepairOrderParam param);
    /**
     * 获取echarts故障图数量信息
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<BotPatrolRepairOrderResult> queryFaultType(BotPatrolRepairOrderParam param);
    /**
     * 获取echarts更换部件图数量信息
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<BotPatrolRepairOrderResult> queryChangePart(BotPatrolRepairOrderParam param);
}
