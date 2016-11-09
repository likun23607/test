/*
 * Javassist, a Java-bytecode translator toolkit.
 * Copyright (C) 1999-2005 Shigeru Chiba. All Rights Reserved.
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License.  Alternatively, the contents of this file may be used under
 * the terms of the GNU Lesser General Public License Version 2.1 or later.
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 */

package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

/**
 * <code>field_info</code> structure.
 *
 * @see javassist.CtField#getFieldInfo()
 */
public final class FieldInfo {
    ConstPool constPool;
    int accessFlags;
    int name;
    int descriptor;
    LinkedList attribute;       // may be null.

    private FieldInfo(ConstPool cp) {
        constPool = cp;
        accessFlags = 0;
        attribute = null;
    }

    /**
     * Constructs a <code>field_info</code> structure.
     *
     * @param cp                a constant pool table
     * @param fieldName         field name
     * @param desc              field descriptor
     *
     * @see Descriptor
     */
    public FieldInfo(ConstPool cp, String fieldName, String desc) {
        this(cp);
        name = cp.addUtf8Info(fieldName);
        descriptor = cp.addUtf8Info(desc);
    }

    FieldInfo(ConstPool cp, DataInputStream in) throws IOException {
        this(cp);
        read(in);
    }

    /**
     * Copies all constant pool items to a given new constant pool
     * and replaces the original items with the new ones.
     * This is used for garbage collecting the items of removed fields
     * and methods.
     *
     * @param cp    the destination
     */
    void compact(ConstPool cp) {
        name = cp.addUtf8Info(getName());
        descriptor = cp.addUtf8Info(getDescriptor());
        attribute = AttributeInfo.copyAll(attribute, cp);
        constPool = cp;
    }

    void prune(ConstPool cp) {
        int index = getConstantValue();
        if (index == 0)
            attribute = null;
        else {
            index = constPool.copy(index, cp, null);
            attribute = new LinkedList();
            attribute.add(new ConstantAttribute(cp, index));
        }

        name = cp.addUtf8Info(getName());
        descriptor = cp.addUtf8Info(getDescriptor());
        constPool = cp;
    }

    /**
     * Returns the constant pool table used
     * by this <code>field_info</code>.
     */
    public ConstPool getConstPool() {
        return constPool;
    }

    /**
     * Returns the field name.
     */
    public String getName() {
        return constPool.getUtf8Info(name);
    }

    /**
     * Sets the field name.
     */
    public void setName(String newName) {
        name = constPool.addUtf8Info(newName);
    }

    /**
     * Returns the access flags.
     *
     * @see AccessFlag
     */
    public int getAccessFlags() {
        return accessFlags;
    }

    /**
     * Sets the access flags.
     *
     * @see AccessFlag
     */
    public void setAccessFlags(int acc) {
        accessFlags = acc;
    }

    /**
     * Returns the field descriptor.
     *
     * @see Descriptor
     */
    public String getDescriptor() {
        return constPool.getUtf8Info(descriptor);
    }

    /**
     * Sets the field descriptor.
     *
     * @see Descriptor
     */
    public void setDescriptor(String desc) {
        if (!desc.equals(getDescriptor()))
            descriptor = constPool.addUtf8Info(desc);
    }

    /**
     * Finds a ConstantValue attribute and returns the index into
     * the <code>constant_pool</code> table.
     *
     * @return 0    if a ConstantValue attribute is not found.
     */
    public int getConstantValue() {
        if ((accessFlags & AccessFlag.STATIC) == 0)
            return 0;

        ConstantAttribute attr
            = (ConstantAttribute)getAttribute(ConstantAttribute.tag);
        if (attr == null)
            return 0;
        else
            return attr.getConstantValue();
    }

    /**
     * Returns all the attributes.
     * A new element can be added to the returned list
     * and an existing element can be removed from the list.
     *
     * @return a list of <code>AttributeInfo</code> objects.
     * @see AttributeInfo
     */
    public List getAttributes() {
        if (attribute == null)
            attribute = new LinkedList();

        return attribute;
    }

    /**
     * Returns the attribute with the specified name.
     *
     * @param name      attribute name
     */
    public AttributeInfo getAttribute(String name) {
        return AttributeInfo.lookup(attribute, name);
    }

    /**
     * Appends an attribute.  If there is already an attribute with
     * the same name, the new one substitutes for it.
     */
    public void addAttribute(AttributeInfo info) {
        if (attribute == null)
            attribute = new LinkedList();

        AttributeInfo.remove(attribute, info.getName());
        attribute.add(info);
    }

    private void read(DataInputStream in) throws IOException {
        accessFlags = in.readUnsignedShort();
        name = in.readUnsignedShort();
        descriptor = in.readUnsignedShort();
        int n = in.readUnsignedShort();
        attribute = new LinkedList();
        for (int i = 0; i < n; ++i)
            attribute.add(AttributeInfo.read(constPool, in));
    }

    void write(DataOutputStream out) throws IOException {
        out.writeShort(accessFlags);
        out.writeShort(name);
        out.writeShort(descriptor);
        if (attribute == null)
            out.writeShort(0);
        else {
            out.writeShort(attribute.size());
            AttributeInfo.writeAll(attribute, out);
        }
    }
}
