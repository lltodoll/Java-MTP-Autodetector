package de.maenz.it.jmtp;

import java.io.IOException;

import org.junit.Test;

import jmtp.PortableDevice;
import jmtp.PortableDeviceManager;

public class AutodetectorThreadTest
{

	@Test
	public void test() throws InterruptedException, IOException
	{
		IAutodetectorListener autodetectorListener = new IAutodetectorListener() {
			
			public void newDevice(PortableDevice portableDevice)
			{
				System.out.println("NewDevice: " + portableDevice);
			}

			@Override
			public void removeDevice(PortableDevice portableDevice)
			{
				System.out.println("RemovedDevice: " + portableDevice);
			}
		};
		
		AutodetectorThread autodetectorThread = new AutodetectorThread(autodetectorListener);
		autodetectorThread.start();
		
		Thread.sleep(50000);
	}

	
	@Test
	public void test2() throws InterruptedException, IOException
	{
		PortableDeviceManager portableDeviceManager = new PortableDeviceManager();
		for(PortableDevice portableDevice: portableDeviceManager.getDevices())
		{
			System.out.println(portableDevice.getFriendlyName());
		}
	}
}
