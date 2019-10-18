package com.person.master.vo.page;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class PageParam {

    /**
     * 页码
     */
    @NotNull(message = "分页: 当前页数不能为空")
    @Positive(message = "页码只能输入正整数")
    Integer page;

    /**
     * 每页条数
     */
    @NotNull(message = "分页: 每页条数不能为空")
    @Positive(message = "每页条数只能输入正整数")
    Integer rows;

}
