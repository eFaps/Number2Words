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
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id$
 */
public class English extends AbstractConverter
{
    private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
        " seventy", " eighty", " ninety" };

    private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
        " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
        " seventeen", " eighteen", " nineteen" };

    private static final String[] log = {" hundred", " thousand", " million", " billion" };

    /**
     * @see org.efaps.number2words.converters.AbstractConverter#getNumNames()
     * @return
     */
    @Override
    protected String[] getNumNames()
    {
        return numNames;
    }

    /**
     * @see org.efaps.number2words.converters.AbstractConverter#getTensNames()
     * @return
     */
    @Override
    protected String[] getTensNames()
    {
        return tensNames;
    }

    /**
     * @see org.efaps.number2words.converters.AbstractConverter#getHundred()
     * @return
     */
    @Override
    protected String[] getLog()
    {
        return log;
    }

    @Override
    protected String getZero()
    {
        return "zero";
    }

}
