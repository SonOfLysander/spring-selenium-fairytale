package io.paulbaker.fairytale;

import io.paulbaker.fairytale.selenium.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by paulbaker on 9/29/15.
 */
@PageObject
public class VillageSection {

  @FindBy(id = "fairy_cost")
  private WebElement fairyCostElement;

  @FindBy(id = "buy_fairy")
  private WebElement villageButton;

  public int getFairyCost() {
    return Integer.parseInt(fairyCostElement.getText());
  }

  public void clickVillageButton() {
    villageButton.click();
//    villageButtons.forEach(button -> {
//      if (button.isDisplayed()) {
//        button.click();
//      }
//    });
  }

}
