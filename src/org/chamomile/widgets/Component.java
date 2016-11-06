package org.chamomile.widgets;

import java.util.ArrayList;

import org.chamomile.beans.ObservableBean;
import org.chamomile.collections.Sequence;
import org.chamomile.util.Callback;
import org.chamomile.util.InternalPreconditions;
import org.chamomile.util.ListenerList;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventException;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;

public abstract class Component extends ObservableBean implements View {

  public final class ClassNameSequence implements Sequence<String> {
    private final Sequence<String> classNames = Sequence.create(new ArrayList<String>());

    @Override
    public int add(String className) {
      int index = getLength();
      insert(className, index);
      return index;
    }

    @Override
    public void insert(String className, int index) {
      InternalPreconditions.checkArgument(className != null, "className is null");
      InternalPreconditions.checkArgument(!contains(className), "className '%s' was added before", className);
      classNames.insert(className, index);
      classNameListeners.classNameInserted(Component.this, index);
    }

    @Override
    public String update(int index, String item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public int remove(String className) {
      int index = indexOf(className);
      if (index != -1) {
        remove(index, 1);
      }
      return index;
    }

    @Override
    public Sequence<String> remove(int index, int count) {
      Sequence<String> removed = classNames.remove(index, count);
      if (count > 0) {
        classNameListeners.classNamesRemoved(Component.this, index, classNames);
      }
      return removed;
    }

    @Override
    public String get(int index) {
      return classNames.get(index);
    }

    @Override
    public int indexOf(String className) {
      return classNames.indexOf(className);
    }

    public boolean contains(String className) {
      return classNames.indexOf(className) != -1;
    }

    @Override
    public int getLength() {
      return classNames.getLength();
    }

    @Override
    public void clear() {
      remove(0, getLength());
    }
  }

  private final class ClassNameListenerList extends ListenerList<ClassNameListener>
      implements ClassNameListener {

    @Override
    public void classNameInserted(Component component, int index) {
      for (ClassNameListener listener : this) {
        listener.classNameInserted(Component.this, index);
      }
    }

    @Override
    public void classNamesRemoved(Component component, int index, Sequence<String> classNames) {
      for (ClassNameListener listener : this) {
        listener.classNamesRemoved(Component.this, index, classNames);
      }
    }
  }

  // ---

  // TODO Transforms

  // ---

  private final ClassNameListenerList classNameListeners = new ClassNameListenerList();

  private Skin skin = null;

  protected Skin getSkin() {
    return skin;
  }

  protected void setSkin(Skin skin) {
    if (skin == null) {
      throw new IllegalArgumentException("Skin is null");
    }

    if (this.skin != null) {
      throw new IllegalArgumentException("Skin already set");
    }

    this.skin = skin;

    // Associate the renderer with this component...
    this.skin.install(this);
  }

  @Override
  public Component toComponent() {
    return this;
  }

  /**
   * The component's id property.
   */
  public static final String ID = "id";

  public String getId() {
    return (String) get(ID);
  }

  public void setId(String id) {
    put(ID, id);
  }

  /**
   * The component's classNames property.
   */
  public static final String CLASS_NAMES = "_classNames";

  public ClassNameSequence getClassNames() {
    ClassNameSequence classNames = (ClassNameSequence) get(CLASS_NAMES);
    if (classNames == null) {
      put(CLASS_NAMES, classNames = new ClassNameSequence(), null);
    }
    return classNames;
  }

  /**
   * The parent view, or {@code null} if the view does not have a parent.
   * <p>
   * Visibility: {@code protected}.
   */
  public static final String PARENT = "_parent";

  public ViewParent<?> getParent() {
    return (ViewParent<?>) get(PARENT);
  }

