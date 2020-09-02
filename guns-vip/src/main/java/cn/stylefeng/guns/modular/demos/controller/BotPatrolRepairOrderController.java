package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.BotPatrolRepairOrder;
import cn.stylefeng.guns.modular.demos.model.params.BotPatrolRepairOrderParam;
import cn.stylefeng.guns.modular.demos.model.result.BotPatrolRepairOrderResult;
import cn.stylefeng.guns.modular.demos.service.BotPatrolRepairOrderService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 缺陷检修工单控制器
 *
 * @author wangcg
 * @Date 2020-08-24 15:09:25
 */
@Controller
@RequestMapping("/botPatrolRepairOrder")
public class BotPatrolRepairOrderController extends BaseController {

    private String PREFIX = "/botPatrolRepairOrder";

    @Autowired
    private BotPatrolRepairOrderService botPatrolRepairOrderService;


    /**
     * 跳转到主页面
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/botPatrolRepairOrder.html";
    }

    /**
     * 加载echarts视图数据
     *
     * @author wangcg
     * @Date 2020-09-01
     */
    @RequestMapping(value="/echarts")
    @ResponseBody
    public Object deviceFaultCount(BotPatrolRepairOrderParam botPatrolRepairOrderParam) {

        List<BotPatrolRepairOrderResult> queryDeviceType = this.botPatrolRepairOrderService.queryDeviceType(botPatrolRepairOrderParam);
        List<BotPatrolRepairOrderResult> queryChangePart = this.botPatrolRepairOrderService.queryChangePart(botPatrolRepairOrderParam);
        List<BotPatrolRepairOrderResult> queryFaultType = this.botPatrolRepairOrderService.queryFaultType(botPatrolRepairOrderParam);
        //map转String
        String faultCountData = JSON.toJSONString(queryDeviceType);
        String changePartData = JSON.toJSONString(queryChangePart);
        String faultTypeData = JSON.toJSONString(queryFaultType);
        /*//String转json
        JSONObject jsonObject = JSON.parseObject(data);
        list.add(countMapList);*/
        System.out.println("faultCountData:"+faultCountData);
        System.out.println("faultTypeData:"+faultTypeData);
        System.out.println("changePartData:"+changePartData);

        Map result=new HashMap();
        result.put("firstChartData",faultCountData);
        result.put("faultTypeData",faultTypeData);
        result.put("changePartData",changePartData);


        return result;
    }
    /**
     *
     */
    /**
     * 新增页面
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/botPatrolRepairOrder_add.html";
    }

    /**
     * 编辑页面
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/botPatrolRepairOrder_edit.html";
    }

    /**
     * 新增接口
     *
     * @author wangcg
     * @Date 2020-08-24
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(BotPatrolRepairOrderParam botPatrolRepairOrderParam) {
        this.botPatrolRepairOrderService.add(botPatrolRepairOrderParam);
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
    public ResponseData editItem(BotPatrolRepairOrderParam botPatrolRepairOrderParam) {
        this.botPatrolRepairOrderService.update(botPatrolRepairOrderParam);
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
    public ResponseData delete(BotPatrolRepairOrderParam botPatrolRepairOrderParam) {
        this.botPatrolRepairOrderService.delete(botPatrolRepairOrderParam);
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
    public ResponseData detail(BotPatrolRepairOrderParam botPatrolRepairOrderParam) {
        BotPatrolRepairOrder detail = this.botPatrolRepairOrderService.getById(botPatrolRepairOrderParam.getId());
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
    public LayuiPageInfo list(BotPatrolRepairOrderParam botPatrolRepairOrderParam) {
        return this.botPatrolRepairOrderService.findPageBySpec(botPatrolRepairOrderParam);
    }

}


