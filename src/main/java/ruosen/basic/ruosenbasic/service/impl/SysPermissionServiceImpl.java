package ruosen.basic.ruosenbasic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import ruosen.basic.ruosenbasic.dao.SysPermissionMapper;
import ruosen.basic.ruosenbasic.model.po.SysPermission;
import ruosen.basic.ruosenbasic.model.po.SysRolePermission;
import ruosen.basic.ruosenbasic.model.po.SysRoleUser;
import ruosen.basic.ruosenbasic.model.vo.SysPermissionRq;
import ruosen.basic.ruosenbasic.model.vo.SysPermissionVo;
import ruosen.basic.ruosenbasic.service.SysPermissionService;
import ruosen.basic.ruosenbasic.service.SysRolePermissionService;
import ruosen.basic.ruosenbasic.service.SysRoleUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysPermissionImpl   
 *  * @package    ruosen.basic.ruosenbasic.service  
 *  * @author Administrator     
 *  * @date   2019/12/1 0001 Sunday
 *  * @version V1.0.0
 *  
 */
@Service
@Slf4j
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Autowired
    private SysRoleUserService sysRoleUserService;

    @Override
    public List<SysPermissionVo> tree() {
        List<SysPermission> sysPermissionList = this.list();
        return getSysPermissionVos(sysPermissionList);

    }

    private List<SysPermissionVo> getSysPermissionVos(List<SysPermission> sysPermissionList) {
        List<SysPermissionVo> permissionVos = new ArrayList<>();
        sysPermissionList.forEach(sysPermission -> {
            SysPermissionVo permissionVo = new SysPermissionVo();
            BeanUtils.copyProperties(sysPermission, permissionVo);
            permissionVos.add(permissionVo);
        });
        return setPermissionTree(permissionVos);
    }

    @Override
    public List<SysPermission> getPermissionByRoleId(Long roleId) {
        List<SysRolePermission> permissionList = sysRolePermissionService.list(new QueryWrapper<SysRolePermission>().eq("role_id", roleId));
        List<Long> longList = permissionList.stream().map(SysRolePermission::getPermissionId).collect(Collectors.toList());
        QueryWrapper<SysPermission> wrapper = new QueryWrapper<>();
        wrapper.in("id", longList);
        return this.list(wrapper);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysPermission> menuAll() {
        return this.list(new QueryWrapper<>());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysPermissionRq sysPermissionRq) {
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(sysPermissionRq, sysPermission);
        this.save(sysPermission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        QueryWrapper<SysPermission> wrapper = new QueryWrapper<>();
        wrapper.eq("ID", id).or();
        wrapper.eq("PARENT_ID", id);
        this.remove(wrapper);
    }

    @Override
    @Transactional(readOnly = true)
    public SysPermissionVo detail(Long id) {
        SysPermission sysPermission = this.getById(id);
        SysPermissionVo sysPermissionVo = new SysPermissionVo();
        BeanUtils.copyProperties(sysPermission, sysPermissionVo);
        return sysPermissionVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(SysPermissionVo sysPermissionVo) {
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(sysPermissionVo, sysPermission);
        this.updateById(sysPermission);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysPermissionVo> menu() {
        Long roleId = 60L;
        List<SysRoleUser> sysRoleUsers = sysRoleUserService.list(new QueryWrapper<SysRoleUser>().eq("user_id", roleId));
        List<Long> longList = sysRoleUsers.stream().map(SysRoleUser::getRoleId).collect(Collectors.toList());
        List<SysRolePermission> sysRolePermissionList = sysRolePermissionService.list(new QueryWrapper<SysRolePermission>().in("ROLE_ID", longList));
        List<Long> longList1 = sysRolePermissionList.stream().map(SysRolePermission::getPermissionId).collect(Collectors.toList());
        List<SysPermission> sysPermissionList = this.list(new QueryWrapper<SysPermission>().in("id", longList1).eq("type",1));
        return getSysPermissionVos(sysPermissionList);
    }

    private List<SysPermissionVo> setPermissionTree(List<SysPermissionVo> sysPermissionVoList) {
        List<SysPermissionVo> permissionVos = new ArrayList<>();
        // 一级菜单
        sysPermissionVoList.stream()
                .filter(sysPermissionVo -> sysPermissionVo.getParentId() == 0)
                .forEach(sysPermissionVo ->
                        permissionVos.add(sysPermissionVo)
                );
        // 二级菜单
        permissionVos.forEach(permissionVo ->
                permissionVo.setChild(getChild(permissionVo.getId(), sysPermissionVoList))
        );
        return permissionVos;
    }

    /**
     * 递归子菜单
     *
     * @param permissionVos
     * @param id
     * @return
     */
    private List<SysPermissionVo> getChild(long id, List<SysPermissionVo> permissionVos) {
        List<SysPermissionVo> childList = new ArrayList<>();
        permissionVos
                .stream()
                .filter(rootMenu ->
                        rootMenu.getParentId() == id)
                .forEach(rootMenu -> childList.add(rootMenu));

        childList.forEach(child ->
                permissionVos.forEach(rootMenu -> {
                    if (child.getId() == rootMenu.getParentId()) {
                        child.setChild(getChild(child.getId(), permissionVos));
                    }
                })
        );

        if (CollectionUtils.isEmpty(childList)) {
            return null;
        }
        return childList;
    }

}
