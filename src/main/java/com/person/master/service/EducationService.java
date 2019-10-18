package com.person.master.service;

import com.person.master.dto.personmessage.EducationDto;
import com.person.master.vo.AddEducationVo;

import java.util.List;

/**
 * @Author jjma
 * @Date Created in 2019/09/18.
 */
public interface EducationService {

    /**
     * 获取所有学历信息
     * @return
     */
    List<EducationDto> getEduMessage();

    /**
     * 添加教育经历
     * @param addEducationVo
     */
    void addEducation(AddEducationVo addEducationVo);

    /**
     * 删除教育经历
     * @param id
     */
    void deleteEdu(Integer id);

    /**
     * 根据id获取教育信息
     * @param id
     * @return
     */
    List<EducationDto> getEduById(Integer id);

}
