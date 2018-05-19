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

    /**
     * 需要找零8元
     有零钞：5元 2元 1元 5角
     求出所有的找零方案
     */
  @Test
    public void test3(){
      int SUM = 80;

      for(int a=0; a <= SUM/50; a++){
          for(int b=0; b <= SUM/20; b++){
              for(int c=0; c <= SUM/10; c++){
                  if((SUM-a*50-b*20-c*10)<0)break;
               int d=((SUM-a*50-b*20-c*10)/5);
                      if(a*50 + b*20 + c*10 + d*5==SUM)
                          System.out.println("五元"+a+"===》两元"+b+"===》一元"+c+"===》五角"+d);

              }
          }
      }
  }

    /**
     *
     数字自身的平方的尾数=自身（100w以内）
     */
    @Test
    public void test4(){
        long begin=System.currentTimeMillis();
        int x=1000000;
        for(int i=0;i<x;i++){
            int a = i*i;//得到的平方
            if(a%10==i||a%100==i||a%1000==i||a%10000==i||a%100000==i){
                System.out.println("本身是"+i+"====>平方是"+a);
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("总耗时"+(end-begin));
    }
/**
 *本身是0====>平方是0
 本身是1====>平方是1
 本身是5====>平方是25
 本身是6====>平方是36
 本身是25====>平方是625
 本身是76====>平方是5776
 本身是376====>平方是141376
 本身是625====>平方是390625
 本身是9376====>平方是87909376
 总耗时15
 */








    /**
     *
     数字自身的平方的尾数=自身（100w以内）
     */
@Test
    public void test5(){
    long begin=System.currentTimeMillis();
    int x=1000000;
    for(int i=0;i<x;i++){
      int a = i*i;
        int b=a%10;
        if(b!=0&&b!=1&&b!=5&&b!=6){continue;}
    if(a%10==i||a%100==i||a%1000==i||a%10000==i||a%100000==i){
        System.out.println("本身是"+i+"====>平方是"+a);
    }
}
    long end=System.currentTimeMillis();
    System.out.println("总耗时"+(end-begin));
}

}
