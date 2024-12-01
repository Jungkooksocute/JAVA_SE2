package com.itheima.myiotest8;

package mypackage;

import org.apache.commons.io.output.FileWriterWithEncoding;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//username=zhangsan&password=123&count=4
  /*
        需求：写一个登陆小案例（添加锁定账号功能）

        步骤：
        	将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
        	保存格式为:username=zhangsan&password=123&count=0
        	让用户键盘录入用户名和密码
        	比较用户录入的和正确的用户名密码是否一致
        	如果一致则打印登陆成功
        	如果不一致则打印登陆失败，连续输错三次被锁定

        */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("D:\\LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLearning_inPerson\\JAVA基础\\day30-阶段综合案例（带权重的随机&每日一记）\\登录\\" +
                "自己添加锁定功能\\userinfo.txt"));
        String line=br.readLine();
        System.out.println(line);
        br.close();//从文件中读取数据

        String[] stuInfo=line.split("&");
        String username=stuInfo[0].split("=")[1];
        String password=stuInfo[1].split("=")[1];
        Integer count=Integer.parseInt(stuInfo[2].split("=")[1]);

        if(count==3){
            System.out.println("账户已锁定，请联系管理员");
            System.exit(0);//程序终止
        }

        Scanner reader=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String inputUsername=reader.nextLine();
        System.out.println("请输入密码：");
        String inoutpassword=reader.nextLine();

        if(username.equals(inputUsername) && password.equals(inoutpassword)){
            System.out.println("登陆成功！");
        }else{
            System.out.println("登陆失败!您还有"+(3-(++count))+"次机会");
        }

        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLearning_inPerson\\JAVA基础\\day30-阶段综合案例（带权重的随机&每日一记）\\登录\\" +
                "\\自己添加锁定功能\\userinfo.txt"));
        bw.write(line.substring(0,line.length()-1)+count);
        bw.close();

        //数据的处理
    }
}

}