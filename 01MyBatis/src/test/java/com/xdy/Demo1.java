package com.xdy;

import org.junit.Test;

public class Demo1 {

   int head=50;
   int foot=120;

   @Test
    public void Test1(){
       //鸡的数量
       for(int x=0;x<head;x++){
           int y=head-x;
           if(x*2+y*4==120){
               System.out.println("鸡的数量："+x);
               System.out.println("兔的数量："+y);
           }
       }
   }@Test
    public void Test2(){
       //鸡的数量
       for(int x=0;x<head;x++){
           int y=head-x;
           if(x*2+y*4==120){
               System.out.println("鸡的数量："+x);
               System.out.println("兔的数量："+y);
           }
       }
   }


}
