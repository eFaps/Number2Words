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

    /**
     * Returns <i>true</i> in the case the converter from numbers to words uses
     * the decimal system. E.g. the converter for German language is using the
     * decimal system, otherwise the converter for Roman Numbers is NOT using
     * the decimal system (and returns then <i>false</i>).
     *
     * @return <i>true</i> if the converter of the used language uses decimal
     *         system; otherwise <i>false</i>
     */
    boolean isDecimal();

    /**
     * <p>Returns <i>true</i> in the case the converter for a language uses the
     * short scale for the decimal system.</p>
     * <p>If the language uses the decimal system ({@link #isDecimal}), two
     * different numerical systems &quot;large scale&quot; and &quot;short
     * scale&quot; exists. Sometimes used numerical system may also changed in
     * the history for one language. E.g. in the United Kindom before the
     * second world war they used the large scale system. In 1974 the UK
     * government changed to short scale for their statistics. Another example
     * is the French language. They changed after the second world war from
     * short scale to long scale.</p>
     * <p>In 1948 the 9th General Conference on Weights and Measures proposed
     * the universal use of the long scale. So here this means that the usage
     * of short scale is an specialty, but could be checked with this
     * method.</p>
     * <p>The different between this two numerical systems is, that a billion
     * in short scale is not the same that in the long scale. The following
     * table gives an overview:
     * <table border="1">
     * <tr><th>Value</th><th>Short Scale</th><th>Long Scale</th></tr>
     * <tr><td>10<sup>0</sup></td><td>one</td><td>one</td></tr>
     * <tr><td>10<sup>3</sup></td><td>thousand</td><td>thousand</td></tr>
     * <tr><td>10<sup>6</sup></td><td>million</td><td>million</td></tr>
     * <tr><td>10<sup>9</sup></td><td>billion</td><td>thousand million
     *      (sometimes milliard)</td></tr>
     * <tr><td>10<sup>12</sup></td><td>trillion</td><td>billion</td></tr>
     * <tr><td>10<sup>15</sup></td><td>quadrillion</td><td>thousand billion
     *      (sometimes billiard)</td></tr>
     * <tr><td>10<sup>18</sup></td><td>quintillion</td><td>trillion</td></tr>
     * </table>
     * </p>
     * <p>For a deeper explanation see e.g. the description of the short and
     * long scale in the Wikipedia.</p>
     *
     * @return <i>true</i> if the converter uses short scale
     * @see #isDecimal()
     */
    boolean usesShortScale();
}
