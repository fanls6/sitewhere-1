/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.microservice.spring;

import java.util.List;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import com.sitewhere.configuration.parser.IInstanceManagementParser.SolrElements;

/**
 * Parses data for global Solr configurations that may be used by tenants.
 * 
 * @author Derek
 */
public class SolrConfigurationsParser extends AbstractBeanDefinitionParser {

    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext context) {
	List<Element> children = DomUtils.getChildElements(element);
	for (Element child : children) {
	    SolrElements type = SolrElements.getByLocalName(child.getLocalName());
	    if (type == null) {
		throw new RuntimeException("Unknown Solr configuration element: " + child.getLocalName());
	    }
	    switch (type) {
	    case DefaultSolrConfiguration: {
		break;
	    }
	    case AlternateSolrConfiguration: {
		break;
	    }
	    }
	}
	return null;
    }
}