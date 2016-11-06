package org.chamomile.widgets;

public abstract class Button extends Component implements HasTextProperty,
    HasSemanticStyleProperty, HasSizeStyleProperty, HasBlockLevelProperty {

  @Override
  public String getText() {
    return (String) get(TEXT, "");
  }

  @Override
  public void setText(String text) {
    put(TEXT, text);
  }

  @Override
  public SemanticStyle getSemanticStyle() {
    return (SemanticStyle) get(SEMANTIC_STYLE);
  }

  @Override
  public void setSemanticStyle(SemanticStyle style) {
    put(SEMANTIC_STYLE, style);
  }

  @Override
  public SizeStyle getSizeStyle() {
    return (SizeStyle) get(SIZE_STYLE);
  }

  @Override
  public void setSizeStyle(SizeStyle style) {
    put(SIZE_STYLE, style);
  }

  public boolean isBlockLevel() {
    return (boolean) get(BLOCK_LEVEL);
  }

  public void setBlockLevel(boolean blockLevel) {
    put(BLOCK_LEVEL, blockLevel);
  }

}
