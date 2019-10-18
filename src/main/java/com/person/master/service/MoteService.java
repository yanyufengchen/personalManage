package com.person.master.service;

import com.person.master.dto.bak.MoteDto;
import com.person.master.vo.motevo.MoteQueryVo;
import com.person.master.vo.page.PageResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jjma
 * @Date Created in 2019/10/16.
 */
public interface MoteService {

    /**
     * 查询用户下所有类型事项
     * @param moteQueryVo
     * @return
     */
    PageResult getAllTypeMemo(MoteQueryVo moteQueryVo);

    /**
     * 内部接口：根据id查询事项
     * @param id
     * @param user_id
     * @return
     */
    List<MoteDto> getMemoById(int user_id,int id);

    /**
     * 根据备份id删除指定事项
     * @param id
     * @param user_id m
     */
    void delNoteById(int id,int user_id);

    /**
     * 添加事项
     * @param title
     * @param content
     * @param user_id
     * @param type
     */
    void addMote(String title,String content,int user_id,int type);

    /**
     * 编辑事项
     * @param title
     * @param content
     * @param id
     * @param type
     */
    void ediMote(String title,String content,int type,int id,int user_id);

    /**
     * 更新事物类型:待办->已办
     * @param id
     * @param user_id
     */
    void updateUntreatToTreated(ArrayList id,int user_id);

    /**
     * 更新事物类型:已办->待办
     * @param id
     * @param user_id
     */
    void updateTreatedToUntreat(ArrayList id,int user_id);
}
