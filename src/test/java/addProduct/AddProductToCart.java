package addProduct;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtilies.BaseClass;
import genericUtilies.FileUtility;
import genericUtilies.SeleniumUtility;
import objectRepo.LoginPage;
import objectRepo.ProductPage;

public class AddProductToCart extends BaseClass {
	@Test
	public  void addProduct() throws EncryptedDocumentException, IOException {
	FileUtility fu= new FileUtility();
	SeleniumUtility sn=new SeleniumUtility();
	String data = fu.readDataFromExel("Sheet1",1,1);
	ProductPage p=new ProductPage(wd);

	sn.findreqElement(wd, data);
	p.getAddToCartBtn().click();
	p.getBackButton().click();
	String data1 = fu.readDataFromExel("Sheet1",2,1);

	sn.findreqElement(wd, data1);
	p.getAddToCartBtn().click();
	p.getBackButton().click();
	
	
	
	
	}

}
