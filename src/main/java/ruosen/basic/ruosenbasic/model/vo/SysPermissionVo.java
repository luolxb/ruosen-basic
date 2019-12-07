package ruosen.basic.ruosenbasic.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(description = "系统权限")
public class SysPermissionVo {

    private static final long serialVersionUID = 3704651911143027290L;

    private long id;

    @NotNull(message = "父级ID不能为空")
    @ApiModelProperty(value = "父级ID")
    private long parentId;

    @NotNull(message = "权限名称不能为空")
    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "css")
    private String css;

    @NotNull(message = "路径不能为空")
    @ApiModelProperty(value = "路径")
    private String href;

    @NotNull(message = "权限类型不能为空")
    @ApiModelProperty(value = "权限类型")
    private Integer type;

    @ApiModelProperty(value = "权限")
    private String permission;

    @NotNull(message = "排序不能为空")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    private List<SysPermissionVo> child;

}
