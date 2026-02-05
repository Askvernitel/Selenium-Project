package org.project.utils;

import org.project.enums.ConfigType;

import java.util.Map;

public class Config {

    private Map<String,String> config;
    public Config(Map<String, String> data){
        this.config=data;
    }


    public String get(ConfigType configType){
        return config.get(configType.name());
    }


}
