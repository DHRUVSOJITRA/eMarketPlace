/**
 * RendercategoryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connection;

public class RendercategoryResponse  implements java.io.Serializable {
    private java.lang.Object[] rendercategoryReturn;

    public RendercategoryResponse() {
    }

    public RendercategoryResponse(
           java.lang.Object[] rendercategoryReturn) {
           this.rendercategoryReturn = rendercategoryReturn;
    }


    /**
     * Gets the rendercategoryReturn value for this RendercategoryResponse.
     * 
     * @return rendercategoryReturn
     */
    public java.lang.Object[] getRendercategoryReturn() {
        return rendercategoryReturn;
    }


    /**
     * Sets the rendercategoryReturn value for this RendercategoryResponse.
     * 
     * @param rendercategoryReturn
     */
    public void setRendercategoryReturn(java.lang.Object[] rendercategoryReturn) {
        this.rendercategoryReturn = rendercategoryReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RendercategoryResponse)) return false;
        RendercategoryResponse other = (RendercategoryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rendercategoryReturn==null && other.getRendercategoryReturn()==null) || 
             (this.rendercategoryReturn!=null &&
              java.util.Arrays.equals(this.rendercategoryReturn, other.getRendercategoryReturn())));
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
        if (getRendercategoryReturn() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRendercategoryReturn());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRendercategoryReturn(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RendercategoryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://connection", ">rendercategoryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rendercategoryReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://connection", "rendercategoryReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://connection", "item"));
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
