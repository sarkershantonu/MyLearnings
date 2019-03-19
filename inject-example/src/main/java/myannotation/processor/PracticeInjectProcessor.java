package myannotation.processor;

import myannotation.PracticeInject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PracticeInjectProcessor {
    public static void practiceInjectProcessor(Class <?> aClass){

        Object anObject = ObjectFactory.getObject(aClass);

        String className = aClass.getName();
        for (Field afield: aClass.getDeclaredFields()){

            afield.setAccessible(true);
            if (afield.isAnnotationPresent(PracticeInject.class)){
                if (afield.getType().isAssignableFrom(String.class)){
                    if(Modifier.isFinal(afield.getModifiers())){
                        System.out.println("Final !! We Cann't Change");

                    }else {
                        if (Modifier.isStatic(afield.getModifiers())){
                            setStaticFieldValue(className,afield.getName(),"Static Value Changed by Injaction");
                        }else {
                            String value = getAnnotationValue(afield.getAnnotation(PracticeInject.class));
                            setFieldValue(anObject,afield.getName(),value);
                        }
                    }
                }
            }
        }
    }

    private static void setStaticFieldValue(String className,String fieldName, Object newValue){
        try {
            Field aField = Class.forName(className).getDeclaredField(fieldName);
            aField.setAccessible(true);

            Object objectOld = aField.get(Class.forName(className));
            aField.set(objectOld,newValue);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static void setFieldValue(Object instance, String fieldName, Object newValue){

        try {
            Field aField =  instance.getClass().getDeclaredField(fieldName);
            aField.setAccessible(true);
            aField.set(instance,newValue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static String getAnnotationValue(PracticeInject practiceInjectAnnotation){

        return practiceInjectAnnotation.value();

    }
}
