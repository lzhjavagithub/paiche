package com.qdyd.vehicle.controller;

import com.qdyd.vehicle.po.TUser;
import com.qdyd.vehicle.po.entity.Result;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.service.TUserService;
import com.qdyd.vehicle.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class TUserController {

    @Autowired
    private TUserService tUserService;

    /**
     * 登录成功
     * @return
     */
    @PostMapping(value ="/index")
    @ResponseBody
    public Result index(String userName, String passWord, HttpSession session){
        TUser user=tUserService.selectUserByUserName(userName);
        if(user==null){
            return new Result(false, StatusCode.LOGINERROR,"用户名不存在");
        }else{
            if(user.getDataStatus()==StatusCode.USER_DATA_STATUS_FAIL){
                return new Result(true,StatusCode.USER_DATA_STATUS_FAIL,"你的账号已停用");
            }else{
                String pass=user.getPassWord();
                if(pass.equals(MD5Util.getStringMD5(passWord))){
                    session.setAttribute("userId",user.getId());
                    return new Result(true,StatusCode.OK,"登陆成功");
                }else{
                    return new Result(false,StatusCode.PASSFAIL,"密码错误");
                }
            }
        }
    }



    /**
     * 添加用户
     * @param user
     * @return 返回状态信息
     */
    @PostMapping(value = "/adduser")
    @ResponseBody
    public Result addUser(TUser user){
        String userName=user.getUserName();
        TUser user1=tUserService.selectUserByUserName(userName);
        if(user1!=null){
            return new Result(false,StatusCode.ERROR,"该用户名已存在");
        }else{
            Integer integer=tUserService.addUser(user);
            if(integer==0){
                return new Result(false,StatusCode.ERROR,"添加用户失败");
            }else{
                return new Result(true,StatusCode.OK,"添加用户成功");
            }
        }

    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping(value = "/updateUser")
    @ResponseBody
    public Result updateUser(TUser user,HttpSession session) {
        Integer integer = tUserService.updateUser(user);
        if (integer == 0) {
            return new Result(false, StatusCode.ERROR, "修改用户失败");
        } else {
            return new Result(true, StatusCode.OK, "修改用户成功");
        }
    }

    /**
     * 修改密码
     * @param id
     * @param oldPassWord
     * @param newPassWord
     * @return
     */
    @PostMapping(value = "/updatePassWord")
    @ResponseBody
    public Result updatePassWord(String id,String oldPassWord,String newPassWord){
        TUser user=tUserService.selectUserById(id);
        String passWord=user.getPassWord();
        if (passWord.equals(MD5Util.getStringMD5(oldPassWord))){
            Integer integer=tUserService.updatePassword(id,MD5Util.getStringMD5(newPassWord));
            if(integer==0){
                return new Result(false,StatusCode.ERROR,"修改密码失败");
            }else{
                return new Result(true,StatusCode.OK,"修改密码成功");
            }
        }else{
            return new Result(false,StatusCode.ERROR,"原密码不正确");
        }

    }

    /**
     * 根据状态查询人员信息
     * @param dataStatus
     * @return
     */
    @GetMapping(value = "/selectByStatus")
    public String selectUserByDataStatus(String dataStatus){
        List<TUser> user=tUserService.selectUserByDataStatus(dataStatus);
        return "";
    }

    /**
     * 根据id查询个人信息
     * @param mp
     * @return
     */
    @GetMapping(value = "/selectUserById")
    public String selectUserById(ModelMap mp){
        return "";
    }

}