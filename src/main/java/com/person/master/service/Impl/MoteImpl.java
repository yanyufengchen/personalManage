package com.person.master.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.person.master.common.exception.InvalidParamException;
import com.person.master.dao.UserDao;
import com.person.master.dao.bak.MoteDao;
import com.person.master.dto.UserDto;
import com.person.master.dto.bak.MoteDto;
import com.person.master.service.MoteService;
import com.person.master.vo.motevo.MoteQueryVo;
import com.person.master.vo.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoteImpl implements MoteService {

    @Autowired
    private MoteDao moteDao;

    @Autowired
    private UserDao userDao;

    private int treated = 2; //完成事项类型
    private int untreat = 1;    //待办事项类型

    /**
     * 获取用户全部备忘事项
     * @param moteQueryVo
     * @return
     */
    @Override
    public PageResult getAllTypeMemo(MoteQueryVo moteQueryVo){

        if (moteQueryVo.getRows() > 12) {
            moteQueryVo.setRows(12);
        } else if (moteQueryVo.getRows() < 1) {
            moteQueryVo.setRows(12);
        }
        PageHelper.startPage(moteQueryVo.getPage(), moteQueryVo.getRows());
        List<MoteDto> list = moteDao.getUntreat(moteQueryVo.getUser_id(),moteQueryVo.getType());
        return new PageResult<>(((Page) list).getTotal(), list);
    }

    /**
     * 根据id获取事项
     * @param user_id
     * @param id
     * @return
     */
    @Override
    public List<MoteDto> getMemoById(int user_id,int id){
        return moteDao.getUntreatById(user_id,id);
    }

    /**
     * 根据id删除指定备忘事项
     * @param id
     * @param user_id m
     */
    @Override
    public void delNoteById(int id,int user_id){
        UserDto userDto = userDao.selectUserById(user_id);
        if(userDto.getId() != user_id){
            throw new InvalidParamException("用户id无效，请检查！");
        }
        List<MoteDto> list = moteDao.getUntreatById(user_id,id);
        if(!list.isEmpty()){
            moteDao.delNote(user_id,id);
        }else{
            throw new InvalidParamException("该人员下事项为该id的不存在！");
        }
    }

    /**
     * 根据id编辑指定事项
     * @param title
     * @param content
     * @param type
     * @param id
     * @param user_id
     */
    @Override
    public  void ediMote(String title,String content,int type,int id,int user_id){
        UserDto userDto = userDao.selectUserById(user_id);
        if(userDto.getId() != user_id){
            throw new InvalidParamException("用户id无效，请检查！");
        }
        //更新事项
        List<MoteDto> list = moteDao.getUntreatById(user_id,id);
        if(!list.isEmpty()){
            moteDao.ediNote(title,content,type,id);
        }else{
            throw new InvalidParamException("该人员下事项为该id的不存在！");
        }
    }

    /**
     * 根据id更新事项类型：待办->已办
     * @param memoId
     * @param user_id
     */
    @Override
    public void updateUntreatToTreated(ArrayList memoId,int user_id){

        //判断用户是否存在
        UserDto userDto = userDao.selectUserById(user_id);
        if(userDto.getId() != user_id){
            throw new InvalidParamException("用户id无效，请检查！");
        }
        //查询事物id和人物id是否匹配
        for(int i = 0;i < memoId.size(); ++i){
            List<MoteDto> list = moteDao.getUntreatById(user_id,(int)memoId.get(i));
            if(list.size() > 0){
                //事项类型转换：待办->已办
                if(list.get(0).getType() != treated){
                    moteDao.updateType(treated,(int)memoId.get(i));
                }
            }
            else
                continue;
        }
    }

    /**
     * 根据id更新事项类型：已办->待办
     * @param memoId
     * @param user_id
     */
    @Override
    public void updateTreatedToUntreat(ArrayList memoId,int user_id){
        //判断用户是否存在
        UserDto userDto = userDao.selectUserById(user_id);
        if(userDto.getId() != user_id){
            throw new InvalidParamException("用户id无效，请检查！");
        }
        //查询事物id和人物id是否匹配
        for(int i = 0;i < memoId.size(); ++i){
            List<MoteDto> list = moteDao.getUntreatById(user_id,(int)memoId.get(i));
            if(list.size() > 0){
                //事项类型转换：待办->已办
                if(list.get(0).getType() != untreat){
                    moteDao.updateType(untreat,(int)memoId.get(i));
                }
            }
            else
                continue;
        }
    }

    /**
     * 添加备忘事项
     * @param title
     * @param content
     * @param user_id
     * @param type
     */
    @Override
    public void addMote(String title,String content,int user_id,int type){
        UserDto userDto = userDao.selectUserById(user_id);
        if(userDto.getId() != user_id){
            throw new InvalidParamException("用户id无效，请检查！");
        }
        List<MoteDto> list = moteDao.getMoteByTitle(title);
        if(!list.isEmpty()){
            throw new InvalidParamException("备忘事项title已存在！");
        }
        moteDao.addMote(title,content,type,user_id);
    }
}
