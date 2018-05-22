package categoryPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsCategoryPage {
    WebDriver driver;
    @FindBy(css = "html#top.js.no-touch.localstorage.no-ios body.catalog-category-view.categorypath-aromaty-podarki-i-nabory.category-podarki-i-nabory div.wrapper div.page div.main-container.col2-left-layout.category-col2-left-layout div.main div.col-main div.category-products ul.products-grid.products-grid--max-4-col.first.last.odd li.product-137391.item.last div.product-image-wrapper a.product-image img#product-collection-image-137391")
    WebElement product10190;

    public WebElement getProduct10190() {
        return product10190;
    }

    public ProductsCategoryPage (WebDriver driver) {
        this.driver = driver;
    }
}
