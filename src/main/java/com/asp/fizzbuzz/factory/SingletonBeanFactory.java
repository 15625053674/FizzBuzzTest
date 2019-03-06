package com.asp.fizzbuzz.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * Created by ch on 2019/3/5.
 */

//Object BeanFactory
public class SingletonBeanFactory {
    private static SingletonBeanFactory beanFactory = null;
    private static Map<String,Object> beans = new HashMap<String,Object>();

    private SingletonBeanFactory(String xmlPath){
        try {
//            InputStream in = SingletonBeanFactory.class.getResourceAsStream(xmlPath);
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("properties.xml");
            //Load xml file
            SAXReader sr = new SAXReader();
            Document doc = sr.read(in);

            //Load all object
            List<Element> beanElems = (List<Element>)doc.selectNodes("//bean");
            for (Element beanElem : beanElems) {
                String objId = beanElem.attributeValue("id");
                String clzName = beanElem.attributeValue("class");
                Object obj = Class.forName(clzName).newInstance();
                beans.put(objId, obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //Get bean
    public Object getBean(String name){
        return beans.get(name);
    }
    // Get factory
    public static SingletonBeanFactory getSingletonBeanFactory(String xmlPath){
        if(beanFactory==null){
            synchronized(SingletonBeanFactory.class){
                if(beanFactory==null){
                    beanFactory = new SingletonBeanFactory(xmlPath);
                }
            }
        }
        return beanFactory;
    }

}
