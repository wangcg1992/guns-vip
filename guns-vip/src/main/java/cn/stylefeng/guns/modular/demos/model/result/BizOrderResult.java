package cn.stylefeng.guns.modular.demos.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author wangcg
 * @since 2020-08-19
 */
@Data
public class BizOrderResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 下单地点
     */
    private String place;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 下单用户名称
     */
    private String userName;

    /**
     * 下单用户电话
     */
    private String userPhone;

}
