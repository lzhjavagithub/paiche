package cn.stylefeng.guns.service;

import cn.stylefeng.guns.pojo.Type;
import com.github.pagehelper.Page;

import java.util.List;

public interface TypeService {
    int countType();
    Page<Type> findAll(int page, int size, String query);
    void addType(String userId,Type type);
    void delete(String userId,String id);
    List<Type> findType();
}
