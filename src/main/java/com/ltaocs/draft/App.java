package com.ltaocs.draft;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @Author: Lin Tao
 * @Date: 12/21/2019 7:02 AM
 */
public class App extends WebMvcConfigurerAdapter
{
    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //下面是重写的代码

        //先定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
        //添加fastJson的配置信息，比如，是否需要格式化返回json数据
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //将convert添加到converters中
        converters.add(fastConverter);
    }
    public static void main( String[] args )
    {
        /**
         * 在Main方法中启动我们的应用程序
         */
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);

    }
}