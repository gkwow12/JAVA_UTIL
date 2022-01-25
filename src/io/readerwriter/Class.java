package io.readerwriter;

public class Class {


static void method()throws Exception {

  throw new Exception();
}

public static void main( String [] args ) {   

     try{

         method();

} catch( Exception ex ) {

         System.out.println("예외처리");

     } 

}

}