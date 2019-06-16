import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClasseTeste {
	static WebDriver driver;
	
	//@BeforeClass
	public static void configurar_BuscasDoGoogle() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com.br");
	}
	
	//@BeforeClass
	public static void configurarTeste2_LimiteCotaViagem() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://economia.uol.com.br/cotacoes");
	}
	
	//@BeforeClass
	public static void configurarTeste3_PassagemMaisBarata() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.tripadvisor.com.br/");
	}
	
	//@BeforeClass
	public static void configurarTeste4_Campeonatos() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://esporte.uol.com.br/");
	}
	
	//@BeforeClass
	public static void configurarTeste3_1_DiferencaPassagens() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.tripadvisor.com.br/CheapFlightsSearchResults-g303631-a_airport0.RIO-a_airport1.SAO-a_cos.0-a_date0.20190630-a_date1.20190707-a_formImp.bddde877__2D__30f3__2D__4cee__2D__9559__2D__f5980f8cca8b__2E__400-a_nearby0.no-a_nearby1.no-a_nonstop.no-a_pax0.a-a_travelers.1-Sao_Paulo_State_of_Sao_Paulo.html");
	}
	
	@Test
	public void executeTeste() {
		System.out.println("Realizando teste...");
		
	}
	
	//@Test
	public void buscaGoogle() {
		
		WebElement input = driver.findElement(By.name("q"));
		input.sendKeys("1");
		WebElement button = driver.findElement(By.className("gNO89b"));
		button.submit();
	}
	
	//@Test
	public void buscaGoogleLoop() {
		for (int i = 0; i < 100; i ++) {
			WebElement input = driver.findElement(By.name("q"));
			input.sendKeys(Integer.toString(i + 1));
			WebElement button = driver.findElement(By.className("gNO89b"));
			button.submit();
			driver.navigate().back();
		}
	}
	
	//@Test
	public void cambioUol() {
		WebElement limiteCotaDolarTurismo = driver.findElement(By.cssSelector("body > section.currency-exchange > div.container > div > div:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(3) > a"));
		System.out.println("Cota do dólar turismo usado em viagens: " + limiteCotaDolarTurismo.getText());
		WebElement button = driver.findElement(By.className("final-term"));
		button.click();
		WebElement input = driver.findElement(By.className("input-term"));
		input.sendKeys("KWD");
		button = driver.findElement(By.className("selected-term"));
		button.click();
	}
	
	//@Test
	public void tripAdvisorTesteDiferencaPrecos() {
		System.out.println("Acessada a pagina...");
		WebElement modal = driver.findElement(By.cssSelector("#c_FL_PopupCFSR"));
		WebElement close = driver.findElement(By.cssSelector("#c_FL_PopupCFSR > div > div.overlays-pieces-CloseX__close--7erra.overlays-pieces-CloseX__inverted--2vrVh"));
		close.click();
		
		WebElement check = driver.findElement(By.cssSelector("#MAIN > div > div.flights-search-results-SearchContainer__centerColumn--1CrLy.scrollAdMain.withLeftRail > div > div.ui_column.is-3.is-shown-at-widescreen > div > div > div > div > div:nth-child(2) > div > label > div > span > span > div > span.flights-search-results-filters-FlightSearchFilters__secondaryText--1BkaK.flights-search-results-filters-FlightSearchFilters__price--3ftvF"));
		System.out.println(check.getText());
		
	}
	
	//@Test
	public void tripAdivsorTestePassagemMaisBarata() throws InterruptedException {
		
		WebElement button = driver.findElement(By.cssSelector("#component_4 > div > div > div > span.ui_column.is-4-mobile.brand-quick-links-QuickLinkTileItem__quickLinkTileItem--zKAkR.brand-quick-links-QuickLinkTileItem__customizedColForTablet--1ql_j.brand-quick-links-commonStyles__order-flights--3Ww9c"));
		button.click();
		
		
		
		WebElement boxFirst = driver.findElement(By.cssSelector("#component_3 > div > div.flights-ufl-fare-cards-FareCardsGroup__centeredContainer--2C4lD > div:nth-child(1)"));
		WebElement firstValue = driver.findElement(By.cssSelector("#component_3 > div > div.flights-ufl-fare-cards-FareCardsGroup__centeredContainer--2C4lD > div:nth-child(1) > div:nth-child(1) > div.flights-ufl-fare-cards-FareCard__priceBlock--2Q91O"));
		System.out.println("Passagem mais barata sem parada: " + firstValue.getText());
		
		/*
		WebElement boxTwo = driver.findElement(By.cssSelector("#c_FL_PopupCFSR"));
		WebElement boxThree = driver.findElement(By.cssSelector("#c_FL_PopupCFSR > div > div.overlays-modal-ModalView__bodyContent--1NwQs.overlays-modal-ModalView__fullBleed--3v73B > div.flights-airwatch-Interstitial__modernHeaderImage--1nNzo > div"));
		WebElement fecharBotao = driver.findElement(By.cssSelector("#c_FL_PopupCFSR > div > div.overlays-pieces-CloseX__close--7erra.overlays-pieces-CloseX__inverted--2vrVh"));
		fecharBotao.click();
		
		WebElement principal = driver.findElement(By.cssSelector("#MAIN > div > div.flights-search-results-SearchContainer__centerColumn--1CrLy.scrollAdMain.withLeftRail > div"));
		WebElement menu = driver.findElement(By.cssSelector("#MAIN > div > div.flights-search-results-SearchContainer__centerColumn--1CrLy.scrollAdMain.withLeftRail > div > div.ui_column.is-3.is-shown-at-widescreen"));
		WebElement valorVooDireto = driver.findElement(By.cssSelector("#MAIN > div > div.flights-search-results-SearchContainer__centerColumn--1CrLy.scrollAdMain.withLeftRail > div > div.ui_column.is-3.is-shown-at-widescreen > div > div > div > div > div:nth-child(2) > div > label > div > span > span > div > span.flights-search-results-filters-FlightSearchFilters__secondaryText--1BkaK.flights-search-results-filters-FlightSearchFilters__price--3ftvF"));
		input = driver.findElement(By.id("checkbox_29"));
		input.click();
		System.out.println(valorVooDireto.getText());
		
		//botao = driver.findElement(By.cssSelector("#MAIN > div > div.flights-search-results-SearchContainer__centerColumn--1CrLy.scrollAdMain.withLeftRail > div > div > div > div.flights-search-results-sorts-SortsFilterBar__container--2V6Qu > div.ui_columns.flights-search-results-sorts-SortsFilterBar__condensedPills--1S33Q.is-gapless.is-mobile > div.ui_column.flights-search-results-sorts-SortsFiltersPills__tag_wrap--3PaN4.flights-search-results-sorts-SortsFiltersPills__filters_column--XvyBl.is-narrow > span"));
		//botao.click();
		*/
		
	}
	
	//@Test
	public void esporteTeste() {
		WebElement botao = driver.findElement(By.cssSelector("body > section.championship-home > div > div:nth-child(2) > div.competiton-content > div > div > a"));
		botao.click();
		driver.navigate().back();
		botao = driver.findElement(By.cssSelector("body > section.championship-home > div > div:nth-child(1) > div.col-xs-8.col-sm-11.col-md-8.col-lg-7"));
		botao.click();
		WebElement campo = driver.findElement(By.id("83"));
		campo.click();
	}
}
