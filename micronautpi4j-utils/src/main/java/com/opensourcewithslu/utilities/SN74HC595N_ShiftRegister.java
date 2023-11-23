package com.opensourcewithslu.utilities;

public class SN74HC595N_ShiftRegister {

    /*
    This is an example from: https://learn.sunfounder.com/lesson-1-1-5-4-digit-7-segment-display/

    void hc595_shift(int8_t data){
    int i;
    for (i = 0; i < 8; i++)
    {
        digitalWrite(SDI, 0x80 & (data << i));
        digitalWrite(SRCLK, 1);
        delayMicroseconds(1);
        digitalWrite(SRCLK, 0);
    }
    digitalWrite(RCLK, 1);
    delayMicroseconds(1);
    digitalWrite(RCLK, 0);
}

This could be all we need for the seven segment display. We will need to know what it should look like for other devices like the lcd display.

     */

}
