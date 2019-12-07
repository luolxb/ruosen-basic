package ruosen.basic.ruosenbasic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ruosen.basic.ruosenbasic.model.basic.ResponseDataXAdmin;
import ruosen.basic.ruosenbasic.model.po.SysPermission;
import ruosen.basic.ruosenbasic.model.vo.SysPermissionRq;
import ruosen.basic.ruosenbasic.model.vo.SysPermissionVo;
import ruosen.basic.ruosenbasic.service.SysPermissionService;

import javax.validation.Valid;
import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysPermissionController   
 *  * @package    ruosen.basic.ruosenbasic.controller  
 *  * @author Administrator     
 *  * @date   2019/12/1 0001 Sunday
 *  * @version V1.0.0
 *  
 */
@RestController
@Slf4j
@RequestMapping("/permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("/tree")
    public ResponseDataXAdmin tree() {
        List<SysPermissionVo> sysPermissionVoList = sysPermissionService.tree();
        return new ResponseDataXAdmin().ok(sysPermissionVoList);
    }

    @GetMapping("/getPermissionByRoleId")
    public ResponseDataXAdmin getPermissionByRoleId(@RequestParam Long roleId) {
        List<SysPermission> sysPermissionList = sysPermissionService.getPermissionByRoleId(roleId);
        return new ResponseDataXAdmin().ok(sysPermissionList);
    }

    @GetMapping("/menuAll")
    public ResponseDataXAdmin menuAll() {
        List<SysPermission> sysPermissionList = sysPermissionService.menuAll();
        return new ResponseDataXAdmin().ok(sysPermissionList);
    }

    @PostMapping("/add")
    public ResponseDataXAdmin add(@Valid @RequestBody SysPermissionRq sysPermissionRq,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseDataXAdmin().error(bindingResult.getFieldError().getDefaultMessage());
        }
        sysPermissionService.add(sysPermissionRq);
        return new ResponseDataXAdmin().ok();
    }

    @PostMapping("/edit")
    public ResponseDataXAdmin edit(@Valid @RequestBody SysPermissionVo sysPermissionVo,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseDataXAdmin().error(bindingResult.getFieldError().getDefaultMessage());
        }
        sysPermissionService.edit(sysPermissionVo);
        return new ResponseDataXAdmin().ok();
    }

    @DeleteMapping("/delete")
    public ResponseDataXAdmin delete(@RequestBody Long id) {
        sysPermissionService.delete(id);
        return new ResponseDataXAdmin().ok();
    }

    @GetMapping("/menu")
    public ResponseDataXAdmin menu() {
        List<SysPermissionVo> sysPermissionVoList = sysPermissionService.menu();
        return new ResponseDataXAdmin().ok(sysPermissionVoList);
    }
}
