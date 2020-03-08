package cn.stylefeng.guns.service.impl;

import cn.stylefeng.guns.dao.KnowledgeDao;
import cn.stylefeng.guns.dao.LogDao;
import cn.stylefeng.guns.pojo.Knowledge;
import cn.stylefeng.guns.pojo.KnowledgeNode;
import cn.stylefeng.guns.pojo.Log;
import cn.stylefeng.guns.service.KnowledgeService;
import cn.stylefeng.guns.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeDao knowledgeDao;

    @Autowired
    private LogDao logDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void saveKnowedge(Integer id, String userId, Knowledge knowledge) {
        // 日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);

        knowledge.settKnowledgeName(knowledge.gettKnowledgeName());
        knowledge.settKnowledgeMan(userId);
        knowledge.settUpdateDate(date);
        if (id==null) {
            knowledge.settParentId(0);// 一级知识点
        } else {
            knowledge.settParentId(id);// 子知识点父级id
        }
        knowledgeDao.insert(knowledge);

        try {
            // 操作日志
            Log log = new Log();
            log.setId(idWorker.nextId()+"");
            log.settIpAddress(Inet4Address.getLocalHost().getHostAddress());
            log.settOperatorDate(date);
            log.settOperatorMan(userId);
            log.settOperatorRecord("保存知识点");
            logDao.insertLog(log);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KnowledgeNode> selectList() {
        return knowledgeDao.selectList();
    }

    @Override
    public Knowledge findById(Integer id) {
        Knowledge knowledge = knowledgeDao.findById(id);
        System.out.println(knowledge);
        return knowledge;
    }

    @Override
    public void update(Integer id, String userId, Knowledge knowledge) {
        // 日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);

        Knowledge knowedgeId = knowledgeDao.findById(id);
        knowedgeId.settKnowledgeName(knowledge.gettKnowledgeName());
        knowedgeId.settKnowledgeMan(userId);
        knowedgeId.settUpdateDate(date);
        knowedgeId.setId(id);
        knowledgeDao.update(knowedgeId);

        try {
            // 操作日志
            Log log = new Log();
            log.setId(idWorker.nextId()+"");
            log.settIpAddress(Inet4Address.getLocalHost().getHostAddress());
            log.settOperatorDate(date);
            log.settOperatorMan(userId);
            log.settOperatorRecord("保存知识点");
            logDao.insertLog(log);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
