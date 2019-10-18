package com.person.master.controller.bak;

import com.person.master.common.web.Result;
import com.person.master.service.DatabaseBakService;
import com.person.master.vo.AddDBBakQueryVo;
import com.person.master.vo.DBBakQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author jjma
 * Created by sang on 2019/8/14.
 */

@RestController
@RequestMapping("/api/v1/bak/database")
public class DatabseBakController {

    @Autowired
    private DatabaseBakService databaseBakService;

    /**
     * 数据库备份查询
     * @param dbBakQueryVo
     * @return
     */
    @RequestMapping(value = "/getBakList",method = RequestMethod.GET)
    public ResponseEntity<Result> getDBbakByName(@Valid DBBakQueryVo dbBakQueryVo){
        return ResponseEntity.ok(Result.success(databaseBakService.getDBbakByName(dbBakQueryVo)));
    }

    /**
     * 根据id删除指定备份记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteBak",method = RequestMethod.DELETE)
    public ResponseEntity<Result> deleteDBBakById(@NotNull(message = "备份id不能为空")Integer id){
        databaseBakService.deleteBakById(id);
        return ResponseEntity.ok(Result.success(null));
    }

    /**
     * 数据备份
     * @param addDBBakQueryVo
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Result> addDBBak(@RequestBody @Valid AddDBBakQueryVo addDBBakQueryVo){
        databaseBakService.addDBBak(addDBBakQueryVo);
        return ResponseEntity.ok(Result.success(null));
    }

    /**
     * 备份数据恢复
     * @param map
     * @return
     */
    @RequestMapping(value = "/renew",method = RequestMethod.POST)
    public ResponseEntity<Result> renewDBBak(@RequestBody Map<String, Integer> map){
        databaseBakService.renewDBBak(map.get("id"));
        return ResponseEntity.ok(Result.success(null));
    }
}

