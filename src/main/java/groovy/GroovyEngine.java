package groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import script.Processor;

public class GroovyEngine {


    public static void main(String[] args) {
        ClassLoader cl = new GroovyEngine().getClass().getClassLoader();
        GroovyClassLoader grvyCl = new GroovyClassLoader(cl);

        //String code = "class test { public String hello(){return \"hello\" } } ";

        String grvyClassConcent = ContentReader.readContent("");
        //grvyClassConcent = code;
        Class groovyClass = grvyCl.parseClass(grvyClassConcent);

        GroovyObject groovyObject = null;
        try {
            groovyObject = (GroovyObject) groovyClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Object[] arg = {};
        String s = (String) groovyObject.invokeMethod("hello", arg);

        System.out.print(s);
    }


    public static Processor getBean(){

        GroovyClassLoader grvyCl = new GroovyClassLoader();

        //String code = "class test { public String hello(){return \"hello\" } } ";

        String grvyClassConcent = ContentReader.readContent("");
        //grvyClassConcent = code;
        Class groovyClass = grvyCl.parseClass(grvyClassConcent);

        Processor processor = null;
        try {
            processor = (Processor) groovyClass.newInstance();


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return processor;
    }

}
