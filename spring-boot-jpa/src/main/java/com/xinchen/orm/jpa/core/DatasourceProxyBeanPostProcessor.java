package com.xinchen.orm.jpa.core;

import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.sql.DataSource;
import java.lang.reflect.Method;

/**
 *
 * Tracing SQL Queries,log sql
 *
 * using a data source proxy to trace Hibernate/JPA SQL statements
 *
 * to verify that insert/update statements are indeed sent in batches.
 *
 * Reference:
 * 1. https://www.baeldung.com/jpa-hibernate-batch-insert-update
 * 2. https://github.com/eugenp/tutorials/blob/master/persistence-modules/spring-data-jpa-3/src/main/java/com/baeldung/batchinserts/DatasourceProxyBeanPostProcessor.java
 *
 * @author xinchen
 * @version 1.0
 * @date 08/06/2020 16:55
 */
@Component
public class DatasourceProxyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSource){
            final ProxyFactory factory = new ProxyFactory(bean);
            factory.setProxyTargetClass(true);
            factory.addAdvice(new ProxyDataSourceInterceptor((DataSource) bean));
            return factory.getProxy();
        }

        return bean;
    }

    private static class ProxyDataSourceInterceptor implements MethodInterceptor {

        private final DataSource dataSource;

        private ProxyDataSourceInterceptor(final DataSource dataSource) {
            this.dataSource = ProxyDataSourceBuilder
                    .create(dataSource)
                    .name("Batch-Insert-Logger")
                    .asJson()
                    .countQuery()
                    .logQueryToSysOut()
                    .build();
        }

        @Override
        public Object invoke(final MethodInvocation invocation) throws Throwable {
            Method proxyMethod = ReflectionUtils.findMethod(dataSource.getClass(), invocation.getMethod().getName());
            if (proxyMethod != null) {
                return proxyMethod.invoke(dataSource, invocation.getArguments());
            }
            return invocation.proceed();
        }
    }
}
