package cn.stylefeng.guns.service.impl;

import cn.stylefeng.guns.dao.CarouselDao;
import cn.stylefeng.guns.dao.CarouselImgDao;
import cn.stylefeng.guns.dao.LogDao;
import cn.stylefeng.guns.pojo.Img;
import cn.stylefeng.guns.pojo.Log;
import cn.stylefeng.guns.pojos.EmpImg;
import cn.stylefeng.guns.service.CarouselSerivce;
import cn.stylefeng.guns.utils.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CarouselSerivceImpl implements CarouselSerivce {

    @Autowired
    private CarouselDao empImgDao;

    @Autowired
    private CarouselImgDao carouselImgDao;

    @Autowired
    private LogDao logDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public EmpImg findById(String id) {
        return empImgDao.findById(id);
    }

    @Override
    public Page<EmpImg> findAll(int page, int size,String query) {
        PageHelper.startPage(page, size);
        EmpImg empImg = new EmpImg();
        empImg.settName(query);
        Page<EmpImg> list = empImgDao.findAll(empImg);
        return list;
    }

    @Override
    public int countImg() {
        return empImgDao.countImg();
    }

    @Override
    public void addCarouse(String userId, Img img) {
        img.setId(idWorker.nextId()+"");
        img.settUploadMan(userId);// 上传人
        img.settImgType(img.gettImgType());
        img.settLinkType(img.gettLinkType());
        img.settStatus(1);// 1生效 2停止
        img.settImgUrl(img.gettImgUrl());// 图片url
        // 日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        img.settUploadDate(date);
        img.settOrderNo(img.gettOrderNo());// 排序号
        carouselImgDao.insert(img);

        try {
            // 操作日志
            Log log = new Log();
            log.setId(idWorker.nextId()+"");
            log.settIpAddress(Inet4Address.getLocalHost().getHostAddress());
            log.settOperatorDate(date);
            log.settOperatorMan(userId);
            log.settOperatorRecord("保存轮播图");
            logDao.insertLog(log);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id, String userId) {
        carouselImgDao.deleteById(id);

        // 日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        try {
            // 操作日志
            Log log = new Log();
            log.setId(idWorker.nextId()+"");
            log.settIpAddress(Inet4Address.getLocalHost().getHostAddress());
            log.settOperatorDate(date);
            log.settOperatorMan(userId);
            log.settOperatorRecord("删除轮播图");
            logDao.insertLog(log);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
