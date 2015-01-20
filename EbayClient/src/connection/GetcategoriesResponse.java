/**
 * GetcategoriesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connection;

public class GetcategoriesResponse  implements java.io.Serializable {
    private java.lang.Object[] getcategoriesReturn;

    public GetcategoriesResponse() {
    }

    public GetcategoriesResponse(
           java.lang.Object[] getcategoriesReturn) {
           this.getcategoriesReturn = getcategoriesReturn;
    }


    /**
     * Gets the getcategoriesReturn value for this GetcategoriesResponse.
     * 
     * @return getcategoriesReturn
     */
    public java.lang.Object[] getGetcategoriesReturn() {
        return getcategoriesReturn;
    }


    /**
     * Sets the getcategoriesReturn value for this GetcategoriesResponse.
     * 
     * @param getcategoriesReturn
     */
    public void setGetcategoriesReturn(java.lang.Object[] getcategoriesReturn) {
        this.getcategoriesReturn = getcategoriesReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetcategoriesResponse)) return false;
        GetcategoriesResponse other = (GetcategoriesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getcategoriesReturn==null && other.getGetcategoriesReturn()==null) || 
             (this.getcategoriesReturn!=null &&
              java.util.Arrays.equals(this.getcategoriesReturn, other.getGetcategoriesReturn())));
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
        if (getGetcategoriesReturn() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetcategoriesReturn());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetcategoriesReturn(), i);
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
        new org.apache.axis.description.TypeDesc(GetcategoriesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://connection", ">getcategoriesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getcategoriesReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://connection", "getcategoriesReturn"));
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
