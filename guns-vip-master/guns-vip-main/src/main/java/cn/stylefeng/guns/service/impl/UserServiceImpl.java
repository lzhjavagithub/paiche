package cn.stylefeng.guns.service.impl;

import cn.stylefeng.guns.dao.UserLoginLogDao;
import cn.stylefeng.guns.dao.UserOrderDao;
import cn.stylefeng.guns.pojos.UserLoginLog;
import cn.stylefeng.guns.pojos.UserOrder;
import cn.stylefeng.guns.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserLoginLogDao userLoginLogDao;

    @Autowired
    private UserOrderDao userOrderDao;

    @Override
    public List<UserLoginLog> findAll(int page,int size) {
        PageHelper.startPage(page, size);
        return userLoginLogDao.findAll();
    }

    @Override
    public int count() {
        return userLoginLogDao.count();
    }

    @Override
    public List<UserOrder> userOrderCount(Integer id) {
        List<UserOrder> count = userOrderDao.userOrderCount(id);
        System.out.println(count);
        return count;
    }
}
