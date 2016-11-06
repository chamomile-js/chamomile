package org.chamomile.widgets;

import org.chamomile.beans.BeanListener;
import org.chamomile.beans.ObservableBean;
import org.chamomile.collections.Dictionary;
import org.chamomile.collections.Sequence;
import org.chamomile.util.Callback;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.html.HTMLElement;

public abstract class ComponentSkin implements Skin, BeanListener, ClassNameListener {

  protected final Dictionary<String, Callback<? extends Object, Void>> propertyChangeHandlers = Dictionary.create();

  private Component component = null;

  // --- Basic functionality ---------------------------------------------

  @Override
  public void install(Component component) {
    if (this.component != null) {
      throw new IllegalStateException("Skin already installed on a view");
    }

    this.component = component;
    this.component.getBeanListeners().add(this);
    this.component.getClassNameListeners().add(this);

    //
    // Install property change listeners.
    //

    propertyChangeHandlers.put(Component.ID, new Callback<String, Void>() {
      @Override
      public Void call(String previousValue) {
        idChanged(getComponent(), previousValue);
        return null;
      }
    });

    propertyChangeHandlers.put(Component.PARENT, new Callback<ViewParent<?>, Void>() {
      @Override
      public Void call(ViewParent<?> previousValue) {
        parentChanged(getComponent(), previousValue);
        return null;
      }
    });
    
    propertyChangeHandlers.put(Component.WIDTH, new Callback<Length, Void>() {
      @Override
      public Void call(Length previousValue) {
        widthChanged(getComponent(), previousValue);
        return null;
      }
    });
    
    propertyChangeHandlers.put(Component.HEIGHT, new Callback<Length, Void>() {
      @Override
      public Void call(Length previousValue) {
        heightChanged(getComponent(), previousValue);
        return null;
      }
    });
    
    propertyChangeHandlers.put(Component.MIN_WIDTH, new Callback<Length, Void>() {
      @Override
      public Void call(Length previousValue) {
        minWidthChanged(getComponent(), previousValue);
        return null;
      }
    });
    
    propertyChangeHandlers.put(Component.MAX_WIDTH, new Callback<Length, Void>() {
      @Override
      public Void call(Length previousValue) {
        maxWidthChanged(getComponent(), previousValue);
        return null;
      }
    });
    
    propertyChangeHandlers.put(Component.MIN_HEIGHT, new Callback<Length, Void>() {
      @Override
      public Void call(Length previousValue) {
        minHeightChanged(getComponent(), previousValue);
        return null;
      }
    });
    
    propertyChangeHandlers.put(Component.MAX_HEIGHT, new Callback<Length, Void>() {
      @Override
      public Void call(Length previousValue) {
        maxHeightChanged(getComponent(), previousValue);
        return null;
      }
    });

    propertyChangeHandlers.put(Component.MARGIN, new Callback<Insets, Void>() {
      @Override
      public Void call(Insets previousValue) {
        marginChanged(getComponent(), previousValue);
        return null;
      }
    });

    propertyChangeHandlers.put(Component.PADDING, new Callback<Insets, Void>() {
      @Override
      public Void call(Insets previousValue) {
        paddingChanged(getComponent(), previousValue);
        return null;
      }
    });

    propertyChangeHandlers.put(Component.VISIBLE, new Callback<Boolean, Void>() {
      @Override
      public Void call(Boolean previousValue) {
        visibleChanged(getComponent(), previousValue);
        return null;
      }
    });

    if (component instanceof HasTextProperty) {
      propertyChangeHandlers.put(Label.TEXT, new Callback<String, Void>() {
        @Override
        public Void call(String previousValue) {
          textChanged((HasTextProperty) getComponent(), previousValue);
          return null;
        }
      });
    }

    if (component instanceof HasSemanticStyleProperty) {
      propertyChangeHandlers.put(HasSemanticStyleProperty.SEMANTIC_STYLE, new Callback<SemanticStyle, Void>() {
        @Override
        public Void call(SemanticStyle value) {
          semanticStyleChanged((HasSemanticStyleProperty) getComponent(), value);
          return null;
        }
      });
    }

    if (component instanceof HasSizeStyleProperty) {
      propertyChangeHandlers.put(HasSizeStyleProperty.SIZE_STYLE, new Callback<SizeStyle, Void>() {
        @Override
        public Void call(SizeStyle value) {
          sizeStyleChanged((HasSizeStyleProperty) getComponent(), value);
          return null;
        }
      });
    }

    if (component instanceof HasBlockLevelProperty) {
      propertyChangeHandlers.put(HasBlockLevelProperty.BLOCK_LEVEL, new Callback<Boolean, Void>() {
        @Override
        public Void call(Boolean value) {
          blockLevelStyleChanged((HasBlockLevelProperty) getComponent(), value);
          return null;
        }
      });
    }
  }

