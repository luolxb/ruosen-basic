package ruosen.basic.ruosenbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruosen.basic.ruosenbasic.model.basic.ResponseDataXAdmin;
import ruosen.basic.ruosenbasic.model.vo.SysRoleUserVo;
import ruosen.basic.ruosenbasic.service.SysRoleUserService;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysUserRoleController   
 *  * @package    ruosen.basic.ruosenbasic.controller  
 *  * @author Administrator     
 *  * @date   2019/11/28 0028 Thursday
 *  * @version V1.0.0
 *  
 */
@RestController
@RequestMapping("roleuser")
public class SysUserRoleController {

    @Autowired
    private SysRoleUserService sysRoleUserService;

    @PostMapping("/getRoleUserByUserId")
    public ResponseDataXAdmin getRoleUserByUserId(@RequestBody Long userId) {
        SysRoleUserVo sysRoleUserVo = sysRoleUserService.getRoleUserByUserId(userId);
        return new ResponseDataXAdmin().ok("获取成功", sysRoleUserVo);
    }
}
