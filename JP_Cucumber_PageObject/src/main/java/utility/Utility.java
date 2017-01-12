package utility;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {

			String time = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
			new File("./Screenshots/").mkdirs();
			FileOutputStream out = new FileOutputStream("./Screenshots/" + screenshotName + time + ".png");
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}
}
