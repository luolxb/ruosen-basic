package ruosen.basic.ruosenbasic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import ruosen.basic.ruosenbasic.model.basic.PageInfo;
import ruosen.basic.ruosenbasic.model.po.SysRole;
import ruosen.basic.ruosenbasic.model.vo.SysRoleRq;
import ruosen.basic.ruosenbasic.model.vo.SysRoleVo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysRoleService   
 *  * @package    ruosen.basic.ruosenbasic.service  
 *  * @author Administrator     
 *  * @date   2019/11/27 0027 Wednesday
 *  * @version V1.0.0
 *  
 */
public interface SysRoleService extends IService<SysRole> {
    List<SysRole> getall();

    IPage<SysRole> getPage(SysRoleRq sysRoleRq, PageInfo pageInfo);

    void add(SysRoleRq sysRoleRq);

    SysRoleVo detail(Long id);

    void edit(SysRoleVo sysRoleVo);

    void delete(List<Long> ids);
}
