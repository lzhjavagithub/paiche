package cn.stylefeng.guns.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class UserLoginLog {
    private Integer id;

    /**
     * 登录日期
     */
    @TableField("t_login_date")
    private Date tLoginDate;

    /**
     * 登录IP
     */
    @TableField("t_login_ip")
    private String tLoginIp;

    /**
     * 注册日期
     */
    @TableField("t_register_date")
    private Date tRegisterDate;

    /**
     * 注册IP
     */
    @TableField("t_register_ip")
    private String tRegisterIp;

    /**
     * 年龄
     */
    @TableField("t_age")
    private Integer tAge;

    /**
     * 手机号
     */
    @TableField("t_mobile")
    private String tMobile;

    /**
     * 性别
     */
    @TableField("t_sex")
    private String tSex;

    /**
     * 用户名
     */
    @TableField("t_username")
    private String tUsername;

    private String recordguid;
}
