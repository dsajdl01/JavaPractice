package tests.task2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *  unit testing for EventConsumerWrapper class
 * 
 *  @author David Sajdl
 *  @date 05/07/2015
 */
public class EventConsumerWrapperTest {

    private String[] t = {"INITIAL", "CREATING", "CREATED", "CLOSING", "CLOSED"};
	EventConsumerWrapperGenesis ecwTemp;
	EventConsumerWrapper ecw;
	EventTracker et;
	Events ev;
	TheLocker lock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		
		ecwTemp = new EventConsumerWrapperGenesis();
		ecw = new EventConsumerWrapper(ecwTemp);
		et = new EventTracker();
		ev = new Events(t[0]);
		lock = new TheLocker();
	}

	@After
	public void tearDown() throws Exception {
		ecwTemp = null;
		ecw = null;
		et = null;
		lock = null;
	}
	/**
	 * Testing consumeEvent() method with one event
	 * and sending type with ascending order
	 */
	@Test
	public void test_consumeEvent_inOrder(){
		ecw.consumeEvent(ev);
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",1, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",1 ,ecwTemp.getNumberOfStoredEvents());
		ev.setType(t[1]);
		ecw.consumeEvent(ev);
		assertEquals("Wrong Answer", t[1], ecwTemp.getLastReceivedEventType());
		ev.setType(t[2]);
		ecw.consumeEvent(ev);
		assertEquals("Wrong Answer", t[2], ecwTemp.getLastReceivedEventType());
		ev.setType(t[3]);
		ecw.consumeEvent(ev);
		assertEquals("Wrong Answer", t[3], ecwTemp.getLastReceivedEventType());
		ev.setType(t[4]);
		ecw.consumeEvent(ev);
		// all typse are sent, the size of the map needs to decrease to zero
		assertEquals("Wrong Answer", t[4], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",0, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",1 ,ecwTemp.getNumberOfStoredEvents());
	}
	/**
	 * Testing consumeEvent() method with two events
	 * and sending type with mixing order
	 */
	@Test
	public void test_consumeEvent_inMix(){
		ecw.consumeEvent(ev);
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		Events e = new Events(t[1]);
		ecw.consumeEvent(e);
		// as new event type CREATING, it to wait for INITIAL type
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",2, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",1 ,ecwTemp.getNumberOfStoredEvents());
		e.setType(t[0]);
		ecw.consumeEvent(e);
		// it is sent event type initial  
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",2, ecw.countTrackerHasSize());
		// so the size of the map increase to 2
		assertEquals("Wrong Answer",2 ,ecwTemp.getNumberOfStoredEvents());
		
		e.setType(t[3]);
		ecw.consumeEvent(e);
		// it is sent event type CLOSING but CREATED has not been sent so current 
		// receive type remind same INITIAL
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",2, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",2 ,ecwTemp.getNumberOfStoredEvents());
		
		e.setType(t[2]);
		ecw.consumeEvent(e);
		// it is sent event type CREATED  
		assertEquals("Wrong Answer", t[2], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",2, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",2 ,ecwTemp.getNumberOfStoredEvents());
		
		e.setType(t[4]);
		ecw.consumeEvent(e);
		// it is sent event type CLOSED so all types for event 'e' was sent 
		// therefore the map needs to decrease by 1 as event is removed
		assertEquals("Wrong Answer", t[4], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",1, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",2 ,ecwTemp.getNumberOfStoredEvents());
	}
	/**
	 * Testing consumeEvent() method with three event
	 * and sending type with descending order
	 */
	@Test
	public void test_consumeEven_DescendingOrder(){
		Events e1 = new Events(t[4]);
		Events e2 = new Events(t[2]);
		// sent e1 CLOSED so track has 1 but it was not sent to store so 
		// store size is 0
		ecw.consumeEvent(e1);
		assertNull(ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",1, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",0 ,ecwTemp.getNumberOfStoredEvents());
		// sent CREATED so track has 2 but it was not sent to store so 
		// store size is still 0
		ecw.consumeEvent(e2);
		assertNull(ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",2, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",0 ,ecwTemp.getNumberOfStoredEvents());
		// adding third event type INITIAL so track size is 3 and it is sent
		// so store size has 1
		ecw.consumeEvent(ev);
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",3, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",1 ,ecwTemp.getNumberOfStoredEvents());
		// e1 type CLOSING so track size is 3 and it is not sent
		// so store size has still 1
		e1.setType(t[3]);
		ecw.consumeEvent(e1);
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",3, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",1 ,ecwTemp.getNumberOfStoredEvents());
		// e1 type CREATED so track size is 3 and it is not sent
		// so store size has still 1 and last received event is INITIAL 
		e1.setType(t[2]);
		ecw.consumeEvent(e1);
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",3, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",1 ,ecwTemp.getNumberOfStoredEvents());
		// e2 type INITIAL so track size is 3 and it is sent
		// so store size change to 2 and receive event is INITIAL 
		e2.setType(t[0]);
		ecw.consumeEvent(e2);
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",3, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",2 ,ecwTemp.getNumberOfStoredEvents());
		// e2 type CREATING so track size is still 3 and it is sent
		// so store size stay at 2 and receive event is CREATING
		e2.setType(t[1]);
		ecw.consumeEvent(e2);
		assertEquals("Wrong Answer", t[1], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",3, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",2 ,ecwTemp.getNumberOfStoredEvents());
		// e2 type CLOSING so track size is still 3, type CREATED was already sent as the first one,
		//it is sent and store size stay at 2 and receive event is CLOSING
		e2.setType(t[3]);
		ecw.consumeEvent(e2);
		assertEquals("Wrong Answer", t[3], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",3, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",2 ,ecwTemp.getNumberOfStoredEvents());
		// e1 type CREATING so track size is still 3,
		//it is not sent and store size stay at 2 and last received event is CLOSING
		e1.setType(t[1]);
		ecw.consumeEvent(e1);
		assertEquals("Wrong Answer", t[3], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",3, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",2 ,ecwTemp.getNumberOfStoredEvents());
		// e1 type INITIAL so track will decrease by 1 to size is still 2 as e1 is deleted,
		//it is sent, store size will increase by 1 to 3 and last received event is INITIAL
		e1.setType(t[0]);
		ecw.consumeEvent(e1);
		assertEquals("Wrong Answer", t[0], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",2, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",3 ,ecwTemp.getNumberOfStoredEvents());
		// e2 type CREATED so track will decrease by 1 to size is still 1
		// as all types were sent and e2 is deleted,
		//it is sent, store size stay at 3 and last received event is CREATED
		e2.setType(t[4]);
		ecw.consumeEvent(e2);
		assertEquals("Wrong Answer", t[4], ecwTemp.getLastReceivedEventType());
		assertEquals("Wrong Answer",1, ecw.countTrackerHasSize());
		assertEquals("Wrong Answer",3 ,ecwTemp.getNumberOfStoredEvents());
	}
}