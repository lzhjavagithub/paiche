package cn.stylefeng.guns.service;

import cn.stylefeng.guns.pojo.Img;
import cn.stylefeng.guns.pojos.EmpImg;
import com.github.pagehelper.Page;

public interface CarouselSerivce {
    EmpImg findById(String id);
    Page<EmpImg> findAll(int page, int size,String query);
    int countImg();
    void addCarouse(String userId, Img img);
    public void deleteById(String id, String userId);
}
