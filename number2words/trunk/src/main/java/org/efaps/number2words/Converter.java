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
import org.efaps.number2words.converters.German;
import org.efaps.number2words.converters.Spanish;

/**
 * <p>Main entry point to get language specific number to word converters.
 * Depending on the use case for what the converter will be used, the male
 * {@link #getMaleConverter(Locale)}, female or neuter static method should be
 * called to get the converter instance.</p>
 *
 * <p><b>Example:</b><br/>
 * Male converter for German language to translate 100 to words:
 * <pre>
 * final IConverter converter = Converter.getMaleConverter(Locale.GERMAN);
 * final String text = converter.convert(100L);
 * </pre>
 * The result in <code>text</code> is &quot;ein hundert&quot;.
 * </p>
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

    /**
     * Returns for a language defined with <code>_locale</code> the related
     * text converter for male numbers.
     *
     * @param _locale   locale which defines the language
     * @return related converted for given <code>_locale</code>
     */
    public static IConverter getMaleConverter(final Locale _locale)
    {
        IConverter converter = null;
        if ("de".equals(_locale.getLanguage()))  {
            converter = new German();
        } else if ("en".equals(_locale.getLanguage()))  {
            converter = new English();
        } else if ("es".equals(_locale.getLanguage()))  {
            converter = new Spanish();
        }
        return converter;
    }
}
