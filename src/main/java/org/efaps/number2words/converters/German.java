/*
 * Copyright 2003 - 2009 The eFaps Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */

package org.efaps.number2words.converters;

/**
 * The class implements the conversion of numbers to German words.
 *
 * @author The eFaps Team
 * @version $Id$
 */
public class German
    extends AbstractConverter
{
    /**
     * String array to define the conversion of numbers for 1 till 19.
     *
     * @see #getNumNames()
     */
    private static final String[] NUM_NAMES = {
        "", "ein", "zwei", "drei", "vier",
        "f\u00FCnf", "sechs", "sieben", "acht", "neun",
        "zehn", "elf", "zw\u00F6lf", "dreizehn", "vierzehn",
        "f\u00FCnfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn"};

    /**
     * String array to define the conversion for the numbers 10, 20, 30, 40,
     * 50, 60, 70, 80, 90 and 100.
     *
     * @see #getTensNames()
     */
    private static final String[] TENS_NAMES = {
        "", "zehn", "zwanzig", "drei\u00DFig", "vierzig",
        "f\u00FCnfzig", "sechzig", "siebzig", "achtzig", "neunzig",
        "hundert"};

    /**
     * String array to define the conversion of power numbers. The array
     * contains the German words for
     * <ul>
     * <li>thousand</li>
     * <li>million</li>
     * <li>billion</li>
     * <li>trillion</li>
     * <li>quadrillion</li>
     * <li>quintillion</li>
     * </ul>
     *
     * @see #getPowerNames()
     */
    private static final String[] POWER_NAMES = {
        "tausend", "Millionen", "Milliarden", "Billionen", "Billiarden", "Trillionen"};

    /**
     * String array to define the conversion of power numbers with exact one.
     * The array contains the German words for
     * <ul>
     * <li>one thousand</li>
     * <li>one million</li>
     * <li>one billion</li>
     * <li>one trillion</li>
     * <li>one quadrillion</li>
     * <li>one quintillion</li>
     * </ul>
     *
     * @see #convertPower(int, int)
     */
    private static final String[] SINGLE_POWER_NAMES = {
        "ein tausend", "eine Million", "eine Milliarde", "eine Billion", "eine Billiarde", "eine Trillion"};

    /**
     * <p>Converts number less than one hundred into German words. The original
     * method was override because in German language the convert is done using
     * first the last digit (one, two, ...) and then the 'ten' digit (twenty,
     * thirty, ...) concatenated by an 'and'.</p>
     * <p><b>Examples:</b><br/>
     * <ul>
     * <li>22: twenty-and-two (German: zwei-und-zwanzig)</li>
     * <li>46: forty-and-six (German: sechs-und-vierzig)</li>
     * </ul>
     * </p>
     *
     * @param _number   number less than one hundred to convert to German words
     * @return converted German words for <code>_number</code>
     */
    @Override
    protected String convertLessThanOneHundred(final int _number)
    {
        final StringBuilder ret = new StringBuilder();
        if (_number < 20)  {
            ret.append(this.getNumNames()[_number]);
        } else  {
            final int modTen = _number % 10;
            if (modTen > 0)  {
                ret.append(this.getNumNames()[_number % 10]).append("und");
            }
            ret.append(this.getTensNames()[_number / 10]);
        }
        return ret.toString();
    }

    /**
     * The method converts the given <code>_number</code> depending on the
     * <code>_power</code> to words. The real number to convert is
     * &quot;<code>_number * (10 ^ _power)</code>&quot;. The original method is
     * overwritten because if <code>_number</code> is equal one, the values
     * from {@link #SINGLE_POWER_NAMES} must be used.
     *
     * @param _number   number to convert
     * @param _power    power of the number
     * @return converted string
     * @see #SINGLE_POWER_NAMES
     */
    @Override
    protected String convertPower(final int _number,
                                  final int _power)
    {
        return (_number == 1)
               ? German.SINGLE_POWER_NAMES[_power]
               : super.convertPower(_number, _power);
    }

    /**
     * Returns the string array to define the conversion of numbers for 1 till
     * 19.
     *
     * @return string array of numbers
     * @see AbstractConverter#getNumNames()
     * @see #NUM_NAMES
     */
    @Override
    protected String[] getNumNames()
    {
        return German.NUM_NAMES;
    }

    /**
     * Returns the string array for the numbers 10, 20, 30, 40, 50, 60, 70, 80
     * and 90.
     *
     * @return string array of tens names
     * @see AbstractConverter#getTensNames()
     * @see #TENS_NAMES
     */
    @Override
    protected String[] getTensNames()
    {
        return German.TENS_NAMES;
    }

    /**
     * Returns the string array for log numbers 100, 1&nbsp;000,
     * 1&nbsp;000&nbsp;000 and 1&nbsp;000&nbsp;000&nbsp;000.
     *
     * @return string array of log numbers
     * @see AbstractConverter#getPowerNames()
     * @see #LOG_NAMES
     */
    @Override
    protected String[] getPowerNames()
    {
        return German.POWER_NAMES;
    }

    /**
     * Returns the related English word for the number zero ('0').
     *
     * @return  always the text string &quot;null&quot;
     */
    @Override
    protected String getZero()
    {
        return "null";
    }

    /**
     * Returns the related German word for &quot;minus&quot; needed for
     * negative numbers.
     *
     * @return always the text string &quot;minus&quot;
     */
    @Override
    protected String getMinus()
    {
        return "minus";
    }
}
