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
 * Implements the test cases for English conversion of numbers to words.
 *
 * @author The eFaps Team
 * @version $Id$
 */
@Test()
public class English
{
    /**
     * Test the convert for English language.
     *
     * @param _number   number to check
     * @param _text     expected conversion in English
     */
    @Test(dataProvider = "english")
    public void englishPositive(final long _number,
                                final String _text)
    {
        final IConverter converter = Converter.getConverter(Locale.ENGLISH);
        Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
    }

    /**
     * Test the convert for English language where the <code>_number</code> is
     * interpreted as negative number.
     *
     * @param _number   number to check
     * @param _text     expected conversion in English
     */
    @Test(dataProvider = "english")
    public void englishNegative(final long _number,
                                final String _text)
    {
        final IConverter converter = Converter.getConverter(Locale.ENGLISH);
        if (_number > 0)  {
            Assert.assertEquals(converter.convert((-1 * _number)), "minus " + _text, "test '-" + _number + "'");
        } else  {
            Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
        }
    }

    /**
     * Returns the English test data as an array of an array of integer and the
     * related converted text.
     *
     * @return English test data
     */
    @DataProvider(name = "english")
    public Object[][] englishTestData()
    {
        return new Object[][] {
            {0L, "zero"},
            {1L, "one"},
            {2L, "two"},
            {3L, "three"},
            {4L, "four"},
            {5L, "five"},
            {6L, "six"},
            {7L, "seven"},
            {8L, "eight"},
            {16L, "sixteen"},
            {21L, "twenty-one"},
            {71L, "seventy-one"},
            {100L, "one hundred"},
            {118L, "one hundred eighteen"},
            {200L, "two hundred"},
            {219L, "two hundred nineteen"},
            {800L, "eight hundred"},
            {801L, "eight hundred one"},
            {1316L, "one thousand three hundred sixteen"},
            {700000L, "seven hundred thousand"},
            {900000L, "nine hundred thousand"},
            {1000000L, "one million"},
            {2000000L, "two million"},
            {3000200L, "three million two hundred"},
            {123456789L, "one hundred twenty-three million "
                        + "four hundred fifty-six thousand "
                        + "seven hundred eighty-nine"},
            {2147483647L, "two billion "
                        + "one hundred forty-seven million "
                        + "four hundred eighty-three thousand "
                        + "six hundred forty-seven"},
            {9223372036854775807L, "nine quintillion "
                            + "two hundred twenty-three quadrillion "
                            + "three hundred seventy-two trillion "
                            + "thirty-six billion "
                            + "eight hundred fifty-four million "
                            + "seven hundred seventy-five thousand "
                            + "eight hundred seven"},
        };
    }
}
