package com.person.master.vo;

import com.person.master.vo.page.PageParam;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class DBBakQueryVo extends PageParam {

    /**
     * 数据库备份名
     */
    @Size(max = 255, message = "名称超过最大长度255个字符")
    private String  bak_name;

}
