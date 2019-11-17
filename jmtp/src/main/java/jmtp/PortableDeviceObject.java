/*
 * Copyright 2007 Pieter De Rycke
 * 
 * This file is part of JMTP.
 * 
 * JTMP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or any later version.
 * 
 * JMTP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU LesserGeneral Public 
 * License along with JMTP. If not, see <http://www.gnu.org/licenses/>.
 */

package jmtp;

import java.math.BigInteger;
import java.util.Date;

import be.derycke.pieter.com.Guid;

/**
 *
 * @author Pieter De Rycke
 */
public interface PortableDeviceObject
{

	String getID();

	String getName();

	String getOriginalFileName();

	String getPath();

	boolean canDelete();

	boolean isHidden();

	boolean isSystemObject();

	boolean isDrmProtected();

	Date getDateModified();

	Date getDateCreated();

	Date getDateAuthored();

	PortableDeviceObject getParent();

	BigInteger getSize();

	String getPersistentUniqueIdentifier();

	String getSyncID();

	Guid getFormat();

	void setSyncID(String value); // TODO nog een exception kunnen gooien

	void delete();
}
