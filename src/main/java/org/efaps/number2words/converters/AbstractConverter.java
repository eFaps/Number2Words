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

import java.text.DecimalFormat;

import org.efaps.number2words.IConverter;

/**
 * Abstract helper class which implements the main methods for the conversion
 * of numbers to words.
 *
 * @author The eFaps Team
 * @version $Id$
 */
public abstract class AbstractConverter
    implements IConverter
{
    /**
     * Method to convert the numbers from 1 to 999. The last to digits
     * (<code>_number modular 100</code>) are converted to words with
     * {@link #convertLessThanOneHundred(int)} so that some special kinds for
     * languages could be easy implemented.
     *
     * @param _number number less than one thousand to be converted
     * @return return words for number
     * @see #convertLessThanOneHundred(int)
     */
    protected String convertLessThanOneThousand(final int _number)
    {
        return new StringBuilder()
                .append(this.getNumNames()[_number / 100])
                .append(' ')
                .append(this.getTensNames()[(_number < 100) ? 0 : 10])
                .append(' ')
                .append(this.convertLessThanOneHundred(_number % 100))
                .toString();
    }

    /**
     * The method converts the numbers from 1 to 99 into words. The method is
     * used from {@link #convertLessThanOneThousand(int)}, because e.g. for the
     * German language the numbers less than one thousands must be converted
     * into a special way (see {@link German#convertLessThanOneHundred(int)}).
     *
     * @param _number       number less than one hundred to convert
     * @return converted <code>_number</code> in words
     */
    protected String convertLessThanOneHundred(final int _number)
    {
        final StringBuilder ret = new StringBuilder();
        if (_number < 20)  {
            ret.append(this.getNumNames()[_number]);
        } else  {
            ret.append(this.getTensNames()[_number / 10])
                .append(' ')
                .append(this.getNumNames()[_number % 10]);
        }
        return ret.toString();
    }

    /**
     * Returns the string array to define the conversion of numbers for 1 till
     * 19.
     *
     * @return string array of numbers
     */
    protected abstract String[] getNumNames();

    /**
     * Returns the string array for a zero length string and the words for
     * numbers 10, 20, 30, 40, 50, 60, 70, 80, 90 and 100.
     *
     * @return string array of tens names
     */
    protected abstract String[] getTensNames();

    /**
     * Returns the string array for power numbers <code>10^n</code>. The
     * translated word values must be defined in this order:
     * <ul>
     * <li><code>n = 0</code>: thousand</li>
     * <li><code>n = 1</code>: million</li>
     * <li><code>n = 2</code>: billion</li>
     * <li><code>n = 3</code>: trillion</li>
     * <li><code>n = 4</code>: quadrillion</li>
     * <li><code>n = 5</code>: quintillion</li>
     * </ul>
     *
     * @return string array of power numbers
     */
    protected abstract String[] getPowerNames();

    /**
     * Returns the word for the number 0.
     *
     * @return string for the number 0
     */
    protected abstract String getZero();

    /**
     * The method converts the given <code>_number</code> depending on the
     * <code>_power</code> to words. The real number to convert is
     * &quot;<code>_number * (10 ^ _power)</code>&quot;.
     *
     * @param _number   number to convert
     * @param _power    power of the number
     * @return converted string
     */
    protected String convertPower(final int _number,
                                  final int _power)
    {
        final StringBuilder ret = new StringBuilder();
        if (_number != 0)  {
            ret.append(this.convertLessThanOneThousand(_number))
                .append(' ')
                .append(this.getPowerNames()[_power]);
        }
        return ret.toString();
    }

    /**
     * Method to convert a number into words.
     *
     * @see IConverter#convert(long)
     * @param _number   number to convert
     * @return words representing the number
     */
    public String convert(final long _number)
    {
        final String ret;
        // 0 to 999 999 999 999
        if (_number == 0)  {
            ret = getZero();
        } else {
            // pad with "0"
            final String mask = "000000000000000000000";
            final DecimalFormat df = new DecimalFormat(mask);
            final String snumber = df.format(_number);

            // XXXnnnnnnnnnnnnnnnnnn
            final int quintillions = Integer.parseInt(snumber.substring(0, 3));
            // nnnXXXnnnnnnnnnnnnnnn
            final int quadrillions = Integer.parseInt(snumber.substring(3, 6));
            // nnnnnnXXXnnnnnnnnnnnn
            final int trillions = Integer.parseInt(snumber.substring(6, 9));
            // nnnnnnnnnXXXnnnnnnnnn
            final int billions = Integer.parseInt(snumber.substring(9, 12));
            // nnnnnnnnnnnnXXXnnnnnn
            final int millions = Integer.parseInt(snumber.substring(12, 15));
            // nnnnnnnnnnnnnnnXXXnnn
            final int thousands = Integer.parseInt(snumber.substring(15, 18));
            // nnnnnnnnnnnnnnnnnnXXX
            final int hundreds = Integer.parseInt(snumber.substring(18, 21));

            final String result = new StringBuilder()
                    .append(this.convertPower(quintillions, 5)).append(' ')
                    .append(this.convertPower(quadrillions, 4)).append(' ')
                    .append(this.convertPower(trillions, 3)).append(' ')
                    .append(this.convertPower(billions, 2)).append(' ')
                    .append(this.convertPower(millions, 1)).append(' ')
                    .append(this.convertPower(thousands, 0)).append(' ')
                    .append(this.convertLessThanOneThousand(hundreds))
                    .toString();

            // remove extra spaces!
            ret = result.replaceAll("^\\s+", "")
                        .replaceAll("\\b\\s{2,}\\b", " ")
                        .trim();
        }
        return ret;
    }
}
