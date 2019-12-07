package ruosen.basic.ruosenbasic.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ruosen.basic.ruosenbasic.model.basic.PageInfo;
import ruosen.basic.ruosenbasic.model.basic.ResponseDataXAdmin;
import ruosen.basic.ruosenbasic.model.po.SysRole;
import ruosen.basic.ruosenbasic.model.vo.SysRoleRq;
import ruosen.basic.ruosenbasic.model.vo.SysRoleVo;
import ruosen.basic.ruosenbasic.service.SysRoleService;

import javax.validation.Valid;
import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysRoleController   
 *  * @package    ruosen.basic.ruosenbasic.controller  
 *  * @author Administrator     
 *  * @date   2019/11/27 0027 Wednesday
 *  * @version V1.0.0
 *  
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/all")
    public ResponseDataXAdmin all() {
        List<SysRole> roleList = sysRoleService.getall();
        return new ResponseDataXAdmin<SysRole>().ok(roleList);
    }

    @ApiOperation(value = "角色分页")
    @PostMapping("/page")
    public ResponseDataXAdmin page(@RequestBody(required = false) SysRoleRq sysRoleRq,
                                   PageInfo pageInfo) {
        IPage<SysRole> page = sysRoleService.getPage(sysRoleRq, pageInfo);
        return new ResponseDataXAdmin<SysRole>().page(page);
    }

    @PostMapping("/add")
    public ResponseDataXAdmin add(@Valid @RequestBody SysRoleRq sysRoleRq,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseDataXAdmin<>().error(bindingResult.getFieldError().getDefaultMessage());
        }
        sysRoleService.add(sysRoleRq);
        return new ResponseDataXAdmin<>().ok();
    }

    @PostMapping("/edit")
    public ResponseDataXAdmin edit(@Valid @RequestBody SysRoleVo sysRoleVo,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseDataXAdmin<>().error(bindingResult.getFieldError().getDefaultMessage());
        }
        sysRoleService.edit(sysRoleVo);
        return new ResponseDataXAdmin<>().ok();
    }

    @DeleteMapping("/delete")
    public ResponseDataXAdmin delete(@RequestBody List<Long> ids) {
        try {
            sysRoleService.delete(ids);
        } catch (Exception e) {
            return new ResponseDataXAdmin<>().error(e.getMessage());
        }
        return new ResponseDataXAdmin<>().ok();
    }
}
