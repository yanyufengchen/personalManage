package com.person.master.service.Impl;

import com.person.master.common.exception.InvalidParamException;
import com.person.master.conf.dozer.DozerConverter;
import com.person.master.dao.personmessage.EducationDao;
import com.person.master.dto.personmessage.EducationDto;
import com.person.master.service.EducationService;
import com.person.master.utils.DateFormatUtil;
import com.person.master.vo.AddEducationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jjma
 * @Date Created in 2019/09/18.
 */
@Slf4j
@Service
public class EducationImpl implements EducationService {

    @Autowired
    private EducationDao educationDao;

    @Autowired
    private DozerConverter dozerConverter;

    /**
     * 获取所有学历信息
     * @return
     */
    @Override
    public List<EducationDto> getEduMessage(){
        return educationDao.getEduMessage();
    }

    /**
     * 添加教育经历
     * @param addEducationVo
     */
    @Override
    public void addEducation(AddEducationVo addEducationVo){
        final EducationDto educationDto = dozerConverter.convert(addEducationVo, EducationDto.class);
        //更改时间格式
        try {
            educationDto.setStart_time(DateFormatUtil.dataFormat2(educationDto.getStart_time()));
            educationDto.setBirthday(DateFormatUtil.dataFormat2(educationDto.getBirthday()));
        }catch (Exception e){
            log.error("参数校验失败",e);
            throw new InvalidParamException("参数格式不正确");
        }
        //判断是否毕业,如未毕业，设置毕业时间和证书为空
        if(educationDto.getGraduate().contains("否")){
            educationDto.setEnd_time(null);
            educationDto.setCertificate(null);
        }else {
            try {
                educationDto.setEnd_time(DateFormatUtil.dataFormat2(educationDto.getEnd_time()));
            }catch (Exception e){
                log.error("参数校验失败",e);
                throw new InvalidParamException("参数格式不正确");
            }
        }
        educationDao.addEducation(educationDto);
    }

    /**
     * 删除个人学历信息
     * @param id
     */
    @Override
    public void deleteEdu(Integer id){
        List<EducationDto> list = educationDao.getEduById(id);
        if(list.size() > 0){
            educationDao.deleteEdu(id);
        }else{
            throw new InvalidParamException("学历Id不存在！");
        }
    }

    /**
     * 根据id获取教务经历信息
     * @param id
     * @return
     */
    @Override
    public List<EducationDto> getEduById(Integer id){
        List<EducationDto> list = educationDao.getEduById(id);
        if(list.size() > 0){
            return list;
        }else{
            throw new InvalidParamException("学历信息不存在！");
        }
    }
}
