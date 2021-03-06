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
 * @since 2020-03-04
 */
@TableName("tb_class")
public class Class implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("row_guid")
    private String rowGuid;

    @TableField("group_guid")
    private String groupGuid;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课节名称
     */
    @TableField("t_name")
    private String tName;

    /**
     * t_teacher
     */
    @TableField("t_teacher")
    private String tTeacher;

    /**
     * 知识点
     */
    @TableField("t_point")
    private String tPoint;

    /**
     * 创作方式
     */
    @TableField("t_methods")
    private String tMethods;

    /**
     * 是否试听
     */
    @TableField("t_istest")
    private Integer tIstest;


    public String getRowGuid() {
        return rowGuid;
    }

    public void setRowGuid(String rowGuid) {
        this.rowGuid = rowGuid;
    }

    public String getGroupGuid() {
        return groupGuid;
    }

    public void setGroupGuid(String groupGuid) {
        this.groupGuid = groupGuid;
    }

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

    public String gettTeacher() {
        return tTeacher;
    }

    public void settTeacher(String tTeacher) {
        this.tTeacher = tTeacher;
    }

    public String gettPoint() {
        return tPoint;
    }

    public void settPoint(String tPoint) {
        this.tPoint = tPoint;
    }

    public String gettMethods() {
        return tMethods;
    }

    public void settMethods(String tMethods) {
        this.tMethods = tMethods;
    }

    public Integer gettIstest() {
        return tIstest;
    }

    public void settIstest(Integer tIstest) {
        this.tIstest = tIstest;
    }

    @Override
    public String toString() {
        return "Class{" +
        "rowGuid=" + rowGuid +
        ", groupGuid=" + groupGuid +
        ", id=" + id +
        ", tName=" + tName +
        ", tTeacher=" + tTeacher +
        ", tPoint=" + tPoint +
        ", tMethods=" + tMethods +
        ", tIstest=" + tIstest +
        "}";
    }
}
