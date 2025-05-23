package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1
	@DataProvider(name = "LoginData")
	public String[][] loginData() throws IOException {
		// String path= System.getProperty("user.dir") +
		// "//testData//data.xlsx";//taking xl file from testData

		// String filePath = System.getProperty("user.dir") +
		// "//testData//caldata.xlsx";

		String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testData

		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols];// created for two dimension array which can store the
																// data user and password

		for (int i = 1; i <= totalrows; i++) // 1 //read the data from xl storing in two deminsional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
			{
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
			}
		}
		return logindata;// returning two dimension array

	}

	// DataProvider 2

	@DataProvider(name = "ConfirmMsg")
	public String[][] confirmMsg() throws IOException {
		// String path= System.getProperty("user.dir") +
		// "//testData//data.xlsx";//taking xl file from testData

		// String filePath = System.getProperty("user.dir") +
		// "//testData//caldata.xlsx";

		String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testData

		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet2");
		int totalcols = xlutil.getCellCount("Sheet2", 1);

		String logindata[][] = new String[totalrows][totalcols];// created for two dimension array which can store the
																// data user and password

		for (int i = 1; i <= totalrows; i++) // 1 //read the data from xl storing in two deminsional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
			{
				logindata[i - 1][j] = xlutil.getCellData("Sheet2", i, j); // 1,0
			}
		}
		return logindata;// returning two dimension array

	}

	// DataProvider 3
	@DataProvider(name = "SearchProducts")
	public String[][] searchProducts() throws IOException {
		// String path= System.getProperty("user.dir") +
		// "//testData//data.xlsx";//taking xl file from testData

		// String filePath = System.getProperty("user.dir") +
		// "//testData//caldata.xlsx";

		String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testData

		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet3");
		int totalcols = xlutil.getCellCount("Sheet3", 1);

		String logindata[][] = new String[totalrows][totalcols];// created for two dimension array which can store the
																// data user and password

		for (int i = 1; i <= totalrows; i++) // 1 //read the data from xl storing in two deminsional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
			{
				logindata[i - 1][j] = xlutil.getCellData("Sheet3", i, j); // 1,0
			}
		}
		return logindata;// returning two dimension array

	}

	// DataProvider 4
	@DataProvider(name = "CompareProductName")
	public String[][] compareProductName() throws IOException {
		// String path= System.getProperty("user.dir") +
		// "//testData//data.xlsx";//taking xl file from testData

		// String filePath = System.getProperty("user.dir") +
		// "//testData//caldata.xlsx";

		String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testData

		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet4");
		int totalcols = xlutil.getCellCount("Sheet4", 1);

		String logindata[][] = new String[totalrows][totalcols];// created for two dimension array which can store the
																// data user and password

		for (int i = 1; i <= totalrows; i++) // 1 //read the data from xl storing in two deminsional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
			{
				logindata[i - 1][j] = xlutil.getCellData("Sheet4", i, j); // 1,0
			}
		}
		return logindata;// returning two dimension array

	}
	
	// DataProvider 5
		@DataProvider(name = "CompareProductNumber")
		public String[][] compareProductNumber() throws IOException {
			// String path= System.getProperty("user.dir") +
			// "//testData//data.xlsx";//taking xl file from testData

			// String filePath = System.getProperty("user.dir") +
			// "//testData//caldata.xlsx";

			String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testData

			ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

			int totalrows = xlutil.getRowCount("Sheet5");
			int totalcols = xlutil.getCellCount("Sheet5", 1);

			String logindata[][] = new String[totalrows][totalcols];// created for two dimension array which can store the
																	// data user and password

			for (int i = 1; i <= totalrows; i++) // 1 //read the data from xl storing in two deminsional array
			{
				for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
				{
					logindata[i - 1][j] = xlutil.getCellData("Sheet5", i, j); // 1,0
				}
			}
			return logindata;// returning two dimension array

		}
}