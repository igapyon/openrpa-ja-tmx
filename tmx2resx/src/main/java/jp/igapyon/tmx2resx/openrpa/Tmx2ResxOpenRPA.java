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

import jp.igapyon.tmx2resx.TmxSimpleUtil;
import jp.igapyon.tmx2resx.XmlSimpleUtil;

public class Tmx2ResxOpenRPA {
    public static void main(String[] args) throws IOException {

        File fileRoot = new File("../../openrpa/");
        if (!fileRoot.exists()) {
            throw new IOException("openrpa folder not found: " + fileRoot.getAbsolutePath());
        }
        File fileInput = new File(fileRoot, "OpenRPA/Resources/strings.resx");
        if (!fileInput.exists()) {
            throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
        }

        File fileOutput = new File(fileRoot, "OpenRPA/Resources/strings.ja.resx");

        File fileTmx = new File("../tmx/OpenRPA-OpenRPA-en2ja.tmx");

        final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

        String resxString = FileUtils.readFileToString(fileInput, "UTF-8");
        resxString = resxString.replace("\uFEFF", ""); // BOM

        Document document = XmlSimpleUtil.string2dom(resxString);

        final XPath xpath = XPathFactory.newInstance().newXPath();
        try {
            final NodeList list = (NodeList) xpath.evaluate("/root/data", document, XPathConstants.NODESET);
            for (int index = 0; index < list.getLength(); index++) {
                final Element eleValue = (Element) xpath.evaluate("value", list.item(index), XPathConstants.NODE);

                String dest = tmxMap.get(eleValue.getTextContent());
                if (dest != null) {
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
            throw new IOException(e);
        }

        String xml = XmlSimpleUtil.dom2xml(document.getDocumentElement());
        xml = "\uFEFF" + xml;
        xml = xml.replaceAll("\"/>\\n", "\" />\n");
        FileUtils.writeStringToFile(fileOutput, xml, "utf-8");

        System.err.println("end.");
    }
}
