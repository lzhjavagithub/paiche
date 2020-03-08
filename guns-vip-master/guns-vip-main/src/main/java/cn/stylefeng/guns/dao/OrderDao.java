package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojos.UOCCP;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderDao extends BaseMapper<UOCCP> {

    @Select("<script>" +
            "SELECT\n" +
            "\tu.t_username,\n" +
            "\tu.t_mobile,\n" +
            "\tc.t_course_name,\n" +
            "\to.t_pay_date,\n" +
            "\to.t_order_no,\n" +
            "\to.t_place_order_date,\n" +
            "\to.t_order_status,\n" +
            "\to.t_price," +
            "o.t_pay_way,\n" +
            "\tcp.t_name \n" +
            "FROM\n" +
            "\ttb_user u,\n" +
            "\ttb_order o,\n" +
            "\ttb_course c,\n" +
            "\ttb_course_package cp \n" +
            "WHERE\n" +
            "\to.t_user_guid = u.id \n" +
            "\tAND o.t_course_guid = c.id\n" +
            "\tAND o.t_class_package_guid = cp.id" +
            " <if test='tUsername!=null and tUsername!=\"\"'> " +
            "     AND u.t_username LIKE '%${tUsername}%'" +
            " </if>" +
            " <if test='tMobile!=null and tMobile!=\"\"'> " +
            "    OR u.t_mobile = #{tMobile} " +
            " </if> " +
            " <if test='tOrderNo!=null and tOrderNo!=\"\"'> " +
            "    OR o.t_order_no = #{tOrderNo}" +
            " </if> " +
            "</script>")
    Page<UOCCP> findAll(UOCCP uoccp);

    @Select("select count(*) from tb_order")
    int count();

}
