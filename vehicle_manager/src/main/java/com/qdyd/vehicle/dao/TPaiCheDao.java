package com.qdyd.vehicle.dao;

import com.qdyd.vehicle.po.TCar;
import com.qdyd.vehicle.po.TDriver;
import com.qdyd.vehicle.po.TDriverUseMan;
import com.qdyd.vehicle.po.TPaiChe;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TPaiCheDao extends JpaRepository<TPaiChe,String>,JpaSpecificationExecutor<TPaiChe> {

    /**
     * 查询派车单列表
     * @return
     */
    @Modifying
    @Query(value = "select * from t_paiche a,t_car b,t_driver c where a.t_data_status=0 and a.t_car_id=b.t_car_id " +
            "and a.t_driver_id=c.t_driver_id order by a.t_date desc",nativeQuery = true)
    public List<Map<Object, Object>> find();

    @Modifying
    @Query(value = "select count(*) from t_paiche where t_data_status=0 limit ?",nativeQuery = true)
    public TPaiChe page(int size);

    /**
     * 删除派车单
     * @param paicheId
     */
    @Modifying
    @Query(value = "update t_paiche set t_data_status=1 where t_paiche_id=?",nativeQuery = true)
    public void delete(String paicheId);

}
