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
@Test()
public class Spanish
{
    /**
     * Tests the convert for Spanish language.
     *
     * @param _number   Spanish number to check
     * @param _text     expected conversion
     */
    @Test(dataProvider = "spanish")
    public void spanish(final int _number,
                        final String _text)
    {
        final IConverter converter = Converter.getConverter(new Locale("es"));
        Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
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
            {0, "cero"},
            {1, "uno"},
            {2, "dos"},
            {3, "tres"},
            {4, "quatro"},
            {5, "cinco"},
            {6, "seis"},
            {7, "siete"},
            {8, "ocho"},
            {16, "diecis\u00E9is"},
            {21, "veintiuno"},
            {22, "veintid\u00F3s"},
            {23, "veintitr\u00E9s"},
            {24, "veinticuatro"},
            {25, "veinticinco"},
            {26, "veintis\u00E9is"},
            {27, "veintisiete"},
            {28, "veintiocho"},
            {29, "veintinueve"},
            {30, "treinta"},
            {100, "cien"},
            {118, "ciento dieciocho"},
            {122, "ciento veintid\u00F3s"},
            {147, "ciento cuarenta y siete"},
            {200, "doscientos"},
            {219, "doscientos diecinueve"},
            {500, "quinientos"},
            {800, "ochocientos"},
            {801, "ochocientos uno"},
            {1316, "un mil trescientos diecis\u00E9is"},
            {24124, "veinticuatro mil ciento veinticuatro"},
            {700000, "sietecientos mil"},
            {900000, "novecientos mil"},
            {1000000, "un mill\u00F3n"},
            {2000000, "dos mill\u00F3nes"},
            {3000200, "tres mill\u00F3nes doscientos"},
            {123456789, "ciento veintitr\u00E9s mill\u00F3nes "
                        + "quatrocientos cincuenta y seis mil "
                        + "sietecientos ochenta y nueve"},
            {1000000000, "un bill\u00F3n"},
            {2147483647, "dos bill\u00F3nes ciento cuarenta y siete mill\u00F3nes "
                        + "quatrocientos ochenta y tres mil "
                        + "seiscientos cuarenta y siete"}
        };
    }
}
