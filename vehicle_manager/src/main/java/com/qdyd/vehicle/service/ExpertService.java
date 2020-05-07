package com.qdyd.vehicle.service;

import com.qdyd.vehicle.dao.ExpertMapper;
import com.qdyd.vehicle.po.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertService {
    @Autowired
    private ExpertMapper expertMapper;

    public List<Expert> findExpertList(String search, String city, String solt, int page, int page_size) {
        return expertMapper.findExpertList(search,city,solt,page,page_size);
    }
}
