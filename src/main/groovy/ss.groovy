import javax.xml.transform.*
import javax.xml.transform.sax.SAXResult
import javax.xml.transform.stream.*

class ss {



    def xml = '<root><old>value</old></root>'
    def replacementXml = '<new>value</new>'

    def factory = TransformerFactory.newInstance()
    def transformer = factory.newTransformer()

    def source = new StreamSource(new StringReader(xml))
    def replacement = new StreamSource(new StringReader(replacementXml))
    def result = new StreamResult(System.out)

    def algo = transformer.transform(source, result, new XmlReplace(replacement))

    class XmlReplace extends javax.xml.transform.sax.SAXResult {
        def replacement

        XmlReplace(Source replacement) {
            this.replacement = replacement
        }

        org.xml.sax.ContentHandler getContentHandler() throws javax.xml.transform.TransformerConfigurationException {
            new XmlReplaceHandler(replacement)
        }
    }

    class XmlReplaceHandler extends org.xml.sax.helpers.DefaultHandler {
        def replacement
        boolean replaced = false

        void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
            if (!replaced && qName == 'old') {
                replaced = true
                def transformer = TransformerFactory.newInstance().newTransformer()
                transformer.transform(replacement, new SAXResult(this))
            } else {
                super.startElement(uri, localName, qName, attributes)
            }
        }
    }
}
