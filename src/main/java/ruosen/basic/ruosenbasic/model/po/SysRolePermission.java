package ruosen.basic.ruosenbasic.model.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class SysRolePermission {

    @ApiModelProperty(value = "角色ID")
    private long roleId;

    @ApiModelProperty(value = "权限ID")
    private long permissionId;


}
