package cn.stylefeng.guns.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class EmpWorks {
    private String id;

    /**
     * 用户名
     */
    @TableField("t_username")
    private String tUsername;
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
     * 教师评价日期
     */
    @TableField("t_valuation_date")
    private Date tValuationDate;

    /**
     * 评价教师GUID
     */
    @TableField("t_teacher_guid")
    private String tTeacherGuid;

    /**
     * 课程GUID
     */
    @TableField("t_course_guid")
    private String tCourseGuid;

    /**
     * 课节guid
     */
    @TableField("t_class_guid")
    private String tClassGuid;

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
}
