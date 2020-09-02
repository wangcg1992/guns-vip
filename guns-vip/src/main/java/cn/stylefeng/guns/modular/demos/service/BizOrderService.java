package cn.stylefeng.guns.modular.demos.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BizOrder;
import cn.stylefeng.guns.modular.demos.model.params.BizOrderParam;
import cn.stylefeng.guns.modular.demos.model.result.BizOrderResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author wangcg
 * @since 2020-08-19
 */
public interface BizOrderService extends IService<BizOrder> {

    /**
     * 新增
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    void add(BizOrderParam param);

    /**
     * 删除
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    void delete(BizOrderParam param);

    /**
     * 更新
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    void update(BizOrderParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    BizOrderResult findBySpec(BizOrderParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    List<BizOrderResult> findListBySpec(BizOrderParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author wangcg
     * @Date 2020-08-19
     */
     LayuiPageInfo findPageBySpec(BizOrderParam param);

}
