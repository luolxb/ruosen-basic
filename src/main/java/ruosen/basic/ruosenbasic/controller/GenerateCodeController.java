package ruosen.basic.ruosenbasic.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ruosen.basic.ruosenbasic.dto.BeanField;
import ruosen.basic.ruosenbasic.dto.GenerateDetail;
import ruosen.basic.ruosenbasic.dto.GenerateInput;
import ruosen.basic.ruosenbasic.model.basic.ResponseDataXAdmin;
import ruosen.basic.ruosenbasic.service.GenerateService;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     GenerateCodeController   
 *  * @package    ruosen.basic.ruosenbasic.controller  
 *  * @author Administrator     
 *  * @date   2019/12/7 0007 星期六
 *  * @version V1.0.0
 *  
 */
@RequestMapping("/generate")
@RestController
@Slf4j
public class GenerateCodeController {

    @Autowired
    private GenerateService generateService;

    @GetMapping("/view")
    public ResponseDataXAdmin view(@RequestParam String tableName ){
        GenerateDetail detail = new GenerateDetail();
        detail.setBeanName(generateService.upperFirstChar(tableName));
        List<BeanField> fields = generateService.listBeanField(tableName);
        detail.setFields(fields);
        return new ResponseDataXAdmin().ok(detail);
    }

    @ApiOperation("生成代码")
    @PostMapping(value = "/save")
    public void save(@RequestBody GenerateInput input) {
        generateService.saveCode(input);
    }
}
