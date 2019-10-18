package com.person.master.vo.motevo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class DelMemoQueryVo {

    @NotNull(message = "user_id不能为空")
    @Positive(message = "user_id必须为正整数")
    private int user_id;

    @NotNull(message = "id不能为空")
    @Positive(message = "id必须为正整数")
    private int id;
}
