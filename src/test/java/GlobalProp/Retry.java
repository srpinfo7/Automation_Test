package GlobalProp;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	
	int count=0;
	int maxCount=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
