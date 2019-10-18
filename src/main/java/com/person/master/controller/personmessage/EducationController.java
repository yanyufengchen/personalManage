package com.person.master.controller.personmessage;

import com.person.master.common.web.Result;
import com.person.master.service.EducationService;
import com.person.master.vo.AddEducationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.xml.ws.Response;

/**
 * @author jjma
 * Created by sang on 2019/8/14.
 */
@RestController
@RequestMapping("/api/v1/manage")
public class EducationController {

    @Autowired
    private EducationService educationService;

    /**
     * 获取所有教育经历
     * @return
     */
    @GetMapping(value = "/message")
    public ResponseEntity<Result> getEduMessage(){
        return ResponseEntity.ok(Result.success(educationService.getEduMessage()));
    }

    /**
     * 添加教育经历
     * @param addEducationVo
     * @return
     */
    @PostMapping(value = "/addEdu")
    public ResponseEntity<Result> addEducation(@RequestBody @Valid AddEducationVo addEducationVo){
        educationService.addEducation(addEducationVo);
        return ResponseEntity.ok(Result.success(null));
    }

    /**
     * 根据id删除个人教育经历
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteEdu")
    public ResponseEntity<Result> deleteEdu(@NotNull(message = "id不能为空") @Positive(message = "id必须为正整数") Integer id){
        educationService.deleteEdu(id);
        return ResponseEntity.ok(Result.success(null));
    }

    /**
     * 根据id获取教育经历详细信息
     * @param id
     * @return
     */
    @GetMapping(value ="/getEduById")
    public ResponseEntity<Result> getEduById(@NotNull(message = "id不能为空") @Positive(message = "id必须为正整数") Integer id){
        return ResponseEntity.ok(Result.success(educationService.getEduById(id)));
    }
}

