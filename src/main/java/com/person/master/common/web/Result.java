package com.person.master.common.web;

import com.person.master.common.errorcode.DefaultCode;
import lombok.Data;


import java.io.Serializable;

/**
 * 通用返回数据
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 是否成功（必填）
     */
    private boolean success;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息，默认为错误码描述
     */
    private String errorMessage;

    /**
     * 数据
     */
    private T data;

    private Result(Builder<T> builder) {
        this.success = builder.success;
        this.errorCode = builder.errorCode;
        this.errorMessage = builder.errorMessage;
        this.data = builder.data;
    }

    /**
     * 成功且设置data
     *
     * @param data 数据
     * @return result对象
     */
    public static Result success(Object data) {
        return new Result.Builder<>(true).data(data).build();
    }

    /**
     * 成功且设置data
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return result对象
     */
    public static Result failure(String errorCode, String errorMessage) {
        return new Builder<>(false)
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .build();
    }

    /**
     * 成功且设置data
     *
     * @param iError 错误信息
     * @return result对象
     */
    public static Result failure(IError iError) {
        return new Builder<>(false)
                .iError(iError)
                .build();
    }

    /**
     * 构建对象
     *
     * @param <T> 构建参数
     */
    @Data
    public static class Builder<T> {

        /**
         * 成功失败标识
         */
        private boolean success;

        /**
         * 错误码
         */
        private String errorCode;

        /**
         * 错误信息，默认为错误码描述
         */
        private String errorMessage;

        /**
         * 返回数据
         */
        private T data;

        public Builder(boolean success) {
            this.success = success;
            if (success) {
                this.errorCode = DefaultCode.SUCCESS;
            }
        }

        public Builder iError(IError iError) {
            this.errorCode = iError.getCode();
            this.errorMessage = iError.getError();
            return this;
        }

        public Builder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public Result build() {
            return new Result<>(this);
        }

    }
}
