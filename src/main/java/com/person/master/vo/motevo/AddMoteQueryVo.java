package com.person.master.vo.motevo;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class AddMoteQueryVo {

    @NotNull(message ="title不能为空")
    private String title;

    @NotNull(message = "content不能为空")
    private String content;

    @NotNull(message = "user_id不能为空")
    @Positive(message = "user_id必须为正整数")
    private int user_id;

    @NotNull(message = "type不能为空")
    @Positive(message = "type必须为正整数")
    private int type;
}
