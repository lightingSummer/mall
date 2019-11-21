package club.lightingsummer.mall.manage;

import club.lightingsummer.mall.api.service.SpuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author light
 * @date 2019/11/21 0021 14:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {
    @Autowired
    SpuService spuService;

    @Test
    public void serviceTest() {
        System.out.println();
    }
}
