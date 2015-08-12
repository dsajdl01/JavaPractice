package tests.task2;

/**
 * 
 *  @author David Sajdl
 *  @date 05/07/2015
 */
public class EventTracker {
	public static enum status { NOT_RECIEVE, STORED, SENT }
	private int countEvent;
	private Event[] container;
	private status[] container_statuses;
	
	public EventTracker(){
		this.countEvent = 5;
		this.container = new Event[5];
		this.container_statuses = new status[] {status.NOT_RECIEVE, status.NOT_RECIEVE, status.NOT_RECIEVE, status.NOT_RECIEVE, status.NOT_RECIEVE };		
	}
	// method to change status only for INITIAL type event
	public void setFirstAsSent(TheLocker lock) throws InterruptedException{
		lock.lock();
		if(container_statuses[0] == status.NOT_RECIEVE){
			container_statuses[0] = status.SENT;
		}
		lock.unLock();
		// else only if the method is called in wrong order
	}
	// method to change status events type to STORED 
	public void addEvent(Event e, TheLocker lock) throws InterruptedException{
		lock.lock();
		switch(e.getEventType()){
			case "INITIAL":
				container_statuses[0] = status.STORED;
				container[0] = e;
				break;
			case "CREATING":
				container_statuses[1] = status.STORED;
				container[1] = e;
				break;
			case "CREATED":
				container_statuses[2] = status.STORED;
				container[2] = e;
				break;
			case "CLOSING":
				container_statuses[3] = status.STORED;
				container[3] = e;
				break;
			case "CLOSED":
				container_statuses[4] = status.STORED;
				container[4] = e;
				break;
			default:
				System.out.println("Unknown evene type: " + e.getEventType());
				// or to throw new exception
				break;
				
		}
		lock.unLock();
	}
	// method to check if the event can be sent
	public Event getNextSendableEvent(TheLocker lock) throws InterruptedException{
		lock.lock();
		for(int i = 0; i < container_statuses.length; i++){
			if(container_statuses[i] == status.NOT_RECIEVE){
				return null;
			} else if (container_statuses[i] == status.STORED){
				countEvent --;
				container_statuses[i] = status.SENT;
				return container[i];
			}
		}
		lock.unLock();
		return null;
	}
	//method to get number how many event needs to be sent
	public synchronized int getStoreCount(){
		return this.countEvent;
	}
}
