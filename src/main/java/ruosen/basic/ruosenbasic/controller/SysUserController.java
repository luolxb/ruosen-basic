package ruosen.basic.ruosenbasic.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ruosen.basic.ruosenbasic.model.basic.PageInfo;
import ruosen.basic.ruosenbasic.model.basic.ResponseDataXAdmin;
import ruosen.basic.ruosenbasic.model.po.SysUser;
import ruosen.basic.ruosenbasic.model.vo.SysUserRq;
import ruosen.basic.ruosenbasic.model.vo.SysUserVo;
import ruosen.basic.ruosenbasic.service.SysUserService;

import javax.validation.Valid;
import java.util.List;

/**
 *  
 *  * @projectName ruosen-basic
 *  * @title     SysUserController   
 *  * @package    ruosen.basic.ruosenbasic.controller  
 *  * @author Administrator     
 *  * @date   2019/11/24 0024 星期日
 *  * @version V1.0.0
 *  
 */
@RestController
@Api(tags = "系统用户")
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @ApiOperation(value = "获取全部用户", notes = "获取全部用户")
    @PostMapping("/userList")
    public ResponseDataXAdmin<SysUser> userPage(@RequestBody(required = false) SysUserRq sysUserRq,
                                                PageInfo pageInfo) {
        IPage<SysUser> page = sysUserService.userPage(sysUserRq, pageInfo);
        return new ResponseDataXAdmin<SysUser>().page(page);
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping(value = "/userAdd")
    public ResponseDataXAdmin add(@Valid @RequestBody SysUserRq sysUserRq,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseDataXAdmin().error(result.getFieldError().getDefaultMessage());
        }
        sysUserService.add(sysUserRq);
        return new ResponseDataXAdmin().ok();
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping("/delete")
    public ResponseDataXAdmin delete(@RequestBody List<Long> ids) {
        sysUserService.delete(ids);
        return new ResponseDataXAdmin().ok();
    }

    @ApiOperation(value = "获取用户详情", notes = "获取用户详情")
    @GetMapping("/detail/{id}")
    public ResponseDataXAdmin detail(@PathVariable long id) {
        SysUserRq detail = sysUserService.detail(id);
        return new ResponseDataXAdmin().ok("成功", detail);
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PostMapping("/userEdit")
    public ResponseDataXAdmin edit(@Valid @RequestBody SysUserVo sysUserVo,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseDataXAdmin().error(result.getFieldError().getDefaultMessage());
        }
        sysUserService.edit(sysUserVo);
        return new ResponseDataXAdmin().ok("成功");
    }
}
