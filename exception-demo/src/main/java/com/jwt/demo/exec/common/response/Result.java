package com.jwt.demo.exec.common.response;

import com.jwt.demo.exec.common.enumeration.BusinessErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 封装返回实体
 * @author Modi Cheung
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String msg;

    /**
     * 成功数据
     */
    private T data;

    /**
     * 服务器当前时间戳
     */
    private Long ts = System.currentTimeMillis();

    public Result() {
    }

    public Result(String code, String msg, T data, Long ts) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.ts = ts;
    }

    /**
     * 成功
     * @return
     */
    public static Result ofSuccess() {
        Result result = new Result();
        result.code = "0000";
        return result;
    }

    /**
     * 成功：返回msg
     * @param msg
     * @return
     */
    public static Result ofSuccess(String msg) {
        Result result = new Result();
        result.code = "0000";
        result.msg = msg;
        return result;
    }

    public static <T> Result ofSuccess(T data) {
        Result result = new Result();
        result.data = data;
        return result;
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static Result ofFail(String code, String msg) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }

    /**
     * 失败：返回数据
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result ofFail(String code, String msg, T data) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        result.data = data;
        return result;
    }

    /**
     * 失败，从枚举中返回code和msg
     * @param errorCodeEnum
     * @return
     */
    public static Result ofFail(BusinessErrorCode errorCodeEnum) {
        Result result = new Result();
        result.code = errorCodeEnum.getErrorcode();
        result.msg = errorCodeEnum.getErrormsg();
        return result;
    }
}
