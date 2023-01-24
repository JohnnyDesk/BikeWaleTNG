package com.util;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v106.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Locator;
import com.base.TestBase;
import com.base.WaitFor;
import com.core.Keyword;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakeAScreenShot extends TestBase {

	@Test
	public static void usingAshot() {
		AShot as = new AShot();
		as.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		Screenshot sc = as.takeScreenshot(Keyword.driver);
		BufferedImage bf = sc.getImage();
		File file = new File("ScreenShotByAShot.jpg");
		try {
		ImageIO.write(bf, "jpg", file);
		}catch (IOException e) {
			System.err.println("Unable to take screenshot");
		}
	}
}