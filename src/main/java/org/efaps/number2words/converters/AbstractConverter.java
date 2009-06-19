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
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id$
 */
public abstract class AbstractConverter implements IConverter
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
        if (number % 100 < 20) {
            soFar = getNumNames()[number % 100];
            number /= 100;
        } else {
            soFar = getNumNames()[number % 10];
            number /= 10;

            soFar = getTensNames()[number % 10] + " " + soFar;
            number /= 10;
        }
        if (number != 0) {
            soFar = getNumNames()[number] + " " + getLog()[0] + " " + soFar;
        }
        return soFar;
    }

    protected abstract String[] getNumNames();

    protected abstract String[] getTensNames();

    protected abstract String[] getLog();

    protected abstract String getZero();

    protected String getBillions(final int _billions)
    {
        String ret = "";
        if (_billions != 0) {
            ret = convertLessThanOneThousand(_billions) + " " + getLog()[3];
        }
        return ret;
    }

    protected String getMillions(final int _millions)
    {
        String ret = "";
        if (_millions != 0) {
            ret = convertLessThanOneThousand(_millions) + " " + getLog()[2];
        }
        return ret;
    }

    protected String getThousands(final int _thousends)
    {
        String ret = "";
        if (_thousends != 0) {
            ret = convertLessThanOneThousand(_thousends) + " " + getLog()[1];
        }
        return ret;
    }

    /**
     * Method to convert a number into words.
     * @see org.efaps.number2words.IConverter#convert(long)
     * @param _number number to convert
     * @return  words representing the number
     */
    public String convert(final long _number)
    {
        String ret;
        // 0 to 999 999 999 999
        if (_number == 0) {
            ret = getZero();
        } else {
            String snumber = Long.toString(_number);
            // pad with "0"
            final String mask = "000000000000";
            final DecimalFormat df = new DecimalFormat(mask);
            snumber = df.format(_number);

            // XXXnnnnnnnnn
            final int billions = Integer.parseInt(snumber.substring(0, 3));
            // nnnXXXnnnnnn
            final int millions = Integer.parseInt(snumber.substring(3, 6));
            // nnnnnnXXXnnn
            final int thous = Integer.parseInt(snumber.substring(6, 9));
            // nnnnnnnnnXXX
            final int hundrets = Integer.parseInt(snumber.substring(9, 12));

            final String result = getBillions(billions) + " " + getMillions(millions) + " " + getThousands(thous) + " "
                            + convertLessThanOneThousand(hundrets);

            // remove extra spaces!
            ret = result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
        }
        return ret;
    }
}
