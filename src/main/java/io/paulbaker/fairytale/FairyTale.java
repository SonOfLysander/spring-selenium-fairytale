package io.paulbaker.fairytale;

import io.paulbaker.fairytale.selenium.PageObject;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * Created by paulbaker on 9/29/15.
 */
@PageObject
public class FairyTale {

  @Value("${game.host}")
  private String gameHost;

  @Autowired
  private WebDriver webDriver;

  @Autowired
  private HandsSection handsSection;

  @Autowired
  private VillageSection villageSection;

  @Autowired
  private ShopSection shopSection;

  @Autowired
  private ForestSection forestSection;

  @PostConstruct
  public void postConstruct() {
    webDriver.get(gameHost);
  }

  public void update() {
    handsSection.gatherMagic();
    if (handsSection.getMagicCount() >= villageSection.getFairyCost()) {
      villageSection.clickVillageButton();
    }
    if (handsSection.getCoinCount() > shopSection.getCheapestCost()) {
      shopSection.buyCheapestItem();
    }
    if (forestSection.isVisible()) {
      forestSection.walkDeeper();
    }
  }

}
