package com.person.master.vo;

import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class AddEducationVo {

    @NotNull
    private String name;
    @NotNull
    private String sex;
    @NotNull
    private String school;
    private String major;
    @NotNull
    private String education_category;
    @NotNull
    private String educational_system;
    @NotNull
    private String level;
    @NotNull
    private String graduate;
    private String modality;
    private String schoolmaster;
    private String certificate;
    private String start_time;
    private String end_time;
    private String birthday;
    private String nation;
    private String college;
}
