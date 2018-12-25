package Testing;

public class TestNull {


    public static void main(String[] args) {

        Long id = new Long(null);

        if(null == id){
            System.out.println("Null Before");
        }

        if (id== null){
            System.out.println("Null After");
        }
    }
}
