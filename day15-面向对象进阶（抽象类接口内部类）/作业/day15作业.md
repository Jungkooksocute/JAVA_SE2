## 第一题：

### 需求：

分析以下需求用代码实现:

1. 定义形状类:

   功能：求面积，求周长

2. 定义圆形类Round:

   属性：半径，圆周率

   功能：求面积，求周长

3. 定义长方形类Rectangle:

   	属性：长和宽

   功能：求面积，求周长			

4. 定义测试类:

		分别创建圆形和长方形对象，为相应的属性赋值
	
	分别调用求面积和求周长的方法

```java
package ui;

public class Rectangle extends shape{

    private int l;
    private int s;

    public Rectangle() {
    }

    public Rectangle(int l, int s) {
        this.l = l;
        this.s = s;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }


    @Override
    public double circle() {
        return (double)(2*(l+s));
    }

    @Override
    public double square() {
        return (double)(l*s);
    }
}//
package ui;
import java.math.*;

public class Round extends shape{

    private int r;

    public Round() {
    }

    public Round(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public double circle() {
        return (2*Math.PI*r);
    }

    @Override
    public double square() {
        return (Math.PI*r*r);
    }
}//
package ui;

public abstract class shape {

    public abstract double circle();

    public abstract double square();

    public shape() {
    }
}//

public class test {
    public static void main(String[] args) {
        Rectangle chang=new Rectangle(2,3);
        System.out.println("长方形的面积："+chang.square()+"周长："+chang.circle());
        Round yuan=new Round(2);
        System.out.println("圆的面积："+yuan.square()+"周长："+yuan.circle());

    }
}


```

## 第二题：

### 需求：

1. 定义手机类

​	行为：打电话,发短信

2. 定义接口IPlay

​	行为：玩游戏

3. 定义旧手机类继承手机类

​	行为：继承父类的行为

4. 定义新手机继承手机类实现IPlay接口

   行为：继承父类的行为,重写玩游戏方法

5. 定义测试类

​	在测试类中定义一个 用手机的方法,要求该方法既能接收老手机对象,也能接收新手机对象

​	在该方法内部调用打电话,发短信以及新手机特有的玩游戏方法

```java
package ui;

public interface IPay {
    public abstract void play();
}//
public class newPhone extends phone implements IPay{
    @Override
    public void play() {
        System.out.println("玩游戏啊玩游戏");
    }
}
//
public class oldPhone extends phone{

}
//
public abstract class phone {
    public void call(){
        System.out.println("手机打电话");
    }
    public void message(){
        System.out.println("手机发短信");
    }
}//

package ui;public class test {
    public static void main(String[] args) {
        meth(new newPhone());
        meth(new oldPhone());
    }
    public static void meth(phone p){
        p.call();
        p.message();
        if(p instanceof newPhone KI){
            KI.play();
        }

    }
}


```





## 第三题：

### 需求:

1. 接口IPlay中有一个方法playGame()，在测试类中如何调用该方法？

​		要求1.创建子类实现接口的方式实现
​		要求2:用匿名内部类实现


2. 一个抽象类Fun中有一个抽象方法 fun() , 在测试类中如何调用该方法?

​		要求1.创建子类继承抽象类的方式实现
​		要求2:用匿名内部类实现

```java
package ui;

public abstract class Fun {
    public abstract void fun();
}//
public interface IPlay {
    public abstract void playGame();
}//
public class son1 implements IPlay{
    @Override
    public void playGame() {
        System.out.println("通过子类实现接口：玩游戏");
    }
}//
public class son2 extends Fun{

    @Override
    public void fun() {
        System.out.println("通过子类继承抽象类：有趣");
    }
}//
public class test {
    public static void main(String[] args) {
        //1.要求1
        son1 a=new son1();
        a.playGame();
        //1.要求2(1)
        new IPlay(){
            @Override
            public void playGame() {
                System.out.println("通过匿名内部类：1玩游戏");
            }
        }.playGame();
        // 1.要求2(2)
        IPlay b=new IPlay(){
            @Override
            public void playGame() {
                System.out.println("通过匿名内部类：2玩游戏");
            }
        };
        b.playGame();


        //2.要求1
        son2 c=new son2();
        c.fun();
        //2.要求2(1)
        new Fun(){
            @Override
            public void fun() {
                System.out.println("通过匿名内部类：1有趣");
            }
        }.fun();
        // 2.要求2(2)
        Fun d=new Fun() {
            @Override
            public void fun() {
                System.out.println("通过匿名内部类：2有趣");
            }
        };
        d.fun();

    }
}





```

## 第四题：

### 需求：

​	在控制台输出”HelloWorld”	

​	自己书写，不要用idea自动生成。

```java
interface Inter {
    void show(); 
}
class Outer { 
    //补齐代码 
    /*public class Outer {
    public static Inter method(){
        return new Inter(){
            @Override
            public void show() {
                System.out.println("Hello World");
            }
        };//这个";"根据实际情况决定要不要
    }
}*/
    
    
    
}
public class OuterDemo {
    public static void main(String[] args) {
        Outer.method().show();//没有New生成对象那肯定是直接调用方法
    }
}





```



## 第五题：

### 需求：

​	在测试类Test中创建A的对象a并调用成员方法methodA(),要求用两种方式实现 

​	自己书写，不要用idea自动生成。

```java
public class Test {
    public static void main(String[] args) {	
        /*方法一：用匿名内部类
        A a=new A();
        a.methodA(new InterA(){
            @Override
            public void showA() {
                System.out.println("showA");
            }
        });*/
        
    }
}

//定义接口
interface InterA {
    void showA();	
}

class A {
    public void methodA(InterA a) {
        a.showA();		
    }	
}



//方法二。用接口实现类的方法
B b = new B();
        a.methodA(b);
class B implements InterA {
    @Override
    public void showA() {
        System.out.println("showA from B");
    }
}


```

## 第六题：

### 需求：

​	在测试类Test中创建B的对象b，并调用成员方法methodB

​	自己书写，不要用idea自动生成。

```java
public class Test {
    public static void main(String[] args) {
/*
B b=new B(new InterB(){
            @Override
            public void showB() {
                System.out.println("showBBBBBBBBBB");
            }
        });
        b.methodB();
        */
    }
}

//定义一个接口
interface InterB {
    void showB();	
}

//目标：调用成员方法methodB
class B {
    InterB b;
    public B(InterB b){
        this.b = b;
    }//☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆构造方法☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
    public void methodB(){
        b.showB();		
    }
}
```

