/*
 * Javassist, a Java-bytecode translator toolkit.
 * Copyright (C) 2004 Bill Burke. All Rights Reserved.
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

package javassist.bytecode.annotation;

import javassist.bytecode.ConstPool;
import java.io.IOException;

/**
 * The value of a member declared in an annotation.
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @author Shigeru Chiba
 */
public abstract class MemberValue {
    ConstPool cp;
    char tag;

    MemberValue(char tag, ConstPool cp) {
        this.cp = cp;
        this.tag = tag;
    }

    /**
     * Accepts a visitor.
     */
    public abstract void accept(MemberValueVisitor visitor);

    abstract void write(AnnotationsWriter w) throws IOException;
}


