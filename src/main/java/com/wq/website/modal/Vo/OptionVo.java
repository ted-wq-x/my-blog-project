package com.wq.website.modal.Vo;

/**
 * Created by BlueT on 2017/3/3.
 */
public class OptionVo {

    // 配置名称
    private String name;

    // 配置值
    private String value;

    // 配置描述
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "OptionVo{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
