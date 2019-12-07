package ruosen.basic.ruosenbasic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruosen.basic.ruosenbasic.dao.SysRoleUserMapper;
import ruosen.basic.ruosenbasic.dao.SysUserMapper;
import ruosen.basic.ruosenbasic.model.basic.PageInfo;
import ruosen.basic.ruosenbasic.model.po.SysRoleUser;
import ruosen.basic.ruosenbasic.model.po.SysUser;
import ruosen.basic.ruosenbasic.model.vo.SysUserRq;
import ruosen.basic.ruosenbasic.model.vo.SysUserVo;
import ruosen.basic.ruosenbasic.service.SysUserService;
import ruosen.basic.ruosenbasic.utils.MD5;

import java.util.Date;
import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysUserServiceImpl   
 *  * @package    ruosen.basic.ruosenbasic.service.impl  
 *  * @author Administrator     
 *  * @date   2019/11/24 0024 星期日
 *  * @version V1.0.0
 *  
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    @Transactional(readOnly = true)
    public IPage<SysUser> userPage(SysUserRq sysUserRq, PageInfo pageInfo) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("CREATE_TIME");
        if (StringUtils.isNotBlank(sysUserRq.getUserName())) {
            wrapper
                    .and(w -> w
                            .like("USER_NAME", sysUserRq.getUserName())
                            .or()
                            .like("NICK_NAME", sysUserRq.getUserName()));
        }
        if (sysUserRq.getStart() != null) {
            wrapper.ge("BIRTH_DAY", sysUserRq.getStart());
        }
        if (sysUserRq.getEnd() != null) {
            wrapper.le("BIRTH_DAY", sysUserRq.getEnd());
        }
        return this.baseMapper.selectPage(pageInfo.getPage(), wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysUserRq sysUserRq) {
        // 保存user
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserRq, sysUser);
        sysUser.setPassword(MD5.crypt(sysUser.getPassword()));
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        this.baseMapper.insert(sysUser);

        // 保存roleuser
        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setRoleId(sysUserRq.getRoleId());
        sysRoleUser.setUserId(sysUser.getId());
        sysRoleUserMapper.insert(sysRoleUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        ids.forEach(id -> {
            QueryWrapper<SysRoleUser> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("USER_ID", id);
            sysRoleUserMapper.delete(userQueryWrapper);
            this.removeById(id);
        });
    }

    @Override
    @Transactional(readOnly = true)
    public SysUserRq detail(Long id) {
        SysUser sysUser = this.getById(id);
        SysUserRq sysUserRq = new SysUserRq();
        BeanUtils.copyProperties(sysUser, sysUserRq);
        // 获取角色ID
        SysRoleUser sysRoleUser = sysRoleUserMapper.selectOne(new QueryWrapper<SysRoleUser>().eq("USER_ID", sysUserRq.getId()));
        sysUserRq.setRoleId(sysRoleUser == null ? null : sysRoleUser.getRoleId());
        return sysUserRq;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(SysUserVo sysUserVo) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserVo, sysUser);
        this.updateById(sysUser);

        //
        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setRoleId(sysUserVo.getRoleId());
        sysRoleUser.setUserId(sysUser.getId());
        sysRoleUserMapper.update(sysRoleUser, new QueryWrapper<SysRoleUser>().eq("USER_ID", sysUser.getId()));
    }
}
