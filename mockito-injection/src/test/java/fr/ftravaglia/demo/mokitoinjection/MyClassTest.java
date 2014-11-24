package fr.ftravaglia.demo.mokitoinjection;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import fr.ftravaglia.demo.mokitoinjection.util.InjectionHelper;

/**
 * Test the class {@link MyClass}
 * @author ftravaglia
 *
 */
public class MyClassTest {

	private transient MyClass myClass;
	private transient Foo foo;
	public MyClassTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		super();
		
		myClass = new MyClass();
		
		foo = Mockito.mock(Foo.class);
		InjectionHelper.setField(myClass, "myFoo", foo);
	}
	
	@Test
	public void printMyFooNameMustReturnMyMockedResult(){
		
		final String valueMock = "MyMockedResult";
		
		Mockito.when(foo.printMyName()).thenReturn(valueMock);
		Assert.assertEquals(valueMock, myClass.printMyFooName());
	}
}
