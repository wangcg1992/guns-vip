package cn.stylefeng.guns.modular.demos.mapper;

import cn.stylefeng.guns.modular.demos.entity.BotDeviceInfo;
import cn.stylefeng.guns.modular.demos.model.params.BotDeviceInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.BotDeviceInfoResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备信息表 Mapper 接口
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
public interface BotDeviceInfoMapper extends BaseMapper<BotDeviceInfo> {

    /**
     * 获取列表
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<BotDeviceInfoResult> customList(@Param("paramCondition") BotDeviceInfoParam paramCondition);

    /**
     * 获取map列表
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") BotDeviceInfoParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    Page<BotDeviceInfoResult> customPageList(@Param("page") Page page, @Param("paramCondition") BotDeviceInfoParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") BotDeviceInfoParam paramCondition);

}
