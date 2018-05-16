package com.xdy;

import org.junit.Test;

public class Demo1 {
    /**
     * 鸡兔同笼
     * 头共50
     * 脚120
     */
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
   }

    /**
     * 韩信点兵
     * 一共有1000多人
     * 五列剩一
     * 六列剩二
     * 七列剩三
     * 问具体多少人
     */
   @Test
    public void Test2(){
       for(int x=1000;x<2000;x++){
           if(x%5==1&&x%6==2&&x%7==3){
               System.out.println("一共有："+x+"人");
           }
       }
   }


}
