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
	private Event e;
	
	public EventConsumerWrapperGenesis(){
		event = Collections.synchronizedMap(new HashMap<String, Event>());
	}
	
	public EventConsumerWrapperGenesis(EventConsumerWrapperGenesis obj){
	}

	@Override
	public synchronized void consumeEvent(Event theEvent) {
		this.e = theEvent;
		String type = theEvent.getEventType();
		String id = theEvent.getEventId();
		synchronized(event) {
			if(event.containsKey(id)){
				System.out.println(id + ", "+type);
			} else {
				event.put(id, theEvent);
			}
		}
	}

	public Event currentReceivedEvent(){
		return this.e;
	}
	public void printAllEvents(){
		synchronized(event){
			for(Map.Entry<String, Event> map: event.entrySet()){
				Event value =map.getValue();
				String date = getDate(value.getEventTimestemp());
				System.out.println("Event ID: " + map.getKey()
						+ ", Event current type: " + value.getEventType()
						+ ", Event Date and time: " + date);
			}
		}
	}
	private String getDate(Calendar cal){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		cal = Calendar.getInstance();
		return  dateFormat.format(cal.getTime());
	}
}
