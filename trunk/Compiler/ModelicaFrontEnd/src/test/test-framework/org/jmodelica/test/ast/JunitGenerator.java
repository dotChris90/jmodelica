/*
    Copyright (C) 2009 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package org.jmodelica.test.ast;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.jmodelica.ast.SourceRoot;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JunitGenerator {
	protected TestSuite ts;
	
	public JunitGenerator(TestSuite ts) {
		this.ts = ts;
	}
	
	public JunitGenerator(String fileName, String className) {
		this.ts = new TestSuite(fileName,className);
	}
	
	public void dump(StringBuffer str) {
		ts.dump(str," ");
	}
	
	public static void main(String args[]) {
		/* The first argument is the name of the .mo file to
		 * generate a Junit test class from, the second argument is
		 * the name of the class in this file, and the final
		 * argument is the name of the directory in which
		 * the generated test class is stored.
		 */
		JunitGenerator jg = new JunitGenerator(args[0],args[1]);
		StringBuffer str = new StringBuffer();
		//jg.ts.printTests(str);
		jg.ts.dumpJunit(args[0],args[2]);
		//System.out.println(str.toString());
	}
	
	
}
