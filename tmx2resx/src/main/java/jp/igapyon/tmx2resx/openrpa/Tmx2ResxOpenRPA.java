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

        // 本体
        {
            File fileTmx = new File("../tmx/OpenRPA.OpenRPA-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // AviRecorder
        {
            File fileTmx = new File("../tmx/OpenRPA.AviRecorder-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.AviRecorder/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.AviRecorder/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Elis.Rossum
        {
            File fileTmx = new File("../tmx/OpenRPA.Elis.Rossum-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Elis.Rossum/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Elis.Rossum/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // FileWatcher
        {
            File fileTmx = new File("../tmx/OpenRPA.FileWatcher-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.FileWatcher/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.FileWatcher/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Forms
        {
            File fileTmx = new File("../tmx/OpenRPA.Forms-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Forms/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Forms/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // IE
        {
            File fileTmx = new File("../tmx/OpenRPA.IE-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.IE/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.IE/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Image
        {
            File fileTmx = new File("../tmx/OpenRPA.Image-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Image/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Image/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Interfaces
        {
            File fileTmx = new File("../tmx/OpenRPA.Interfaces-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Interfaces/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Interfaces/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Java
        {
            File fileTmx = new File("../tmx/OpenRPA.Java-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Java/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Java/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // NM
        {
            File fileTmx = new File("../tmx/OpenRPA.NM-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.NM/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.NM/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Office
        {
            File fileTmx = new File("../tmx/OpenRPA.Office-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Office/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Office/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // OpenFlowDB
        {
            File fileTmx = new File("../tmx/OpenRPA.OpenFlowDB-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.OpenFlowDB/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.OpenFlowDB/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // RDServicePlugin
        {
            File fileTmx = new File("../tmx/OpenRPA.RDServicePlugin-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.RDServicePlugin/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.RDServicePlugin/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Script
        {
            File fileTmx = new File("../tmx/OpenRPA.Script-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Script/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Script/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Updater
        {
            File fileTmx = new File("../tmx/OpenRPA.Updater-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Updater/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Updater/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Utilities
        {
            File fileTmx = new File("../tmx/OpenRPA.Utilities-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Utilities/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Utilities/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        // Windows
        {
            File fileTmx = new File("../tmx/OpenRPA.Windows-en2ja.tmx");
            final Map<String, String> tmxMap = TmxSimpleUtil.file2map(fileTmx, "en-US", "ja");

            File fileInput = new File(fileRoot, "OpenRPA.Windows/Resources/strings.resx");
            if (!fileInput.exists()) {
                throw new IOException("resx filenot found: " + fileInput.getAbsolutePath());
            }

            File fileOutput = new File(fileRoot, "OpenRPA.Windows/Resources/strings.ja.resx");

            TransResxUtil.translate(tmxMap, fileInput, fileOutput);
        }

        System.err.println("end.");
    }
}
