package com.dao.util.comm;

/**
 * Created by back on 2016/1/18.
 */
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBeanFactory implements ApplicationContextAware {

    private static ApplicationContext context = null;


    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        context = arg0;
        System.out.println("MyBeanFactory is start");

    }

    public static Object getBean(String name)
    {
        if(context==null)
        {
            return null;
        }
        return context.getBean(name);
    }

    public static <T> T getBean(Class<T> clname)
    {
        if(context==null)
        {
            return null;
        }
        return context.getBean(clname);
    }

}
