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

import jp.igapyon.tmx2resx.TmxSimpleUtil;

public class Tmx2ResxOpenRPA {
    public static void main(String[] args) throws IOException {

        File fileRoot = new File("../../openrpa/");
        if (!fileRoot.exists()) {
            throw new IOException("openrpa folder not found: " + fileRoot.getAbsolutePath());
        }

        {
            File fileTmx = new File("../tmx/OpenRPA-OpenRPA-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        System.err.println("end.");
    }
}
