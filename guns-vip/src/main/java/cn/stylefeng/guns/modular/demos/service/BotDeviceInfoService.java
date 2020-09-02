package cn.stylefeng.guns.modular.demos.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BotDeviceInfo;
import cn.stylefeng.guns.modular.demos.model.params.BotDeviceInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.BotDeviceInfoResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备信息表 服务类
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
public interface BotDeviceInfoService extends IService<BotDeviceInfo> {

    /**
     * 新增
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    void add(BotDeviceInfoParam param);

    /**
     * 删除
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    void delete(BotDeviceInfoParam param);

    /**
     * 更新
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    void update(BotDeviceInfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    BotDeviceInfoResult findBySpec(BotDeviceInfoParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    List<BotDeviceInfoResult> findListBySpec(BotDeviceInfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author wangcg
     * @Date 2020-08-24
     */
     LayuiPageInfo findPageBySpec(BotDeviceInfoParam param);

}
