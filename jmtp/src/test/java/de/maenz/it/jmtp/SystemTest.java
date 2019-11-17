package de.maenz.it.jmtp;

import static org.junit.Assert.*;

import org.junit.Test;

public class SystemTest
{

	@Test
	public void test()
	{
		String jvm = System.getProperty("sun.arch.data.model");
		System.out.println(jvm);
	}

}
