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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlSimpleUtil {
    public static Document string2dom(final String xml) throws IOException {
        try {
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            return documentBuilder.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException e) {
            throw new IOException(e);
        } catch (SAXException e) {
            throw new IOException(e);
        }
    }

    /**
     * Convert document to xml.
     * 
     * @param element input root element.
     * @param fileOutput output file.
     * @throws IOException IO Exception occurred.
     */
    public static void dom2xml(Element element, File fileOutput) throws IOException {
        try {
            final Transformer transformer = TransformerFactory.newInstance().newTransformer();
            // インデントなどは実施しない。
            final DOMSource source = new DOMSource(element);
            final OutputStream outStream = new BufferedOutputStream(new FileOutputStream(fileOutput));
            final StreamResult target = new StreamResult(outStream);
            transformer.transform(source, target);
        } catch (TransformerFactoryConfigurationError ex1) {
            throw new IOException(ex1);
        } catch (TransformerConfigurationException ex2) {
            throw new IOException(ex2);
        } catch (TransformerException ex3) {
            throw new IOException(ex3);
        }
    }
}
