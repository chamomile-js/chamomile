package org.chamomile.widgets;

import org.chamomile.widgets.skin.DefaultPushButtonSkin;
import org.chamomile.widgets.skin.PushButtonSkin;

public class PushButton extends Button {

  public PushButton() {
    this(new DefaultPushButtonSkin());
  }

  public PushButton(String text) {
    this();
    setText(text);
  }

  public PushButton(PushButtonSkin skin) {
    setSkin(new DefaultPushButtonSkin());
  }

}
