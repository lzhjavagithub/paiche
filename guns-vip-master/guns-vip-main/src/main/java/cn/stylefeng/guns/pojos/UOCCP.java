package cn.stylefeng.guns.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UOCCP {

    private String rowGuid;

    private String groupGuid;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String tUsername;

    /**
     * 手机号
     */
    private String tMobile;

    /**
     * 课包
     */
    private String tName;


    /**
     * 所拥有的课程ID
     */
    private String tCourseId;

    /**
     * 订单号
     */
    private String tOrderNo;

    /**
     * 订单状态 1待支付 2已支付 3已取消
     */
    private Integer tOrderStatus;

    /**
     * 支付方式
     */
    private String tPayWay;

    /**
     * 订单金额
     */
    private BigDecimal tPrice;

    /**
     * 支付时间
     */
    private Date tPayDate;

    /**
     * 商户订单号
     */
    private String tShopNo;

    /**
     * 下单时间
     */
    private Date tPlaceOrderDate;

    /**
     * 收货地址
     */
    private String tAcceptAddress;

    /**
     * 收货人
     */
    private String tAcceptPeople;

    /**
     * 联系手机
     */
    private String tAcceptPhone;

    /**
     * 课程名称
     */
    private String tCourseName;

}
