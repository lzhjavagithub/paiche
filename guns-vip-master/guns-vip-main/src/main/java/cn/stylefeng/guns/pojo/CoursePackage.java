package cn.stylefeng.guns.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2020-03-05
 */
@TableName("tb_course_package")
public class CoursePackage implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课包名称
     */
    @TableField("t_name")
    private String tName;

    @TableField("row_guid")
    private Integer rowGuid;

    @TableField("group_guid")
    private Integer groupGuid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer getRowGuid() {
        return rowGuid;
    }

    public void setRowGuid(Integer rowGuid) {
        this.rowGuid = rowGuid;
    }

    public Integer getGroupGuid() {
        return groupGuid;
    }

    public void setGroupGuid(Integer groupGuid) {
        this.groupGuid = groupGuid;
    }

    @Override
    public String toString() {
        return "CoursePackage{" +
        "id=" + id +
        ", tName=" + tName +
        ", rowGuid=" + rowGuid +
        ", groupGuid=" + groupGuid +
        "}";
    }
}
