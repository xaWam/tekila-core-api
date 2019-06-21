/**
 * 
 */
/**
 * @author sajabrayilov
 *
 */

@javax.xml.bind.annotation.XmlSchema(
		xmlns = {
		@javax.xml.bind.annotation.XmlNs (
		    prefix=com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace.PAYMENT_PF,
			namespaceURI=com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace.PAYMENT_NS),
		@javax.xml.bind.annotation.XmlNs (
			prefix=com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace.W3_PF,
			namespaceURI=com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace.W3_NS
				),
		@javax.xml.bind.annotation.XmlNs (
			prefix=com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace.SUBSCRIPTION_PF,
			namespaceURI=com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace.SUBSCRIPTION_NS
				),
		@javax.xml.bind.annotation.XmlNs (
			prefix=com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace.SERVICE_PF,
			namespaceURI=com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace.SERVICE_NS
				)
	},
	elementFormDefault=javax.xml.bind.annotation.XmlNsForm.QUALIFIED		
)

package com.jaravir.tekila.module.subscription.persistence.entity;
