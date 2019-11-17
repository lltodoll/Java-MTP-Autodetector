package de.maenz.it.jmtp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jmtp.PortableDevice;
import jmtp.PortableDeviceManager;

/**
 * Detect all new devices which are connected on the windows pc or which are removed from pc.
 * 
 * @author maenz.torsten
 *
 */
public class AutodetectorThread extends Thread
{

	private Logger log = Logger.getLogger(this.getClass().getName());

	private IAutodetectorListener[] autodetectorListeners;
	private final long sleepTime;
	
	
	public AutodetectorThread(final IAutodetectorListener... autodetectorListeners)
	{
		this(1000, autodetectorListeners);
	}
	
	public AutodetectorThread(final long sleepTime, final IAutodetectorListener... autodetectorListeners)
	{
		this.sleepTime = sleepTime;
		this.autodetectorListeners = autodetectorListeners;
		this.setName(this.getClass().getSimpleName());
	}

	@Override
	public void run()
	{
		log.log(Level.INFO, "start watching thread for autodetection");
		
		List<PortableDevice> oldPortableDevices = getPortableDevices();
		List<PortableDevice> newPortableDevices = new ArrayList<>(0);
		
		log.log(Level.FINE, "Initial Portable Devices: {0}", oldPortableDevices);

		while (!Thread.currentThread().isInterrupted()) 
		{
			try
			{
				newPortableDevices = getPortableDevices();
				log.log(Level.FINE, "Portable Devices: {0}", newPortableDevices);

				if (oldPortableDevices.equals(newPortableDevices))
				{
					log.log(Level.FINE, "Devices are equals ...");
					oldPortableDevices = newPortableDevices;
				}
				else
				{
					List<PortableDevice> newDevices = new ArrayList<>(newPortableDevices);
					newDevices.removeAll(oldPortableDevices);

					for (PortableDevice portableDevice : newDevices)
					{
						for (IAutodetectorListener autodetectorListener : autodetectorListeners)
						{
							log.log(Level.FINE, "Open new device={0}", portableDevice);
							portableDevice.open();
							autodetectorListener.newDevice(portableDevice);
						}
					}
					
					List<PortableDevice> removedDevices = new ArrayList<PortableDevice>(oldPortableDevices);
					removedDevices.removeAll(newPortableDevices);
					
					for (PortableDevice portableDevice : removedDevices)
					{
						for (IAutodetectorListener autodetectorListener : autodetectorListeners)
						{
							autodetectorListener.removeDevice(portableDevice);
							log.log(Level.FINE, "Close device={0}", portableDevice);
							portableDevice.close();
						}
					}
					
					oldPortableDevices = newPortableDevices;
				}
				
				Thread.sleep(sleepTime);
			}
			catch (InterruptedException e)
			{
				log.log(Level.SEVERE, e.getMessage(), e);
				Thread.currentThread().interrupt();
			}
		}
	}

	private List<PortableDevice> getPortableDevices()
	{
		PortableDeviceManager portableDeviceManager = new PortableDeviceManager();
		PortableDevice[] portableDevices = portableDeviceManager.getDevices();
		List<PortableDevice> listDevices = new ArrayList<>(Arrays.asList(portableDevices));

		log.log(Level.FINE, "All Devices: {0}", listDevices.size());
		return listDevices;
	}

}
