
public aspect Logger {
	pointcut mutators(): call(void Stack.push(String)) || 
							call(String Stack.pop());
	before(): mutators(){
		System.out.println(">Message sent to update stack.");
	}
	
	before(): execution(String Human.reason()){
		System.out.println(">Captured execution to Human.reason(): " + thisJoinPoint);
	}
	
	before(): execution(String Bladerunner.reason()) {
		System.out.println(">Captured execution to Bladerunner.reason(): " + thisJoinPoint);
	}
	
	before(): call(String Server.ping()){
		System.out.println(">Before: " + thisJoinPoint);
	}
	
	after(): call(String Server.ping()){
		System.out.println(">After: " + thisJoinPoint);
	}
	
	before(): execution(String Server.ping()){
		System.out.println(">Before: " + thisJoinPoint);
	}
	
	after(): execution(String Server.ping()){
		System.out.println(">After: " + thisJoinPoint);
	}
}
