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
    public void english(final int _number,
                        final String _text)
    {
        final IConverter converter = Converter.getConverter(Locale.ENGLISH);
        Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
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
            {700000, "seven hundred thousand"},
            {900000, "nine hundred thousand"},
            {1000000, "one million"},
            {2000000, "two million"},
            {3000200, "three million two hundred"},
            {123456789, "one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine"},
            {2147483647, "two billion one hundred forty seven million "
                        + "four hundred eighty three thousand six hundred forty seven"}
        };
    }
}
