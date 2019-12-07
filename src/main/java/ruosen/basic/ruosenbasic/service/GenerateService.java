package ruosen.basic.ruosenbasic.service;

import ruosen.basic.ruosenbasic.dto.BeanField;
import ruosen.basic.ruosenbasic.dto.GenerateInput;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     GenerateService   
 *  * @package    ruosen.basic.ruosenbasic.service  
 *  * @author Administrator     
 *  * @date   2019/12/7 0007 星期六
 *  * @version V1.0.0
 *  
 */
public interface GenerateService {


    /**
     * 获取数据库表信息
     *
     * @param tableName
     * @return
     */
    List<BeanField> listBeanField(String tableName);

    /**
     * 转成驼峰并大写第一个字母
     *
     * @param string
     * @return
     */
    String upperFirstChar(String string);

    /**
     * 生成代码
     *
     * @param input
     */
    void saveCode(GenerateInput input);
}
