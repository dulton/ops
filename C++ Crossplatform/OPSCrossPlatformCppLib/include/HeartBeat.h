/**
* 
* Copyright (C) 2006-2009 Anton Gravestam.
*
* This notice apply to all source files, *.cpp, *.h, *.java, and *.cs in this directory 
* and all its subdirectories if nothing else is explicitly stated within the source file itself.
*
* This file is part of OPS (Open Publish Subscribe).
*
* OPS (Open Publish Subscribe) is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.

* OPS (Open Publish Subscribe) is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with OPS (Open Publish Subscribe).  If not, see <http://www.gnu.org/licenses/>.
*/

//Auto generated OPS-code. DO NOT MODIFY!

#ifndef opsHeartBeat_h
#define opsHeartBeat_h

#include "OPSObject.h"
#include <string>
#include <vector>



namespace ops
{
class HeartBeat :
	public ops::OPSObject
{
public:
	
    char messageType;
    char endianness;
    int highestSegment;
    int port;
    __int64 qosMask;
    __int64 highestPublicationID;
    std::string subscriberID;
    std::string topicName;
    std::string topLevelKey;
    std::string address;
    

    HeartBeat()
        : ops::OPSObject()
    {
        
        messageType = 0;
        endianness = 0;
        highestSegment = 0;
        port = 0;
        qosMask = 0;
        highestPublicationID = 0;
        subscriberID = "";
        topicName = "";
        topLevelKey = "";
        address = "";
        

    }
    std::string GetTypeID()
    {
        return "ops.HeartBeat";
    }

    ~HeartBeat(void)
    {
        
    }
    
};
}

#endif
