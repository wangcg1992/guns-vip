package cn.stylefeng.guns.utils;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页工具类
 */
public abstract class PageHelper {

    /**
     * 获取分页参数信息
     */
    public static Page getPage(){
        return LayuiPageFactory.defaultPage();
    }

    /**
     * 将mybatis plus 的分页插件返回的Page 信息适配为layui需要的结果
     */
    public static LayuiPageInfo adapt(Page page){
        return LayuiPageFactory.createPageInfo(page);
    }

}
