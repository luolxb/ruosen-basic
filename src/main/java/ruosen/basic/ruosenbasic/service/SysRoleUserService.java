package ruosen.basic.ruosenbasic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ruosen.basic.ruosenbasic.model.po.SysRoleUser;
import ruosen.basic.ruosenbasic.model.vo.SysRoleUserVo;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysRoleUserService   
 *  * @package    ruosen.basic.ruosenbasic.service  
 *  * @author Administrator     
 *  * @date   2019/11/28 0028 Thursday
 *  * @version V1.0.0
 *  
 */
public interface SysRoleUserService extends IService<SysRoleUser> {

    SysRoleUserVo getRoleUserByUserId(long userId);
}
