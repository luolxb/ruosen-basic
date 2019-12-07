package ruosen.basic.ruosenbasic.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import ruosen.basic.ruosenbasic.model.basic.BasePo;

@Data
@ApiModel(description = "系统权限")
public class SysPermission extends BasePo {

    @ApiModelProperty(value = "父级ID")
    private long parentId;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "css")
    private String css;

    @ApiModelProperty(value = "路径")
    private String href;

    @ApiModelProperty(value = "权限类型")
    private Integer type;

    @ApiModelProperty(value = "权限")
    private String permission;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
