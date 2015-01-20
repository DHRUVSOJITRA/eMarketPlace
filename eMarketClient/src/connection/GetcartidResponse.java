/**
 * GetcartidResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connection;

public class GetcartidResponse  implements java.io.Serializable {
    private int getcartidReturn;

    public GetcartidResponse() {
    }

    public GetcartidResponse(
           int getcartidReturn) {
           this.getcartidReturn = getcartidReturn;
    }


    /**
     * Gets the getcartidReturn value for this GetcartidResponse.
     * 
     * @return getcartidReturn
     */
    public int getGetcartidReturn() {
        return getcartidReturn;
    }


    /**
     * Sets the getcartidReturn value for this GetcartidResponse.
     * 
     * @param getcartidReturn
     */
    public void setGetcartidReturn(int getcartidReturn) {
        this.getcartidReturn = getcartidReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetcartidResponse)) return false;
        GetcartidResponse other = (GetcartidResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.getcartidReturn == other.getGetcartidReturn();
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
        _hashCode += getGetcartidReturn();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetcartidResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://connection", ">getcartidResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getcartidReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://connection", "getcartidReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
