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

package org.efaps.number2words.test;

import java.util.Locale;

import org.efaps.number2words.Converter;
import org.efaps.number2words.IConverter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Implements the test cases for Spanish conversion of numbers to words.
 *
 * @author The eFaps Team
 * @version $Id$
 */
@Test
public class Spanish
{
    /**
     * Tests the convert for Spanish language.
     *
     * @param _number   Spanish number to check
     * @param _text     expected conversion
     */
    @Test(dataProvider = "spanish")
    public void spanishPositive(final long _number,
                                final String _text)
    {
        final IConverter converter = Converter.getMaleConverter(new Locale("es"));
        Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
        Assert.assertEquals(converter.usesShortScale(), false, "check Spanish uses long scale");
        Assert.assertEquals(converter.isDecimal(), true, "check Spanish uses decimal system");
    }

    /**
     * Test the convert for Spanish language where the <code>_number</code> is
     * interpreted as negative number.
     *
     * @param _number   Spanish number to check
     * @param _text     expected conversion
     */
    @Test(dataProvider = "spanish")
    public void spanishNegative(final long _number,
                                final String _text)
    {
        final IConverter converter = Converter.getMaleConverter(new Locale("es"));
        if (_number > 0)  {
            Assert.assertEquals(converter.convert(-1 * _number), "menos " + _text, "test '-" + _number + "'");
        } else  {
            Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
        }
        Assert.assertEquals(converter.usesShortScale(), false, "check Spanish uses long scale");
        Assert.assertEquals(converter.isDecimal(), true, "check Spanish uses decimal system");
    }

    /**
     * Returns the Spanish test data as an array of an array of integer and the
     * related converted text.
     *
     * @return Spanish test data
     */
    @DataProvider(name = "spanish")
    public Object[][] spanishTestData()
    {
        return new Object[][] {
            {0L, "cero"},
            {1L, "uno"},
            {2L, "dos"},
            {3L, "tres"},
            {4L, "cuatro"},
            {5L, "cinco"},
            {6L, "seis"},
            {7L, "siete"},
            {8L, "ocho"},
            {16L, "diecis\u00E9is"},
            {21L, "veintiuno"},
            {22L, "veintid\u00F3s"},
            {23L, "veintitr\u00E9s"},
            {24L, "veinticuatro"},
            {25L, "veinticinco"},
            {26L, "veintis\u00E9is"},
            {27L, "veintisiete"},
            {28L, "veintiocho"},
            {29L, "veintinueve"},
            {30L, "treinta"},
            {100L, "cien"},
            {118L, "ciento dieciocho"},
            {122L, "ciento veintid\u00F3s"},
            {147L, "ciento cuarenta y siete"},
            {200L, "doscientos"},
            {219L, "doscientos diecinueve"},
            {221L, "doscientos veintiuno"},
            {500L, "quinientos"},
            {700L, "setecientos"},
            {721L, "setecientos veintiuno"},
            {800L, "ochocientos"},
            {801L, "ochocientos uno"},
            {1316L, "un mil trescientos diecis\u00E9is"},
            {21000L, "veintiun mil"},
            {21045L, "veintiun mil cuarenta y cinco"},
            {24124L, "veinticuatro mil ciento veinticuatro"},
            {700000L, "setecientos mil"},
            {721000L, "setecientos veintiun mil"},
            {735000L, "setecientos treinta y cinco mil"},
            {851000L, "ochocientos cincuenta y un mil"},
            {851321L, "ochocientos cincuenta y un mil trescientos veintiuno"},
            {900000L, "novecientos mil"},
            {1000000L, "un mill\u00F3n"},
            {2000000L, "dos mill\u00F3nes"},
            {3000200L, "tres mill\u00F3nes doscientos"},
            {321521221L, "trescientos veintiun mill\u00F3nes quinientos veintiun mil doscientos veintiuno"},
            {311521221L, "trescientos once mill\u00F3nes quinientos veintiun mil doscientos veintiuno"},
            {123456789L, "ciento veintitr\u00E9s mill\u00F3nes "
                        + "cuatrocientos cincuenta y seis mil "
                        + "setecientos ochenta y nueve"},
            {1000000000L, "mil mill\u00F3nes"},
            {2147483647L, "dos mil mill\u00F3nes ciento cuarenta y siete mill\u00F3nes "
                        + "cuatrocientos ochenta y tres mil "
                        + "seiscientos cuarenta y siete"},
            {21147483647L, "veintiun mil mill\u00F3nes ciento cuarenta y siete mill\u00F3nes "
                        + "cuatrocientos ochenta y tres mil "
                        + "seiscientos cuarenta y siete"},
            {21141481641L, "veintiun mil mill\u00F3nes ciento cuarenta y un mill\u00F3nes "
                        + "cuatrocientos ochenta y un mil "
                        + "seiscientos cuarenta y uno"},
            {1000000000000L, "un bill\u00F3n"},
            {1000000000000000L, "mil bill\u00F3nes"},
            {2000000000000000L, "dos mil bill\u00F3nes"},
            {1000000000000000000L, "un trill\u00F3n"},
            {9221371031854775807L, "nueve trill\u00F3nes "
                                + "doscientos veintiun mil bill\u00F3nes "
                                + "trescientos setenta y un bill\u00F3nes "
                                + "treinta y un mil mill\u00F3nes "
                                + "ochocientos cincuenta y cuatro mill\u00F3nes "
                                + "setecientos setenta y cinco mil "
                                + "ochocientos siete"},
        };
    }
}
