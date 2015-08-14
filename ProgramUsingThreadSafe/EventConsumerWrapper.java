package tests.task2;
/**
 * 
 *  @author David Sajdl
 *  @date 05/07/2015
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import tests.task2.EventTracker;

public class EventConsumerWrapper implements EventConsumer{
	
	private EventConsumerWrapper ecwrapper;
	private Map<String, EventTracker> tracker;
	
	
	public EventConsumerWrapper(){}
	
	public EventConsumerWrapper(EventConsumerWrapper obj){
		this.ecwrapper = obj;
		tracker = Collections.synchronizedMap(new HashMap<String, EventTracker>());
	}

	@Override
	public synchronized void consumeEvent(Event theEvent) {
	
		try {
				// get id and type
				String type = theEvent.getEventType();
				String id = theEvent.getEventId();
				EventTracker et;
				synchronized(tracker) {
					//checking if id exist in tracker or map
					if(tracker.containsKey(id)){
						et = tracker.get(id);
					} else {
						et = new EventTracker();
						tracker.put(id, et);
					}
				}
				
				TheLocker locker = new TheLocker();	
				locker.lock();
				// add or update eventTracker
				if(type.equals("INITIAL")){
					et.setFirstAsSent(theEvent, locker);
				} else {
					et.addEvent(theEvent, locker);
				}
				
				// check if next event is available to be sent
				boolean toSent = true;
				while (toSent){
					Event event = et.getNextSendableEvent(locker);
					if(event == null){
						toSent = false;
					} else {
						this.ecwrapper.consumeEvent(event);
					}
				}
				locker.unLock();	
				// remove the event from the tracker if all the events types have been sent
				synchronized(tracker){ 
					if(et.getStoreCount() == 0){
						tracker.remove(id);
					}
				}
		// if any errors occur catch the error
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// get tracker size 
	//it is just for unit test if event object is removed when all types are sent
	public synchronized int countTrackerHasSize(){
		return tracker.size();
	}
}
