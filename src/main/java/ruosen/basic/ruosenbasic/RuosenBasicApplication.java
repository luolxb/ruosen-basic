package ruosen.basic.ruosenbasic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     RuosenBasicApplication   
 *  * @package    ruosen.basic.ruosenbasic.RuosenBasicApplication  
 *  * @author Administrator     
 *  * @date   2019/11/24 0024 星期日
 *  * @version V1.0.0
 *  
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("ruosen.basic.ruosenbasic.dao")
public class RuosenBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuosenBasicApplication.class, args);
    }

}
