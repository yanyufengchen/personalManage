package com.person.master.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.person.master.common.exception.InvalidParamException;
import com.person.master.dao.bak.DBBakDao;
import com.person.master.dto.bak.DBBakDto;
import com.person.master.service.DatabaseBakService;
import com.person.master.utils.DateFormatUtil;
import com.person.master.utils.ShellHelper;
import com.person.master.vo.AddDBBakQueryVo;
import com.person.master.vo.DBBakQueryVo;
import com.person.master.vo.page.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.person.master.conf.dozer.DozerConverter;


import java.util.List;

@Service
@Slf4j
public class DatabaseBakImp implements DatabaseBakService {

    @Autowired
    private DozerConverter dozerConverter;

    @Autowired
    private DBBakDao dbBakDao;

    /**
     * 获取数据备份记录
     * @param dbBakQueryVo
     * @return
     */
    @Override
    public PageResult getDBbakByName(DBBakQueryVo dbBakQueryVo) {
        if (dbBakQueryVo.getRows() > 40) {
            dbBakQueryVo.setRows(40);
        }
        PageHelper.startPage(dbBakQueryVo.getPage(), dbBakQueryVo.getRows());
        List<DBBakDto> list = dbBakDao.getDBbakByName(dbBakQueryVo.getBak_name());
        try {
            for(int i = 0;i<list.size();++i){
                list.get(i).setOperateDate(DateFormatUtil.dataFormat(list.get(i).getOperateDate()));
            }
        }catch (Exception e){
        }
        return new PageResult<>(((Page) list).getTotal(), list);
    }

    /**
     * 删除备份
     *
     * @param id
     */
    @Override
    public void deleteBakById(Integer id) {
        dbBakDao.deleteBakDB(id);
    }

    /**
     * 数据备份
     *
     * @param addDBBakQueryVo
     */
    @Override
    public void addDBBak(AddDBBakQueryVo addDBBakQueryVo) {

        final DBBakDto dbBakDto = dozerConverter.convert(addDBBakQueryVo, DBBakDto.class);
        Integer hr_id = dbBakDao.getHrIdByName(dbBakDto.getHr_name());
        if (hr_id != null && hr_id > 0) {
            dbBakDto.setHr_id(hr_id);
        } else {
            throw new InvalidParamException("该操作人不存在！请确认重新输入！");
        }
        List<DBBakDto> list = dbBakDao.getDBbakByName(addDBBakQueryVo.getBak_name());
        if(!list.isEmpty()){
            if(!list.contains(dbBakDto.getPath())){
                throw new InvalidParamException("备份名与备份地址在一条记录中同时相同，请重新输入！");
            }
        }

        boolean assertTrue = false;
        assertTrue = backup(dbBakDto);
        if (assertTrue == false) {
            throw new InvalidParamException("数据库表：" + dbBakDto.getTable_name() + "备份失败！");
        } else {
            dbBakDao.addDBBak(dbBakDto);
        }
    }

    /**
     * 备份数据恢复
     * @param bakId
     */
    @Override
    public void renewDBBak(Integer bakId){
        DBBakDto dbBakDto = dbBakDao.renewDBBak(bakId);
        if(dbBakDto != null){
            int responseId = renewDBOperate(dbBakDto);
            if(responseId == 1){
                throw new InvalidParamException("备份记录："+ dbBakDto.getBak_name() + "不存在！");
            }else if(responseId == 2){
                throw new InvalidParamException("备份记录："+ dbBakDto.getBak_name() + "恢复数据失败！");
            }
        }else{
            throw new InvalidParamException("该备份记录不存在！");
        }
    }

    /**
     * 数据库恢复操作
     * @param dbBakDto
     * @return 0 恢复成功 1 备份路径或文件不存在 2 恢复失败
     */
    public static int renewDBOperate(DBBakDto dbBakDto){
        //连接虚拟机
        ShellHelper shellHelper = new ShellHelper(dbBakDto.getNode_ip(), dbBakDto.getNode_port(), dbBakDto.getNode_user(),
                dbBakDto.getNode_password(), false);
        String execCMD = "mysql" + " -u" + dbBakDto.getMysql_user() + " -p" + dbBakDto.getMysql_password() + " " +
                "-P"+ dbBakDto.getMysql_port()+ " " + dbBakDto.getDatabase_name() + "<" + dbBakDto.getPath() + "/"+ dbBakDto.getBak_name();
        try {
            //判断备份文件路径是否存在
            final String pwdPath = shellHelper.execWithResult("cd " + dbBakDto.getPath() + "&&pwd");
            log.info("cd => {}", pwdPath);
            if (!dbBakDto.getPath().equals(pwdPath)) {
                return 1;
            }
            //判断备份文件是否存在
            final String bakExist = shellHelper.execWithResult("cd" +dbBakDto.getPath()+"&&ls");
            log.info("cd => {}",bakExist);
            if (bakExist.contains(dbBakDto.getBak_name())) {
                return 1;
            }
            //执行备份数据恢复
            final String bak_result =  shellHelper.execWithResult(execCMD);
            if(bak_result.contains("error")){
                return 2;
            }else{
                return 0;
            }
        }catch (Exception e) {
            return 2;
        }
    }

    /**
     * 数据库备份操作
     * @param dbBakDto
     * @return
     */
    public static boolean backup(DBBakDto dbBakDto) {

        //连接虚拟机
        final ShellHelper shellHelper = new ShellHelper(dbBakDto.getNode_ip(), dbBakDto.getNode_port(), dbBakDto.getNode_user(),
                dbBakDto.getNode_password(), false);

        dbBakDto.setBak_name(dbBakDto.getBak_name() + ".sql");
        int len = dbBakDto.getBak_name().length();
        String savePath = dbBakDto.getPath();
        //拼接命令行的命令
        String execCMD = "/usr/bin/mysqldump" + " -u" + dbBakDto.getMysql_user() + " -p" + dbBakDto.getMysql_password() + " " +
                "-P"+ dbBakDto.getMysql_port() + " "+ dbBakDto.getDatabase_name() + " " + dbBakDto.getTable_name() + ">" +
                dbBakDto.getPath() + "/"+ dbBakDto.getBak_name();
        try {
            //判断备份路径是否存在
            final String pwdPath = shellHelper.execWithResult("cd " + dbBakDto.getPath() + "&&pwd");
            log.info("cd => {}", pwdPath);
            if (!dbBakDto.getPath().equals(pwdPath)) {
                shellHelper.exec("mkdir "+ dbBakDto.getPath());
            }
            //执行备份
            final String bak_result =  shellHelper.execWithResult(execCMD);
            if(bak_result.contains("error")){
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            log.error("数据库：" + dbBakDto.getDatabase_name() + " " + dbBakDto.getTable_name() + "备份失败", e);
            throw new InvalidParamException("数据库：" + dbBakDto.getDatabase_name() + " " + dbBakDto.getTable_name() + "备份失败");
        }
    }
}
