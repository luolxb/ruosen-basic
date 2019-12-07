package ruosen.basic.ruosenbasic.model.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 *  公共属性抽取
 *  * @projectName ruosen-basic
 *  * @title     BasicPo   
 *  * @package    ruosen.basic.ruosenbasic.model.basic  
 *  * @author Administrator     
 *  * @date   2019/11/24 0024 星期日
 *  * @version V1.0.0
 *  
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
@ApiModel(description = "公共属性抽取 实体类")
public class BasePo implements Serializable {

    private static final long serialVersionUID = 2028505817035034088L;

    @ApiModelProperty(value = "ID")
    private long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}
