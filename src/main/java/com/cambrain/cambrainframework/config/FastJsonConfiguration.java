package com.cambrain.cambrainframework.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: [cambrianc]
 * @Package: [com.cambrain.cambrianc]
 * @ClassName: [FastJsonConfiguration]
 * @Description: FastJson 配置类
 * @Author: [EastHJ]
 * @CreateDate: [2018-010-27 14:52]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-10-27 14:52]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer
{


    /**
     * 引入Fastjson解析json，替代默认的jackson
     * FastJson SerializerFeatures
     * WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
     * WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
     * DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
     * WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
     * WriteMapNullValue：是否输出值为null的字段,默认为false。
     */
    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        // 1.定义一个convert 转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2 添加fastjson 的配置信息 比如 是否要格式化 返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 解决乱码的问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        /**
         * 注2：SpringBoot 2.0.1版本中加载WebMvcConfigurer的顺序发生了变动，
         * 故需使用converters.add(0, converter);指定FastJsonHttpMessageConverter在converters内的顺序，
         * 否则在SpringBoot 2.0.1及之后的版本中将优先使用Jackson处理。
         * 详情：https://github.com/spring-projects/spring-boot/issues/12389
         */
        converters.add(0,fastConverter);
    }



}
