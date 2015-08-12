package tests.task2;

public class TheLocker {

	private boolean isLock = false;
	private Thread lockedBy = null;
	private int lockCounter = 0;
	
	// to lock the thread 
	public synchronized void lock() throws InterruptedException{
		Thread collingThread = Thread.currentThread();
		// if islock is true and it is not current thread then let other thread wait
		while(isLock && lockedBy != collingThread){
			wait();
		}
	// if islock is true and current thread is not then set islock true, get current thread and counter + 1
		// or if islock is false and is current thread then counter + 1 
		isLock = true;
		lockedBy = collingThread;
		lockCounter++;
	}
	// to unlock the thread
	public synchronized void unLock(){
		// if thread is current then counter - 1
		if(Thread.currentThread() == this.lockedBy){
			lockCounter--;
		// if thread is current and counter is zero then unlock the lock
			if(lockCounter == 0){
				isLock = false;
				notify();
			}
		}
	}
}
