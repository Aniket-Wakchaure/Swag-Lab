package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	@FindBy(xpath = "//button[.='ADD TO CART']") private WebElement addToCartBtn;
	@FindBy(xpath = "//div[@class='inventory_item_name']")private WebElement  Products;
	@FindBy(xpath = "//button[.='<- Back']")private WebElement BackButton;
	@FindBy(xpath ="//a[.='Logout']" )private WebElement logOutBtn;
	@FindBy(xpath = "//button[.='Open Menu']")private WebElement menueBtn;
	@FindBy(id = "shopping_cart_container") private WebElement shoppingKart;
	@FindBy(xpath = "//button[.='REMOVE']")private WebElement removeBtn;
	
//Constructur
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getBackButton() {
		return BackButton;
	}


	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	public WebElement getProducts() {
		return Products;
	}


	public WebElement getLogOutBtn() {
		return logOutBtn;
	}


	public WebElement getMenueBtn() {
		return menueBtn;
	}


	public WebElement getShoppingKart() {
		return shoppingKart;
	}


	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	
	

}
