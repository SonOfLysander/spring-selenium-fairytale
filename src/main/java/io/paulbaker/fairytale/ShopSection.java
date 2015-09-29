package io.paulbaker.fairytale;

import io.paulbaker.fairytale.selenium.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Created by paulbaker on 9/29/15.
 */
@PageObject
public class ShopSection {

  @FindAll(
    @FindBy(css = "div.parent_shoptab p.shop_display button")
  )
  private List<WebElement> shopButtons;

  private Optional<WebElement> findCheapest() {
    Optional<WebElement> min = shopButtons.stream().filter(WebElement::isDisplayed).min((o1, o2) -> {
      int a = Integer.parseInt(o1.findElement(By.tagName("span")).getText());
      int b = Integer.parseInt(o2.findElement(By.tagName("span")).getText());
      return Integer.compare(a, b);
    });

    return min;
  }

  public int getCheapestCost(){
    Optional<WebElement> cheapest = findCheapest();
    if (cheapest.isPresent() && cheapest.get().isDisplayed()){
      return Integer.parseInt(cheapest.get().findElement(By.tagName("span")).getText());
    }
    return Integer.MAX_VALUE;
  }

  public void buyCheapestItem(){
    Optional<WebElement> cheapest = findCheapest();
    if (cheapest.isPresent() && cheapest.get().isDisplayed()){
      cheapest.get().click();
    }
  }
}
