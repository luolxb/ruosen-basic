package ruosen.basic.ruosenbasic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ruosen.basic.ruosenbasic.dao.SysRoleUserMapper;
import ruosen.basic.ruosenbasic.model.po.SysRoleUser;
import ruosen.basic.ruosenbasic.model.vo.SysRoleUserVo;
import ruosen.basic.ruosenbasic.service.SysRoleUserService;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysRoleUserServiceImpl   
 *  * @package    ruosen.basic.ruosenbasic.service.impl  
 *  * @author Administrator     
 *  * @date   2019/11/28 0028 Thursday
 *  * @version V1.0.0
 *  
 */
@Service
@Slf4j
public class SysRoleUserServiceImpl extends ServiceImpl<SysRoleUserMapper, SysRoleUser> implements SysRoleUserService {

    @Override
    public SysRoleUserVo getRoleUserByUserId(long userId) {
        SysRoleUserVo sysRoleUserVo = new SysRoleUserVo();
        SysRoleUser sysRoleUser = this.getOne(new QueryWrapper<SysRoleUser>().eq("USER_ID", userId));
        BeanUtils.copyProperties(sysRoleUser, sysRoleUserVo);
        return sysRoleUserVo;
    }
}
