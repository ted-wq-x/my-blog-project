package com.wq.website.dao;

import com.wq.website.modal.Vo.OptionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库操作options表方法
 * Created by BlueT on 2017/3/3.
 */
@Repository
public interface OptionMapper {
    /**
     * 保存一组配置
     *
     * @param options
     */
    void saveOptions(List<OptionVo> options);

    /**
     * 保存配置
     * @param optionVo
     */
    void saveOption(OptionVo optionVo);

    /**
     * 获取系统配置
     * @return
     */
    List<OptionVo> getOptions();

    /**
     * 更新option字段
     * @param optionVo 待更新对象
     * @return 更新记录数
     */
    int updateOptionByName(OptionVo optionVo);
}
