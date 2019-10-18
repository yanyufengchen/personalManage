package com.person.master.controller.bak;

import com.person.master.common.web.Result;
import com.person.master.service.MoteService;
import com.person.master.vo.motevo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/v1/note")
public class MoteController {

    @Autowired
    private MoteService moteService;

    /**
     * 获取备忘事项
     * @param moteQueryVo
     * @return
     */
    @RequestMapping(value = "/getMemoList",method = RequestMethod.GET)
    public ResponseEntity<Result> getMemoList(@Valid MoteQueryVo moteQueryVo){
        return ResponseEntity.ok(Result.success(moteService.getAllTypeMemo(moteQueryVo)));
    }

    /**
     * 获取待办事项
     * @param moteQueryVo
     * @return
     */
    @RequestMapping(value = "/getUntreatList",method = RequestMethod.GET)
    public ResponseEntity<Result> getUntreatList(@Valid MoteQueryVo moteQueryVo){
        return ResponseEntity.ok(Result.success(moteService.getAllTypeMemo(moteQueryVo)));
    }

    /**
     * 获取已办事项
     * @param moteQueryVo
     * @return
     */
    @RequestMapping(value = "/getTreatedList",method = RequestMethod.GET)
    public ResponseEntity<Result> getTreatedList(@Valid MoteQueryVo moteQueryVo){
        return ResponseEntity.ok(Result.success(moteService.getAllTypeMemo(moteQueryVo)));
    }

    /**
     * 根据id获取事项
     * @param user_id
     * @param id
     * @return
     */
    @RequestMapping(value = "/getMemoById",method = RequestMethod.GET)
    public ResponseEntity<Result> getMemoById(@NotNull(message = "user_id不能为空")@Positive(message = "user_id只能为正整数")int user_id,
                                              @NotNull(message = "id不能为空")@Positive(message = "id只能为正整数") int id){
        return ResponseEntity.ok(Result.success(moteService.getMemoById(user_id,id)));
    }

    /**
     * 根据id删除事项
     * @param id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "/delNote",method = RequestMethod.DELETE)
    public ResponseEntity<Result> delMoteById(@NotNull(message = "user_id不能为空")@Positive(message = "user_id只能为正整数") int user_id,
                                              @NotNull(message = "id不能为空")@Positive(message = "id只能为正整数")int id){
        moteService.delNoteById(id,user_id);
        return ResponseEntity.ok(Result.success(null));
    }

    /**
     * 添加事项
     * @param adEtMoteQueryVo
     * @return
     */
    @RequestMapping(value = "/addMote",method = RequestMethod.POST)
    public ResponseEntity<Result> addMote(@RequestBody @Valid AddMoteQueryVo adEtMoteQueryVo){
        moteService.addMote(adEtMoteQueryVo.getTitle(),adEtMoteQueryVo.getContent(),adEtMoteQueryVo.getUser_id(),adEtMoteQueryVo.getType());
        return ResponseEntity.ok(Result.success(null));
    }

    /**
     * 编辑事项
     * @param editMoteQueryVo
     * @return
     */
    @RequestMapping(value = "/ediNote",method = RequestMethod.POST)
    public ResponseEntity<Result> ediNote(@RequestBody @Valid EditMoteQueryVo editMoteQueryVo){
        moteService.ediMote(editMoteQueryVo.getTitle(),editMoteQueryVo.getContent(),editMoteQueryVo.getType(),
                editMoteQueryVo.getId(),editMoteQueryVo.getUser_id());
        return ResponseEntity.ok(Result.success(null));
    }

    /**
     * 更新事项类型:待办-已办
     * @param updateMemoTypeVo
     * @return
     */
    @RequestMapping(value = "/updateUntreatToTreated",method = RequestMethod.POST)
    public ResponseEntity<Result> updateUntreatToTreated(@RequestBody @Valid UpdateMemoTypeVo updateMemoTypeVo){
        moteService.updateUntreatToTreated(updateMemoTypeVo.getId(),updateMemoTypeVo.getUser_id());
        return ResponseEntity.ok(Result.success(null));
    }

    /**
     * 更新事项类型:已办-待办
     * @param updateMemoTypeVo
     * @return
     */
    @RequestMapping(value = "/updateTreatedToUntreat",method = RequestMethod.POST)
    public ResponseEntity<Result> updateTreatedToUntreat(@RequestBody @Valid UpdateMemoTypeVo updateMemoTypeVo){
        moteService.updateTreatedToUntreat(updateMemoTypeVo.getId(),updateMemoTypeVo.getUser_id());
        return ResponseEntity.ok(Result.success(null));
    }

}
