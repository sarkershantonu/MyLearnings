package main.practice;

import myannotation.PracticeInject;
import myannotation.processor.ObjectFactory;
import myannotation.processor.PracticeInjectProcessor;

public class Application {

    /**
     * To Do
     */

    @PracticeInject(value = "Change Regular value")
    private String regularStr = "regular";
    @PracticeInject
    private static String staticStr = "static";
    @PracticeInject
    private static final String finalString = "final";

    static {
//        ObjectFactory.createObject(Application.class);
        PracticeInjectProcessor.practiceInjectProcessor(Application.class);
    }
    public static void main(String[] args) {


       Application app = (Application) ObjectFactory.getObject(Application.class);


        System.out.println(app.regularStr);
        System.out.println(Application.staticStr);
        System.out.println(finalString);

    }
}
