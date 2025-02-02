package co.wangming.nsb.server.spring;

import co.wangming.nsb.common.spring.AbstractBeanDefinitionRegistrar;
import co.wangming.nsb.server.event.NSEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 用于扫描 #{@link NSEvent} 注解
 * <p>
 * Created By WangMing On 2019-12-06
 **/
public class NSEventRegistrar extends AbstractBeanDefinitionRegistrar {

    private static final Logger log = LoggerFactory.getLogger(NSEventRegistrar.class);

    @Override
    public List<Class> getAnnotationTypeFilterClass() {
        return Arrays.asList(NSEvent.class);
    }

    @Override
    public BeanNameGenerator beanNameGenerator() {
        return new AnnotationBeanNameGenerator();
    }

    @Override
    public void process(BeanDefinitionRegistry beanDefinitionRegistry, Set<BeanDefinitionHolder> beanDefinitionHolders) throws Exception {
        log.info("注册 NSEvent");
        // non-impl
    }

}
