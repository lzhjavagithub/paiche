package com.qdyd.vehicle.dao;

import com.qdyd.vehicle.po.TDuty;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DutyDao {
    @Insert("insert into t_duty(duty_id,duty_company,duty_create_date,duty_week,duty_date,duty_leader,duty_man)values" +
            "(#{dutyId},#{dutyCompany},#{dutyCreateDate},#{dutyWeek},#{dutyDate},#{dutyLeader},#{dutyMan})")
    Integer AddDuty(TDuty duty);
}
