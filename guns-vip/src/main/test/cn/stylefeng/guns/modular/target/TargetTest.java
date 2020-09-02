package cn.stylefeng.guns.modular.target;

import cn.stylefeng.guns.modular.target.component.TargetCalContext;
import cn.stylefeng.guns.modular.target.entity.TargetItem;
import cn.stylefeng.guns.modular.target.service.TargetCalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TargetTest {

    @Resource
    private TargetCalService targetCalService;


    /**
     * 测试求解平均值这种类型
     */
    @Test
    public void testAvg() {

        // 构造Context
        TargetCalContext context = new TargetCalContext();
        // 计算时间
        context.setCalTime("2020-07-01");
        // 开始时间
        context.setStartTime("2020-01-12 08:12:00");
        // 结束时间
        context.setEndTime("2020-12-12 08:12:00");
        // 班次
        context.setClassName("1");

        // 构建 Item对象
        TargetItem item = new TargetItem();
        item.setId("1");
        item.setName("均值计算");
        item.setTag("XNJS_HBS");
        item.setCalType(1);
        item.setSeq(1);

        this.targetCalService.calTargetItem(context, item);

    }

    /**
     * 计算累积值
     */
    @Test
    public void testCaculate() {

        // 构造Context
        TargetCalContext context = new TargetCalContext();
        // 计算时间
        context.setCalTime("2020-07-01");
        // 开始时间
        context.setStartTime("2020-03-12 08:12:00");
        // 结束时间
        context.setEndTime("2020-12-12 08:12:00");
        // 班次
        context.setClassName("1");

        // 构建 Item对象
        TargetItem item = new TargetItem();
        item.setId("2");
        item.setName("累计值计算");
        item.setTag("XNJS_HBS");
        item.setCalType(2);
        item.setSeq(1);

        this.targetCalService.calTargetItem(context, item);

    }


    /**
     * 公式计算
     */
    @Test
    public void testFormula() {

        // 构造Context
        TargetCalContext context = new TargetCalContext();
        // 计算时间
        context.setCalTime("2020-07-01");
        // 开始时间
        context.setStartTime("2020-03-12 08:12:00");
        // 结束时间
        context.setEndTime("2020-12-12 08:12:00");
        // 班次
        context.setClassName("1");

        // 构建 Item对象
        TargetItem item = new TargetItem();
        item.setId("3");
        item.setName("公式计算");
        item.setTag("XNJS_HBS");
        item.setCalType(3);
        item.setSeq(1);
        item.setFormula("${1} + ${2} + 3");

        this.targetCalService.calTargetItem(context, item);

    }

    /**
     * 公式计算
     */
    @Test
    public void testHour() {

        // 构造Context
        TargetCalContext context = new TargetCalContext();
        // 计算时间
        context.setCalTime("2020-07-01");
        // 开始时间
        context.setStartTime("2020-03-11 04:12:00");
        // 结束时间
        context.setEndTime("2020-03-12 08:33:00");
        // 班次
        context.setClassName("1");

        // 构建 Item对象
        TargetItem item = new TargetItem();
        item.setId("4");
        item.setName("小时计数");
        item.setTag("XNJS_HBS");
        item.setCalType(4);
        item.setSeq(1);
        item.setFormula("${value} > 0");

        this.targetCalService.calTargetItem(context, item);

    }

}
