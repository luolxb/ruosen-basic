package ruosen.basic.ruosenbasic.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import ruosen.basic.ruosenbasic.model.basic.BasePo;

/**
 * @author Administrator
 */
@Data
@ApiModel(description = "系统角色")
public class SysRole extends BasePo {

    private static final long serialVersionUID = -8585569192803572495L;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String description;


}
