package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BizOrder;
import cn.stylefeng.guns.modular.demos.model.params.BizOrderParam;
import cn.stylefeng.guns.modular.demos.service.BizOrderService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 订单表控制器
 *
 * @author wangcg
 * @Date 2020-08-19 16:22:17
 */
@Controller
@RequestMapping("/bizOrder")
public class BizOrderController extends BaseController {

    private String PREFIX = "/bizOrder";

    @Autowired
    private BizOrderService bizOrderService;

    /**
     * 跳转到主页面
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/bizOrder.html";
    }

    /**
     * 新增页面
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/bizOrder_add.html";
    }

    /**
     * 编辑页面
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/bizOrder_edit.html";
    }

    /**
     * 新增接口
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(BizOrderParam bizOrderParam) {
        this.bizOrderService.add(bizOrderParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(BizOrderParam bizOrderParam) {
        this.bizOrderService.update(bizOrderParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(BizOrderParam bizOrderParam) {
        this.bizOrderService.delete(bizOrderParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(BizOrderParam bizOrderParam) {
        BizOrder detail = this.bizOrderService.getById(bizOrderParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author wangcg
     * @Date 2020-08-19
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(BizOrderParam bizOrderParam) {
        return this.bizOrderService.findPageBySpec(bizOrderParam);
    }

}