  protected void idChanged(Component component, String previousValue) {
    getActiveElement().setId(component.getId());
  }

  protected void parentChanged(Component component, ViewParent<?> previousValue) {
    // TODO Auto-generated method stub
  }

  protected void widthChanged(Component component, Length previousValue) {
    CSSStyleDeclaration style = getElement().getStyle();
    Length newValue = component.getWidth();
    if (newValue != null) {
      style.setWidth(newValue.toString());
    } else {
      style.setWidth("");
    }
  }
  
  protected void heightChanged(Component component, Length previousValue) {
    CSSStyleDeclaration style = getElement().getStyle();
    Length newValue = component.getHeight();
    if (newValue != null) {
      style.setHeight(newValue.toString());
    } else {
      style.setHeight("");
    }
  }

  protected void minWidthChanged(Component component, Length previousValue) {
    CSSStyleDeclaration style = getElement().getStyle();
    Length newValue = component.getMinWidth();
    if (newValue != null) {
      style.setMinWidth(newValue.toString());
    } else {
      style.setMinWidth("");
    }
  }

  protected void maxWidthChanged(Component component, Length previousValue) {
    CSSStyleDeclaration style = getElement().getStyle();
    Length newValue = component.getMaxWidth();
    if (newValue != null) {
      style.setMaxWidth(newValue.toString());
    } else {
      style.setMaxWidth("");
    }
  }
  
  protected void minHeightChanged(Component component, Length previousValue) {
    CSSStyleDeclaration style = getElement().getStyle();
    Length newValue = component.getMinHeight();
    if (newValue != null) {
      style.setMinHeight(newValue.toString());
    } else {
      style.setMinHeight("");
    }
  }

  protected void maxHeightChanged(Component component, Length previousValue) {
    CSSStyleDeclaration style = getElement().getStyle();
    Length newValue = component.getMaxHeight();
    if (newValue != null) {
      style.setMaxHeight(newValue.toString());
    } else {
      style.setMaxHeight("");
    }
  }

  protected void marginChanged(Component component, Insets previousValue) {
    CSSStyleDeclaration style = getElement().getStyle();
    style.setPadding(component.getMargin().toString());
  }

  protected void paddingChanged(Component component, Insets previousValue) {
    CSSStyleDeclaration style = getActiveElement().getStyle();
    style.setPadding(component.getMargin().toString());
  }

  protected void visibleChanged(Component component, Boolean previousValue) {
    HTMLElement elem = getElement();
    CSSStyleDeclaration style = elem.getStyle();
    if (component.isVisible()) {
      style.setDisplay("");
      elem.removeAttribute("aria-hidden");
    } else {
      style.setDisplay("none");
      elem.setAttribute("aria-hidden", "true");
    }
  }

  protected void textChanged(HasTextProperty component, String previousValue) {
    getActiveElement().setTextContent(component.getText());
  }

  protected void semanticStyleChanged(HasSemanticStyleProperty component, SemanticStyle previousValue) {
    semanticStyleChanged(component.getSemanticStyle(), previousValue, getClassNamePrefix(), getActiveElement());
  }

  protected static final void semanticStyleChanged(SemanticStyle newValue, SemanticStyle previousValue,
      String classNamePrefix, HTMLElement... elements) {
    if (elements == null || elements.length == 0)
      return;

    String oldClassName = previousValue != null
        ? classNamePrefix + previousValue.getStyleName() : null;

    String newClassName = newValue != null
        ? classNamePrefix + newValue.getStyleName() : null;

    for (HTMLElement elem : elements) {
      if (previousValue != null) {
        removeClassName(elem, oldClassName);
      }
      if (newValue != null) {
        addClassName(elem, newClassName);
      }
    }
  }

  protected void sizeStyleChanged(HasSizeStyleProperty component, SizeStyle previousValue) {
    sizeStyleChanged(component.getSizeStyle(), previousValue, getClassNamePrefix(), getActiveElement());
  }

  protected static final void sizeStyleChanged(SizeStyle newValue, SizeStyle previousValue,
      String classNamePrefix, HTMLElement... elements) {
    if (elements == null || elements.length == 0)
      return;

    String oldClassName = previousValue != null
        ? classNamePrefix + previousValue.getStyleName() : null;

    String newClassName = newValue != null
        ? classNamePrefix + newValue.getStyleName() : null;

    for (HTMLElement elem : elements) {
      if (previousValue != null) {
        removeClassName(elem, oldClassName);
      }
      if (newValue != null) {
        addClassName(elem, newClassName);
      }
    }
  }

