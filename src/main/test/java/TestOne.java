import com.ywh.bean.Tbladdress;
import com.ywh.bean.Tblmanager;
import com.ywh.mapper.AddressMapper;
import com.ywh.mapper.TblmanagerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

//注解让测试运行于Spring测试环境。
@RunWith(SpringJUnit4ClassRunner.class)
//引入Spring配置
@ContextConfiguration({"classpath*:/applicationContext.xml"})
public class TestOne {
    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private TblmanagerMapper tblmanagerMapper;

    @Test
    public void TestAddressSelectAll(){
        List<Tbladdress> list = addressMapper.selectAll();
        System.out.println(list);
    }

    @Test
    public void TestFindManager(){
        Tblmanager manager = tblmanagerMapper.findManager("1", "1");
        System.out.println(manager);
    }

}