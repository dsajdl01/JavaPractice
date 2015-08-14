package tests.task2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 *  @author David Sajdl
 *  @date 14/07/2015
 */
public class EventConsumerWrapperGenesis extends EventConsumerWrapper {

	private Map<String, Event> event;
	String consumerEventType = null;
	
	public EventConsumerWrapperGenesis(){
		event = Collections.synchronizedMap(new HashMap<String, Event>());
	}
	
	public EventConsumerWrapperGenesis(EventConsumerWrapperGenesis obj){
	}

	@Override
	public synchronized void consumeEvent(Event theEvent) {
		this.consumerEventType = theEvent.getEventType();
		String id = theEvent.getEventId();
		synchronized(event) {
			//checking if id exist in tracker or map
			if(!event.containsKey(id)){
				event.put(id, theEvent);
			}
		}
	}
	
	public synchronized int getNumberOfStoredEvents(){
		return event.size();
	}
	
	public synchronized String getLastReceivedEventType(){
		return this.consumerEventType;
	}
	
	public void printAllEvents(){
		synchronized(event){
			int count = 1;
			for(Map.Entry<String, Event> map: event.entrySet()){
				Event value =map.getValue();
				String date = getDate(value.getEventTimestemp());
				System.out.println(count +") Event ID: " + map.getKey()
						+ ", Event current type: " + value.getEventType()
						+ ", Event Date and time: " + date);
				count++;
			}
		}
	}
	
	private synchronized String getDate(Calendar cal){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		cal = Calendar.getInstance();
		return  dateFormat.format(cal.getTime());
	}
}
