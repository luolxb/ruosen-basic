package ruosen.basic.ruosenbasic.model.basic;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     PageInfo   
 *  * @package    ruosen.basic.ruosenbasic.model.basic  
 *  * @author Administrator     
 *  * @date   2019/11/26 0026 Tuesday
 *  * @version V1.0.0
 *  
 */
@Data
public class PageInfo<T> {

    private Integer page = 1;

    private Integer limit = 20;

    public Page<T> getPage() {
        return new Page<T>(page, limit);
    }

}
