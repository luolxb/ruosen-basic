package ruosen.basic.ruosenbasic.model.basic;

import lombok.Data;
import ruosen.basic.ruosenbasic.model.enums.ResultInfoEnum;

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
public class ResponseData<T> {


    private Integer code;

    private String msg;

    private Object data;

    public ResponseData error() {
        ResponseData responseData = new ResponseData();
        responseData.setCode(ResultInfoEnum.ERROR_MSG.getCode());
        responseData.setMsg(ResultInfoEnum.ERROR_MSG.getMsg());
        responseData.setData(null);
        return responseData;
    }

    public ResponseData error(Integer code, String msg) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(code);
        responseData.setMsg(msg);
        responseData.setData(null);
        return responseData;
    }

    public ResponseData error(String msg) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(ResultInfoEnum.ERROR_MSG.getCode());
        responseData.setMsg(msg);
        responseData.setData(null);
        return responseData;
    }

    public ResponseData ok(Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(ResultInfoEnum.SUCCESS_MSG.getMsg());
        responseData.setData(data);
        return responseData;
    }

    public ResponseData ok(String msg) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(msg);
        responseData.setData(null);
        return responseData;
    }

    public ResponseData ok(String msg, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(msg);
        responseData.setData(data);
        return responseData;
    }

    public ResponseData ok() {
        ResponseData responseData = new ResponseData();
        responseData.setCode(ResultInfoEnum.SUCCESS_MSG.getCode());
        responseData.setMsg(ResultInfoEnum.SUCCESS_MSG.getMsg());
        responseData.setData(null);
        return responseData;
    }


}
