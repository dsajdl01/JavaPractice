Write a thread-safe class called EventConsumerWrapper which will be responsible for 
reordering events received, before sending those events in the correct order to another 
supplied class. Your class will be an implementation of the tests.task2.EventConsumer 
interface (supplied with these tests). 

Your class should also take another implementation of EventConsumer in its constructor 
to pass the reordered events to. 
The rules for reordering are as follows: 
   • The event ID will be a String represetation of a java.util.UUID. 
   • The event type will be a String with one of the following values: 
                        INITIAL, CREATING, CREATED, CLOSING, CLOSED 
   • An event may be received for any event ID and any event type at any time. 
   • Events which share the same ID must be in the following event type order before 
        being passed to the wrapped EventConsumer: 
                              INITIAL, CREATING, CREATED, CLOSING, CLOSED 
   • One event for each event type will be received for every event ID. 
   • Events must be sent as soon as they are received if they are in the correct order. For 
           example, if an INITIAL event type is recieved, it must be sent on immediately. 
           However, if a CREATED is then subsequently received for the same event ID, a 
           CREATING must be received before both the CREATING and CREATED events can be sent. 


Write a set of unit tests to test the functionality of your EventConsumerWrapper. 
