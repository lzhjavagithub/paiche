package cn.stylefeng.guns.base;

import cn.stylefeng.guns.GunsApplication;
import cn.stylefeng.guns.dao.PermissionDao;
import cn.stylefeng.guns.dao.RoleDao;
import cn.stylefeng.guns.pojo.PermissionNode;
import cn.stylefeng.guns.pojos.RolePermissionNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;


/**
 * 基础测试类
 *
 * @author stylefeng
 * @Date 2017/5/21 16:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GunsApplication.class)
public class BaseJunit {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void test() {
        List<PermissionNode> perList = permissionDao.selectList();
        System.out.println(perList);
    }

    @Test
    public void testRole() {
        List<RolePermissionNode> perList = roleDao.findByRoleId("1");
        System.out.println(perList);
    }

}
