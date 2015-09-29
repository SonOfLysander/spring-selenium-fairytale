package io.paulbaker.fairytale;

import com.sun.speech.freetts.Voice;
import io.paulbaker.fairytale.selenium.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by paulbaker on 9/29/15.
 */
@PageObject
public class ForestSection {

  private Logger logger = Logger.getLogger(this.getClass());

//  @Autowired
//  private Voice voice;

  @FindBy(id = "forest_display")
  private WebElement forestBoddice;

  @FindBy(id = "forest_button")
  private WebElement forestButton;

  @FindBy(xpath = "//div[@id='storyBox']/p")
  private WebElement storyBox;

  private Set<String> storyLines;

  public ForestSection() {
    storyLines = new HashSet<>();
  }

  public boolean isVisible() {
    return forestBoddice.isDisplayed();
  }

  public void walkDeeper() {
    forestButton.click();
    String text = storyBox.getText();
    if (storyLines.add(text)) {
      logger.info(text);
//      voice.speak(text);
    }
  }

}
