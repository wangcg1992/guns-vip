package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BizOrder;
import cn.stylefeng.guns.modular.demos.mapper.BizOrderMapper;
import cn.stylefeng.guns.modular.demos.model.params.BizOrderParam;
import cn.stylefeng.guns.modular.demos.model.result.BizOrderResult;
import  cn.stylefeng.guns.modular.demos.service.BizOrderService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author wangcg
 * @since 2020-08-19
 */
@Service
public class BizOrderServiceImpl extends ServiceImpl<BizOrderMapper, BizOrder> implements BizOrderService {

    @Override
    public void add(BizOrderParam param){
        BizOrder entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BizOrderParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BizOrderParam param){
        BizOrder oldEntity = getOldEntity(param);
        BizOrder newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BizOrderResult findBySpec(BizOrderParam param){
        return null;
    }

    @Override
    public List<BizOrderResult> findListBySpec(BizOrderParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(BizOrderParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(BizOrderParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private BizOrder getOldEntity(BizOrderParam param) {
        return this.getById(getKey(param));
    }

    private BizOrder getEntity(BizOrderParam param) {
        BizOrder entity = new BizOrder();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
