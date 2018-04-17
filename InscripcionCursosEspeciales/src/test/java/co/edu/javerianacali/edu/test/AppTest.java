package co.edu.javerianacali.edu.test;

import co.edu.javerianacali.entities.Calculadora;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase
{
/**
 * Create the test case
 *
 * @param testName name of the test case
 */
	private Calculadora calculadora= new Calculadora();
	
public AppTest( String testName )
{
    super( testName );
}

/**
 * @return the suite of tests being tested
 */
public static Test suite()
{
    return new TestSuite( AppTest.class );
}

/**
 * Rigourous Test :-)
 */

public void testApp()
{
	int num1=1;
	int num2=2;
	
	 int total= calculadora.sumar(num1, num2);
    assertTrue( total==3); 
}
}

