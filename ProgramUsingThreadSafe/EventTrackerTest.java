package tests.task2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *  Unit testing for EventTracker Class
 *  
 *  @author David Sajdl
 *  @date 14/07/2015
 */
public class EventTrackerTest {

	 private String[] t = {"INITIAL", "CREATING", "CREATED", "CLOSING", "CLOSED"};
	 private EventTracker et;
	 private Events ev;
	 private TheLocker lock;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		this.et = new EventTracker();
		this.ev = new Events(t[0]);
		this.lock = new TheLocker();
	}

	@After
	public void tearDown() throws Exception {
		this.et = null;
		this.ev = null;
		this.lock = null;
	}

	@Test
	public void test_get_StoresCount() {
		assertEquals("Wrong Answer",5, et.getStoreCount());
		
	}
	
	@Test
	public void test_addEvent() throws InterruptedException{
		et.addEvent(ev, lock);
		assertNotNull( et.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",4, et.getStoreCount());
		
		ev.setType(t[4]); 
		et.addEvent(ev, lock);
		assertNull( et.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",4, et.getStoreCount());
		ev.setType(t[1]); 
		et.addEvent(ev, lock);
		assertNotNull( et.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",3, et.getStoreCount());
		
		ev.setType(t[3]); 
		et.addEvent(ev,lock);
		assertNull( et.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",3, et.getStoreCount());
		
		ev.setType(t[2]);
		et.addEvent(ev, lock);
		assertNotNull( et.getNextSendableEvent(lock));
		this.loopHelper(ev, lock, et);
		assertEquals("Wrong Answer",0, et.getStoreCount());
	}
	
	@Test
	public void test_addEventTwo() throws InterruptedException{
		Events event = new Events(t[0]);
		EventTracker evtr = new EventTracker();
		evtr.setFirstAsSent(event, lock);
		assertNotNull( evtr.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",4, evtr.getStoreCount());
		
		event.setType(t[1]);
		evtr.addEvent(event, lock);
		assertNotNull( evtr.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",3, evtr.getStoreCount());
		
		event.setType(t[2]);
		evtr.addEvent(event, lock);
		assertNotNull( evtr.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",2, evtr.getStoreCount());
		
		event.setType(t[3]);
		evtr.addEvent(event, lock);
		assertNotNull( evtr.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",1, evtr.getStoreCount());
		
		event.setType(t[4]);
		evtr.addEvent(event, lock);
		assertNotNull( evtr.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",0, evtr.getStoreCount());
		
	}
	
	@Test
	public void test_AddEventThree() throws InterruptedException{
		Events event = new Events(t[4]);
		EventTracker etr = new EventTracker();
		etr.addEvent(event, lock);
		assertNull( etr.getNextSendableEvent(lock));
		assertEquals("Wrong Answer",5, etr.getStoreCount());

		event.setType(t[3]);;
		etr.addEvent(event, lock);
		assertNull( etr.getNextSendableEvent(lock));
		this.loopHelper(event, lock, etr);
		assertEquals("Wrong Answer",5, etr.getStoreCount());
		
		event.setType(t[2]);;
		etr.addEvent(event, lock);
		assertNull( etr.getNextSendableEvent(lock));
		this.loopHelper(event, lock, etr);
		assertEquals("Wrong Answer",5, etr.getStoreCount());
		
		event.setType(t[1]);;
		etr.addEvent(event, lock);
		assertNull( etr.getNextSendableEvent(lock));
		this.loopHelper(event, lock, etr);
		assertEquals("Wrong Answer",5, etr.getStoreCount());
		
		event.setType(t[0]);;
		etr.addEvent(event, lock);
		assertNotNull( etr.getNextSendableEvent(lock));
		this.loopHelper(event, lock, etr);
		assertEquals("Wrong Answer",0, etr.getStoreCount());
	}

	public void loopHelper(Event e, TheLocker l, EventTracker et) throws InterruptedException{
		while (true){
			Event event = et.getNextSendableEvent(l);
			if(event == null)	return;
			
		}
	}

}