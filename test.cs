using System;

public class GFG{
	static public void Main() {
		int maxIndex = maximumIndex(3, 2);
		Console.WriteLine("Max Index: {0}", maxIndex);
	}
	
	static int maximumIndex(int maxSteps, int badIndex) {
	    int curIndex = 0;
	    int curStep = 1;
	    int tmp = curIndex;
	    while (curStep <= maxSteps) {
	        int nextIndex = curIndex + curStep;
	        
	        if (nextIndex != badIndex) {
	            curIndex = nextIndex;
	        }
	        tmp = curIndex;
	        curStep++;
	    }
	    return tmp;
	}
}
