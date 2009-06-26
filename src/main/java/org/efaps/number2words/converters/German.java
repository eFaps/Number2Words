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
     * 50, 60, 70, 80 and 90.
     *
     * @see #getTensNames()
     */
    private static final String[] TENS_NAMES = {
        "", "zehn", "zwanzig", "drei\u00DFig", "vierzig",
        "f\u00FCnfzig", "sechzig", "siebzig", "achtzig", "neunzig"};

    /**
     * String array to define the conversion for the log numbers 100,
     * 1&nbsp;000, 1&nbsp;000&nbsp;000 and 1&nbsp;000&nbsp;000&nbsp;000.
     *
     * @see #getLogNames()
     */
    private static final String[] LOG_NAMES = {
        "", "hundert", "tausend", "Millionen", "Milliarden"};

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
                ret.append(this.getNumNames()[_number % 10]).append("-und-");
            }
            ret.append(this.getTensNames()[_number / 10]);
        }
        return ret.toString();
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
     * @see AbstractConverter#getLogNames()
     * @see #LOG_NAMES
     */
    @Override
    protected String[] getLogNames()
    {
        return German.LOG_NAMES;
    }

    /**
     * Returns the related English word for the number zero ('0').
     *
     * @return &quot;zero&quot;
     */
    @Override
    protected String getZero()
    {
        return "null";
    }

    /**
     * Converts the billion's of a number to related word representation.
     * Because in German one billion must be written in another way (&quot;eine
     * Milliarde&quot;), the original method was overwritten.
     *
     * @param _billions     number of billion's to convert
     * @return converted string with words
     */
    @Override
    protected String getBillions(final int _billions)
    {
        return (_billions == 1)
               ? "eine Milliarde"
               : super.getBillions(_billions);
    }

    /**
     * Converts the million's of a number to related word representation.
     * Because in Spanish one million must be written in another way
     * (&quot;eine Million&quot;), the original method was overwritten.
     *
     * @param _millions     number of million's to convert
     * @return converted string with words
     */
    @Override
    protected String getMillions(final int _millions)
    {
        return (_millions == 1)
               ? "eine Million"
               : super.getMillions(_millions);
    }

}
