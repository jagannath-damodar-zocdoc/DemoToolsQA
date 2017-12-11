package com.toolsqa.listeners;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.base.CaseFormat;

public class Listeners implements ISuiteListener , ITestListener , IInvokedMethodListener{

	@Override
	public void onFinish(ISuite arg0) {		
		System.out.println("Finished execution of Test Suite ="+ arg0.getName());
		Reporter.log("Finished execution of Test Suite ="+ arg0.getName());
	}
	
	@Override
	public void onStart(ISuite arg0) {		
		System.out.println("Started execution of Test Suite ="+ arg0.getName());	
		Reporter.log("Started execution of Test Suite ="+ arg0.getName());
	}

	/////////////////////////////////////////////////////////////////////
	
	@Override
	public void onFinish(ITestContext arg0) {		
		System.out.println("Finished execution of Test ="+ arg0.getName());
		Reporter.log("Finished execution of Test ="+ arg0.getName() );		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("Started execution of Test ="+ arg0.getName());	
		Reporter.log("Started execution of Test ="+ arg0.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		// do not do anything
	}

	@Override
	public void onTestFailure(ITestResult arg0) {		
		System.out.println("Test Failed . Method name = "+ arg0.getName() );	
		Reporter.log("Test Failed . Method name = "+ arg0.getName()  );		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Skipped . Method name = "+ arg0.getName()  );	
		Reporter.log("Test Skipped . Method name = "+ arg0.getName()  );
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Started . Method name = "+ arg0.getName()  );	
		Reporter.log("Test Started . Method name = "+ arg0.getName()  );		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Success . Method name = "+ arg0.getName()  );	
		Reporter.log("Test Success . Method name = "+ arg0.getName()  );
					
	}
	
	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		System.out.println("Method execution is complete . Method name = "+ arg0.getTestMethod() );	
		Reporter.log("Method execution is complete . Method name = "+ arg0.getTestMethod() );		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		System.out.println("Method execution started . Method name = "+ arg0.getTestMethod() );	
		Reporter.log("Method execution started . Method name = "+ arg0.getTestMethod() );
	}
	
	// unused as of now
	// not so useful as object returned and object references displayed.
	private void printTestcaseResults(ITestResult arg0){		
		if (arg0.getParameters().length != 0 ){		
			String params = null ;			 
			for (Object parameter : arg0.getParameters()) {			
				params += parameter.toString() + " , " ;				
			}	
			Reporter.log("Parameters for testcase = "+ params);
			System.out.println("Parameters for testcase = "+ params);
			
			String status = null ;			
			switch(arg0.getStatus() ){			
				case ITestResult.SUCCESS : 
					status = "Pass" ;
				case ITestResult.FAILURE:
					status = "Fail";
				case ITestResult.SKIP:
					status = "Skip";				
			}			
			Reporter.log("Test case status = "+ status);
			System.out.println("Test case status = "+ status);
		}
		
	}

} // end of listener class

