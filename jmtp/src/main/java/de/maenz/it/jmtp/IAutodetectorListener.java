package de.maenz.it.jmtp;

import jmtp.PortableDevice;

/**
 * 
 * @author maenz.torsten
 *
 */
public interface IAutodetectorListener
{

	public void newDevice(final PortableDevice portableDevice);
	
	public void removeDevice(final PortableDevice portableDevice);
	
}
