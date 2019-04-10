package com.mcy.threats;
/*class MyTask{
	void executeTask()
	{
		for(int doc = 1;doc<=10;doc++)
		{
			System.out.println("@@Printing Document #"+doc+" - Printer2");
		}
	}
}*/
class CA{}

//MyTask IS-A thread
//class MyTask extends CA,Thread{ is not supported
class MyTask extends CA implements Runnable{
	@Override
	public void run()
	{
		for(int doc = 1;doc<=10;doc++)
		{
			System.out.println("@@Printing Document #"+doc+" - Printer2");
		}
	}
}


public class Threads {

	//main methods represents main thread
	public static void main(String[] args) {
		//whatevet we write in here will be executed by main thread
		//threads always execute the jobs in a sequence
		
		//Job1
		System.out.println("=====Application Started=======");
		 
		//Job2
		//MyTask task = new MyTask();//Child Thread
		//task.start(); // start shall internally execute run method
		
		Runnable r = new MyTask();
		Thread task = new Thread(r);
		task.start();
		
		//Job3
		for(int doc = 1;doc<=10;doc++)
		{
			System.out.println("Printing Document #"+doc+" - Printer1");
		}
		
		//Till Job2 is not finished, below written jobs are waiting and are not executed.
		//In case Job2 is a long running operation.i.e. several documents are suppose to be printed
		//In such a use case OS/JVM shall give a message that app is not responding.
		//Some sluggish behaviour in app can be observed --> App seems to hang
		
		//Now, main and MyTask are executing both parallely or concurrently
		
		//Job3
		
		System.out.println("=====Application Finished=======");
	}

}
