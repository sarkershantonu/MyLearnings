package org.tutoring.api;

public class TestClass {


    public static void main(String args[]){


        for(int i = 0; i < 6; i++){
            for(int j =0; j < 5 ; j ++){

                    if(i%2==0){
                         if(j % 2 != 0){
                             System.out.print("*");
                         }else{
                             System.out.print("#");
                         }
                    }else{
                        if(j%2 != 0){
                            System.out.print("#");
                        }else{
                            System.out.print("*");
                        }
                    }
            }
            System.out.println("\n");
        }
    }

}


