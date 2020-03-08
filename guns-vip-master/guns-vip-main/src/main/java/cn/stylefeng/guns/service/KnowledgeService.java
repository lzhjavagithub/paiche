package cn.stylefeng.guns.service;

import cn.stylefeng.guns.pojo.Knowledge;
import cn.stylefeng.guns.pojo.KnowledgeNode;
import cn.stylefeng.guns.pojos.EmpKnowledge;

import java.util.List;

public interface KnowledgeService {
    void saveKnowedge(Integer id, String userId, Knowledge knowledge);
    List<KnowledgeNode> selectList();
    Knowledge findById(Integer id);
    void update(Integer id, String userId, Knowledge knowledge);
}
