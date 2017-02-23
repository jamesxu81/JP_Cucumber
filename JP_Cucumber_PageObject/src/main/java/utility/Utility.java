package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utility {
	
	//Screenshot

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {

			String time = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
			new File("./Screenshots/").mkdirs();
			BufferedImage scrFile = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
					.takeScreenshot(driver).getImage();
			ImageIO.write(scrFile, "PNG", new File("./Screenshots/" + screenshotName + time + ".png"));
			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}
	
	
	
	
		//Highlight Element
	
	public void highlightElement(WebElement element) {
		
	
		String originalStyle = element.getAttribute("style");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');", element);
		
		try {
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {}
		
		js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
		
	}
	

}
