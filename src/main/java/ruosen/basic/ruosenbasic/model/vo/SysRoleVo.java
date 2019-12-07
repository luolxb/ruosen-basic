package ruosen.basic.ruosenbasic.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Administrator
 */
@Data
@ApiModel(description = "系统角色")
public class SysRoleVo {

    private static final long serialVersionUID = -8585569192803572495L;

    private long id;

    @NotNull(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String description;

    private List<Long> permissionIds;

}
