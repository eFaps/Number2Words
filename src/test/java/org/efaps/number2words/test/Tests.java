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
import org.testng.annotations.Test;

/**
 * Implements the test cases for English and Spanish conversion of numbers to
 * word.
 *
 * @author The eFaps Team
 * @version $Id$
 */
@Test()
public class Tests
{
    /**
     * Test the convert for English language.
     */
    public void english()
    {
        final Object[][] data = new Object[][] {
            {0, "zero"},
            {1, "one"},
            {2, "two"},
            {3, "three"},
            {4, "four"},
            {5, "five"},
            {6, "six"},
            {7, "seven"},
            {8, "eight"},
            {16, "sixteen"},
            {100, "one hundred"},
            {118, "one hundred eighteen"},
            {200, "two hundred"},
            {219, "two hundred nineteen"},
            {800, "eight hundred"},
            {801, "eight hundred one"},
            {1316, "one thousand three hundred sixteen"},
            {1000000, "one million"},
            {2000000, "two million"},
            {3000200, "three million two hundred"},
            {700000, "seven hundred thousand"},
            {900000, "nine hundred thousand"},
            {123456789, "one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine"},
            {2147483647, "two billion one hundred forty seven million "
                        + "four hundred eighty three thousand six hundred forty seven"}
        };
        this.test(data, Locale.ENGLISH);
    }

    /**
     * Tests the test for Spanish language.
     */
    public void spanish()
    {
        final Object[][] data = new Object[][] {
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
            {100, "cien"},
            {118, "ciento dieciocho"},
            {200, "dos cientos"},
            {219, "dos cientos diecinueve"},
            {800, "ocho cientos"},
            {801, "ocho cientos uno"},
            {1316, "un mil tres cientos diecis\u00E9is"},
            {24124, "veinte quatro mil veinte quatro"},
            {1000000, "un mill\u00F3n"},
            {2000000, "dos bill\u00F3nes"},
            {3000200, "tres bill\u00F3nes dos cientos"},
            {700000, "siete cientos mil"},
            {900000, "nueve cientos mil"},
            {123456789, "veinte tres bill\u00F3nes quatro cientos cincuenta y seis mil siete cientos ochenta y nueve"},
            {2147483647, "dos mill\u00F3nes cuarenta y siete bill\u00F3nes quatro cientos ochenta "
                        + "y tres mil seis cientos cuarenta y siete"},
        };
        this.test(data, new Locale("es"));
    }

    /**
     * Tests that for given data the number to word conversion is correct. The
     * <code>_data</code> is an array of an array of integer and the related
     * converted text.
     *
     * @param _data     data array to test
     * @param _locale   locale of the data to test
     */
    private void test(final Object[][] _data,
                      final Locale _locale)
    {
        final IConverter converter = Converter.getConverter(_locale);
        for (final Object[] dataLine : _data)  {
            Assert.assertEquals(converter.convert((Integer) dataLine[0]), (String) dataLine[1]);
        }
    }
}
