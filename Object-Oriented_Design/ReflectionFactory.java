package cn.mldn.demo;
interface Fruit {
	publicvoideat() ;
}
class Apple implements Fruit {
	public void eat() {
		System.out.println("吃苹果。");
	};
}

class Factory {
	public static Fruit getInstance(String className) {
		if("apple".equals(className)){
			returnnewApple() ;
		}
		returnnull;
	}
}

public class FactoryDemo {
	public static void main(String[] args) {
		Fruit f = Factory.getInstance("apple") ;
		f.eat() ;
	}
}

// 真正的耦合其实来源于 new 关键字

// 常规Factory 设计模式，如果Fruit 接口子类增加了，那么Factory类肯定需要修改
// 如果改用反射机制就能解决这个问题：

package cn.mldn.demo;
interface Fruit {
	public voi deat() ;
}
class Apple implements Fruit {
	public void eat() {
		System.out.println("吃苹果。");
	}; 
}

class Orange implements Fruit {
	public void eat() { 
		System.out.println("吃橘子。");
	}; 
}
class Factory {
	public static Fruit getInstance(String className) {
		Fruit f = null;
		try{
			// 不需要匹配类名，直接利用反射创建新的实例
			f = (Fruit) Class.forName(className).newInstance() ;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return f ;
	}
}
public class FactoryDemo {
	public static void main(String[] args) {
		Fruit f = Factory.getInstance("cn.mldn.demo.Orange") ;
		f.eat() ;
	}
}