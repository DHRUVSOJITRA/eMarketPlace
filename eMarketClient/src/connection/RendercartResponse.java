/**
 * RendercartResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connection;

public class RendercartResponse  implements java.io.Serializable {
    private java.lang.String rendercartReturn;

    public RendercartResponse() {
    }

    public RendercartResponse(
           java.lang.String rendercartReturn) {
           this.rendercartReturn = rendercartReturn;
    }


    /**
     * Gets the rendercartReturn value for this RendercartResponse.
     * 
     * @return rendercartReturn
     */
    public java.lang.String getRendercartReturn() {
        return rendercartReturn;
    }


    /**
     * Sets the rendercartReturn value for this RendercartResponse.
     * 
     * @param rendercartReturn
     */
    public void setRendercartReturn(java.lang.String rendercartReturn) {
        this.rendercartReturn = rendercartReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RendercartResponse)) return false;
        RendercartResponse other = (RendercartResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rendercartReturn==null && other.getRendercartReturn()==null) || 
             (this.rendercartReturn!=null &&
              this.rendercartReturn.equals(other.getRendercartReturn())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRendercartReturn() != null) {
            _hashCode += getRendercartReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RendercartResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://connection", ">rendercartResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rendercartReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://connection", "rendercartReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
