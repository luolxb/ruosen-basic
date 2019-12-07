package ruosen.basic.ruosenbasic.model.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户角色关联")
public class SysRoleUser {

    @ApiModelProperty(value = "用户ID")
    private long userId;

    @ApiModelProperty(value = "角色ID")
    private long roleId;

}
