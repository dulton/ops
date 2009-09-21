#ifndef pizza_CapricosaDataPublisher_h
#define pizza_CapricosaDataPublisher_h

#include "Publisher.h"
#include "Topic.h"
#include "OPSObject.h"
#include "CapricosaData.h"
#include <string>

namespace pizza {



class CapricosaDataPublisher : public ops::Publisher 
{
    
public:
    CapricosaDataPublisher(ops::Topic<CapricosaData> t)
        : ops::Publisher(ops::Topic<>(t.GetName(), t.GetPort(), t.GetTypeID(), t.GetDomainAddress()))
    {


    }
    
    ~CapricosaDataPublisher(void)
    {
    }
    
    void write(CapricosaData* data)
    {
        ops::Publisher::write(data);

    }
    /*
    ops::AckData writeReliable(CapricosaData* data, std::string destinationIdentity)
    {
        return ops::Publisher::writeReliable(data, destinationIdentity);

    }
    */
    

};


}


#endif