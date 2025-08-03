package com.blink.academy.film.support.stream.ts.google.flavor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public class XML {
    public static File m_fXML;
    public static FileWriter m_fXMLWriter;
    public static int m_nIndent;

    public static void CreateXmlHeader(String str, String str2) throws IOException {
        try {
            m_fXML = new File(str);
            FileWriter fileWriter = new FileWriter(m_fXML);
            m_fXMLWriter = fileWriter;
            fileWriter.write("<?xml version=\"1.0\"?>\n<" + str2 + "\n    xmlns=\"http://www.ee.columbia.edu/flavor\"\n    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n>\n");
        } catch (IOException unused) {
        }
    }

    public static void EndXml(String str) throws IOException {
        try {
            m_fXMLWriter.write("</" + str + ">");
            m_fXMLWriter.flush();
            m_fXMLWriter.close();
        } catch (IOException unused) {
        }
    }

    public static void IntoAClass(String str, int i) throws IOException {
        PutIndents();
        try {
            if (i > 0) {
                m_fXMLWriter.write("<" + str + " aligned=\" + nAlign + \">\n");
            } else {
                m_fXMLWriter.write("<" + str + ">\n");
            }
        } catch (IOException unused) {
        }
        m_nIndent++;
    }

    public static void OutOfClass(String str) throws IOException {
        m_nIndent--;
        PutIndents();
        try {
            m_fXMLWriter.write(str + "\n");
        } catch (IOException unused) {
        }
    }

    public static void PutIndents() throws IOException {
        for (int i = 0; i <= m_nIndent; i++) {
            try {
                m_fXMLWriter.write("    ");
            } catch (IOException unused) {
            }
        }
    }

    public static void WriteXmlElement(String str) throws IOException {
        PutIndents();
        try {
            m_fXMLWriter.write(str + "\n");
        } catch (IOException unused) {
        }
    }

    public static void CreateXmlHeader(String str, String str2, String str3) throws IOException {
        try {
            m_fXML = new File(str);
            FileWriter fileWriter = new FileWriter(str);
            m_fXMLWriter = fileWriter;
            fileWriter.write("<?xml version=\"1.0\"?>\n<" + str2 + "\n    xmlns=\"http://www.ee.columbia.edu/flavor\"\n    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n    xsi:schemaLocation=\"http://www.ee.columbia.edu/flavor\n                        " + str3 + "\"\n>\n");
        } catch (IOException unused) {
        }
    }
}
