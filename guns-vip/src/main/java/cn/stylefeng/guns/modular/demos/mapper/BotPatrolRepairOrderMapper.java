package cn.stylefeng.guns.modular.demos.mapper;

import cn.stylefeng.guns.modular.demos.entity.BotPatrolRepairOrder;
import cn.stylefeng.guns.modular.demos.model.params.BotPatrolRepairOrderParam;
import cn.stylefeng.guns.modular.demos.model.result.BotPatrolRepairOrderResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 缺陷检修工单 Mapper 接口
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
public interface BotPatrolRepairOrderMapper extends BaseMapper<BotPatrolRepairOrder> {

    /**
     * 获取列表
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<BotPatrolRepairOrderResult> customList(@Param("paramCondition") BotPatrolRepairOrderParam paramCondition);

    /**
     * 获取map列表
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") BotPatrolRepairOrderParam paramCondition);


    /**
     * 获取分页实体列表
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    Page<BotPatrolRepairOrderResult> customPageList(@Param("page") Page page, @Param("paramCondition") BotPatrolRepairOrderParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") BotPatrolRepairOrderParam paramCondition);

    /**
     * 获取echarts柱状图数量信息
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<Map<String, Object>> queryDeviceType(@Param("paramCondition") BotPatrolRepairOrderParam paramCondition);

    /**
     * 获取echarts故障图数量信息
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<Map<String, Object>> queryFaultType(@Param("paramCondition") BotPatrolRepairOrderParam paramCondition);
    /**
     * 获取echarts更换部件图数量信息
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<Map<String, Object>> queryChangePart(@Param("paramCondition") BotPatrolRepairOrderParam paramCondition);

}
