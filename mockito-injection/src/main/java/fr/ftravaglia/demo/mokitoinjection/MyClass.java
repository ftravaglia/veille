package fr.ftravaglia.demo.mokitoinjection;

/**
 * Use for test with reflexion
 * @author ftravaglia
 */
public class MyClass {

	// Field that haven't setter !
	private transient Foo myFoo;

	/**
	 * Default constructor
	 */
	public MyClass(){
		super();
		myFoo = new Foo();
	}

	/**
	 * Return the Foo name.
	 * @return
	 */
	public String printMyFooName(){
		return myFoo.printMyName();
	}
}
