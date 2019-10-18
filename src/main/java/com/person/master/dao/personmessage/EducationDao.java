package com.person.master.dao.personmessage;

import com.person.master.dto.personmessage.EducationDto;
import com.person.master.vo.AddEducationVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jjma
 * created 2019/09/18
 */

@Component
@Mapper
public interface EducationDao {

    /**
     * 获取所以学历信息
     * @return
     */
    @Select("select * from education")
    List<EducationDto> getEduMessage();

    /**
     * 添加教育经历
     * @param educationDto
     */
    @Options(useGeneratedKeys = true)
    @Insert("insert into education(name,sex,school,major,education_category,educational_system,level,graduate,"+
            "modality,schoolmaster,certificate,start_time,end_time,birthday,nation,college)"+
            "value(#{name},#{sex},#{school},#{major},#{education_category},#{educational_system},#{level},#{graduate},"+
            "#{modality},#{schoolmaster},#{certificate},#{start_time},#{end_time},#{birthday},#{nation},#{college})")
    void addEducation(EducationDto educationDto);

    /**
     * 删除教育经历
     * @param id
     */
    @Delete("delete from education where id = #{id}")
    void deleteEdu(@Param("id") Integer id);

    /**
     * 根据Id获取个人学历信息
     * @param id
     * @return
     */
    @Select("select * from education where id = #{id}")
    List<EducationDto> getEduById(@Param("id") Integer id);
}
