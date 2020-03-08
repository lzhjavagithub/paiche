package cn.stylefeng.guns.service;

import cn.stylefeng.guns.pojos.UserLoginLog;
import cn.stylefeng.guns.pojos.UserOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserLoginLog> findAll(int page,int size);
    int count();
    List<UserOrder> userOrderCount(Integer id);
}
