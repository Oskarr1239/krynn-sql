package dev.krynn.sql.impl.compiler.data;

import java.sql.Types;

public enum DataType {

    STRING(String.class, "LONGTEXT", Types.LONGVARCHAR),
    INT(Integer.class, "INT", Types.INTEGER),
    LONG(Long.class, "BIGINT", Types.BIGINT),
    BOOLEAN(Boolean.class, "TYNYINT(1)", Types.TINYINT),
    //Always last :XD:
    OBJECT(Object.class, "LONGTEXT", Types.LONGVARCHAR);

    private Class<?> clazz;
    private String sqlType;
    private int numericType;

    DataType(Class<?> clazz, String sqlType, int numericType) {
        this.clazz = clazz;
        this.sqlType = sqlType;
        this.numericType = numericType;
    }

    public static DataType getType(Class<?> clazz) {
        for (DataType value : values()) {
            if(clazz.equals(value.getClazz())) return value;
        }

        return OBJECT;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public String getSqlType() {
        return sqlType;
    }

    public int getNumericType() {
        return numericType;
    }
}
