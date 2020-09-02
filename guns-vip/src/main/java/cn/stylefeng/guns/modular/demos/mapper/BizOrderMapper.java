package cn.stylefeng.guns.modular.demos.mapper;

import cn.stylefeng.guns.modular.demos.entity.BizOrder;
import cn.stylefeng.guns.modular.demos.model.params.BizOrderParam;
import cn.stylefeng.guns.modular.demos.model.result.BizOrderResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author wangcg
 * @since 2020-08-19
 */
public interface BizOrderMapper extends BaseMapper<BizOrder> {

    /**
     * 获取列表
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    List<BizOrderResult> customList(@Param("paramCondition") BizOrderParam paramCondition);

    /**
     * 获取map列表
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") BizOrderParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    Page<BizOrderResult> customPageList(@Param("page") Page page, @Param("paramCondition") BizOrderParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") BizOrderParam paramCondition);

}
