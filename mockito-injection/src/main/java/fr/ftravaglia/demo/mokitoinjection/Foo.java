package fr.ftravaglia.demo.mokitoinjection;

/**
 * Object to mock
 * @author ftravaglia
 */
public class Foo {

	/**
	 * Default constructor
	 */
	public Foo(){
		super();
	}
	
	/**
	 * Method used for demonstrate mock
	 * @return
	 */
	public String printMyName(){
		return this.getClass().getName();
	}
}