  protected void setParent(final ViewParent<?> parent) {
    ViewParent<?> previousParent = (ViewParent<?>) get(PARENT);
    if (previousParent != null) {
      previousParent.toComponent().descendantRemoved(this);
    }
    put(PARENT, parent, new Callback<ViewParent<?>, Void>() {
      @Override
      public Void call(ViewParent<?> previousValue) {
        if (parent != null) {
          parent.toComponent().descendantAdded(Component.this);
        }
        return null;
      }
    });
  }

  /**
   * The component's width property (set by the user).
   */
  public static final String WIDTH = "width";

  public Length getWidth() {
    return (Length) get(WIDTH);
  }

  public void setWidth(Length width) {
    put(WIDTH, width);
  }

  /**
   * The component's height property (set by the user).
   */
  public static final String HEIGHT = "height";

  public Length getHeight() {
    return (Length) get(HEIGHT);
  }

  public void setHeight(Length height) {
    put(HEIGHT, height);
  }

  /**
   * The component's minimum width property.
   */
  public static final String MIN_WIDTH = "minWidth";

  public Length getMinWidth() {
    return (Length) get(MIN_WIDTH);
  }

  public void setMinWidth(Length minWidth) {
    put(MIN_WIDTH, minWidth);
  }

  /**
   * The component's maximum width property.
   */
  public static final String MAX_WIDTH = "maxWidth";

  public Length getMaxWidth() {
    return (Length) get(MAX_WIDTH);
  }

  public void setMaxWidth(Length maxWidth) {
    put(MAX_WIDTH, maxWidth);
  }

  /**
   * The component's minimum height property.
   */
  public static final String MIN_HEIGHT = "minHeight";

  public Length getMinHeight() {
    return (Length) get(MIN_HEIGHT);
  }

  public void setMinHeight(Length minHeight) {
    put(MIN_HEIGHT, minHeight);
  }

  /**
   * The component's maximum height property.
   */
  public static final String MAX_HEIGHT = "maxHeight";

  public Length getMaxHeight() {
    return (Length) get(MAX_HEIGHT);
  }

  public void setMaxHeight(Length maxHeight) {
    put(MAX_HEIGHT, maxHeight);
  }

  /**
   * The component's margin property.
   */
  public static final String MARGIN = "margin";

  public Insets getMargin() {
    return (Insets) get(MARGIN, Insets.NONE);
  }

  public void setMargin(Insets insets) {
    put(MARGIN, insets);
  }

  /**
   * The component's padding property.
   */
  public static final String PADDING = "padding";

  public Insets getPadding() {
    return (Insets) get(PADDING, Insets.NONE);
  }

  public void setPadding(Insets margin) {
    put(PADDING, margin);
  }

  // TODO BORDER

  /**
   * The component's visible property.
   */
  public static final String VISIBLE = "visible";

  public boolean isVisible() {
    return (boolean) get(VISIBLE, Boolean.TRUE);
  }

  public void setVisible(boolean visible) {
    put(VISIBLE, visible);
  }
  
  //
  // Should be implemented by container views.
  //

  protected void descendantRemoved(Component component) {}

  protected void descendantAdded(Component component) {}

  protected boolean isAncestor(ViewParent<?> container) {
    return false;
  }

  //
  // EventTarget interface implementation.
  //

  @Override
  public void addEventListener(String type, EventListener listener, boolean useCapture) {
    EventTarget eventTarget = (EventTarget) getSkin().getActiveElement();
    eventTarget.addEventListener(type, listener, useCapture);
  }

  @Override
  public void removeEventListener(String type, EventListener listener, boolean useCapture) {
    EventTarget eventTarget = (EventTarget) getSkin().getActiveElement();
    eventTarget.removeEventListener(type, listener, useCapture);
  }

  @Override
  public boolean dispatchEvent(Event evt) throws EventException {
    EventTarget eventTarget = (EventTarget) getSkin().getActiveElement();
    return eventTarget.dispatchEvent(evt);
  }

  //
  // Component listeners.
  //

  public ListenerList<ClassNameListener> getClassNameListeners() {
    return classNameListeners;
  }

}
