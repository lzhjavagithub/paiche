package com.qdyd.vehicle.service;

import com.qdyd.vehicle.dao.TUserDao;
import com.qdyd.vehicle.po.TUser;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.util.IdWorker;
import com.qdyd.vehicle.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserService {

    @Autowired
    private TUserDao tUserDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的用户
     * @return
     */
    public List<TUser> selectAllUser(){
        List<TUser> users=tUserDao.selectAllUser();
        return users;
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    public Integer addUser(TUser user) {
        user.setId(idWorker.nextId()+"");
        user.setDataStatus(StatusCode.USER_DATA_STATUS_SUCCESS);
        user.setPassWord(MD5Util.getStringMD5(user.getPassWord()));
        user.setPer(2);// 帮你添加个初始权限
        Integer num=tUserDao.insert(user);
        return num;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public Integer updateUser(TUser user){
        return  tUserDao.updateUser(user);
    }

    /**
     * 修改密码
     * @param id
     * @param passWord
     * @return
     */
    public  Integer updatePassword(String id,String passWord){
        return tUserDao.updatePassWord(id,passWord);
    }

    /**
     * 按照用户状态查询用户
     * @param dataStatus
     * @return
     */
    public List<TUser> selectUserByDataStatus(String dataStatus){
        return tUserDao.selectUserByDataStatus(dataStatus);
    }

    /**
     * 按照用户id查询用户具体信息
     * @param id
     * @return
     */
    public TUser selectUserById(String id){
        return tUserDao.selectUserById(id);
    }

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    public TUser selectUserByUserName(String userName){
        return tUserDao.selectUserByUserName(userName);
    }

    /**
     * 修改用户状态
     * @param id
     * @return
     */
    public Integer deleteUser(String id){
        TUser user=tUserDao.selectUserById(id);
        if(user.getDataStatus()==StatusCode.USER_DATA_STATUS_SUCCESS){
            user.setDataStatus(StatusCode.USER_DATA_STATUS_FAIL);
        }else{
            user.setDataStatus(StatusCode.USER_DATA_STATUS_SUCCESS);
        }
        return tUserDao.deleleUser(id,user.getDataStatus());
    }

}
