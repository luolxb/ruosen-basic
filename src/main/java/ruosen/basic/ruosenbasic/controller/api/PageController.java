package ruosen.basic.ruosenbasic.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ruosen.basic.ruosenbasic.model.vo.SysPermissionVo;
import ruosen.basic.ruosenbasic.model.vo.SysRoleVo;
import ruosen.basic.ruosenbasic.model.vo.SysUserRq;
import ruosen.basic.ruosenbasic.model.vo.SysUserVo;
import ruosen.basic.ruosenbasic.service.SysPermissionService;
import ruosen.basic.ruosenbasic.service.SysRoleService;
import ruosen.basic.ruosenbasic.service.SysUserService;

/**
 *  页面跳转路由
 *  * @projectName ruosen-basic
 *  * @title     ApiController   
 *  * @package    ruosen.basic.ruosenbasic.controller  
 *  * @author Administrator     
 *  * @date   2019/11/26 0026 Tuesday
 *  * @version V1.0.0
 *  
 */
@Controller
@RequestMapping("${api-url}")
@Slf4j
public class PageController {

    @Autowired
    private GenericApplicationContext genericApplicationContext;

    @GetMapping("/{url}")
    public String url(@PathVariable String url) {
        log.info("url==>{}", url);
        return url;
    }

    @GetMapping("/{parent}/{url}")
    public String getDetailUrl(@PathVariable String url,
                               @PathVariable String parent,
                               @RequestParam(required = false) Long id,
                               Model model) {

        try {
            detail(id, model, parent);
        } catch (Exception e) {
            log.error("反射异常==>", e);
        }
        log.info("parent==>{},url==>{}", parent, url);
        return parent + "/" + url;
    }

    private void detail(Long id, Model model, String parent) {
        String sysNameService = "sys" + parent.substring(0, 1).toUpperCase() + parent.substring(1) + "ServiceImpl";
        log.info("id==>{},sysNameService ==>{}", id, sysNameService);
        if (null != id && id != 0) {
            if (parent.startsWith("user")) {
                SysUserService sysUserService = (SysUserService) genericApplicationContext.getBean(sysNameService);
                SysUserRq detail = sysUserService.detail(id);
                SysUserVo sysUserVo = new SysUserVo();
                BeanUtils.copyProperties(detail, sysUserVo);
                log.info("sysUserVo==> {}", sysUserVo);
                model.addAttribute(sysUserVo);
            } else if (parent.startsWith("role")) {
                SysRoleService sysRoleService = (SysRoleService) genericApplicationContext.getBean(sysNameService);
                SysRoleVo detail = sysRoleService.detail(id);
                model.addAttribute(detail);
            } else if (parent.startsWith("permission")) {
                SysPermissionService sysPermissionService = (SysPermissionService) genericApplicationContext.getBean(sysNameService);
                SysPermissionVo detail = sysPermissionService.detail(id);
                model.addAttribute(detail);
            }
        }
    }
}
