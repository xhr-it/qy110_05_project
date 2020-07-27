package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.RandomCheckMapper;
import com.aaa.model.CheckPerson;
import com.aaa.model.MappingUnit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;


/**
 * 随机抽查模块service
 * @author sheep
 */
@Service
public class RandomCheckService extends BaseService<MappingUnit> {
    @Autowired
    private RandomCheckMapper randomCheckMapper;

    /**
     * 随机查询单位
     * @return
     */
    public PageInfo selectRandomMappingUnit(Double proportion, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<MappingUnit> list = randomCheckMapper.selectRandomMappingUnit(null,pageNo,pageSize);
        if (list != null && list.size() > 0){
            Double randomNum =  list.size() * proportion;
            int newRandomNum = Integer.parseInt(new DecimalFormat("0").format(randomNum));
            List<MappingUnit> listResult = randomCheckMapper.selectRandomMappingUnit(newRandomNum,pageNo,pageSize);
            if (listResult != null && listResult.size() > 0){
                PageInfo pageInfo = new PageInfo(listResult);
                return pageInfo;
            }
        }
        return null;
    }

    /**
     * 随机抽查人员
     * @return
     */
    public List<CheckPerson> selectRandomCheckPerson(Double proportion){
        List<CheckPerson> list = randomCheckMapper.selectRandomCheckPerson(null);
        if (list != null && list.size() > 0){
            Double randomNum =  list.size() * proportion;
            int newRandomNum = Integer.parseInt(new DecimalFormat("0").format(randomNum));
            List<CheckPerson> listResult = randomCheckMapper.selectRandomCheckPerson(newRandomNum);
            if (listResult != null && listResult.size() > 0){
                return listResult;
            }
        }
        return null;
    }

}
