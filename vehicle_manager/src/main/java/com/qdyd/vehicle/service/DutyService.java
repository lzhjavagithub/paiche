package com.qdyd.vehicle.service;

import com.qdyd.vehicle.dao.DutyDao;
import com.qdyd.vehicle.po.TDuty;
import com.qdyd.vehicle.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DutyService {
    @Autowired
    private DutyDao dutyDao;

    @Autowired
    private IdWorker idW;



    public void addDuty(List<TDuty> list) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(TDuty duty:list){
            duty.setDutyId(idW.nextId()+"");
            duty.setDutyCreateDate(new Date());
            dutyDao.AddDuty(duty);
        }
    }

}
