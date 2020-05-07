package com.qdyd.vehicle.service;

import com.qdyd.vehicle.dao.TDestinationDao;
import com.qdyd.vehicle.po.TDestination;
import com.qdyd.vehicle.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TDestinationService {

    @Autowired
    private TDestinationDao destinationDao;

    @Autowired
    private IdWorker idWorker;

    public List<TDestination> destinationSelect(){
        List<TDestination> list = destinationDao.destinationSelect();
        return list;
    }

    // 查询目的地列表
    public List<TDestination> findAll(){
        List<TDestination> selectList = destinationDao.findAll();
        return selectList;
    }

    // 根据ID查询
    public TDestination findById(String id){
        TDestination destination = destinationDao.selectById(id);
        return destination;
    }

    // 新增目的地
    public void save(TDestination destination){
        String id =(idWorker.nextId()+"").substring(0,15);
        destination.setDesId(id.substring(4));
        destination.setDesTime(new Date());
        destination.setDataStatus(0);
        destinationDao.addDes(destination);
    }

    // 删除目的地
    public void deleteById(String id){
        destinationDao.delByid(id);
    }

}
