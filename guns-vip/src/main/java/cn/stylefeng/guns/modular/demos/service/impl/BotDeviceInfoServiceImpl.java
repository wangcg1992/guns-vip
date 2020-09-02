package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BotDeviceInfo;
import cn.stylefeng.guns.modular.demos.mapper.BotDeviceInfoMapper;
import cn.stylefeng.guns.modular.demos.model.params.BotDeviceInfoParam;
import cn.stylefeng.guns.modular.demos.model.result.BotDeviceInfoResult;
import  cn.stylefeng.guns.modular.demos.service.BotDeviceInfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 设备信息表 服务实现类
 * </p>
 *
 * @author wangcg
 * @since 2020-08-24
 */
@Service
public class BotDeviceInfoServiceImpl extends ServiceImpl<BotDeviceInfoMapper, BotDeviceInfo> implements BotDeviceInfoService {

    @Override
    public void add(BotDeviceInfoParam param){
        BotDeviceInfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BotDeviceInfoParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BotDeviceInfoParam param){
        BotDeviceInfo oldEntity = getOldEntity(param);
        BotDeviceInfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BotDeviceInfoResult findBySpec(BotDeviceInfoParam param){
        return null;
    }

    @Override
    public List<BotDeviceInfoResult> findListBySpec(BotDeviceInfoParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(BotDeviceInfoParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(BotDeviceInfoParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private BotDeviceInfo getOldEntity(BotDeviceInfoParam param) {
        return this.getById(getKey(param));
    }

    private BotDeviceInfo getEntity(BotDeviceInfoParam param) {
        BotDeviceInfo entity = new BotDeviceInfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
