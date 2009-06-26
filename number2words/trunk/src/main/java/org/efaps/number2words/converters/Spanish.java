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
        "quince", "diecis\u00E9is", "diecisiete", "dieciocho", "diecinueve", "veinte",
        "veintiuno", "veintid\u00F3s", "veintitr\u00E9s", "veinticuatro", "veinticinco",
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
        "sesenta", "setenta", "ochenta", "noventa", "ciento"};

    /**
     * String array to define the conversion for the hundred numbers 100, 200,
     * 300, 400, 500, 600, 700, 800 and 900. In Spanish for some hundred
     * numbers exists special wordings.
     *
     * @see #convertLessThanOneThousand(int)
     */
    private static final String[] HUNDREDS_NAMES = {
        "", "ciento", "doscientos", "trescientos", "quatrocientos", "quinientos",
        "seiscientos", "sietecientos", "ochocientos", "novecientos"};

    /**
     * String array to define the conversion for the log numbers 100,
     * 1&nbsp;000, 1&nbsp;000&nbsp;000 and 1&nbsp;000&nbsp;000&nbsp;000.
     *
     * @see #getPowerNames()
     */
    private static final String[] POWER_NAMES = {
        "mil", "mill\u00F3nes", "mil mill\u00F3nes", "bill\u00F3nes", "mil bill\u00F3nes", "trill\u00F3nes"};

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
        "un mil", "un mill\u00F3n", "mil mill\u00F3nes", "un bill\u00F3n", "mil bill\u00F3nes", "un trill\u00F3n"};

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
               ? Spanish.SINGLE_POWER_NAMES[_power]
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
     * @see AbstractConverter#getPowerNames()
     * @see #POWER_NAMES
     */
    @Override
    protected String[] getPowerNames()
    {
        return Spanish.POWER_NAMES;
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
