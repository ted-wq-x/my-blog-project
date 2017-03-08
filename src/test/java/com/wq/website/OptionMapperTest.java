package com.wq.website;

import com.wq.website.dao.OptionMapper;
import com.wq.website.modal.Vo.OptionVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BlueT on 2017/3/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.wq.website.dao")
public class OptionMapperTest {
    @Autowired
    private OptionMapper optionMapper;

    @Test
    public void index(){
//        List<OptionVo> list = new ArrayList<>();
//        OptionVo op1 = new OptionVo();
//        op1.setName("wq");
//        op1.setValue("12");
//        op1.setDescription("hahahha");
//        list.add(op1);
//        op1 = new OptionVo();
//        op1.setName("scc");
//        op1.setValue("22");
//        op1.setDescription("woowow");
//        list.add(op1);
//        optionMapper.saveOptions(list);
//
//        op1 = new OptionVo();
//        op1.setName("lyf");
//
//        op1.setValue("33");
//        op1.setDescription("0009");
//        optionMapper.saveOption(op1);
//
//
//        System.out.println(optionMapper.getOptions());
    }
}
