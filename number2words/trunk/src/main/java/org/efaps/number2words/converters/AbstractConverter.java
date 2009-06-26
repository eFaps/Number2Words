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
                .append(this.getLogNames()[(_number < 100) ? 0 : 1])
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
     * Returns the string array for the numbers 10, 20, 30, 40, 50, 60, 70, 80
     * and 90.
     *
     * @return string array of tens names
     */
    protected abstract String[] getTensNames();

    /**
     * Returns the string array for log numbers 100, 1&nbsp;000,
     * 1&nbsp;000&nbsp;000 and 1&nbsp;000&nbsp;000&nbsp;000.
     *
     * @return string array of log numbers
     */
    protected abstract String[] getLogNames();

    /**
     * Returns the word for the number 0.
     *
     * @return string for the number 0
     */
    protected abstract String getZero();

    /**
     * Converts the billion's of a number to related word representation.
     *
     * @param _billions     number of billion's to convert
     * @return converted string with words
     */
    protected String getBillions(final int _billions)
    {
        final StringBuilder ret = new StringBuilder();
        if (_billions != 0)  {
            ret.append(this.convertLessThanOneThousand(_billions))
                .append(' ')
                .append(this.getLogNames()[4]);
        }
        return ret.toString();
    }

    /**
     * Converts the million's of a number to related word representation.
     *
     * @param _millions     number of million's to convert
     * @return converted string with words
     */
    protected String getMillions(final int _millions)
    {
        final StringBuilder ret = new StringBuilder();
        if (_millions != 0)  {
            ret.append(this.convertLessThanOneThousand(_millions))
                .append(' ')
                .append(this.getLogNames()[3]);
        }
        return ret.toString();
    }

    /**
     * Converts the thousand's of a number to related word representation.
     *
     * @param _thousends    number of thousend's to convert
     * @return converted string with words
     */
    protected String getThousands(final int _thousends)
    {
        final StringBuilder ret = new StringBuilder();
        if (_thousends != 0)  {
            ret.append(this.convertLessThanOneThousand(_thousends))
                .append(' ')
                .append(this.getLogNames()[2]);
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
            final String mask = "000000000000";
            final DecimalFormat df = new DecimalFormat(mask);
            final String snumber = df.format(_number);

            // XXXnnnnnnnnn
            final int billions = Integer.parseInt(snumber.substring(0, 3));
            // nnnXXXnnnnnn
            final int millions = Integer.parseInt(snumber.substring(3, 6));
            // nnnnnnXXXnnn
            final int thous = Integer.parseInt(snumber.substring(6, 9));
            // nnnnnnnnnXXX
            final int hundreds = Integer.parseInt(snumber.substring(9, 12));

            final String result = new StringBuilder()
                    .append(this.getBillions(billions)).append(' ')
                    .append(this.getMillions(millions)).append(' ')
                    .append(this.getThousands(thous)).append(' ')
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
