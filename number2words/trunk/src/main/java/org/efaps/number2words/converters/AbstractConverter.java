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
     * Method to convert the numbers from 1 to 999.
     *
     * @param _number number to be converted
     * @return return words for number
     */
    protected String convertLessThanOneThousand(final int _number)
    {
        int number = _number;
        String soFar;
        if ((number % 100) < 20)  {
            soFar = this.getNumNames()[number % 100];
            number /= 100;
        } else  {
            soFar = this.getNumNames()[number % 10];
            number /= 10;

            soFar = this.getTensNames()[number % 10] + " " + soFar;
            number /= 10;
        }
        if (number != 0)  {
            soFar = this.getNumNames()[number] + " " + getLogNames()[0] + " " + soFar;
        }
        return soFar;
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
     * Returns the string array for log numbers 100, 1000, 1000000 and
     * 1000000000.
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
        final String ret;
        if (_billions != 0)  {
            ret = this.convertLessThanOneThousand(_billions) + " " + this.getLogNames()[3];
        } else  {
            ret = "";
        }
        return ret;
    }

    /**
     * Converts the million's of a number to related word representation.
     *
     * @param _millions     number of million's to convert
     * @return converted string with words
     */
    protected String getMillions(final int _millions)
    {
        final String ret;
        if (_millions != 0) {
            ret = this.convertLessThanOneThousand(_millions) + " " + this.getLogNames()[2];
        } else  {
            ret = "";
        }
        return ret;
    }

    /**
     * Converts the thousand's of a number to related word representation.
     *
     * @param _thousends    number of thousend's to convert
     * @return converted string with words
     */
    protected String getThousands(final int _thousends)
    {
        final String ret;
        if (_thousends != 0) {
            ret = this.convertLessThanOneThousand(_thousends) + " " + this.getLogNames()[1];
        } else  {
            ret = "";
        }
        return ret;
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
