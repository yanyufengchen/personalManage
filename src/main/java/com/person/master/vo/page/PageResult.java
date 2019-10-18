package com.person.master.vo.page;

import lombok.Data;

import java.util.List;

/**
 * 分页请求返回值
 */

@Data
public class PageResult<T> {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 列表内容
     */
    private List<T> data;

    public PageResult(Long total, List<T> content) {
        this.total = total;
        this.data = content;
    }
}
