/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

/**
 *
 * @author user
 */
public class ColumnProperty {

    private String name;
    private String type;
    private Class typeAsClass;
    private String columnName;
    private int length;
    private boolean isNotNull;
    private boolean isForeignKey;
    private boolean isPrimaryKey;
    private Class foreignClass;
    private String comment;

    public Class getTypeAsClass() {
        return typeAsClass;
    }

    public void setTypeAsClass(Class typeAsClass) {
        this.typeAsClass = typeAsClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isIsNotNull() {
        return isNotNull;
    }

    public void setIsNotNull(boolean isNotNull) {
        this.isNotNull = isNotNull;
    }

    public boolean isIsForeignKey() {
        return isForeignKey;
    }

    public void setIsForeignKey(boolean isForeignKey) {
        this.isForeignKey = isForeignKey;
    }

    @Override
    public String toString() {
        return "ColumnProperty{" + "name=" + name + ", type=" + type + ", columnName=" + columnName + ", length=" + length + ", isNotNull=" + isNotNull + ", isForeignKey=" + isForeignKey + '}';
    }

    public boolean isIsPrimaryKey() {
        return isPrimaryKey;
    }

    public void setIsPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public Class getForeignClass() {
        return foreignClass;
    }

    public void setForeignClass(Class foreignClass) {
        this.foreignClass = foreignClass;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
