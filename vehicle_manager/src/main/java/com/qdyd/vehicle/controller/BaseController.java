package com.qdyd.vehicle.controller;

import com.qdyd.vehicle.po.*;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.service.PaicheRecordService;
import com.qdyd.vehicle.service.TPaiCheService;
import com.qdyd.vehicle.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class BaseController {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private PaicheRecordService paicheRecordService;

    @Autowired
    private TPaiCheService paiCheService;

    /**
     * 投屏
     */
    @RequestMapping("/touping")
    public String touping(){
        return "wel-touping";
    }

    /**
     * 事由
     */
    @RequestMapping("/matter-list")
    public String matterList(){
        return "page/matter/matter-list";
    }

    @RequestMapping("/matter-add")
    public String matterAdd(){
        return "page/matter/matter-add";
    }

    /**
     * 目的地
     */
    @GetMapping("/destination-list")
    public String desList(){
        return "page/destination/destination-list";
    }

    @GetMapping("/destination-add")
    public String desAdd(){
        return "page/destination/destination-add";
    }

    /**
     * 跳转到首页
     * @return
     */
    @GetMapping(value = "/toIndex")
    public String toIndex(HttpSession session, ModelMap mp){
        String id=(String)session.getAttribute("userId");
        TUser user=tUserService.selectUserById(id);
        if(user!=null){
            mp.addAttribute("user",user);
            return "index";
        }else {
            return "redirect:loginindex";
        }
    }

    // 预览派车单 获取id
    @RequestMapping("/viewpaiche")
    public String viewPaiche(String id, HttpSession session){
        session.setAttribute("id", id);
        return "page/order/order-print";
    }

    // 派车单编辑页面
    @RequestMapping("/order-edit")
    public String orderEdit(){
        return "page/order/order-edit";
    }

    /**
     * 派车管理页面
     * @return
     */
    @RequestMapping("/order-list")
    public String orderList(HttpSession session,ModelMap mp){
        String id=(String)session.getAttribute("userId");
        TUser user=tUserService.selectUserById(id);
        if(user!=null){
            mp.addAttribute("user",user);
            return "page/order/order-list";
        }else {
            return "error";
        }
    }

    @RequestMapping("/order-add")
    public String orderAdd(){
        return "page/order/order-add";
    }

    // 审核派车单
    @RequestMapping("/orderview")
    public String orderView(String id, HttpSession session){
        session.setAttribute("id", id);
        System.out.println(id);
        return "page/order/order-view";
    }

    /**
     * 获取所有用户的信息
     * @return
     */
    @GetMapping(value = "/selectAllUser")
    public String selectAllUser(ModelMap mp){
        List<TUser> users=tUserService.selectAllUser();
        mp.addAttribute("users",users);
        return "page/user/admin-list";
    }

    /**
     * 跳转到增加用户页面
     * @return
     */
    @GetMapping(value = "/addIndex")
    public String addIndx(HttpSession session){
        String id=(String)session.getAttribute("userId");
        TUser user=tUserService.selectUserById(id);
        if(user!=null){
            if(user.getPer()==StatusCode.USER_PER_CAOZUO){
                return "page/user/no-per";
            }else{
                return "page/user/admin-add";
            }
        }else {
            return "error";
        }
    }

    /**
     * 退出系统回到登录首页
     * @param session
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }


    /**
     * 跳转到修改用户信息页面
     * @param session
     * @param mp
     * @return
     */
    @GetMapping(value = "/updateIndex")
    public String updateUser(HttpSession session, ModelMap mp){
        String id=(String)session.getAttribute("userId");
        TUser user=tUserService.selectUserById(id);
        if(user!=null){
            mp.addAttribute("user",user);
            return "page/user/admin-edit";
        }else {
            return "error";
        }
    }

    /**
     *跳转到修改密码页面
     * @param session
     * @param mp
     * @return
     */
    @GetMapping(value = "/updatePassIndex")
    public String updatePassIndex(HttpSession session,ModelMap mp){
        String id=(String)session.getAttribute("userId");
        TUser user=tUserService.selectUserById(id);
        if(user!=null){
            mp.addAttribute("user",user);
            return "page/user/member-password";
        }else{
            return "error";
        }
    }

    /**
     * 跳转到管理员修改所有用户信息页面
     * @param session
     * @param mp
     * @return
     */
    @GetMapping(value = "/updateAllIndex")
    public String updateAllUser(HttpSession session, ModelMap mp,String id){
        TUser user=tUserService.selectUserById(id);
        String sid=(String)session.getAttribute("userId");
        TUser suser=tUserService.selectUserById(sid);
        if(suser!=null){
            if(suser.getPer()==StatusCode.USER_PER_CAOZUO){
                return "page/user/no-per";
            }else{
                mp.addAttribute("user",user);
                return "page/user/admin-edit";
            }
        }else{
            return "error";
        }
    }

    /**
     * 修改用户状态
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteUser")
    public String deleteUser(String id,HttpSession  session){
        String sid=(String)session.getAttribute("userId");
        TUser suser=tUserService.selectUserById(sid);
        if(suser!=null){
            if(suser.getPer()==StatusCode.USER_PER_CAOZUO){
                return "page/user/no-per";
            }else {
                Integer integer=tUserService.deleteUser(id);
                return "redirect:selectAllUser";
            }
        }else{
            return "error";
        }

    }

    /*@GetMapping(value = "/selectAllRecords")
    public String selectAll(ModelMap mp,String driverName,HttpSession session){
        session.removeAttribute("driverName");
        List<PaicheRecord> lists=paicheRecordService.selectRecords(driverName);
        if(driverName!=null){
            session.setAttribute("driverName",driverName);
        }
        mp.addAttribute("lists",lists);
        return "record-list";
    }*/

    /**
     * 跳转到登陆页面
     * @return
     */
    @GetMapping(value = "/loginindex")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/welcome")
    public String toWelcome(HttpSession session, ModelMap mp){
        String id=(String)session.getAttribute("userId");
        TUser user=tUserService.selectUserById(id);
        if(user!=null){
            mp.addAttribute("user",user);
            return "welcome";
        }else {
            return "error";
        }
    }

    /**
     * 陈
     */
    @RequestMapping("/car")
    public String car(HttpSession session,ModelMap mp){
        String id=(String)session.getAttribute("userId");
        TUser user=tUserService.selectUserById(id);
        if(user!=null){
            mp.addAttribute("user",user);
            return "page/car/car";
        }else {
            return "error";
        }
    }

    @RequestMapping("/caradd")
    public String caradd(){
        return "page/car/car-add";
    }

    //获得id
    @RequestMapping("/carupdateid")
    public String carupdateid(String id,HttpSession session){
     	session.setAttribute("id", id);
        //String userId=(String)session.getAttribute("userId");
        //TUser user=tUserService.selectUserById(userId);
        //if(user!=null){
          //  if(user.getPer()== StatusCode.USER_PER_CAOZUO){
            //    return "page/user/no-per";
            //}else{
                return "page/car/car-edit";
            //}
//        }else {
//            return "error";
//        }
    }

    //获得id
    @RequestMapping("/driversupdateid")
    public String driversupdateid(String driverId,HttpSession session){
      	//System.out.println("basedriverId:"+driverId);
      	session.setAttribute("driverId", driverId);
        String userId=(String)session.getAttribute("userId");
        TUser user=tUserService.selectUserById(userId);
        if(user!=null){
            if(user.getPer()== StatusCode.USER_PER_CAOZUO){
                return "page/user/no-per";
            }else{
                return "page/man/driver/drivers-edit";
            }
        }else {
            return "error";
        }
   }

   @RequestMapping("/drivers")
   public String drivers(HttpSession session,ModelMap mp){
       String id=(String)session.getAttribute("userId");
       TUser user=tUserService.selectUserById(id);
       if(user!=null){
           mp.addAttribute("user",user);
           return "page/man/driver/drivers";
       }else {
           return "error";
       }
   }

   @RequestMapping("/driversadd")
   public String driversadd(){
       return "page/man/driver/drivers-add";
    }

   @RequestMapping("/usemanupdateid")
   public String usemanupdateid(String driverId,HttpSession session){

       session.setAttribute("driverId", driverId);
       String userId=(String)session.getAttribute("userId");
       TUser user=tUserService.selectUserById(userId);
       if(user!=null){
           if(user.getPer()== StatusCode.USER_PER_CAOZUO){
               return "page/user/no-per";
           }else{
               return "page/man/useman/use-man-edit";
           }
       }else {
           return "error";
       }
   }

   @RequestMapping("/useman")
   public String useman(HttpSession session,ModelMap mp){
       String id=(String)session.getAttribute("userId");
       TUser user=tUserService.selectUserById(id);
       if(user!=null){
           mp.addAttribute("user",user);
           return "page/man/useman/use-man";
       }else {
           return "error";
       }
   }

   @RequestMapping("/usemanadd")
   public String usemanadd(){
        return "page/man/useman/use-man-add";
   }

//派车单统计
    @GetMapping(value = "selectAllRecords")
    public String selectAll(ModelMap mp){
        List<TDriverDepartment> deptList=paicheRecordService.selectAllDepartment();
        mp.addAttribute("deptList",deptList);
        List<TCar> carList=paicheRecordService.selectAllCar();
        mp.addAttribute("carList",carList);
        List<TDriver> driverList=paicheRecordService.selectAllDricer();
        mp.addAttribute("driverList",driverList);
        return "page/order/record-list-paiche";
    }

    //数据统计
    @GetMapping(value = "chucheSelectAllRecords")
    public String chucheSelectAll(ModelMap mp){
        List<TDriverDepartment> deptList=paicheRecordService.selectAllDepartment();
        mp.addAttribute("deptList",deptList);
        List<TCar> carList=paicheRecordService.selectAllCar();
        mp.addAttribute("carList",carList);
        List<TDriver> driverList=paicheRecordService.selectAllDricer();
        mp.addAttribute("driverList",driverList);
        return "page/user/record-list-chuche";
    }

    // ---
    @GetMapping("/departmentfindAll")
    public String departmentfindAll(){
        return "page/department/department";
    }
    @GetMapping("/departmentadd")
    public String departmentadd(){
        return "page/department/department-add";
    }
    //获得id
    @RequestMapping("/departmentid")
    public String departmentid(String id,HttpSession session){
        session.setAttribute("departmentId", id);
        return  "page/department/department-edit";
    }

    @GetMapping("/carStatusfindAll")
    public String carStatusfindAll(){
        return "page/carStatus/carStatus";
    }
    @GetMapping("/carStatusadd")
    public String carStatusadd(){
        return "page/carStatus/carStatus-add";
    }
    //获得id
    @RequestMapping("/carStatusid")
    public String carStatusid(String id,HttpSession session){
        session.setAttribute("carStatusId", id);
        return  "page/carStatus/carStatus-edit";
    }

    // 打印预览页面
    @RequestMapping("/order-print")
    public String orderPrint(){
        return "page/order/order-print";
    }

    // 派车列表中打印
    @RequestMapping("/order-paiche-print")
    public String orderpaicheprint(String paicheNo,ModelMap mp){
        PaicheRecord paicheRecord= paicheRecordService.selectPaicheRecordById(paicheNo);
        mp.addAttribute("paicheRecord",paicheRecord);
        return "page/order/order-paiche-print";
    }

    @RequestMapping("/carTypefindAll")
    public String carTypefindAll(){
        return "page/carStatus/carType";
    }

}
