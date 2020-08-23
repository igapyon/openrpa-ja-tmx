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
package jp.igapyon.tmx2resx.openrpa;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jp.igapyon.tmx2resx.SimpleTmxReader;
import jp.igapyon.tmx2resx.Tmx2Resx;

public class Tmx2ResxOpenRPA {
    public static void main(String[] args) throws IOException {
        final Map<String, String> tmxMap = SimpleTmxReader.file2map(new File("../tmx/OpenRPA-OpenRPA-en2ja.tmx"),
                "en-US", "ja");
        //  System.err.println(tmxMap.get("Add variables"));

        File fileRoot = new File("../../openrpa/");
        if (!fileRoot.exists()) {
            throw new IOException("openrpa folder not found: " + fileRoot.getAbsolutePath());
        }
        File file = new File(fileRoot, "OpenRPA/Resources/strings.resx");
        if (!file.exists()) {
            throw new IOException("resx filenot found: " + file.getAbsolutePath());
        }

        String resxString = FileUtils.readFileToString(file, "UTF-8");
        resxString = resxString.replace("\uFEFF", ""); // BOM

        //      System.err.println(resxString);

        Document document = Tmx2Resx.string2dom(resxString);

        final XPath xpath = XPathFactory.newInstance().newXPath();
        try {
            final NodeList list = (NodeList) xpath.evaluate("/root/data", document, XPathConstants.NODESET);
            for (int index = 0; index < list.getLength(); index++) {
               // System.err.println(list.item(index));

                final Element eleValue = (Element) xpath.evaluate("value", list.item(index), XPathConstants.NODE);
             //   System.err.println(eleValue.getTextContent());

                String dest = tmxMap.get(eleValue.getTextContent());
                if (dest != null) {
                //    System.err.println(dest);

                    for (;;) {
                        Node first = eleValue.getFirstChild();
                        if (first == null) {
                            break;
                        }
                        eleValue.removeChild(first);
                    }

                    eleValue.appendChild(document.createTextNode(dest));
                }
            }
        } catch (XPathExpressionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Tmx2Resx.dom2xml(document.getDocumentElement(), new File(fileRoot, "OpenRPA/Resources/strings.ja.resx"));
    }
}
