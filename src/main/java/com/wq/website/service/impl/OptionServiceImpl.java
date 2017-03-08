package com.wq.website.service.impl;

import com.wq.website.dao.OptionMapper;
import com.wq.website.exception.TipException;
import com.wq.website.modal.Vo.OptionVo;
import com.wq.website.service.IOptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * options表的service
 * Created by BlueT on 2017/3/7.
 */
@Service
public class OptionServiceImpl implements IOptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionServiceImpl.class);

    @Resource
    private OptionMapper optionDao;

    @Override
    public void insertOption(OptionVo optionVo) {
        LOGGER.debug("Enter insertOption method:optionVo={}" ,optionVo);
        optionDao.saveOption(optionVo);
        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    public void insertOption(String name, String value) {
        LOGGER.debug("Enter insertOption method:name={},value={}",name,value );
        OptionVo optionVo = new OptionVo();
        optionVo.setName(name);
        optionVo.setValue(value);
        if(optionDao.getOptions().size()==0){
            optionDao.saveOption(optionVo);
        }else{
            optionDao.updateOptionByName(optionVo);
        }
        throw new TipException("test");
//        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    public List<OptionVo> getOptions(){
        return optionDao.getOptions();
    }
}
