package io.paulbaker.fairytale;

import io.paulbaker.fairytale.selenium.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by paulbaker on 9/29/15.
 */
@PageObject
public class HandsSection {

  @FindBy(id = "magic_amount")
  private WebElement magicCountElement;

  @FindBy(id = "coin_amount")
  private WebElement coinCountElement;

  @FindBy(id = "buy_magic")
  private WebElement magicGatherElement;

  public int getMagicCount() {
    return Integer.parseInt(magicCountElement.getText());
  }

  public int getCoinCount() {
    if (!coinCountElement.isDisplayed()) {
      return 0;
    }
    return Integer.parseInt(coinCountElement.getText());
  }

  public void gatherMagic() {
    magicGatherElement.click();
  }

}
