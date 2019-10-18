package com.person.master.vo.motevo;

import com.person.master.vo.page.PageParam;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class MoteQueryVo extends PageParam {

    /**
     * 使用者id
     */
    @NotNull(message = "id不能为空")
    @Positive(message = "id必须为正整数")
    private int user_id;

    /**
     * 类型
     */
    @NotNull(message = "id不能为空")
    @Positive(message = "id必须为正整数")
    private int type;
}
