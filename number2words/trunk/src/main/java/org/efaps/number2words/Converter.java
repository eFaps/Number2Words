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

package org.efaps.number2words;

import java.util.Locale;

import org.efaps.number2words.converters.English;
import org.efaps.number2words.converters.Spanish;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id$
 */
public final class Converter
{
    /**
     * Private constructor to make a singleton.
     */
    private Converter()
    {
    }

    public static IConverter getConverter(final Locale _locale) {
        IConverter converter = null;
        if (_locale.getLanguage().equals("en")) {
            converter = new English();
        } else if (_locale.getLanguage().equals("es")) {
            converter = new Spanish();
        }
        return converter;
    }
}
