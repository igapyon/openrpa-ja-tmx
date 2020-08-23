/*
 * Copyright 2020 Toshiki Iga
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.igapyon.tmx2resx;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SimpleTmxReader {
    public static Map<String, String> file2map(final File tmx, final String langSrc, final String langDst)
            throws IOException {
        final Map<String, String> result = new LinkedHashMap<>();

        String tmxString = FileUtils.readFileToString(tmx, "UTF-8");
        tmxString = tmxString.replace("\uFEFF", ""); // BOM
        tmxString = tmxString.replace("<!DOCTYPE tmx SYSTEM \"tmx11.dtd\">", ""); // Drop DTD

        Document document = Tmx2Resx.string2dom(tmxString);

        final XPath xpath = XPathFactory.newInstance().newXPath();
        try {
            final NodeList tuList = (NodeList) xpath.evaluate("/tmx/body/tu", document, XPathConstants.NODESET);
            for (int indexTu = 0; indexTu < tuList.getLength(); indexTu++) {
                String stringSrc = null;
                String stringDst = null;

                final NodeList tuvList = (NodeList) xpath.evaluate("tuv", tuList.item(indexTu), XPathConstants.NODESET);
                for (int indexTuv = 0; indexTuv < tuvList.getLength(); indexTuv++) {
                    Element eleTuv = (Element) tuvList.item(indexTuv);
                    String lang = eleTuv.getAttribute("lang");
                //    System.err.println(lang);

                    String segText = (String) xpath.evaluate("seg/text()", eleTuv, XPathConstants.STRING);
              //      System.err.println(segText);

                    if (langSrc.equals(lang)) {
                        stringSrc = segText;
                    }
                    if (langDst.equals(lang)) {
                        stringDst = segText;
                    }
                }

                if (stringSrc != null || stringDst != null) {
                    result.put(stringSrc, stringDst);
                }
            }
        } catch (XPathExpressionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }
}
