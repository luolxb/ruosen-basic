package ruosen.basic.ruosenbasic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ruosen.basic.ruosenbasic.dao.SysRolePermissionMapper;
import ruosen.basic.ruosenbasic.model.po.SysRolePermission;
import ruosen.basic.ruosenbasic.service.SysRolePermissionService;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysRolePermissionServiceImpl   
 *  * @package    ruosen.basic.ruosenbasic.service.impl  
 *  * @author Administrator     
 *  * @date   2019/12/3 0003 Tuesday
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission>
        implements SysRolePermissionService {
}
