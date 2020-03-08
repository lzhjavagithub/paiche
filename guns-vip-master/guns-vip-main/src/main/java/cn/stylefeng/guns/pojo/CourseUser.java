package cn.stylefeng.guns.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2020-03-04
 */
@TableName("tb_course_user")
public class CourseUser implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("t_user_guid")
    private String tUserGuid;

    @TableField("t_course_guid")
    private String tCourseGuid;

    @TableField("t_create_time")
    private Date tCreateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettUserGuid() {
        return tUserGuid;
    }

    public void settUserGuid(String tUserGuid) {
        this.tUserGuid = tUserGuid;
    }

    public String gettCourseGuid() {
        return tCourseGuid;
    }

    public void settCourseGuid(String tCourseGuid) {
        this.tCourseGuid = tCourseGuid;
    }

    public Date gettCreateTime() {
        return tCreateTime;
    }

    public void settCreateTime(Date tCreateTime) {
        this.tCreateTime = tCreateTime;
    }

    @Override
    public String toString() {
        return "CourseUser{" +
        "id=" + id +
        ", tUserGuid=" + tUserGuid +
        ", tCourseGuid=" + tCourseGuid +
        ", tCreateTime=" + tCreateTime +
        "}";
    }
}
