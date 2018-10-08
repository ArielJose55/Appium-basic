package core.calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculadora {

	public static AppiumDriver<MobileElement> driver; //Este driver es el que contralara los eventos de la automatizacion
	DesiredCapabilities capabilities = new DesiredCapabilities(); //caracteristicas de la automatizacion

//	private ReaderExcel reader;
//	private WriteExcel writer;
//	
//	public TestCalculadora() {
//		try {
//			reader = new ReaderExcel();
//			writer = new WriteExcel(reader.getWorkbook());
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.exit(0);
//		}
//	}
	
	@BeforeMethod
	public void setUpAppium() throws MalformedURLException, InterruptedException {
		String packageName = "com.google.android.calculator"; //Paquete principal de la aplicacion a automatizar
		String URL = "http://127.0.0.1:4723/wd/hub"; //IP y puerto de Appium
		String activityName = "com.android.calculator2.CalculatorGoogle"; //Nombre de la actividad (o vista) en donde empezara la automatizacion
		
//		String activityName = "org.chromium.chrome.browser.document.ChromeLauncherActivity";
//		String packageName = "com.android.chrome";
//		String URL = "http://127.0.0.1:4723/wd/hub";
		
		capabilities.setCapability("deviceName", "Moto G (4)"); //No es obligatorio que este nombre coincida
		capabilities.setCapability("udid", "ZY3226DRP3"); //Serial del dispositivo, se obtiene activando la depuración USB y con el comando adb devices
		capabilities.setCapability("platformVersion", "7.0"); //No es obligatorio que la version coincida
		capabilities.setCapability("platformName", "Android"); //Nombre del sistema operativo
		capabilities.setCapability("appPackage", packageName);
		capabilities.setCapability("appActivity", activityName);
		driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@AfterTest
	public void CleanUpAppium() {
		driver.quit();
	}

	@Test
	public void mytest() throws InterruptedException {
		
		Thread.sleep(1000L);
		
//		try {
//			List<Operation> listOperation = reader.getData();
//			int row = 0;
//			for(Operation operation : listOperation) {
//				writerNumber(operation.getNumberOne());
//				writeOperation(operation.getOperation());
//				writerNumber(operation.getNumberTwo());
//				writeOperation("=");
//				writerResult(row);
//				writeOperation("DEL");
//				row++;
//			}
//			reader.close();
//			writer.flush();
//		}catch (Exception ex) {
//			System.out.print("Se presento Excepción " + ex);
//		}	
	}
	
	public void writerResult(int row) {
		
//		int column = 3;
//		
//		MobileElement viewElement = driver.findElement(By.id(DigitesPath.TEXT_RESULT));
//
//		String text = viewElement.getAttribute("text");
//		
//		writer.write(column, row, text);
		
	}
	
	private void writerNumber(int number) throws InterruptedException{
		
		int[] digitos = getDigits(number);
		
		for(int digit : digitos) {
			writerDigit(digit);
		}
	}
	
	private void writerDigit(int digit) {
		
		String path;
		switch (digit) {
			case 1:
				path = DigitesPath.UNO;
				break;
			case 2:
				path = DigitesPath.DOS;
				break;
			case 3:
				path = DigitesPath.TRES;
				break;
			case 4:
				path = DigitesPath.CUATRO;
				break;
			case 5:
				path = DigitesPath.CINCO;
				break;
			case 6:
				path = DigitesPath.SEIS;
				break;
			case 7:
				path = DigitesPath.SIETE;
				break;
			case 8:
				path = DigitesPath.OCHO;
				break;
			case 9:
				path = DigitesPath.NUEVE;
				break;
			case 0:
				path = DigitesPath.CERO;
				break;	
			default:
				throw new RuntimeException("Digito no valido" + digit);
		}
		
		driver.findElement(By.id(path)).click();
	}
	
	private int [] getDigits(int number) {
		String numberString = String.valueOf(number);
		char [] digitosChar = numberString.toCharArray();
		int []digitos = new int[digitosChar.length];
		int i = 0;
		for(char ch : digitosChar) {
			digitos[i++] = Character.getNumericValue(ch);
		}
		return digitos;
	}
	
	private void writeOperation(String operation) throws InterruptedException{
		String path;
		
		if(operation.compareTo("*") == 0) {
			path = DigitesPath.MULTIPLICACION;
		}else if(operation.compareTo("/") == 0) {
			path = DigitesPath.DIVISION;
		}else if(operation.compareTo("-") == 0){
			path = DigitesPath.RESTA;
		}else if(operation.compareTo("+") == 0) {
			path = DigitesPath.SUMA;
		}else if(operation.compareTo("DEL") == 0){
			path = DigitesPath.BORRAR;
		}else {
			path = DigitesPath.RESULTADO;
		}
		driver.findElement(By.id(path)).click();
	}
}
