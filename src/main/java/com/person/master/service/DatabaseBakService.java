package com.person.master.service;

import com.person.master.vo.AddDBBakQueryVo;
import com.person.master.vo.DBBakQueryVo;
import com.person.master.vo.page.PageResult;

/**
 * @Author jjma
 * @Date Created in 2019/8/9.
 */
public interface DatabaseBakService {

    /**
     * 查询指定数据库备份记录
     * @param dbBakQueryVo
     * @return
     */
    PageResult getDBbakByName(DBBakQueryVo dbBakQueryVo);

    /**
     * 根据备份id删除指定备份数据
     * @param id
     */
    void deleteBakById(Integer id);

    /**
     * 数据备份
     * @param addDBBakQueryVo
     */
    void addDBBak(AddDBBakQueryVo addDBBakQueryVo);

    /**
     * 备份数据恢复
     * @param bakId
     */
    void renewDBBak(Integer bakId);

}
