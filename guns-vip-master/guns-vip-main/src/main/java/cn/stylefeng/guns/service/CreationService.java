package cn.stylefeng.guns.service;

import cn.stylefeng.guns.pojo.Creation;
import cn.stylefeng.guns.pojos.EmpCreation;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreationService {
    Page<EmpCreation> findAll(int page, int size, String query);
    int count();
    EmpCreation findById(String id);
    void save(String userId, Creation creation);
    void update(Integer id, String userId, Creation creation);
    void delete(Integer id, String userId);
}
