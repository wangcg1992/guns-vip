package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BotDeviceInfo;
import cn.stylefeng.guns.modular.demos.model.params.BotDeviceInfoParam;
import cn.stylefeng.guns.modular.demos.service.BotDeviceInfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 设备信息表控制器
 *
 * @author wangcg
 * @Date 2020-08-24 15:09:25
 */
@Controller
@RequestMapping("/botDeviceInfo")
public class BotDeviceInfoController extends BaseController {

    private String PREFIX = "/botDeviceInfo";

    @Autowired
    private BotDeviceInfoService botDeviceInfoService;

    /**
     * 跳转到主页面
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/botDeviceInfo.html";
    }

    /**
     * 新增页面
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/botDeviceInfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/botDeviceInfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(BotDeviceInfoParam botDeviceInfoParam) {
        this.botDeviceInfoService.add(botDeviceInfoParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(BotDeviceInfoParam botDeviceInfoParam) {
        this.botDeviceInfoService.update(botDeviceInfoParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(BotDeviceInfoParam botDeviceInfoParam) {
        this.botDeviceInfoService.delete(botDeviceInfoParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(BotDeviceInfoParam botDeviceInfoParam) {
        BotDeviceInfo detail = this.botDeviceInfoService.getById(botDeviceInfoParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(BotDeviceInfoParam botDeviceInfoParam) {
        return this.botDeviceInfoService.findPageBySpec(botDeviceInfoParam);
    }

}


