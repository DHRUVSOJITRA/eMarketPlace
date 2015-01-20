/**
 * AddtocartResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connection;

public class AddtocartResponse  implements java.io.Serializable {
    private java.lang.String addtocartReturn;

    public AddtocartResponse() {
    }

    public AddtocartResponse(
           java.lang.String addtocartReturn) {
           this.addtocartReturn = addtocartReturn;
    }


    /**
     * Gets the addtocartReturn value for this AddtocartResponse.
     * 
     * @return addtocartReturn
     */
    public java.lang.String getAddtocartReturn() {
        return addtocartReturn;
    }


    /**
     * Sets the addtocartReturn value for this AddtocartResponse.
     * 
     * @param addtocartReturn
     */
    public void setAddtocartReturn(java.lang.String addtocartReturn) {
        this.addtocartReturn = addtocartReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddtocartResponse)) return false;
        AddtocartResponse other = (AddtocartResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.addtocartReturn==null && other.getAddtocartReturn()==null) || 
             (this.addtocartReturn!=null &&
              this.addtocartReturn.equals(other.getAddtocartReturn())));
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
        if (getAddtocartReturn() != null) {
            _hashCode += getAddtocartReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddtocartResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://connection", ">addtocartResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addtocartReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://connection", "addtocartReturn"));
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
