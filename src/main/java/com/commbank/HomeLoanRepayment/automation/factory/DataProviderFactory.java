package com.commbank.HomeLoanRepayment.automation.factory;

import com.commbank.HomeLoanRepayment.automation.dataprovider.ConfigDataProvider;

public class DataProviderFactory {

	public static ConfigDataProvider getConfigDataProvider() {
		return new ConfigDataProvider();
	}
}
