package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BotPatrolRepairOrder;
import cn.stylefeng.guns.modular.demos.mapper.BotPatrolRepairOrderMapper;
import cn.stylefeng.guns.modular.demos.model.params.BotPatrolRepairOrderParam;
import cn.stylefeng.guns.modular.demos.model.result.BotPatrolRepairOrderResult;
import  cn.stylefeng.guns.modular.demos.service.BotPatrolRepairOrderService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.security.Key;
import java.util.*;

/**
 * <p>
 * 缺陷检修工单 服务实现类
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
@Service
public class BotPatrolRepairOrderServiceImpl extends ServiceImpl<BotPatrolRepairOrderMapper, BotPatrolRepairOrder> implements BotPatrolRepairOrderService {

    @Override
    public void add(BotPatrolRepairOrderParam param){
        BotPatrolRepairOrder entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BotPatrolRepairOrderParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BotPatrolRepairOrderParam param){
        BotPatrolRepairOrder oldEntity = getOldEntity(param);
        BotPatrolRepairOrder newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BotPatrolRepairOrderResult findBySpec(BotPatrolRepairOrderParam param){
        return null;
    }

    @Override
    public List<BotPatrolRepairOrderResult> findListBySpec(BotPatrolRepairOrderParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(BotPatrolRepairOrderParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(BotPatrolRepairOrderParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private BotPatrolRepairOrder getOldEntity(BotPatrolRepairOrderParam param) {
        return this.getById(getKey(param));
    }

    private BotPatrolRepairOrder getEntity(BotPatrolRepairOrderParam param) {
        BotPatrolRepairOrder entity = new BotPatrolRepairOrder();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

    @Override
    public List queryDeviceType(BotPatrolRepairOrderParam param){
        List<Map<String, Object>> mapList = this.baseMapper.queryDeviceType(param);
        //遍历map集合
//        for (Map<String, Object> map : mapList){
//            for (String k : map.keySet()) {
//                System.out.println(k + " : " + map.get(k));
//            }
//        }
        return mapList;
    }
    /**
     * 获取echarts故障图数量信息
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @Override
    public List queryChangePart(BotPatrolRepairOrderParam param) {
        List<Map<String, Object>> changePartMaps = this.baseMapper.queryChangePart(param);
        return changePartMaps;
    }
    /**
     * 获取echarts更换部件图数量信息
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @Override
    public List queryFaultType(BotPatrolRepairOrderParam param) {
        List<Map<String, Object>> FaultTypeMaps = this.baseMapper.queryFaultType(param);

        return FaultTypeMaps;
    }
}
