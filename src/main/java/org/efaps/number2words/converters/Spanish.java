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
 * The class implements the conversion of numbers to Spanish words.
 *
 * @author The eFaps Team
 * @version $Id$
 */
public class Spanish
    extends AbstractConverter
{
    /**
     * String array to define the Spanish conversion of numbers for 1 till 29.
     *
     * @see #getNumNames()
     * @see #convertLessThanOneThousand(int)
     */
    private static final String[] NUM_NAMES = {
        "", "uno", "dos", "tres", "quatro", "cinco",
        "seis", "siete", "ocho", "nueve",
        "diez", "once", "doce", "trece", "catorce",
        "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte",
        "veintiuno", "veintidós", "veintitr\u00E9s", "veinticuatro", "veinticinco",
        "veintis\u00E9is", "veintisiete", "veintiocho", "veintinueve"};

    /**
     * String array to define the conversion for the numbers 10, 20, 30, 40,
     * 50, 60, 70, 80 and 90.
     *
     * @see #getTensNames()
     * @see #convertLessThanOneThousand(int)
     */
    private static final String[] TENS_NAMES = {
        "", "diez", "veinte", "treinta", "cuarenta", "cincuenta",
        "sesenta", "setenta", "ochenta", "noventa"};

    /**
     * String array to define the conversion for the hundred numbers 100, 200,
     * 300, 400, 500, 600, 700, 800 and 900.
     *
     * @see #convertLessThanOneThousand(int)
     */
    private static final String[] HUNDREDS_NAMES = {
        "", "ciento", "doscientos", "trescientos", "quatrocientos", "quinientos",
        "seiscientos", "sietecientos", "ochocientos", "novecientos"};

    /**
     * String array to define the conversion for the log numbers 100, 1000,
     * 1000000 and 1000000000.
     *
     * @see #getLogNames()
     */
    private static final String[] LOG_NAMES = {"cien", " mil", " mill\u00F3nes", " bill\u00F3nes"};

    /**
     * Method to convert the numbers from 1 to 999. The original method must be
     * overwritten because of some specialties of the Spanish languages for
     * numbers below 30 and for all hundred numbers (100, 200, ...).
     *
     * @param _number number to be converted
     * @return return words for number
     */
    @Override
    protected String convertLessThanOneThousand(final int _number)
    {
        final StringBuilder ret = new StringBuilder();
        if (_number == 100)  {
            ret.append("cien");
        } else  {
            ret.append(Spanish.HUNDREDS_NAMES[_number / 100]);

            final int numsTens = _number % 100;

            // between 1 and 29
            if (numsTens < 30) {
                ret.append(" ").append(Spanish.NUM_NAMES[numsTens]);
            // all others
            } else  {
                ret.append(" ").append(Spanish.TENS_NAMES[numsTens / 10]);
                final String num = Spanish.NUM_NAMES[numsTens % 10];
                if (!"".equals(num))  {
                    ret.append(" y ").append(Spanish.NUM_NAMES[numsTens % 10]);
                }
            }
        }
        return ret.toString();
    }

    /**
     * Converts the billion's of a number to related word representation.
     * Because in Spanish one billion must be written in another way, the
     * original method was overwritten.
     *
     * @param _billions     number of billion's to convert
     * @return converted string with words
     */
    @Override
    protected String getBillions(final int _billions)
    {
        return (_billions == 1)
               ? "un bill\u00F3n"
               : super.getBillions(_billions);
    }

    /**
     * Converts the million's of a number to related word representation.
     * Because in Spanish one million must be written in another way, the
     * original method was overwritten.
     *
     * @param _millions     number of million's to convert
     * @return converted string with words
     */
    @Override
    protected String getMillions(final int _millions)
    {
        return (_millions == 1)
               ? "un mill\u00F3n"
               : super.getMillions(_millions);
    }

    /**
     * Converts the thousand's of a number to related word representation.
     * Because in Spanish one thousands must be written in another way, the
     * original method was overwritten.
     *
     * @param _thousends    number of thousend's to convert
     * @return converted string with words
     */
    @Override
    protected String getThousands(final int _thousends)
    {
        return (_thousends == 1)
               ? "un mil"
               : super.getThousands(_thousends);
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
        return Spanish.NUM_NAMES;
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
        return Spanish.TENS_NAMES;
    }

    /**
     * Returns the string array for log numbers 100, 1000, 1000000 and
     * 1000000000.
     *
     * @return string array of log numbers
     * @see AbstractConverter#getHundred()
     * @see #LOG_NAMES
     */
    @Override
    protected String[] getLogNames()
    {
        return Spanish.LOG_NAMES;
    }

    /**
     * Returns the related Spanish word for the number zero ('0').
     *
     * @return &quot;cero&quot;
     */
    @Override
    protected String getZero()
    {
        return "cero";
    }
}
