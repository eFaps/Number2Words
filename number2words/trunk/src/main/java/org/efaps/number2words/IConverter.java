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

/**
 * Interface description which must be implement for a language to convert
 * numbers to related text representation.
 *
 * @author The eFaps Team
 * @version $Id$
 */
public interface IConverter
{
    /**
     * Converts the <code>_number</code> into the related text representation.
     *
     * @param _number   number to convert
     * @return converted number
     */
    String convert(final long _number);
}
