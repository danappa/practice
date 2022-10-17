package com.crm.Generic_Utility;

import java.util.Random;

public class JavaUtility {
     /**
      * This method is used to get the random number
      * @return
      */
	public int getRandomNum()
	{
		Random ran=new Random();
		int RanNum=ran.nextInt(1000000);
		return RanNum;
	}
}
