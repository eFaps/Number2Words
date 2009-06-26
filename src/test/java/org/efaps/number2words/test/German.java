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
 * Implements the test cases for German conversion of numbers to words.
 *
 * @author The eFaps Team
 * @version $Id$
 */
@Test()
public class German
{
    /**
     * Tests the convert for German language.
     *
     * @param _number   number to check
     * @param _text     expected conversion in German words
     */
    @Test(dataProvider = "german")
    public void german(final int _number,
                       final String _text)
    {
        final IConverter converter = Converter.getConverter(Locale.GERMAN);
        Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
    }

    /**
     * Returns the German test data as an array of an array of integer and the
     * expected converted text.
     *
     * @return German test data
     */
    @DataProvider(name = "german")
    public Object[][] germanTestData()
    {
        return new Object[][] {
            {0, "null"},
            {1, "ein"},
            {2, "zwei"},
            {3, "drei"},
            {4, "vier"},
            {5, "f\u00FCnf"},
            {6, "sechs"},
            {7, "sieben"},
            {8, "acht"},
            {9, "neun"},
            {10, "zehn"},
            {16, "sechzehn"},
            {21, "ein-und-zwanzig"},
            {30, "drei\u00DFig"},
            {100, "ein hundert"},
            {118, "ein hundert achtzehn"},
            {122, "ein hundert zwei-und-zwanzig"},
            {200, "zwei hundert"},
            {219, "zwei hundert neunzehn"},
            {1316, "ein tausend drei hundert sechzehn"},
            {24124, "vier-und-zwanzig tausend ein hundert vier-und-zwanzig"},
            {700000, "sieben hundert tausend"},
            {1000000, "eine Million"},
            {2000000, "zwei Millionen"},
            {3000200, "drei Millionen zwei hundert"},
            {123456789, "ein hundert drei-und-zwanzig Millionen "
                        + "vier hundert sechs-und-f\u00FCnfzig tausend "
                        + "sieben hundert neun-und-achtzig"},
            {1000000000, "eine Milliarde"},
            {2147483647, "zwei Milliarden "
                        + "ein hundert sieben-und-vierzig Millionen "
                        + "vier hundert drei-und-achtzig tausend "
                        + "sechs hundert sieben-und-vierzig"}
        };
    }

}
