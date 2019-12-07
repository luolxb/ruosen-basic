package ruosen.basic.ruosenbasic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import ruosen.basic.ruosenbasic.model.basic.PageInfo;
import ruosen.basic.ruosenbasic.model.po.SysUser;
import ruosen.basic.ruosenbasic.model.vo.SysUserRq;
import ruosen.basic.ruosenbasic.model.vo.SysUserVo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysUserService   
 *  * @package    ruosen.basic.ruosenbasic.service  
 *  * @author Administrator     
 *  * @date   2019/11/24 0024 星期日
 *  * @version V1.0.0
 *  
 */
public interface SysUserService extends IService<SysUser> {

    IPage<SysUser> userPage(SysUserRq sysUserRq, PageInfo pageInfo);

    void add(SysUserRq sysUserRq);

    void delete(List<Long> id);

    SysUserRq detail(Long id);

    void edit(SysUserVo sysUserVo);
}
