import groovy.xml.StreamingMarkupBuilder
import groovy.util.XmlSlurper

import groovy.xml.StreamingMarkupBuilder
import org.apache.commons.lang3.StringEscapeUtils

import javax.xml.transform.Source
import javax.xml.transform.TransformerFactory
import javax.xml.transform.sax.SAXResult
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

static void main(String[] args) {

/*  def response = '''<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <SOAP-ENV:Body>
        <JBRZ362.ExecuteResponse xmlns="DesarrollosPartGx9.0">
            <Feccontable>000000</Feccontable>
            <Coderror>OK</Coderror>
            <Descripcion>Procesado OK</Descripcion>
            <Data>&lt;DATOSOUT&gt;&lt;Canal&gt;000&lt;/Canal&gt;&lt;Identificador&gt;00000&lt;/Identificador&gt;&lt;Pais&gt;000&lt;/Pais&gt;&lt;TipoDocumento&gt;1&lt;/TipoDocumento&gt;&lt;NroDocumento&gt;00000000&lt;/NroDocumento&gt;&lt;Tarjetas&gt;&lt;Tarjeta&gt;&lt;NroTarjeta&gt;5254863488355846&lt;/NroTarjeta&gt;&lt;Sucursal&gt;00&lt;/Sucursal&gt;&lt;TipoTarjeta&gt;00&lt;/TipoTarjeta&gt;&lt;FechaAlta&gt;000000&lt;/FechaAlta&gt;&lt;FechaVto&gt;000000&lt;/FechaVto&gt;&lt;FechaUltUso&gt;0&lt;/FechaUltUso&gt;&lt;CCEmpresa&gt;1&lt;/CCEmpresa&gt;&lt;CCSucursal&gt;00&lt;/CCSucursal&gt;&lt;CCModulo&gt;00&lt;/CCModulo&gt;&lt;CCCuenta&gt;000000000&lt;/CCCuenta&gt;&lt;CCOperacion&gt;0&lt;/CCOperacion&gt;&lt;CCSubOp&gt;1&lt;/CCSubOp&gt;&lt;CCMoneda&gt;0&lt;/CCMoneda&gt;&lt;CCPapel&gt;0&lt;/CCPapel&gt;&lt;Nombre&gt;PRUEBA1&lt;/Nombre&gt;&lt;GAF&gt;000&lt;/GAF&gt;&lt;EstadoPlastico&gt;A EMITIR&lt;/EstadoPlastico&gt;&lt;SituacionActual&gt;INACTIVA&lt;/SituacionActual&gt;&lt;EstadoTarjeta&gt;AC&lt;/EstadoTarjeta&gt;&lt;MotivoCancelacion/&gt;&lt;FechaCancelacion&gt;0&lt;/FechaCancelacion&gt;&lt;Cuentas&gt;&lt;Cuenta&gt;&lt;Empresa&gt;00&lt;/Empresa&gt;&lt;Sucursal&gt;00&lt;/Sucursal&gt;&lt;Modulo&gt;00&lt;/Modulo&gt;&lt;NroCuenta&gt;000000000&lt;/NroCuenta&gt;&lt;Operacion&gt;0&lt;/Operacion&gt;&lt;SubOp&gt;6&lt;/SubOp&gt;&lt;Moneda&gt;0&lt;/Moneda&gt;&lt;Papel&gt;0&lt;/Papel&gt;&lt;TipoCuenta&gt;PREFERENCIAL LOCAL&lt;/TipoCuenta&gt;&lt;/Cuenta&gt;&lt;/Cuentas&gt;&lt;CuentasPJ&gt;N&lt;/CuentasPJ&gt;&lt;Courier/&gt;&lt;CodigoCourier/&gt;
                        &lt;EstadoCourier/&gt;&lt;/Tarjeta&gt;&lt;/Tarjetas&gt;&lt;/DATOSOUT&gt;</Data>
        </JBRZ362.ExecuteResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>'''*/
//  def slurper = new XmlSlurper(false, false)
//  def soap = slurper.parseText(response)
//
//  def data = soap.Body.ExecuteResponse.Data.text()
//  def unescapedData = StringEscapeUtils.unescapeXml(data)
//
//  def dataSlurper = new XmlSlurper(false, false)
//  def datosout = dataSlurper.parseText(unescapedData)

//  def body = new XmlSlurper().parseText(response).Body
//
//  def xmlResponse = new StreamingMarkupBuilder().bind {
//    mkp.xmlDeclaration()
//    body.getAt(0).name() {
//      body.children().each { child ->
//        delegate."$child.name()"("${child.text()}")
//      }
//    }
//  }
//  println xmlResponse

// Definir el XML antiguo
  def oldXml = '''
<root>
  <seccion1>
    <elemento1>Valor1</elemento1>
  </seccion1>
  <seccion2>
    <elemento1>Valor2</elemento1>
  </seccion2>
</root>
'''

// Definir el XML nuevo
  def newXml = '''
<root>
  <seccion1>
    <elemento1>Valor1</elemento1>
  </seccion1>
  <seccion2>
    <elemento1>Valor2Nuevo</elemento1>
  </seccion2>
</root>
'''

// Leer el XML antiguo con XmlSlurper
  def xmlAntiguo = new XmlSlurper().parseText(oldXml)

// Leer el XML nuevo con XmlSlurper
  def xmlNuevo = new XmlSlurper().parseText(newXml)

// Reemplazar la sección deseada del XML antiguo con la del XML nuevo
 xmlAntiguo = xmlNuevo

// Convertir el XML resultante a String con XmlUtil
  def xmlResultante = new StreamingMarkupBuilder().bind {
    mkp.yield xmlAntiguo
  }

// Imprimir el resultado
  println xmlResultante.toString()

}