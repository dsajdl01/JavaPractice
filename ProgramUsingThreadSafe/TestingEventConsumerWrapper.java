package tests.task2;
/**
 *  TestingEventConsumerWrapper class tests EventConsumerWrapper Class 
 *  by printing excepting result and then compare with outcome result
 *  
 *  @author David Sajdl
 *  @date 15/07/2015
 */
public class TestingEventConsumerWrapper {

	public static void main(String[] args) {
		

		EventConsumerWrapperGenesis tempEcw = new EventConsumerWrapperGenesis();
		EventConsumerWrapper ecw = new EventConsumerWrapper(tempEcw);
		Events e = new Events("INITIAL");
		Events e1 = new Events("CREATING");
		
		System.out.println("Test 1:");
		System.out.println("Adding event with type: INITIAL");
		ecw.consumeEvent(e);
		System.out.println("Excepted type: INITIAL and is: " + tempEcw.getLastReceivedEventType());
		System.out.println("only 1 event is excepted with type INITIAL:");
		tempEcw.printAllEvents();
		System.out.println("Excepted traker size 1 and is: " + ecw.countTrackerHasSize());
		
		System.out.println("\nTest 2:");
		System.out.println("Adding another event2 with type: CRAETING");
		ecw.consumeEvent(e1);
		System.out.println("Excepted type: INITIAL and is: " + tempEcw.getLastReceivedEventType());
		System.out.println("only 1 event is excepted with type INITIAL:");
		tempEcw.printAllEvents();
		System.out.println("Excepted traker size 2 and is: " + ecw.countTrackerHasSize());
		
		System.out.println("\nTest 3:");
		System.out.println("Changing state of type event to type: CRAETING");
		e.setType("CREATING");
		ecw.consumeEvent(e);
		System.out.println("Excepted type: CREATING and is: " + tempEcw.getLastReceivedEventType());
		System.out.println("only 1 event is excepted with type CREATING:");
		tempEcw.printAllEvents();
		System.out.println("Excepted traker size 2 and is: " + ecw.countTrackerHasSize());
		
		System.out.println("\nTest 4:");
		System.out.println("Changing state of type event 2 to type: INITIAL");
		e1.setType("INITIAL");
		ecw.consumeEvent(e1);
		System.out.println("Excepted type: INITIAL and is: " + tempEcw.getLastReceivedEventType());
		System.out.println("only 2 event are excepted with types INITIAL and CREATING:");
		tempEcw.printAllEvents();
		System.out.println("Excepted traker size 2 and is: " + ecw.countTrackerHasSize());
		
		System.out.println("\nTest 5:");
		System.out.println("Changing state of type event 2 to type: CLOSED");
		e1.setType("CLOSED");
		ecw.consumeEvent(e1);
		System.out.println("Excepted type: INITIAL and is: " + tempEcw.getLastReceivedEventType());
		System.out.println("only 2 event are excepted with types CLOSED and CREATING:");
		tempEcw.printAllEvents();
		System.out.println("Excepted traker size 2 and is: " + ecw.countTrackerHasSize());
		
		System.out.println("\nTest 6:");
		System.out.println("Changing state of type event 2 to type: CLOSING");
		e1.setType("CLOSING");
		ecw.consumeEvent(e1);
		System.out.println("Excepted type: INITIAL and is: " + tempEcw.getLastReceivedEventType());
		System.out.println("only 2 event are excepted with types CLOSING and CREATING:");
		tempEcw.printAllEvents();
		System.out.println("Excepted traker size 2 and is: " + ecw.countTrackerHasSize());
		
		System.out.println("\nTest 7:");
		System.out.println("Changing state of type event 2 to type: CREATED");
		e1.setType("CREATED");
		ecw.consumeEvent(e1);
		System.out.println("Excepted type: CREATED and is: " + tempEcw.getLastReceivedEventType());
		System.out.println("only 2 event are excepted with types CREATED and CREATING:");
		tempEcw.printAllEvents();
		System.out.println("Excepted traker size 1 and is: " + ecw.countTrackerHasSize());
		System.out.println("\n- - - - - - - - - - - END - - - - - - - - - - " );

	}

}
