package com.wq.website.service.impl;

import com.wq.website.constant.WebConst;
import com.wq.website.dao.LogMapper;
import com.wq.website.modal.Vo.LogVo;
import com.wq.website.service.ILogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by BlueT on 2017/3/4.
 */
@Service
public class LogServiceImpl implements ILogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceImpl.class);

    @Resource
    private LogMapper logDao;

    @Override
    public void insertLog(LogVo logVo) {
        logDao.insertLog(logVo);
    }

    @Override
    public List<LogVo> getLogs(int page, int limit) {
//        LOGGER.debug("Enter getLogs method:page={},linit={}",page,limit);
//        if (page <= 0) {
//            page = 1;
//        }
//        if (limit < 1 || limit > WebConst.MAX_POSTS) {
//            limit = 10;
//        }
//        Paginator<LogVo> logsPaginator = activeRecord.page(new Take(Logs.class).page(page, limit, "id desc"));
//        LOGGER.debug("Exit getLogs method");
//        return logsPaginator.getList();
        return null;
    }
}
