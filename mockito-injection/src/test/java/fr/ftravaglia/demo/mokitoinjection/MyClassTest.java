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
		
		
	}
		
	@Test
	public void printMyFooNameMustFail() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		final String valueMock = "MyMockedResult";

		Assert.assertEquals(valueMock, myClass.printMyFooName());
	}
	
	@Test
	public void printMyFooNameMustReturnMyMockedResult() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		foo = Mockito.mock(Foo.class);
		InjectionHelper.setField(myClass, "myFoo", foo);
		
		final String valueMock = "MyMockedResult";
		
		Mockito.when(foo.printMyName()).thenReturn(valueMock);
		Assert.assertEquals(valueMock, myClass.printMyFooName());
	}
}
