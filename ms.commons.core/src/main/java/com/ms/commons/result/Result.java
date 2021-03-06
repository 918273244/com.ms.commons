/*
 * Copyright 2011-2016 ZXC.com All right reserved. This software is the confidential and proprietary information of
 * ZXC.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with ZXC.com.
 */
package com.ms.commons.result;

import org.apache.commons.lang.StringUtils;

/**
 * @author zxc Apr 12, 2013 1:37:11 PM
 */
public class Result implements IResult {

    private boolean       isSuccess;
    private StringBuilder message = new StringBuilder();
    private Object        data;

    public static Result success() {
        return new Result().setSuccess(true);
    }

    public static Result success(String message) {
        return new Result().setSuccess(true).setMessage(message);
    }

    public static Result success(Object data) {
        return new Result().setSuccess(true).setData(data);
    }

    public static Result success(String message, Object data) {
        return new Result().setSuccess(true).setMessage(message).setData(data);
    }

    public static Result failed() {
        return new Result().setSuccess(false).setMessage("失败");
    }

    public static Result failed(String msg) {
        return new Result().setSuccess(false).setMessage(msg);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFailed() {
        return !isSuccess();
    }

    public Result setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public String getMessage() {
        return message.toString();
    }

    public Result setMessage(String message) {
        if (StringUtils.isNotBlank(message)) {
            this.message = new StringBuilder(message);
        } else {
            this.message = new StringBuilder();// 清空
        }
        return this;
    }

    public Result appendMessage(String message) {
        this.message.append(message).append(";");
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
