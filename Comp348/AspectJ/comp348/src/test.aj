
public aspect test {
	
	pointcut getterAndSetter(): call(String Test1.getTitle()) || call(void Test1.setTitle(String));
	
	before(): getterAndSetter(){
		System.out.println("We are calling getter and setter");
	}
}
