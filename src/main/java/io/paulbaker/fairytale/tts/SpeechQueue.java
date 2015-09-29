package io.paulbaker.fairytale.tts;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by paulbaker on 9/29/15.
 */
public class SpeechQueue {

  private final Queue<String> strings;

  public SpeechQueue() {
    strings = new LinkedList<>();
  }

  public void say(String text) {
    strings.add(text);

    
  }
}
