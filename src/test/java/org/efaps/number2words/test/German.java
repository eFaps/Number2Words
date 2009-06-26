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
    public void germanPositive(final long _number,
                               final String _text)
    {
        final IConverter converter = Converter.getConverter(Locale.GERMAN);
        Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
    }

    /**
     * Test the convert for German language where the <code>_number</code> is
     * interpreted as negative number.
     *
     * @param _number   number to check
     * @param _text     expected conversion in German words
     */
    @Test(dataProvider = "german")
    public void germanNegative(final long _number,
                               final String _text)
    {
        final IConverter converter = Converter.getConverter(Locale.GERMAN);
        if (_number > 0)  {
            Assert.assertEquals(converter.convert((-1 * _number)), "minus " + _text, "test '-" + _number + "'");
        } else  {
            Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
        }
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
            {0L, "null"},
            {1L, "ein"},
            {2L, "zwei"},
            {3L, "drei"},
            {4L, "vier"},
            {5L, "f\u00FCnf"},
            {6L, "sechs"},
            {7L, "sieben"},
            {8L, "acht"},
            {9L, "neun"},
            {10L, "zehn"},
            {16L, "sechzehn"},
            {21L, "ein-und-zwanzig"},
            {30L, "drei\u00DFig"},
            {100L, "ein hundert"},
            {118L, "ein hundert achtzehn"},
            {122L, "ein hundert zwei-und-zwanzig"},
            {200L, "zwei hundert"},
            {219L, "zwei hundert neunzehn"},
            {1316L, "ein tausend drei hundert sechzehn"},
            {24124L, "vier-und-zwanzig tausend ein hundert vier-und-zwanzig"},
            {700000L, "sieben hundert tausend"},
            {1000000L, "eine Million"},
            {2000000L, "zwei Millionen"},
            {3000200L, "drei Millionen zwei hundert"},
            {123456789L, "ein hundert drei-und-zwanzig Millionen "
                        + "vier hundert sechs-und-f\u00FCnfzig tausend "
                        + "sieben hundert neun-und-achtzig"},
            {1000000000L, "eine Milliarde"},
            {2147483647, "zwei Milliarden "
                        + "ein hundert sieben-und-vierzig Millionen "
                        + "vier hundert drei-und-achtzig tausend "
                        + "sechs hundert sieben-und-vierzig"},
            {9223372036854775807L, "neun Trillionen "
                                 + "zwei hundert drei-und-zwanzig Billiarden "
                                 + "drei hundert zwei-und-siebzig Billionen "
                                 + "sechs-und-drei\u00DFig Milliarden "
                                 + "acht hundert vier-und-f\u00FCnfzig Millionen "
                                 + "sieben hundert f\u00FCnf-und-siebzig tausend "
                                 + "acht hundert sieben"},
        };
    }

}
