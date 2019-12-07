package ruosen.basic.ruosenbasic.model.basic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import ruosen.basic.ruosenbasic.model.enums.ResultInfoEnum;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     ResponseData   
 *  * @package    com.ruosen.star.ruosenstar.model.po  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@Data
public class ResponseDataXAdmin<T> {


    private Integer code;

    private long count;

    private String msg;

    private Object data;

    public ResponseDataXAdmin error() {
        ResponseDataXAdmin responseData = new ResponseDataXAdmin();
        responseData.setCode(ResultInfoEnum.ERROR_MSG.getCode());
        responseData.setMsg(ResultInfoEnum.ERROR_MSG.getMsg());
        responseData.setData(null);
        return responseData;
    }

    public ResponseDataXAdmin error(Integer code, String msg) {
        ResponseDataXAdmin responseData = new ResponseDataXAdmin();
        responseData.setCode(code);
        responseData.setMsg(msg);
        responseData.setData(null);
        return responseData;
    }

    public ResponseDataXAdmin error(String msg) {
        ResponseDataXAdmin responseData = new ResponseDataXAdmin();
        responseData.setCode(ResultInfoEnum.ERROR_MSG.getCode());
        responseData.setMsg(msg);
        responseData.setData(null);
        return responseData;
    }

    public ResponseDataXAdmin ok(List<T> data) {
        ResponseDataXAdmin responseData = new ResponseDataXAdmin();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(ResultInfoEnum.SUCCESS_MSG.getMsg());
        responseData.setData(data);
        responseData.setCount(data.size());
        return responseData;
    }
    public ResponseDataXAdmin ok(T data) {
        ResponseDataXAdmin responseData = new ResponseDataXAdmin();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(ResultInfoEnum.SUCCESS_MSG.getMsg());
        responseData.setData(data);
        return responseData;
    }

    public ResponseDataXAdmin ok(String msg) {
        ResponseDataXAdmin responseData = new ResponseDataXAdmin();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(msg);
        responseData.setData(null);
        return responseData;
    }

    public ResponseDataXAdmin ok(String msg, Object data) {
        ResponseDataXAdmin responseData = new ResponseDataXAdmin();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(msg);
        responseData.setData(data);
        return responseData;
    }

    public ResponseDataXAdmin ok() {
        ResponseDataXAdmin responseData = new ResponseDataXAdmin();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(ResultInfoEnum.SUCCESS_MSG.getMsg());
        responseData.setData(null);
        return responseData;
    }

    public ResponseDataXAdmin page(IPage<T> page) {
        ResponseDataXAdmin responseData = new ResponseDataXAdmin();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(ResultInfoEnum.SUCCESS_MSG.getMsg());
        responseData.setData(page.getRecords());
        responseData.setCount(page.getTotal());
        return responseData;
    }


}
