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
import org.springframework.util.CollectionUtils;
import ruosen.basic.ruosenbasic.dao.SysRoleMapper;
import ruosen.basic.ruosenbasic.model.basic.PageInfo;
import ruosen.basic.ruosenbasic.model.po.SysRole;
import ruosen.basic.ruosenbasic.model.po.SysRolePermission;
import ruosen.basic.ruosenbasic.model.po.SysRoleUser;
import ruosen.basic.ruosenbasic.model.vo.SysRoleRq;
import ruosen.basic.ruosenbasic.model.vo.SysRoleVo;
import ruosen.basic.ruosenbasic.service.SysRolePermissionService;
import ruosen.basic.ruosenbasic.service.SysRoleService;
import ruosen.basic.ruosenbasic.service.SysRoleUserService;

import java.util.Date;
import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysRoleServiceImpl   
 *  * @package    ruosen.basic.ruosenbasic.service.impl  
 *  * @author Administrator     
 *  * @date   2019/11/27 0027 Wednesday
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {


    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Autowired
    private SysRoleUserService sysRoleUserService;

    @Override
    public List<SysRole> getall() {
        return this.list();
    }

    @Override
    public IPage<SysRole> getPage(SysRoleRq sysRoleRq, PageInfo pageInfo) {
        QueryWrapper<SysRole> roleQueryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(sysRoleRq.getName())) {
            roleQueryWrapper.like("name", sysRoleRq.getName());
        }
        return this.page(pageInfo.getPage(), roleQueryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysRoleRq sysRoleRq) {
        SysRole sysRole = new SysRole();
        sysRole.setCreateTime(new Date());
        sysRole.setUpdateTime(new Date());
        BeanUtils.copyProperties(sysRoleRq, sysRole);
        // 新增角色 获取返回id
        this.save(sysRole);
        // 新增角色权限关联
        addPermission(sysRoleRq.getPermissionIds(), sysRole.getId());
    }

    /**
     * 新增角色权限关联
     *
     * @param permissionIds
     * @param sysRoleId
     */
    private void addPermission(List<Long> permissionIds, Long sysRoleId) {
        permissionIds.forEach(permissionId -> {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setRoleId(sysRoleId);
            sysRolePermission.setPermissionId(permissionId);
            sysRolePermissionService.save(sysRolePermission);
        });
    }

    @Override
    @Transactional(readOnly = true)
    public SysRoleVo detail(Long id) {
        SysRole sysRole = this.getOne(new QueryWrapper<SysRole>().eq("ID", id));
        SysRoleVo sysRoleVo = new SysRoleVo();
        BeanUtils.copyProperties(sysRole, sysRoleVo);
        return sysRoleVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(SysRoleVo sysRoleVo) {
        // 根据角色ID删除角色权限关联
        sysRolePermissionService.remove(new QueryWrapper<SysRolePermission>().eq("role_id", sysRoleVo.getId()));
        // 新增角色权限关联
        addPermission(sysRoleVo.getPermissionIds(), sysRoleVo.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {

        List<SysRoleUser> sysRoleUsers = sysRoleUserService.list(new QueryWrapper<SysRoleUser>().in("role_id", ids));
        if (!CollectionUtils.isEmpty(sysRoleUsers)) {
            throw new RuntimeException("角色被用户使用中");
        }
        // 删除角色
        this.removeByIds(ids);
        // 删除角色关联
        sysRolePermissionService.remove(new QueryWrapper<SysRolePermission>().in("role_id", ids));

    }
}
