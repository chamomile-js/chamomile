package org.chamomile.j2js.demo;

import j2js.Global;
import j2js.w3c.dom.Element;
import j2js.w3c.dom.events.Event;
import j2js.w3c.dom.events.EventListener;
import j2js.w3c.dom.events.EventTarget;

public class HelloWorld2 {
   
   public static void main(String[] args) {
      //Global.init();
      
      // Define event listener.
      EventListener listener = new EventListener() {
         public void handleEvent(Event evt) {
            System.out.println("Hello World");
         }
      };
      
      // Attach event listener to button.
      Element button = Global.document.getElementById("Greetings");
      ((EventTarget) button).addEventListener("click", listener, false);
   }
}
