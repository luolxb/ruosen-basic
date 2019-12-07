package ruosen.basic.ruosenbasic.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *  系统用户
 *  * @projectName ruosen-basic
 *  * @title     SysUserRq   
 *  * @package    uosen.basic.ruosenbasic.model.vo  
 *  * @author Administrator     
 *  * @date   2019/11/24 0024 星期日
 *  * @version V1.0.0
 *  
 */
@Data
@ApiModel(description = "系统用户")
public class SysUserRq {

    private long id;

    @NotNull(message = "用户名称不能为空")
    @ApiModelProperty(value = "用户名称")
    private String userName;

    @JsonInclude
    @ApiModelProperty(value = "用户密码")
    private String password;

    @NotNull(message = "用户昵称不能为空")
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String headImgUrl;

    @NotNull(message = "用户电话不能为空")
    @ApiModelProperty(value = "用户电话")
    private String phone;

    @NotNull(message = "用户电话不能为空")
    @ApiModelProperty(value = "用户电话")
    private String telePhone;

    @NotNull(message = "用户邮箱不能为空")
    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @NotNull(message = "用户性别不能为空")
    @ApiModelProperty(value = "用户性别")
    private Integer sex;

    @ApiModelProperty(value = "用户状态")
    private Integer status;

    @NotNull(message = "角色ID不能为空")
    @ApiModelProperty(value = "角色ID")
    private long roleId;

    @ApiModelProperty(value = "用户生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start;

    @ApiModelProperty(value = "用户生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end;
}
