/**
* 
* Copyright (C) 2006-2009 Anton Gravestam.
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

#ifndef ops_ParticipantH
#define	ops_ParticipantH

#include <string>
#include "ThreadPool.h"
#include "Runnable.h"
#include "IOService.h"
#include "SerializableFactory.h"
#include <map>
#include "Topic.h"
#include "OPSConfig.h"
#include "OPSObjectFactory.h"
#include "DeadlineTimer.h"
#include "Error.h"



namespace ops
{
	//Forward declaration..
	class TopicHandler;

	class Participant : Runnable, Listener<int>, public Notifier<Error*>
	{
		friend class Subscriber;
	public:

		///By Singelton, one Participant per participantID
		static std::map<std::string, Participant*> instances;
		static Participant* getInstance(std::string domainID);
		static Participant* getInstance(std::string domainID, std::string participantID);

		void addTypeSupport(ops::SerializableFactory* typeSupport);

		Topic createTopic(std::string name);

		void run();

		void reportError(Error* err);

		//Deadline listener callback
		void onNewEvent(Notifier<int>* sender, int message);

		IOService* getIOService()
		{
			return ioService;
		}

	private:

		Participant(std::string domainID_, std::string participantID_);
		~Participant();

		OPSConfig* config;
		IOService* ioService;
		ThreadPool* threadPool;
		DeadlineTimer* aliveDeadlineTimer;

		///By Singelton, one TopicHandler per Topic (name) on this Participant
		std::map<std::string, TopicHandler*> topicHandlerInstances;
		//Visible to friends only
		TopicHandler* getTopicHandler(Topic top);

		std::string domainID;
		std::string participantID;

		bool keepRunning;

		__int64 aliveTimeout;

		//OPSObjectFactory* objectFactory;



	};

}
#endif