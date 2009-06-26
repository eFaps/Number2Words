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
 * The class implements the conversion of numbers to English words.
 *
 * @author The eFaps Team
 * @version $Id$
 */
public class English
    extends AbstractConverter
{
    /**
     * String array to define the conversion of numbers for 1 till 19.
     *
     * @see #getNumNames()
     */
    private static final String[] NUM_NAMES = {
        "", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    /**
     * String array to define the conversion for the numbers 10, 20, 30, 40,
     * 50, 60, 70, 80 and 90.
     *
     * @see #getTensNames()
     */
    private static final String[] TENS_NAMES = {
        "", "ten", "twenty", "thirty", "forty",
        "fifty", "sixty", "seventy", "eighty", "ninety",
        "hundred"};

    /**
     * String array to define the conversion for the log numbers 100, 1000,
     * 1000000 and 1000000000.
     *
     * @see #getPowerNames()
     */
    private static final String[] POWER_NAMES = {
        "thousand", "million", "billion", "trillion", "quadrillion", "quintillion"};

    /**
     * The method converts the numbers from 1 to 99 into words. The method is
     * used from {@link AbstractConverter#convertLessThanOneThousand(int)}.
     *
     * @param _number       number less than one hundred to convert
     * @return converted <code>_number</code> in words
     */
    @Override
    protected String convertLessThanOneHundred(final int _number)
    {
        final StringBuilder ret = new StringBuilder();
        if (_number < 20)  {
            ret.append(this.getNumNames()[_number]);
        } else  {
            ret.append(this.getTensNames()[_number / 10])
                .append('-')
                .append(this.getNumNames()[_number % 10]);
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
        return English.NUM_NAMES;
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
        return English.TENS_NAMES;
    }

    /**
     * Returns the string array for log numbers 100, 1000, 1000000 and
     * 1000000000.
     *
     * @return string array of log numbers
     * @see AbstractConverter#getPowerNames()
     * @see #POWER_NAMES
     */
    @Override
    protected String[] getPowerNames()
    {
        return English.POWER_NAMES;
    }

    /**
     * Returns the related English word for the number zero ('0').
     *
     * @return always the text string &quot;zero&quot;
     */
    @Override
    protected String getZero()
    {
        return "zero";
    }

    /**
     * Returns the related English word for &quot;minus&quot; needed for
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
