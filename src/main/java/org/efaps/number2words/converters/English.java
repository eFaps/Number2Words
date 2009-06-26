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
 * The class implements the conversion of numbers to English words.
 *
 * @author The eFaps Team
 * @version $Id$
 */
public class English
    extends AbstractConverter
{
    /**
     * String array to define the conversion of numbers for 1 till 19.
     *
     * @see #getNumNames()
     */
    private static final String[] NUM_NAMES = {
        "", " one", " two", " three", " four", " five", " six", " seven",
        " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
        " seventeen", " eighteen", " nineteen" };

    /**
     * String array to define the conversion for the numbers 10, 20, 30, 40,
     * 50, 60, 70, 80 and 90.
     *
     * @see #getTensNames()
     */
    private static final String[] TENS_NAMES = {
        "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
        " seventy", " eighty", " ninety" };

    /**
     * String array to define the conversion for the log numbers 100, 1000,
     * 1000000 and 1000000000.
     *
     * @see #getLogNames()
     */
    private static final String[] LOG_NAMES = {" hundred", " thousand", " million", " billion"};

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
        return English.NUM_NAMES;
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
        return English.TENS_NAMES;
    }

    /**
     * Returns the string array for log numbers 100, 1000, 1000000 and
     * 1000000000.
     *
     * @return string array of log numbers
     * @see AbstractConverter#getLogNames()
     * @see #LOG_NAMES
     */
    @Override
    protected String[] getLogNames()
    {
        return English.LOG_NAMES;
    }

    /**
     * Returns the related English word for the number zero ('0').
     *
     * @return &quot;zero&quot;
     */
    @Override
    protected String getZero()
    {
        return "zero";
    }
}
