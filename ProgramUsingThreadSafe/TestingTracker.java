package tests.task2;

/**
 *  TestingTracket class tests EventTracker Class by printing 
 *  excepting result and then compare with outcome result
 *  
 *  @author David Sajdl
 *  @date 15/07/2015
 */
public class TestingTracker {

	public static void main(String[] args) {
		try {
			TheLocker l = new TheLocker();
			Events e = new Events("CREATING");
			EventTracker et = new EventTracker();
			et.addEvent(e,l);
			System.out.println("Excepteing counter 5 and is: " + et.getStoreCount());
			
			e.setType("INITIAL");
			et.addEvent(e, l);
			loopHelper(e,l,et);
			System.out.println("Excepteing counter 3 and is: " + et.getStoreCount());
			e.setType("CLOSING");
			et.addEvent(e, l);
			loopHelper(e,l,et);
			System.out.println("Excepteing counter 3 and is: " + et.getStoreCount());
			e.setType("CLOSED");
			et.addEvent(e, l);
			loopHelper(e,l,et);
			System.out.println("Excepteing counter 3 and is: " + et.getStoreCount());
			e.setType("CREATED");
			et.addEvent(e, l);
			loopHelper(e,l,et);
			System.out.println("Excepteing counter 0 and is: " + et.getStoreCount());
			
			TheLocker lc = new TheLocker();
			Events ev = new Events("CLOSED");
			et.addEvent(ev,lc);
			System.out.println("Excepteing counter 5 and is: " + et.getStoreCount());
			
		} catch (InterruptedException e){
				e.printStackTrace();
		} catch (UnknownTypeException ute){
				ute.printStackTrace();
		}
	}

	public static void loopHelper(Event e, TheLocker l, EventTracker et) throws InterruptedException{
		
		while (true){
			Event event = et.getNextSendableEvent(l);
			if(event == null) return;	
		}
	}
}
