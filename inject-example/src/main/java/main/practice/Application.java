package main.practice;

import myannotation.PracticeInject;
import myannotation.processor.ObjectFactory;
import myannotation.processor.PracticeInjectProcessor;

public class Application {

    /**
     * To Do
     */

    @PracticeInject(value = "Change Regular value from annotaton value")
    private String regularStr = "regular str";
    @PracticeInject
    private static String staticStr = "static str";
    @PracticeInject
    private static final String finalString = "final Str";

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
