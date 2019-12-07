package ruosen.basic.ruosenbasic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ruosen.basic.ruosenbasic.model.po.SysPermission;
import ruosen.basic.ruosenbasic.model.vo.SysPermissionRq;
import ruosen.basic.ruosenbasic.model.vo.SysPermissionVo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysPermissionService   
 *  * @package    ruosen.basic.ruosenbasic.service  
 *  * @author Administrator     
 *  * @date   2019/12/1 0001 Sunday
 *  * @version V1.0.0
 *  
 */
public interface SysPermissionService extends IService<SysPermission> {


    List<SysPermissionVo> tree();

    List<SysPermission> getPermissionByRoleId(Long roleId);

    List<SysPermission> menuAll();

    void add(SysPermissionRq sysPermissionRq);

    void delete(Long id);

    SysPermissionVo detail(Long id);

    void edit(SysPermissionVo sysPermissionVo);

    List<SysPermissionVo> menu();
}
