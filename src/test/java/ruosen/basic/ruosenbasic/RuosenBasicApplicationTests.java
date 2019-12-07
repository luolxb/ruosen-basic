package ruosen.basic.ruosenbasic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RuosenBasicApplicationTests {

    @Test
    void contextLoads() {
        try {
            Object clzz = Class.forName("ruosen.basic.ruosenbasic.model.po.SysUser").newInstance();
            System.out.println(clzz);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
