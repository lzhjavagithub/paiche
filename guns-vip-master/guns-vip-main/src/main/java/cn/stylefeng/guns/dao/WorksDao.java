package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojo.Works;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface WorksDao extends BaseMapper<Works> {

    @Select("SELECT w.id, w.t_img_url, w.t_content,\n" +
            "FROM tb_works w \n" +
            "WHERE w.id=#{id}")
    Works findById(Integer id);
}
