package ruosen.basic.ruosenbasic.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import ruosen.basic.ruosenbasic.model.basic.BasePo;

import java.util.Date;

/**
 *  系统用户
 *  * @projectName ruosen-basic
 *  * @title     SysUser   
 *  * @package    uosen.basic.ruosenbasic.model.po  
 *  * @author Administrator     
 *  * @date   2019/11/24 0024 星期日
 *  * @version V1.0.0
 *  
 */
@Data
@ApiModel(description = "系统用户")
public class SysUser extends BasePo {

    private static final long serialVersionUID = 286484163248358848L;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String headImgUrl;

    @ApiModelProperty(value = "用户电话")
    private String phone;

    @ApiModelProperty(value = "用户电话")
    private String telePhone;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @ApiModelProperty(value = "用户性别")
    private Integer sex;

    @ApiModelProperty(value = "用户状态")
    private Integer status;

}
