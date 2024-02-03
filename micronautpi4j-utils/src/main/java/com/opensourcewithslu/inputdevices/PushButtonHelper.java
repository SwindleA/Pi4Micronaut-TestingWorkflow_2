package com.opensourcewithslu.inputdevices;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalStateChangeListener;
import io.micronaut.context.annotation.Prototype;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The PushButtonHelper class is used to create a listener that determines when a 4 pin button is pressed.
 */
public class PushButtonHelper {
    private static final Logger log = LoggerFactory.getLogger(PushButtonHelper.class);

    private DigitalInput buttonInput;
    public Boolean isPressed;

    /**
     *
     * @param buttonInput A Pi4J DigitalInput Object.
     */
    //tag::const[]
    public PushButtonHelper(DigitalInput buttonInput)
    //end::const[]
    {
        this.buttonInput = buttonInput;
        this.isPressed = buttonInput.isHigh();

        initialize();
    }

    /**
     * Initializes the PushButton. Automatically called when the PushButton is created.
     */
    //tag::method[]
    public void initialize()
    //end::method[]
    {
        log.trace("Initializing " + buttonInput.getName());

        buttonInput.addListener(e->{
           isPressed = buttonInput.isHigh();
        });
    }

    /**
     * Adds an EventListener to the PushButton.
     * @param function A DigitalStateChangeListener Object.
     */
    //tag::method[]
    public void addEventListener(DigitalStateChangeListener function)  
    //end::method[]
    {
        buttonInput.addListener(function);
    }

    /**
     * Removes an EvenListener from the button.
     * @param function The listener to be removed.
     */
    //tag::method[]
    public void removeEventListener(DigitalStateChangeListener function)
    //end::method[]
    {
        buttonInput.removeListener(function);
    }
}