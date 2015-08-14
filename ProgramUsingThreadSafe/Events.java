package tests.task2;

import java.util.UUID;
import java.util.Calendar;

/**
 * 
 *  @author David Sajdl
 *  @date 41/07/2015
 */
public class Events implements Event{

	private String type;
	private String id;
	private Calendar cal;
	
	public Events(String type){
		this.setType(type);
		this.setId();
		this.setEventTimes();
	}
	private void setId(){
		UUID uid = UUID.randomUUID();
		this.id = uid.toString();
	}
	@Override
	public String getEventId() {
		return id;
	}

	public void setType(String type){
		this.type = type;
	}
	@Override
	public String getEventType() {
		return type;
	}

	private void setEventTimes(){
		Calendar calendar = Calendar.getInstance();
		this.cal = calendar;
	}
	@Override
	public Calendar getEventTimestemp() {
		return cal;
	}

}
