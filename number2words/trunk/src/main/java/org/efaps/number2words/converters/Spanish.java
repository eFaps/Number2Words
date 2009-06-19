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
public class Spanish extends AbstractConverter
{
    private static final String[] tensNames = { "", "diez", "veinte", "treinta", "cuarenta", "cincuenta",
        "sesenta", "setenta", "ochenta", "noventa" };

    private static final String[] numNames = { "", "uno", "dos", "tres", "quatro", "cinco", "seis", "siete",
        "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince", "diecisis",
        "diecisiete", "dieciocho", "diecinueve" };

    private static final String[] log = {" cientos", " mil", " mill—nes", " bill—nes" };

    @Override
    protected String convertLessThanOneThousand(int _number)
    {
        String soFar = "";
        if (_number == 100 ) {
            soFar = "cien";
            _number =0;
        }
        if (_number > 100 && _number < 200) {
            soFar = "ciento";
            _number -= 100;
        }
        if (_number % 100 < 20) {
            soFar += " " + getNumNames()[_number % 100];
            _number /= 100;
            if (_number != 0) {
                soFar = getNumNames()[_number] + " " + getLog()[0] + " " + soFar;
            }
        } else if ((_number % 100 < 30) ) {
            soFar = getNumNames()[_number % 10];
            _number /= 10;

            soFar = getTensNames()[_number % 10] + " " + soFar;
            _number /= 10;
            if (_number != 0) {
                soFar = getNumNames()[_number] +" " +  getLog()[0] +" " +  soFar;
            }
        }    else {
            soFar = getNumNames()[_number % 10];
            _number /= 10;

            soFar = getTensNames()[_number % 10] + " y " + soFar;
            _number /= 10;
            if (_number != 0) {
                soFar = getNumNames()[_number] + " " + getLog()[0] + " " + soFar;
            }
        }

        return soFar;
    }

    @Override
    protected String getThousands(final int _thousends)
    {
        String ret = "";
        switch (_thousends) {
        case 0:
            break;
        case 1:
            ret= "un " + getLog()[1];
            break;
        default:
            ret = convertLessThanOneThousand(_thousends) + " " + getLog()[1];
            break;
        }
        return ret;
    }

    @Override
    protected String getBillions(final int _billions) {
        String ret = "";
        switch (_billions) {
        case 0:
            break;
        case 1:
            ret= "un bill—n";
            break;
        default:
            ret = convertLessThanOneThousand(_billions) + " " + getLog()[2];
            break;
        }
        return ret;
    }

    @Override
    protected String getMillions(final int _millions) {
        String ret = "";
        switch (_millions) {
        case 0:
            break;
        case 1:
            ret= "un mill—n";
            break;
        default:
            ret = convertLessThanOneThousand(_millions) + " " + getLog()[3];
            break;
        }
        return ret;
    }

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
        return "cero";
    }

}
