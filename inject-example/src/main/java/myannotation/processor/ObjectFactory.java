package myannotation.processor;


import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {

    private static Map<Class<?> , Object> objectMap = new HashMap<>() ;

    public static Object getObject(Class <?> aClass){

        if (objectMap.get(aClass) == null){
            createObject(aClass);
        }
        return objectMap.get(aClass);

    }

    public static void createObject(Class<?> aClass)  {
        try {
            objectMap.put(aClass, aClass.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
