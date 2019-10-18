package com.person.master.vo.motevo;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;

@Data
public class UpdateMemoTypeVo {

    /**
     * id集合
     */
    @NotNull(message = "id集合不能为空")
    private ArrayList id;

    /**
     * 用户id
     */
    @NotNull(message = "user_id不能为空")
    @Positive(message = "user_id必须为正整数")
    private int user_id;

}