  protected void blockLevelStyleChanged(HasBlockLevelProperty component, Boolean previousValue) {
    if (previousValue != null && previousValue) {
      removeClassName(getElement(), getClassNamePrefix() + "block");
    }
    if (component.isBlockLevel()) {
      addClassName(getElement(), getClassNamePrefix() + "block");
    }
  }

  // --- ComponentSkin API -----------------------------------------------

  @Override
  public Component getComponent() {
    return component;
  }

  protected static <T extends View> Skin getSkin(T component) {
    return component.toComponent().getSkin();
  }

  protected String getClassNamePrefix() {
    return "";
  }

  @Override
  public int getOffsetTop() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getOffsetLeft() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getOffsetWidth() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getOffsetHeight() {
    // TODO Auto-generated method stub
    return 0;
  }

  // --- BeanListener ----------------------------------------------------

  @Override
  public final void propertyChanged(ObservableBean bean, String property, Object previousValue) {
    @SuppressWarnings("unchecked")
    Callback<Object, Void> listener = (Callback<Object, Void>) propertyChangeHandlers.get(property);
    if (listener != null) {
      listener.call(previousValue);
    }
  }

  // --- ClassNameListener -----------------------------------------------

  @Override
  public void classNameInserted(Component component, int index) {
    setClassName(component.getClassNames().get(index), true);
  }

  @Override
  public void classNamesRemoved(Component component, int index, Sequence<String> classNames) {
    for (int i = 0, n = classNames.getLength(); i < n; i++) {
      setClassName(classNames.get(i), false);
    }
  }

  // --- Helpers ---------------------------------------------------------

  private static final String[] browserSupport = { "webkit", "moz", "ms" };

  protected void setCustomStyle(CSSStyleDeclaration style, String propertyName, String value, String priority) {
    String _propertyName = capitalize(propertyName);
    for (String prefix : browserSupport) {
      style.setProperty(prefix + _propertyName, value, priority);
    }
    style.setProperty(propertyName, value, priority);
  }

  private static String capitalize(String s) {
    if (s.length() == 0)
      return s;
    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
  }

  protected void setClassName(String className, boolean add) {
    HTMLElement elem = getElement();
    if (add) {
      addClassName(elem, elem.getClassName(), className);
    } else {
      removeClassName(elem, elem.getClassName(), className);
    }
  }

  /**
   * Adds a name to this element's class property. If the name is already
   * present, this method has no effect.
   */
  public static final boolean addClassName(HTMLElement elem, String oldClassName, String className) {
    // Get the current style string.
    int idx = indexOfName(oldClassName, className);

    // Only add the style if it's not already present.
    if (idx == -1) {
      if (oldClassName.length() > 0) {
        elem.setClassName(oldClassName + " " + className);
      } else {
        elem.setClassName(className);
      }
      return true;
    }
    return false;
  }

  public static final boolean addClassName(HTMLElement elem, String className) {
    return addClassName(elem, elem.getClassName(), className);
  }

  /**
   * Removes a name from this element's class property. If the name is not
   * present, this method has no effect.
   */
  public static final boolean removeClassName(HTMLElement elem, String oldClassName, String className) {
    // Get the current style string.
    int idx = indexOfName(oldClassName, className);

    // Don't try to remove the style if it's not there.
    if (idx != -1) {
      // Get the leading and trailing parts, without the removed name.
      String begin = oldClassName.substring(0, idx).trim();
      String end = oldClassName.substring(idx + className.length()).trim();

      // Make sure we don't leave extra spaces.
      String newClassName;
      if (begin.length() == 0) {
        newClassName = end;
      } else if (end.length() == 0) {
        newClassName = begin;
      } else {
        newClassName = begin + " " + end;
      }

      elem.setClassName(newClassName);
      return true;
    }
    return false;
  }

  public static final boolean removeClassName(HTMLElement elem, String className) {
    return removeClassName(elem, elem.getClassName(), className);
  }

  /**
   * Returns the index of the first occurrence of name in a space-separated list
   * of names, or -1 if not found.
   *
   * @param nameList
   *          list of space delimited names
   * @param name
   *          a non-empty string. Should be already trimmed.
   */
  private static int indexOfName(String nameList, String name) {
    int idx = nameList.indexOf(name);

    // Calculate matching index.
    while (idx != -1) {
      if (idx == 0 || nameList.charAt(idx - 1) == ' ') {
        int last = idx + name.length();
        int lastPos = nameList.length();
        if ((last == lastPos)
            || ((last < lastPos) && (nameList.charAt(last) == ' '))) {
          break;
        }
      }
      idx = nameList.indexOf(name, idx + 1);
    }

    return idx;
  }
}
