package com.qdyd.vehicle.service;

import com.qdyd.vehicle.dao.TMatterDao;
import com.qdyd.vehicle.po.TMatter;
import com.qdyd.vehicle.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TMatterService {

    @Autowired
    private TMatterDao matterDao;
    @Autowired
    private IdWorker idWorker;

    // 查询事由列表
    public List<TMatter> findAll(){
        List<TMatter> all = matterDao.findAll();
        return all;
    }

    // 新增事由
    public void insertTMatter(TMatter matter){
        String id=(idWorker.nextId()+"").substring(0,15);
        //String newId = id.substring(4);
        matter.setTid(id);
        matter.setCreateDate(new Date());
        matter.setDataStatus(0);
        matterDao.insertMatter(matter);
    }

    // 删除事由
    public void deleteTMatter(String tid){
        matterDao.deleteMatter(tid);
    }

}
