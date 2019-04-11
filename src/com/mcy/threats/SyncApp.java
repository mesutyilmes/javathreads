package com.mcy.threats;

class Printer {
	// synchronized void printDocuments(int numOfcopies,String docname)
	void printDocuments(int numOfcopies, String docname) {
		for (int i = 1; i <= numOfcopies; i++) {

			// try { Thread.sleep(1000); } catch (InterruptedException e)
			// {e.printStackTrace(); }

			System.out.println(">>Printing Document " + docname + " " + i);
		}
	}
}

class MyThread extends Thread {
	Printer pRef;

	MyThread(Printer p) {
		pRef = p;
	}

	@Override
	public void run() {
		synchronized (pRef) {
			pRef.printDocuments(10, "MyThreadDocument.pdf");
		}
	}
}

class YourThread extends Thread {
	Printer pRef;

	YourThread(Printer p) {
		pRef = p;
	}

	@Override
	public void run() {
		synchronized (pRef) {
			pRef.printDocuments(10, "YourThreadDocument.pdf");
		}
	}
}

public class SyncApp {

	// representing main thread
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=====Application Started=======");
		Printer printer = new Printer();
		// printer.printDocuments(10, "mesut.pdf");
		// We have only 1 single object of printer
		// If multiple threads are going to eork on the same single object we must
		// syncronize them
		MyThread mRef = new MyThread(printer);// is having reference to the printer object
		// scenario is that we have multiple thread working onb thme same printer object
		YourThread yRef = new YourThread(printer);
		mRef.start();
		yRef.start();

		/*
		 * try { mRef.join(); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 * 
		 * 
		 * try { yRef.join(); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		for (int b = 0; b < 1000; b++) {
			System.out.println(b);
		}

		System.out.println("=====Application Finished=======");
	}

}
