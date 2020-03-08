package cn.stylefeng.guns.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class WorkUC {

    private Integer id;
    /**
     * 作品编号
     */
    @TableField("t_works_num")
    private String tWorksNum;

    /**
     * 作品名
     */
    @TableField("t_works_name")
    private String tWorksName;
    /**
     * 教师评价内容
     */
    @TableField("t_content")
    private String tContent;

    /**
     * 上传日期
     */
    @TableField("t_upload_date")
    private Date tUploadDate;

    /**
     * 作品图片
     */
    @TableField("t_img_url")
    private String tImgUrl;

    @TableField("t_works_type")
    private String tWorksType;

    /**
     * 用户名
     */
    @TableField("t_username")
    private String tUsername;
    private String tEmpname;

    /**
     * 手机号
     */
    @TableField("t_mobile")
    private String tMobile;

    /**
     * 课程名称
     */
    @TableField("t_course_name")
    private String tCourseName;

    /**
     * 课节名称
     */
    @TableField("t_name")
    private String tName;

}
