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

/**
 *
 * @author Pieter De Rycke
 */
public interface PortableDeviceAudioObject extends PortableDeviceObject {
    String getTitle();
    String getArtist();
    String getAlbumArtist();
    String getAlbum();
    String getGenre();
    BigInteger getDuraction();
    Date getReleaseDate();
    int getTrackNumber();
    long getUseCount();
    
    void setTitle(String value);
    void setArtist(String value);
    void setAlbumArtist(String value);
    void setAlbum(String value);
    void setGenre(String value);
    void setDuration(BigInteger value);
    void setReleaseDate(Date value);
    void setTrackNumber(int value);
    void setUseCount(long value);
}
